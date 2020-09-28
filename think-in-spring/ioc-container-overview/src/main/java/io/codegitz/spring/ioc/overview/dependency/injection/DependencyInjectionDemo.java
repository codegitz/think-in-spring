package io.codegitz.spring.ioc.overview.dependency.injection;

import io.codegitz.spring.ioc.overview.annotation.Super;
import io.codegitz.spring.ioc.overview.domain.User;
import io.codegitz.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

/**
 * 依赖注入
 * @author 张观权
 * @date 2020/9/9 18:10
 **/
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF\\dependency-injection-context.xml");
//        lookupCollectionByType(beanFactory);
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
//        System.out.println(userRepository.toString());
        System.out.println(userRepository.getObjectFactory());
        System.out.println(userRepository.getObjectFactory().getObject());
        System.out.println(beanFactory);
        System.out.println(userRepository.getObjectFactory().getObject() == beanFactory);
//        System.out.println(userRepository.getBeanFactory() == beanFactory);

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
}
