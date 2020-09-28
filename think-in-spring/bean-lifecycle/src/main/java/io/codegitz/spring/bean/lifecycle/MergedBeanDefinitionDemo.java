package io.codegitz.spring.bean.lifecycle;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 合并示例
 * @author 张观权
 * @date 2020/9/21 15:19
 **/
public class MergedBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String location = "classpath:META-INF\\dependency-lookup-context.xml";
        Resource resource = new ClassPathResource(location);
        // 出现乱码可以用 EncodedResource
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
//        int beanCounts = propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);
        int beanCounts = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("已加载的bean数量： " + beanCounts);
        // 通过bean id  和类型查找
        User user = defaultListableBeanFactory.getBean("user",User.class);
        System.out.println(user);

        User superUser = defaultListableBeanFactory.getBean("superUser",User.class);
        System.out.println(superUser);
    }
}
