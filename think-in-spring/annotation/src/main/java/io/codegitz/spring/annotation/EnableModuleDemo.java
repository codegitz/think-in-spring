package io.codegitz.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 张观权
 * @date 2020/10/29 20:36
 **/
@EnableHelloWorld
public class EnableModuleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(EnableModuleDemo.class);
        applicationContext.refresh();
        String helloWorld = applicationContext.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        applicationContext.close();
    }
}
