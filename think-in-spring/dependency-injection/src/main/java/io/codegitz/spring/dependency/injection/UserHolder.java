package io.codegitz.spring.dependency.injection;

import io.codegitz.spring.ioc.overview.domain.User;

/**
 * {@link io.codegitz.spring.ioc.overview.domain.User}的holder类
 * @author 张观权
 * @date 2020/9/15 13:03
 **/
public class UserHolder {

    private User user;

    public UserHolder(){}

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
