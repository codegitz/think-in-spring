package io.codegitz.spring.bean.configuration;

import io.codegitz.spring.bean.factory.ObjectFactory;

/**
 * @author 张观权
 * @date 2021/10/9 17:16
 **/
public class ObjectFactoryDemo {
    public static void main(String[] args) {
        String beanName = "codegitz";
        Object singleton = getSingleton(beanName, () -> {
            return creatBean(beanName);
        });
        System.out.println(singleton);
    }
    public static <T> T getSingleton(String beanName, ObjectFactory<T> singletonFactory){
        System.out.println("getSingleton(): " + beanName);
        return singletonFactory.getObject();
    }

    public static <T> T creatBean(String beanName){
        System.out.println("creatBean(): " + beanName);
        return (T) new Object();
    }
}
