package io.codegitz.spring.configuration.metadata;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * 基于 java 注解的 YAML 外部化配置示例
 *
 * @author 张观权
 * @date 2020/9/28 15:00
 **/

@PropertySource(name = "yamlPropertySource",
value = "classpath:META-INF\\user.yaml",
factory = YamlPropertySourceFactory.class)
public class AnnotatedBaseYamlPropertyResourceDemo {

    @Bean
    public User user(@Value("${user.id}") Long id , @Value("${user.name}") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AnnotatedBaseYamlPropertyResourceDemo.class);

        context.refresh();

        User user = context.getBean("user", User.class);
        System.out.println(user);
        context.close();
    }
}
