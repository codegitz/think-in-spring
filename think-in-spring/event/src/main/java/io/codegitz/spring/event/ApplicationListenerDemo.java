package io.codegitz.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * {@link org.springframework.context.ApplicationListener} 示例
 *
 * @author 张观权
 * @date 2020/10/22 13:20
 * @see org.springframework.context.ApplicationListener
 * @see org.springframework.context.event.EventListener
 **/
@EnableAsync
public class ApplicationListenerDemo implements ApplicationEventPublisherAware {
    public static void main(String[] args) {
//        GenericApplicationContext applicationContext = new GenericApplicationContext();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ApplicationListenerDemo.class);

        // 方法一：面向 Spring 接口
        // a.基于 ConfigurableApplicationContext API 实现
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("接收到事件： " + event);
            }
        });

        // b.将 ApplicationListener 注册为 Spring bean
        // 将 MyapplicationListener 作为 Configuration class 注册
        applicationContext.register(MyApplicationListener.class);

        // 方法二：使用注解 @org.springframework.context.event.EventListener
        applicationContext.refresh(); //触发ContextRefreshedEvent

        applicationContext.start(); //触发ContextStartedEvent

        applicationContext.close(); //触发ContextStoppedEvent

        applicationContext.close(); //触发ContextClosedEvent
    }

    /**
     * 事件发布器 ApplicationEventPublisher 和 ApplicationEventMulticaster
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new ApplicationEvent("Hello,world") {
        });
        applicationEventPublisher.publishEvent("Hello,world");
    }

    static class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            println("MyApplicationListener 接收到事件： " + event);
        }
    }
    @EventListener
    @Order(1)
    public void onApplicationEvent(ContextRefreshedEvent event){
        println("@EventListener 接收到事件 ContextRefreshedEvent");
    }

    @EventListener
    @Order(2)
    public void onApplicationEvent1(ContextRefreshedEvent event){
        println("@EventListener1 接收到事件 ContextRefreshedEvent");
    }
    @EventListener
    @Async
    public void onApplicationEventAsync(ContextRefreshedEvent event){
        println("@EventListener (异步)接收到事件 ContextRefreshedEvent");
    }

    @EventListener
    public void onApplicationEvent(ContextStartedEvent event){
        println("@EventListener 接收到事件 ContextStartedEvent");
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event){
        println("@EventListener 接收到事件 ContextClosedEvent");
    }

    public static void println(Object printable){
        System.out.printf("线程名称: [%s]，事件内容%s : \n",Thread.currentThread().getName(),printable);
    }
}
