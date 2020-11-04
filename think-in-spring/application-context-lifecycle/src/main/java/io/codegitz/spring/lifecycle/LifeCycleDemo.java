package io.codegitz.spring.lifecycle;

import org.springframework.context.support.GenericApplicationContext;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.rootBeanDefinition;

/**
 * @author 张观权
 * @date 2020/11/4 20:23
 **/
public class LifeCycleDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        // 注解 MyLifecycle 成为一个 Spring Bean
        context.registerBeanDefinition("myLifecycle", rootBeanDefinition(MyLifeCycle.class).getBeanDefinition());

        // 刷新 Spring 应用上下文
        context.refresh();

        // 启动 Spring 应用上下文
        context.start();

        // 停止 Spring 应用上下文
        context.stop();

        // 关闭 Spring 应用
        context.close();
    }
}
