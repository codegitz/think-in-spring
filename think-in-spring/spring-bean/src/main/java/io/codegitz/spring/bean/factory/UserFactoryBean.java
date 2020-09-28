package io.codegitz.spring.bean.factory;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 张观权
 * @date 2020/9/11 16:11
 **/
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
