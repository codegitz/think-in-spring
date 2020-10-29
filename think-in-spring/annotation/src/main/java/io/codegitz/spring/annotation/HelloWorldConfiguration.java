package io.codegitz.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张观权
 * @date 2020/10/29 20:37
 **/
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "helloWorld";
    }
}
