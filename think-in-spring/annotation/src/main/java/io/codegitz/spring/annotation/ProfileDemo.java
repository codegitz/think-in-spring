package io.codegitz.spring.annotation;

import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * {@link org.springframework.context.annotation.Profile} 示例
 * @author 张观权
 * @date 2020/10/29 20:55
 * @see org.springframework.context.annotation.Profile
 * @see Environment#getActiveProfiles()
 * @see ProfileCondition
 * @see EvenConditional
 **/
@Configuration
public class ProfileDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ProfileDemo.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setDefaultProfiles("odd");
//        environment.setActiveProfiles("even");
//        --spring.profiles.active=even Springboot 外部化配置
//        -Dspring.profiles.active=even VM option
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
