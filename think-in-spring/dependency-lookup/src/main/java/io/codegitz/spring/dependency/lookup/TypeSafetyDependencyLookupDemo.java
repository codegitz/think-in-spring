package io.codegitz.spring.dependency.lookup;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全依赖查找示例
 * 层次性依赖查找的安全性取决于其扩展的单一类型或者集合类型的BeanFactory接口
 * @author 张观权
 * @date 2020/9/14 17:30
 **/
public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);//默认配置类

        applicationContext.refresh();
        // 演示BeanFactory#getBean()方法的安全性
        displayBeanFactoryGetBean(applicationContext);
        // 演示ObjectFactory#getObject()方法的安全性
        displayObjectFactoryGetObject(applicationContext);
        // 演示ObjectProvider#getIfAvailable()方法的安全性
        displayObjectProviderIfAvailable(applicationContext);
        // 演示ListableBeanFactory#getBenasOfType()方法的安全性
        displayListableBeanFactoryGetBeansOfType(applicationContext);

        // 演示ObjectProvider stream方法的安全性
        displayObjectProviderStreamOps(applicationContext);
        applicationContext.close();

    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStreamOps",() -> userObjectProvider.forEach(System.out::println));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeansException("displayListableBeanFactoryGetBeansOfType",() -> beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderIfAvailable",() -> userObjectProvider.getIfAvailable());
    }

    private static void displayObjectFactoryGetObject(BeanFactory beanFactory) {
        ObjectProvider<User> userObjectProvider = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject",() -> userObjectProvider.getObject());
    }

    private static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeansException("displayBeanFactoryGetBean",() -> beanFactory.getBean(User.class));
    }

    private static void printBeansException(String source,Runnable runnable){
        System.err.println("====================================================");
        System.err.println("source from : " + source);
        try {
            runnable.run();
        }catch (BeansException exception){
            exception.printStackTrace();
        }
    }
}
