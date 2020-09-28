package io.codegitz.spring.configuration.metadata;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

/**
 * 基于java注解的spring IOC容器元信息配置示例
 * @author 张观权
 * @date 2020/9/27 22:28
 **/
// 将当前类作为configuration class
@ImportResource("classpath:META-INF\\dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("classpath:META-INF\\users-config.properties") // java 8+ repeatable 支持
@PropertySource("classpath:META-INF\\users-config.properties")
public class AnnotatedSpringIoCContainerMetadataConfigurationDemo {


    @Bean
    public User configuredUser(@Value("${user.id}") Long id , @Value("${user.name}") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AnnotatedSpringIoCContainerMetadataConfigurationDemo.class);

        context.refresh();

        Map<String, User> userMap = context.getBeansOfType(User.class);

        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.printf("User bean name: %s ,content: %s \n",entry.getKey(),entry.getValue());
        }
        context.close();

    }
}
