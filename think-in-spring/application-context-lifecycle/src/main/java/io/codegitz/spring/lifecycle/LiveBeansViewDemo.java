package io.codegitz.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.springframework.context.support.LiveBeansView.MBEAN_DOMAIN_PROPERTY_NAME;

/**
 * {@link org.springframework.context.support.LiveBeansView} 示例
 * @author 张观权
 * @date 2020/11/3 17:18
 **/
public class LiveBeansViewDemo {

    public static void main(String[] args) throws IOException {

        System.setProperty(MBEAN_DOMAIN_PROPERTY_NAME,"io.codegitz.spring");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(LiveBeansViewDemo.class);
        applicationContext.refresh();

        System.out.println("Press any key to continue...");
        System.in.read();
        applicationContext.close();
    }
}
