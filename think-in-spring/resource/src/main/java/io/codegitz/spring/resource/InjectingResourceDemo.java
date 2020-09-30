package io.codegitz.spring.resource;

import io.codegitz.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * 注入 {@link Resource} 实现示例
 *
 * @author 张观权
 * @date 2020/9/30 14:37
 * @see Resource
 * @see Value
 * @see AnnotationConfigApplicationContext
 * @since xxx
 **/
public class InjectingResourceDemo {

    @Value("classpath:/META-INF/default.properties")
    private Resource defaultPropertiesResource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] propertiesResource;

    @Value("${user.dir}")
    private String rootPath;

    @PostConstruct
    public void init() {
        System.out.println(ResourceUtils.getContent(defaultPropertiesResource));
        System.out.println("=================================");
        Stream.of(propertiesResource).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("=================================");
        System.out.println(rootPath);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(InjectingResourceDemo.class);

        applicationContext.refresh();

        applicationContext.close();
    }
}
