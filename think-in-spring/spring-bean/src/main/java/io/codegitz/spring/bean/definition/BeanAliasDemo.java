package io.codegitz.spring.bean.definition;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean别名示例
 * @author 张观权
 * @date 2020/9/11 11:59
 **/
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF\\bean-definitions-context.xml");
        User user = (User) beanFactory.getBean("user");
        User springUser = (User) beanFactory.getBean("spring-user");
        System.out.println(user == springUser);
    }
}
