package io.codegitz.spring.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于{@link org.springframework.beans.factory.Aware} 接口的函数回调注入示例
 * @author 张观权
 * @date 2020/9/15 12:54
 **/
public class AwareInterfaceDependencyInjection implements BeanFactoryAware, ApplicationContextAware {

    static BeanFactory beanFactory;
    static ApplicationContext context;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AwareInterfaceDependencyInjection.class);

        applicationContext.refresh();

        System.out.println(beanFactory == applicationContext.getBeanFactory());
        System.out.println(context == applicationContext);
        applicationContext.close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceDependencyInjection.context = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjection.beanFactory = beanFactory;

    }
}
