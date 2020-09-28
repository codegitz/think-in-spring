package io.codegitz.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * 注解 BeanDefinition 解析示例
 *
 * @author 张观权
 * @date 2020/9/18 17:47
 **/
public class AnnotatedBeanDefinitionParsingDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(defaultListableBeanFactory);
        int beanDefinitionCountBefore = defaultListableBeanFactory.getBeanDefinitionCount();
        annotatedBeanDefinitionReader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int beanDefinitionCountAfter = defaultListableBeanFactory.getBeanDefinitionCount();
        int beanCount = beanDefinitionCountAfter - beanDefinitionCountBefore;
        System.out.println("已注册bean数量: " + beanCount);

        // 普通class作为Component注册到Spring IOC容器中
        // beanName 由BeanNameGenerator生成
        AnnotatedBeanDefinitionParsingDemo demo = defaultListableBeanFactory.getBean("annotatedBeanDefinitionParsingDemo", AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo);

    }
}
