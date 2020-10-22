package io.codegitz.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 层次性 Spring 事件传播示例
 *
 * @author 张观权
 * @date 2020/10/22 19:22
 **/
public class HierarchicalSpringEventPropagateDemo {
    public static void main(String[] args) {
        // 1.创建 parent spring 应用上下文
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.setId("parent-context");
        // 注册 MyListener 到 parent spring 应用上下文
        parentContext.register(MyListener.class);

        // 2.创建 current spring 应用上下文
        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.setId("current-context");
        // 注册 MyListener 到 current spring 应用上下文
        currentContext.register(MyListener.class);

        // 3.current -> parent
        currentContext.setParent(parentContext);

        // 4.启动 parent spring 应用上下文
        parentContext.refresh();

        // 5.启动 current spring 应用上下文
        currentContext.refresh();

        // 关闭应用上下文
        // 这两个关闭的顺序不一样，事件也会不一样
        currentContext.close();
        parentContext.close();

    }

    static class MyListener implements ApplicationListener<ApplicationContextEvent> {

        private String name = "";

        // 过滤重复事件
        private static Set<ApplicationContextEvent> processedEvents = new LinkedHashSet<>();

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            if (processedEvents.add(event)){
                System.out.printf("监听到 Spring 应用上下文 [ ID : %s ] 的 ApplicationContextEvent : %s 事件\n", event.getApplicationContext().getId(), event.getClass().getSimpleName());
            }
        }
    }
}
