package io.codegitz.service;

import io.codegitz.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Codegitz
 * @date 2022/1/29 11:20
 **/
public class UserServiceTest {
    @Test
    public void testInsert() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-transaction.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setName("coco");
        user.setSex("man");
        user.setAge(24);
        userService.save(user);
    }

    @Test
    public void currentProxy() throws Exception {
        UserService userService  = (UserService) AopContext.currentProxy();
        userService.save(new User());
    }
}
