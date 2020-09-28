package io.codegitz.spring.ioc.bean.scope;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义scope{@link ThreadLocalScope} 示例
 * @author 张观权
 * @date 2020/9/18 15:07
 **/
public class ThreadLocalScopeDemo {

    @Bean
    @Scope(ThreadLocalScope.SCOPE_NAME)
    public User user(){
        return createUser();
    }

    public static User createUser(){
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册configuration类 -> spring bean
        applicationContext.register(ThreadLocalScopeDemo.class);
        applicationContext.addBeanFactoryPostProcessor(beanFactory ->{
            // 注册自定义scope
            beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME,new ThreadLocalScope());
        });
        applicationContext.refresh();
        scopeBeansByLookup(applicationContext);
        applicationContext.close();
    }

    private static void scopeBeansByInjection(AnnotationConfigApplicationContext applicationContext) {

    }

    private static void scopeBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0 ; i < 3 ; i++){
            Thread thread = new Thread(()->{
                User user = applicationContext.getBean("user", User.class);
                System.out.printf("ThreadId: %s ,userId: %s",Thread.currentThread().getId(),user.getId());
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
