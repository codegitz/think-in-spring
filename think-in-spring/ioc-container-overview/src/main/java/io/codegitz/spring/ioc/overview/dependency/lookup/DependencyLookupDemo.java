package io.codegitz.spring.ioc.overview.dependency.lookup;

import io.codegitz.spring.ioc.overview.annotation.Super;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 * 1.通过名称查找
 * 2.通过类型查找
 * @author 张观权
 * @date 2020/9/9 18:10
 **/
public class DependencyLookupDemo {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF\\dependency-lookup-context.xml");
//        lookupInRealTime(beanFactory);
//        lookupInLazyTime(beanFactory);
        //安装类型查找
//        lookupByType(beanFactory);
        //按照类型查找对象集合
        lookupCollectionByType(beanFactory);
        //安装注解查询
        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("注解查找： "+ beansWithAnnotation);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找集合： "+userMap);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("类型查找： "+ user);
    }

    private static void lookupInLazyTime(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找： "+ user);
    }

    public static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找： "+ user);
    }
}
