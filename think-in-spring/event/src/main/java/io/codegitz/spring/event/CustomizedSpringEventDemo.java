package io.codegitz.spring.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 * 自定义 Spring 事件示例
 *
 * @author 张观权
 * @date 2020/10/22 20:16
 **/
public class CustomizedSpringEventDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new MySpringEventListener());

        context.refresh();

        context.publishEvent(new MySpringEvent("Hello world"));

        context.close();
    }
}
