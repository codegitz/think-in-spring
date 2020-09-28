package io.codegitz.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 张观权
 * @date 2020/9/11 16:05
 **/
public class DefaultUserFactory implements UserFactory , InitializingBean , DisposableBean {

    // 1.基于@PostConstruct
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct: UserFactory初始化中...");
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法initUserFactory: UserFactory初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() : UserFactory初始化中...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy: UserFactory销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy(): UserFactory销毁中...");
    }

    public void doDestroy(){
        System.out.println("自定义doDestroy(): UserFactory销毁中...");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("DefaultUserFactory对象正在被回收...");
    }
}
