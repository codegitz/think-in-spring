package io.codegitz.spring.validation;

import io.codegitz.spring.ioc.overview.domain.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * JavaBeans 示例
 * @author 张观权
 * @date 2020/10/12 19:55
 **/
public class JavaBeansDemo {
    public static void main(String[] args) throws IntrospectionException {

        // stopClass 排除类 （截止类）
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

        // 属性描述符 PropertyDescriptor
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            propertyDescriptor.getReadMethod();  // Getter 方法
            propertyDescriptor.getWriteMethod(); // Setter 方法
            System.out.println(propertyDescriptor);
            }
        );

        // 输出User定义的方法
        Stream.of(beanInfo.getMethodDescriptors()).forEach(System.out::println);
    }
}
