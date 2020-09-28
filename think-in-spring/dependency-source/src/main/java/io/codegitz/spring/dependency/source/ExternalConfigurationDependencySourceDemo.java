package io.codegitz.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;

/**
 * 外部化配置作为依赖来源
 * @author 张观权
 * @date 2020/9/17 18:00
 **/

@Configuration
@PropertySource("META-INF\\Default.properties")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${user.name}")
    private String name;

    @Value("${user.resource:classpath://default.properties}")
    private Resource resource;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册configuration类 -> spring bean
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);
        applicationContext.refresh();
        ExternalConfigurationDependencySourceDemo demo = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);
        System.out.println("demo.id: " + demo.id);
        System.out.println("demo.resource: " + demo.resource);
        System.out.println("demo.name: " + demo.name);
        applicationContext.close();
    }
}
