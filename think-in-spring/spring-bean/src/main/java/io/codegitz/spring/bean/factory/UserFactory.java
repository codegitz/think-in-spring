package io.codegitz.spring.bean.factory;

import io.codegitz.spring.ioc.overview.domain.User;

/**
 * @author 张观权
 * @date 2020/9/11 16:04
 **/
public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }
}
