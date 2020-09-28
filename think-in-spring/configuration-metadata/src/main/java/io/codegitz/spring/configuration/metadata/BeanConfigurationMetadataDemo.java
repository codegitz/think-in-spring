package io.codegitz.spring.configuration.metadata;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ObjectUtils;

/**
 * Bean配置元信息示例
 *
 * @author 张观权
 * @date 2020/9/24 17:34
 **/
public class BeanConfigurationMetadataDemo {
    public static void main(String[] args) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder.addPropertyValue("name", "codegitz");

        final AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 附加属性，不影响 Bean populate initialize
        beanDefinition.setAttribute("name", "hhh");

        // 辅助信息
        beanDefinition.setSource(BeanConfigurationMetadataDemo.class);

        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
                    // 属性存储上下文
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    if (BeanConfigurationMetadataDemo.class.equals(bd.getSource())){
                        String name = (String) bd.getAttribute("name");
                        User user = (User) bean;
                        user.setName(name);
                    }
                }
                return bean;
            }
        });
        beanFactory.registerBeanDefinition("user", beanDefinition);

        User user = beanFactory.getBean("user", User.class);

        System.out.println(user);
    }
}
