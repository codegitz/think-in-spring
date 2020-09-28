package io.codegitz.spring.bean.lifecycle;

import io.codegitz.spring.bean.lifecycle.holder.UserHolder;
import io.codegitz.spring.ioc.overview.domain.SuperUser;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * bean 实例化生命周期示例
 *
 * @author 张观权
 * @date 2020/9/21 15:19
 **/
public class BeanInstantiationLifecycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 添加BeanPostProcessor实现
        defaultListableBeanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String[] locations = {"classpath:META-INF\\dependency-lookup-context.xml","classpath:bean-constructor-dependency-injection.xml"};
        int beanCounts = xmlBeanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载的bean数量： " + beanCounts);
        // 通过bean id  和类型查找
        User user = defaultListableBeanFactory.getBean("user", User.class);
        System.out.println(user);

        User superUser = defaultListableBeanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        UserHolder userHolder = defaultListableBeanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)){
                return new SuperUser();
            }
                return null;
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())){
                // user 对象不允许属性填入（配置元信息->属性值）
                return false;
            }
            return true;

        }

        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())){
                    MutablePropertyValues propertyValues = new MutablePropertyValues();
                    propertyValues.addPropertyValue("number","2");
                    return propertyValues;
            }
            return null;
        }
    }
}
