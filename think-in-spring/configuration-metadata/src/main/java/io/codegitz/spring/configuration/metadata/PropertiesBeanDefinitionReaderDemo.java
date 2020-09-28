package io.codegitz.spring.configuration.metadata;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * {@link PropertiesBeanDefinitionReader} 示例
 * @author 张观权
 * @date 2020/9/24 20:04
 **/
public class PropertiesBeanDefinitionReaderDemo {
    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:META-INF\\users-config.properties");

        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");

        propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);

        User user = (User) beanFactory.getBean("user",User.class);

        System.out.println(user);
    }
}
