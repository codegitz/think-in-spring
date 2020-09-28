package io.codegitz.spring.dependency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link org.springframework.beans.BeanInstantiationException}示例
 * @author 张观权
 * @date 2020/9/15 11:20
 **/
public class BeanInstantiationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
        applicationContext.registerBeanDefinition("errorBean",beanDefinitionBuilder.getBeanDefinition());
        applicationContext.refresh();
        applicationContext.close();
    }

}
