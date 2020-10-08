package io.codegitz.spring.i18n;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * 实现操作系统无关的动态变化的 MessageSource 实现
 * 动态 （更新） 资源 {@link org.springframework.context.MessageSource}
 * <p>
 * 实现步骤：
 * 1.定位资源位置 （Properties 文件）
 * 2.初始化Properties对象
 * 3.实现AbstractMessageSource#resolveCode方法
 * 4.监听资源文件 (Java NIO 2 WatchService)
 * 5.线程池处理文件变化
 * 6.重新装载Properties对象
 *
 * @author 张观权
 * @date 2020/10/8 13:46
 * @see org.springframework.context.MessageSource
 * @see org.springframework.context.support.AbstractMessageSource
 * @since 2020-10-08
 **/
public class DynamicResourceMessageSource extends AbstractMessageSource implements ResourceLoaderAware {

    private static final String resourceFileName = "msg.properties";
    private static final String resourcePath = "META-INF/" + resourceFileName;

    private static final String ENCODING = "UTF-8";

    private final ExecutorService executorService;

    private final Properties messageProperties;

    private final Resource messagePropertiesResource;

    private ResourceLoader resourceLoader;

    public DynamicResourceMessageSource() {
        this.executorService = Executors.newSingleThreadExecutor();
        this.messagePropertiesResource = getMessagePropertiesResource();
        this.messageProperties = LoadMessageProperties();

        // 监听资源文件 (Java NIO 2 WatchService)
        onMessagePropertiesChanged();
    }

    private void onMessagePropertiesChanged() {

        if (this.messagePropertiesResource.isFile()) {// 判断是否为文件
            // 获取文件系统中的文件
            try {
                File messagePropertiesFile = this.messagePropertiesResource.getFile();
                Path messagePropertiesFilePath = messagePropertiesFile.toPath();
                // 获取当前文件OS系统
                FileSystem fileSystem = FileSystems.getDefault();
                // 新建WatchService
                WatchService watchService = fileSystem.newWatchService();
                // 获取资源文件所在目录
                Path dirPath = messagePropertiesFilePath.getParent();
                // 注册watchService到dirPath并且关心修改事件
                dirPath.register(watchService, ENTRY_MODIFY);
                // 处理资源文件变化
                processMessagePropertiesChanged(watchService);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 处理资源文件变化(异步)
     *
     * @param watchService
     */
    private void processMessagePropertiesChanged(WatchService watchService) {
        executorService.submit(() -> {
            while (true) {
                WatchKey watchKey = watchService.take();
                try {
                    // watchKey是否有效
                    if (watchKey.isValid()) {
                        for (WatchEvent event : watchKey.pollEvents()) {
                            Watchable watchable = watchKey.watchable();
                            // 目录路径 （监听的注册目录）
                            Path path = (Path) watchable;
                            // 事件所关联的对象即注册目录的子文件 （或子目录）
                            // 事件发生源是相对路径
                            Path fileRelativePath = (Path) event.context();
                            if (resourceFileName.equals(fileRelativePath.toString())) {
                                // 处理为绝对路径
                                Path filePath = path.resolve(fileRelativePath);
                                File file = filePath.toFile();
                                Properties properties = LoadMessageProperties(new FileReader(file));
                                System.out.println("修改过的Properties文件： " + filePath);
                                synchronized (messageProperties) {
                                    messageProperties.clear();
                                    messageProperties.putAll(properties);
                                }
                            }
                        }
                    }
                } finally {
                    if (watchKey != null) {
                        watchKey.reset(); // 重置watchKey
                    }
                }

            }
        });
    }

    private Properties LoadMessageProperties() {
        EncodedResource encodedResource = new EncodedResource(this.messagePropertiesResource, ENCODING);
        try {
            return LoadMessageProperties(encodedResource.getReader());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private Properties LoadMessageProperties(Reader reader) {

        Properties properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
        }

        return properties;
    }

    private Resource getMessagePropertiesResource() {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(resourcePath);
        return resource;
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String messageFormatPattern = messageProperties.getProperty(code);
        if (StringUtils.hasText(messageFormatPattern)) {
            return new MessageFormat(messageFormatPattern, Locale.getDefault());
        }
        return null;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader != null ? this.resourceLoader : new DefaultResourceLoader();
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) throws InterruptedException {
        DynamicResourceMessageSource dynamicResourceMessageSource = new DynamicResourceMessageSource();
        for (int i = 0; i < 10000; i++) {
            String message = dynamicResourceMessageSource.getMessage("name", new Object[]{}, Locale.getDefault());
            System.out.println(message);
            Thread.sleep(1000L);
        }
    }
}
