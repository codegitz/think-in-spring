package io.codegitz;

import io.codegitz.entity.User;
import io.codegitz.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Codegitz
 * @date 2022/2/18 11:02
 **/
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setName("codegitz");
        user.setAge(25);
        user.setSex("man");
        // insert a record
        userService.save(user);
    }
}
