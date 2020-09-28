package io.codegitz.spring.dependency.lookup;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.support.SimpleTriggerContext;


/**
 * 通过{@link org.springframework.beans.factory.ObjectProvider} 进行依赖查找
 * @author 张观权
 * @date 2020/9/14 12:52
 **/
public class ObjectProviderDemo {//@Configuration注解是非必须的

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);//默认配置类
        applicationContext.refresh();
        lookupByObjectProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);
        applicationContext.close();

    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
//        Iterable<String> stringIterable = beanProvider;
//        for (String s:beanProvider
//             ) {
//            System.out.println(s);
//        }
        beanProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userProvider = applicationContext.getBeanProvider(User.class);
        User user = userProvider.getIfAvailable(User::createUser);
        System.out.println("当前user对象： " + user);
    }

    @Bean
    @Primary
    public String helloWorld(){
        return "Hello,World";
    }

    @Bean
    public String message(){
        return "Message";
    }
    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
    }
}
