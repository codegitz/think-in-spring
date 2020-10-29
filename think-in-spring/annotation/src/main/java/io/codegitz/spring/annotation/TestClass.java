package io.codegitz.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 张观权
 * @date 2020/10/28 13:08
 **/
@MyComponent2
public class TestClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TestClass.class);
        applicationContext.refresh();
        TestClass bean = applicationContext.getBean(TestClass.class);
        System.out.println(bean);
        applicationContext.close();
    }
}
