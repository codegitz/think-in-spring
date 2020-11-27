package io.codegitz.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 注入 {@link org.springframework.context.ApplicationEventPublisher}
 * @author 张观权
 * @date 2020/10/22 20:25
 **/
public class InjectingApplicationEventPublisherDemo implements ApplicationContextAware, ApplicationEventPublisherAware, BeanPostProcessor {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init(){
        // #3
        applicationEventPublisher.publishEvent(new MySpringEvent("the event from @Autowired ApplicationEventPublisher"));
        // #4
        applicationContext.publishEvent(new MySpringEvent("the event from @Autowired ApplicationContext"));

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectingApplicationEventPublisherDemo.class);
        applicationContext.addApplicationListener(new MySpringEventListener());
        applicationContext.refresh();
        applicationContext.close();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // #1
        applicationEventPublisher.publishEvent(new MySpringEvent("the event from setApplicationContext"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        // #2
        applicationEventPublisher.publishEvent(new MySpringEvent("the event from setApplicationEventPublisher"));
    }
}
