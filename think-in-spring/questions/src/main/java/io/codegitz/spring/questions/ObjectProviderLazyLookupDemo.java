package io.codegitz.spring.questions;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * {@link ObjectProvider} 示例
 * {@link ObjectFactory}
 * @author 张观权
 * @date 2020/11/5 15:11
 **/
public class ObjectProviderLazyLookupDemo {

    @Autowired
    ObjectProvider<User> objectProvider;

    @Autowired
    ObjectFactory<User> objectFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderLazyLookupDemo.class);

        applicationContext.refresh();

        System.out.println(applicationContext.getBean("createUser"));
        ObjectProviderLazyLookupDemo objectProviderLookupDemo = applicationContext.getBean(ObjectProviderLazyLookupDemo.class);
        System.out.println(objectProviderLookupDemo.objectFactory == objectProviderLookupDemo.objectProvider);

        System.out.println(objectProviderLookupDemo.objectFactory.getClass() == objectProviderLookupDemo.objectProvider.getClass());
        System.out.println("user = " + objectProviderLookupDemo.objectFactory.getObject());
        System.out.println("user = " + objectProviderLookupDemo.objectProvider.getObject());
        System.out.println("user = " + applicationContext.getBean(User.class));

        applicationContext.close();
    }

    @Bean
//    @Lazy
    public User createUser(){
        User user = new User();
        user.setId(1L);
        user.setName("Codegitz");
        return user;
    }


}
