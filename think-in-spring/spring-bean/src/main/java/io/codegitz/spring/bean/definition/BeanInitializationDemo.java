package io.codegitz.spring.bean.definition;

import io.codegitz.spring.bean.factory.DefaultUserFactory;
import io.codegitz.spring.bean.factory.UserFactory;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author 张观权
 * @date 2020/9/14 9:27
 **/
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        System.out.println("spring上下文准备启动");
        applicationContext.refresh();
        System.out.println("spring上下文已经启动");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println("spring上下文准备关闭");
        applicationContext.close();
        System.out.println("spring上下文已经关闭");
    }

    @Bean(initMethod = "initUserFactory" , destroyMethod = "doDestroy")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }

}
