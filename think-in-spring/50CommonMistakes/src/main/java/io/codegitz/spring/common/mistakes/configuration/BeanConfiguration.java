package io.codegitz.spring.common.mistakes.configuration;

import io.codegitz.spring.common.mistakes.service.LightService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张观权
 * @date 2021/4/28 15:17
 **/
//@Configuration
public class BeanConfiguration {

//    @Bean
    public LightService getLightService(){
        return new LightService();
    }
}
