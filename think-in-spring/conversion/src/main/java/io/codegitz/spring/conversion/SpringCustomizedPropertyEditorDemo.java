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
 *
 * Spring PropertyEditor 的设计缺陷
 * 1.违反单一职责原则 -> java.beans.PropertyEditor 接口职责太多，除了类型转换，还包括Java Beans 事件和 Java GUI 交互
 * 2.java.beans.PropertyEditor 实现类型的局限性 -> 来源只能是 java.lang.String 类型
 * 3.java.beans.PropertyEditor 缺少类型安全 -> 除了实现类命名可以感知语义，实现类无法感知目标转换类型
 *
 **/
public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF\\property-editors-context.xml");

        User user = context.getBean("user", User.class);
        System.out.println(user);
        context.close();
    }
}
