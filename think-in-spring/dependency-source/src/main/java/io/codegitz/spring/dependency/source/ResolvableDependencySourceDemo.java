package io.codegitz.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * ResolvableDependency作为依赖来源
 * @author 张观权
 * @date 2020/9/17 18:00
 **/
public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init(){
        System.out.println(value);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySourceDemo.class);
        // 注册configuration类 -> spring bean
        applicationContext.addBeanFactoryPostProcessor(beanFactory ->{
            beanFactory.registerResolvableDependency(String.class,"Hello,world");
        });
        applicationContext.refresh();
        applicationContext.close();
    }
}
