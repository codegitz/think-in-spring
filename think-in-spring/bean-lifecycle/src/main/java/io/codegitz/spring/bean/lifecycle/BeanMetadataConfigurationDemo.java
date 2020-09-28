package io.codegitz.spring.bean.lifecycle;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * Bean 元信息配置示例
 *
 * @author 张观权
 * @date 2020/9/18 17:09
 **/
public class BeanMetadataConfigurationDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 实例化一个PropertiesBeanDefinitionReader
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "classpath:user.properties";
        Resource resource = new ClassPathResource(location);
        // 出现乱码可以用 EncodedResource
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
//        int beanCounts = propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);
        int beanCounts = propertiesBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("已加载的bean数量： " + beanCounts);
        // 通过bean id  和类型查找
        User user = beanFactory.getBean("user",User.class);
        System.out.println(user);
    }
}
