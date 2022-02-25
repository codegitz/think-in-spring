package io.codegitz;

import io.codegitz.entity.User;
import io.codegitz.service.ProgrammaticTransactionService;
import io.codegitz.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Codegitz
 * @date 2022/2/18 11:02
 **/
public class ProgrammaticApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ProgrammaticTransactionService programmaticService = (ProgrammaticTransactionService) applicationContext.getBean("programmaticService");
        User user = new User();
        user.setName("CodegitzByProgrammaticTransaction");
        user.setAge(25);
        user.setSex("knight");
        // insert a record
        programmaticService.transactionInsert(user);
    }
}
