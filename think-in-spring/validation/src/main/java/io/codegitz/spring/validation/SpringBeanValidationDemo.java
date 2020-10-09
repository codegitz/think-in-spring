package io.codegitz.spring.validation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Spring bean Validation 整合示例
 * @author 张观权
 * @date 2020/10/9 18:58
 * @see org.springframework.validation.Validator
 * @see org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
 * @since
 **/
public class SpringBeanValidationDemo {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF\\bean-validation-context.xml");

        Validator validator = applicationContext.getBean(Validator.class);

        System.out.println(validator instanceof LocalValidatorFactoryBean);

        applicationContext.close();
    }
}
