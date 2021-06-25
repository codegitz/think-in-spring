package io.codegitz.spring.common.mistakes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author 张观权
 * @date 2021/4/28 14:33
 **/
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("io.codegitz.spring.common.mistakes");
        ((AbstractApplicationContext)applicationContext).close();
    }
}
