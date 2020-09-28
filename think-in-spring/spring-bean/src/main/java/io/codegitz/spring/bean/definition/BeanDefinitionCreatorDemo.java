package io.codegitz.spring.bean.definition;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @author 张观权
 * @date 2020/9/10 18:53
 **/
public class BeanDefinitionCreatorDemo {
    public static void main(String[] args) {
        // 1.通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id",1);
        beanDefinitionBuilder.addPropertyValue("name","beanDefinitionBuilder");
        // 获取BeanDefinition实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition并非是bean的终态，可以自定义修改

        // 2.通过AbstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 设置属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("id",2);
        propertyValues.addPropertyValue("name","genericBeanDefinition");
        propertyValues
                .add("id",3)
                .add("name","hhh");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
