package io.codegitz.spring.configuration.metadata;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;
import java.util.zip.Deflater;

/**
 * 基于 xml 资源的 YAML 外部化配置示例
 *
 * @author 张观权
 * @date 2020/9/28 15:00
 **/
public class XmlBaseYamlPropertyResourceDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("classpath:META-INF\\yaml-property-source-context.xml");

        Map<String, Object> yamlMap = beanFactory.getBean("yamlMap", Map.class);

        System.out.println(yamlMap);
    }
}
