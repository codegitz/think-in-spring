package io.codegitz.spring.configuration.metadata;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import javax.jws.soap.SOAPBinding;

/**
 * spring xml 元素扩展
 * @author 张观权
 * @date 2020/9/28 13:06
 **/
public class ExtensibleXmlAuthoringDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:META-INF\\users-context.xml");

        User usr = defaultListableBeanFactory.getBean(User.class);

        System.out.println(usr);
    }
}
