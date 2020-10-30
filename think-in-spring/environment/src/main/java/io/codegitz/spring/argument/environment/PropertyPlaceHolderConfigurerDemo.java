package io.codegitz.spring.argument.environment;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.util.StringValueResolver;

/**
 * environment 占位符处理
 * 3.1之前 组件{@link PropertyPlaceholderConfigurer} 接口{@link StringValueResolver}
 * 3.1之后 组件{@link PropertySourcesPlaceholderConfigurer} 接口{@link EmbeddedValueResolver}
 * @author 张观权
 * @date 2020/10/30 20:21
 **/
public class PropertyPlaceHolderConfigurerDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF\\property-placeholder.xml");
        applicationContext.refresh();
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.toString());
        applicationContext.close();
    }
}
