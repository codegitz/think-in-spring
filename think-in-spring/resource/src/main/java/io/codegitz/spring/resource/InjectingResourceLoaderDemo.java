package io.codegitz.spring.resource;

import io.codegitz.spring.resource.util.ResourceUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * 注入 {@link org.springframework.core.io.ResourceLoader} 实现示例
 *
 * @author 张观权
 * @date 2020/9/30 14:37
 * @see ResourceLoader
 * @see Resource
 * @since xxx
 **/
public class InjectingResourceLoaderDemo implements ResourceLoaderAware , ApplicationContextAware {

    private ResourceLoader resourceLoader;

    private ApplicationContext applicationContext;

    @Autowired
    private ResourceLoader autoWiredResourceLoader;

    @Autowired
    private ApplicationContext autoWiredApplicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        System.out.println("resourceLoader == autoWiredResourceLoader? : " +(resourceLoader == autoWiredResourceLoader));
        System.out.println("resourceLoader == autoWiredApplicationContext? : " +(resourceLoader == autoWiredApplicationContext));
        System.out.println("resourceLoader == applicationContext? : " +(resourceLoader == applicationContext));

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(InjectingResourceLoaderDemo.class);

        applicationContext.refresh();

        applicationContext.close();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
