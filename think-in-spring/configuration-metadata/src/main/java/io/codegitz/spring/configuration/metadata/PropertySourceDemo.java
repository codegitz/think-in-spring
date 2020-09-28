package io.codegitz.spring.configuration.metadata;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 外部化配置示例
 * @author 张观权
 * @date 2020/9/28 14:35
 **/
@PropertySource("classpath:META-INF\\users-config.properties") // java 8+ repeatable 支持
public class PropertySourceDemo {

    @Bean
    public User user(@Value("${user.id}") Long id , @Value("${user.name}") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 扩展 Environment 中 PropertySources 属性
        // 添加 PropertySource 必须在 refresh() 操作之前完成

        Map<String, Object> propertySourcesMap = new HashMap<>();
        propertySourcesMap.put("user.name","firstCC");
        org.springframework.core.env.PropertySource<?> propertySources = new MapPropertySource("first-property-resource",propertySourcesMap);
        context.getEnvironment().getPropertySources().addFirst(propertySources);

        context.register(PropertySourceDemo.class);

        context.refresh();

        System.out.println(context.getEnvironment().getPropertySources());

        Map<String, User> userMap = context.getBeansOfType(User.class);

        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.printf("User bean name: %s ,content: %s \n",entry.getKey(),entry.getValue());
        }

        context.close();
    }
}
