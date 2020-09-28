package io.codegitz.spring.bean.lifecycle.holder;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * {@link UserHolder} User的包装类
 * @author 张观权
 * @date 2020/9/22 10:27
 **/
public class UserHolder implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware {

    private final User user;

    private Integer number;

    private String beanName;

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UserHolder(User user1){
        this.user = user1;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = beanName;
    }
}
