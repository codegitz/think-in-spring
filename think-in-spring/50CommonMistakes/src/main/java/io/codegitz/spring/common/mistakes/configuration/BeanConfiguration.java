package io.codegitz.spring.common.mistakes.configuration;

import io.codegitz.spring.common.mistakes.service.LightService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 张观权
 * @date 2021/4/28 15:17
 **/
@Configuration
public class BeanConfiguration {

    @Bean
    public LightService getLightService(){
        AtomicInteger integer = new AtomicInteger();
        integer.getAndIncrement();
        integer.get();
        return new LightService();
    }
}
