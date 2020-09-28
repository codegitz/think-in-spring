package io.codegitz.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * "Constructor" Auto-wiring 依赖 构造器 注入示例
 * @author 张观权
 * @date 2020/9/15 15:23
 **/
public class AutoWiringDependencyConstructorInjection {
    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String sourcesPath="classpath:/META-INF/autowiring-dependency-constructor-injection.xml";
        // 加载xml资源，生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(sourcesPath);
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
