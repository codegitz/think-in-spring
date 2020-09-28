package io.codegitz.spring.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 依赖来源
 * @author 张观权
 * @date 2020/9/17 12:57
 **/
public class DependencyDemo {

    // 注入在 postProcessorProperties()方法执行，早于setter注入，也早于@PostConstruct
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void init(){
        System.out.println("beanFactory == applicationContext : " + (beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getAutowireCapableBeanFactory() : " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext : " + (resourceLoader == applicationContext));
        System.out.println("applicationEventPublisher == applicationContext : " + (applicationEventPublisher == applicationContext));
    }

    @PostConstruct
    public void initByLookup(){
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ApplicationEventPublisher.class);
        getBean(ResourceLoader.class);
    }

    private <T> T getBean(Class<T> beanType){
        try {
            return beanFactory.getBean(beanType);
        }catch (NoSuchBeanDefinitionException e){
            System.err.println("当前类型 " + beanType.getName() + " 无法在BeanFactory中查找！");
        }
        return null;
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册configuration类 -> spring bean
        applicationContext.register(DependencyDemo.class);
        applicationContext.refresh();
        DependencyDemo demo = applicationContext.getBean(DependencyDemo.class);
        applicationContext.close();
    }
}
