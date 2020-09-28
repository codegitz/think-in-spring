package io.codegitz.spring.bean.definition;

import io.codegitz.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;

/**
 * bean 垃圾回收（GC）示例
 * @author 张观权
 * @date 2020/9/14 11:22
 **/
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        System.out.println("spring上下文准备启动");
        applicationContext.refresh();
        System.out.println("spring上下文已经启动");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println("spring上下文准备关闭");
        applicationContext.close();
        System.out.println("spring上下文已经关闭");
        Thread.sleep(5000L);
        System.gc();
        Thread.sleep(5000L);
    }
}
