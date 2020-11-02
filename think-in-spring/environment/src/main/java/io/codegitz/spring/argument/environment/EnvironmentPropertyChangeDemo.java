package io.codegitz.spring.argument.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link org.springframework.core.env.Environment} 属性改变示例
 * @author 张观权
 * @date 2020/11/2 19:40
 **/
public class EnvironmentPropertyChangeDemo {

    @Value("${user.name}")
    private String userName;

    // propertySource("first-source"){user.name=zhangguanquan}
    // propertySource(Java System Properties){user.name=Codegitz}
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(EnvironmentPropertyChangeDemo.class);

        ConfigurableEnvironment environment = context.getEnvironment();

        MutablePropertySources propertySources = environment.getPropertySources();

        Map<String,Object> source = new HashMap<>();
        source.put("user.name","Codegitz");

        MapPropertySource mapPropertySource = new MapPropertySource("first-source", source);
        propertySources.addFirst(mapPropertySource);

        context.refresh();
        source.put("user.name","996");

        EnvironmentPropertyChangeDemo environmentPropertyChangeDemo = context.getBean(EnvironmentPropertyChangeDemo.class);
        System.out.println(environmentPropertyChangeDemo.userName);
        for (PropertySource ps : propertySources){
            System.out.printf("PropertySources = %s ,user.name = %s \n",ps.getName(),ps.getProperty("user.name"));
        }

        context.close();
    }
}
