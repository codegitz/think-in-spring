package io.codegitz.spring.validation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Spring bean Validation 整合示例
 *
 * @author 张观权
 * @date 2020/10/9 18:58
 * @see org.springframework.validation.Validator
 * @see org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
 * @since
 **/
public class SpringBeanValidationDemo {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF\\bean-validation-context.xml");

//        Validator validator = applicationContext.getBean(Validator.class);
//        System.out.println("validator instanceof LocalValidatorFactoryBean: " + (validator instanceof LocalValidatorFactoryBean));

        UserProcessor userProcessor = applicationContext.getBean(UserProcessor.class);
        userProcessor.process(new User());
        applicationContext.close();
    }

//    @Configuration(proxyBeanMethods = false)
    @Component
    @Validated
    static class UserProcessor{

        public void process(@Valid User user){
            System.out.println(user);
        }
    }

    static class User{

        @NotNull
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    '}';
        }
    }
}
