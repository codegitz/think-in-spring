package io.codegitz;

import io.codegitz.entity.User;
import io.codegitz.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Codegitz
 * @date 2022/2/28 15:23
 **/
public class AnnotationDrivenApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("io.codegitz");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setName("codegitzByAnnotation");
        user.setAge(25);
        user.setSex("man");
        // insert a record
        userService.save(user);
    }
}
