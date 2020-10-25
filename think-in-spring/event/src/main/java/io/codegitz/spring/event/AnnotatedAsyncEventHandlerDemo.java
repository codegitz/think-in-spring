package io.codegitz.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * 注解实现异步事件处理器示例
 * @author 张观权
 * @date 2020/10/25 16:26
 **/
@EnableAsync
public class AnnotatedAsyncEventHandlerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotatedAsyncEventHandlerDemo.class);
        applicationContext.refresh(); // 初始化ApplicationEventMulticaster

        applicationContext.publishEvent(new MySpringEvent("Hello,world"));

        applicationContext.close();
    }


    @Async
    @EventListener
    public void onEvent(MySpringEvent event){
        System.out.printf("[线程 ：%s 监听到事件 : %s ]\n",Thread.currentThread().getName(),event);
    }

    @Bean
    public Executor taskExecutor(){
        return Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-taskExecutor"));
    }
}
