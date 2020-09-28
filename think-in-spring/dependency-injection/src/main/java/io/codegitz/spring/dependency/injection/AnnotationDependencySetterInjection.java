package io.codegitz.spring.dependency.injection;

import io.codegitz.spring.ioc.overview.container.AnnotationApplicationContextAsIOCContainer;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;

/**
 * 基于java 注解的Setter方法注入示例
 * @author 张观权
 * @date 2020/9/15 12:54
 **/
public class AnnotationDependencySetterInjection {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencySetterInjection.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String sourcesPath="classpath:/META-INF/dependency-lookup-context.xml";
        // 加载xml资源，生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(sourcesPath);

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }
}
