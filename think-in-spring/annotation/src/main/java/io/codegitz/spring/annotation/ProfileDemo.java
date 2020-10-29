package io.codegitz.spring.annotation;

import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * {@link org.springframework.context.annotation.Profile} 示例
 * @author 张观权
 * @date 2020/10/29 20:55
 * @see org.springframework.context.annotation.Profile
 * @see Environment#getActiveProfiles()
 **/
@Configuration
public class ProfileDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ProfileDemo.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setDefaultProfiles("odd");
//        environment.setActiveProfiles("even");
        applicationContext.refresh();
        Integer number = applicationContext.getBean("number", Integer.class);
        System.out.println(number);
        applicationContext.close();
    }

    @Bean(name = "number")
    @Profile("odd")
    public Integer odd(){
        return 1;
    }

    @Bean(name = "number")
//    @Profile("even")
    @Conditional(EvenConditional.class)
    public Integer even(){
        return 2;
    }
}
