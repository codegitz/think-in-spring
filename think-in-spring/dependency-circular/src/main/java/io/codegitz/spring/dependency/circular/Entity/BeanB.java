package io.codegitz.spring.dependency.circular.Entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 张观权
 * @date 2021/3/15 17:37
 **/
public class BeanB {

    @Autowired
    private BeanC c;

    public BeanC getC() {
        return c;
    }

    public void setC(BeanC c) {
        this.c = c;
    }
}
