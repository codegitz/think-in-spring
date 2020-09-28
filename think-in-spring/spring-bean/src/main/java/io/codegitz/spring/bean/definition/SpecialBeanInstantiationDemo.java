package io.codegitz.spring.bean.definition;

import io.codegitz.spring.bean.factory.DefaultUserFactory;
import io.codegitz.spring.bean.factory.UserFactory;
import io.codegitz.spring.ioc.overview.domain.User;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特设的 bean 实例化示例
 * 1. {@link ServiceLoader} 实现
 * 2. {@link AutowireCapableBeanFactory} 实现
 * @author 张观权
 * @date 2020/9/11 15:58
 **/
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF\\special-bean-instantiation-context.xml");
        //通过ApplicationContext获取AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<UserFactory> userFactoryServiceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(userFactoryServiceLoader);

        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());

//        demoServiceLoader();
    }

    public static void demoServiceLoader(){
        ServiceLoader<UserFactory> userFactories = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(userFactories);
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader){
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }
    }
}
