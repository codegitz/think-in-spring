package io.codegitz.spring.ioc.overview.repository;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * 用户信息仓库
 * @author 张观权
 * @date 2020/9/10 13:01
 **/
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
