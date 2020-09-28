package io.codegitz.spring.ioc.overview.container;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * {@link ApplicationContext} 作为IOC容器
 * @author 张观权
 * @date 2020/9/10 18:06
 **/
@Component
public class AnnotationApplicationContextAsIOCContainer {
    public static void main(String[] args) {
        //创建beanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIOCContainer.class);
        applicationContext.refresh();
        //加载配置
        //依赖查找集合对象
        lookupCollectionByType(applicationContext);
    }

    @Bean
    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setName("hhh");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找集合： "+userMap);
        }
    }
}
