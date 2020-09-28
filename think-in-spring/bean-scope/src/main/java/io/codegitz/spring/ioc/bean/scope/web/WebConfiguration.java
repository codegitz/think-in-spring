package io.codegitz.spring.ioc.bean.scope.web;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * spring web MVC 配置类
 * @author 张观权
 * @date 2020/9/18 11:38
 **/

@Configuration
@EnableWebMvc
public class WebConfiguration {

    @Bean
//    @RequestScope
//    @SessionScope
    @ApplicationScope
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("RequestScope");
        return user;
    }
}
