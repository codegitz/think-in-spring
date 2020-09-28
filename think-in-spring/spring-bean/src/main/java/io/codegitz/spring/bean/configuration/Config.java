package io.codegitz.spring.bean.configuration;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.Bean;

/**
 * @author 张观权
 * @date 2020/9/11 14:16
 **/
public class Config {
    @Bean
    public User user(){
        User user = new User();
        user.setId(1l);
        user.setName("userName");
        return user;
    }
}
