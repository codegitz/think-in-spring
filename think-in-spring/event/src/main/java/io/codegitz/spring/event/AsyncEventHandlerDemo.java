package io.codegitz.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import sun.net.www.content.text.Generic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步事件处理器示例
 * @author 张观权
 * @date 2020/10/25 16:26
 **/
public class AsyncEventHandlerDemo {
    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();

        applicationContext.addApplicationListener(new MySpringEventListener());
        applicationContext.refresh(); // 初始化ApplicationEventMulticaster

        ApplicationEventMulticaster multicaster = applicationContext.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
        if (multicaster instanceof SimpleApplicationEventMulticaster){
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = (SimpleApplicationEventMulticaster) multicaster;
            ExecutorService executorService = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-event-execute-pool"));
            // 同步 -> 异步
            simpleApplicationEventMulticaster.setTaskExecutor(executorService);
            // 添加 ContextClosedEvent 事件监听
            applicationContext.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent event) {
                    if (!executorService.isShutdown()){
                        executorService.shutdown();
                    }

                }
            });
        }
        applicationContext.publishEvent(new MySpringEvent("Hello,world"));

        applicationContext.close();
    }
}
