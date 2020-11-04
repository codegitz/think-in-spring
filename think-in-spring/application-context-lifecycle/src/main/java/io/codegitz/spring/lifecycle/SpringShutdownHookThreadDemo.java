package io.codegitz.spring.lifecycle;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.rootBeanDefinition;

/**
 * Spring Shutdown Hook 线程示例
 * @author 张观权
 * @date 2020/11/4 20:23
 **/
public class SpringShutdownHookThreadDemo {
    public static void main(String[] args) throws IOException {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
            @Override
            public void onApplicationEvent(ContextClosedEvent event) {
                System.out.printf("线程: %s 接受到 ContextClosedEvent事件\n",Thread.currentThread().getName());
            }
        });

        // 刷新 Spring 应用上下文
        context.refresh();

        context.registerShutdownHook();
        System.out.println("Press any key to continue....");
        System.in.read();

        // 关闭 Spring 应用
        context.close();
    }
}
