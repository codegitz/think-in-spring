package io.codegitz.spring.ioc.overview.container;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * {@link BeanFactory}作为IOC容器
 * @author 张观权
 * @date 2020/9/10 18:06
 **/
public class BeanFactoryAsIOCContainer {
    public static void main(String[] args) {
        //创建beanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:META-INF\\dependency-lookup-context.xml";
        int beanDefinitionsCounts = reader.loadBeanDefinitions(location);
        System.out.println("加载的bean数量： "+ beanDefinitionsCounts);
        //依赖查找集合对象
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找集合： "+userMap);
        }
    }
}
