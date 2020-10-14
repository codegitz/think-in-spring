package io.codegitz.spring.conversion;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditor;

/**
 * Spring 自定义 {@link PropertyEditor} 实现
 * @author 张观权
 * @date 2020/10/14 13:27
 * @see PropertyEditor
 **/
public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF\\property-editors-context.xml");

        User user = context.getBean("user", User.class);
        System.out.println(user);
        context.close();
    }
}
