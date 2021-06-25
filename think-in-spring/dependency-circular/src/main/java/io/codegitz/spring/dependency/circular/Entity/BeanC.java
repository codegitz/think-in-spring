package io.codegitz.spring.dependency.circular.Entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 张观权
 * @date 2021/3/15 17:37
 **/
public class BeanC {

    @Autowired
    private BeanA a;

    public BeanA getA() {
        return a;
    }

    public void setA(BeanA a) {
        this.a = a;
    }
}
