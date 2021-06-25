package io.codegitz.spring.dependency.circular;

import io.codegitz.spring.dependency.circular.Entity.BeanA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 张观权
 * @date 2021/3/15 17:41
 **/
public class CircularApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:\\META-INF\\circular-dependency-injection.xml");
        BeanA a = applicationContext.getBean(BeanA.class);

    }
}
