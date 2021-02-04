package io.codegitz.spring.mock.impl;

import io.codegitz.spring.mock.UserService;

/**
 * @author 张观权
 * @date 2021/2/3 12:16
 **/
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "Codegitz";
    }
}
