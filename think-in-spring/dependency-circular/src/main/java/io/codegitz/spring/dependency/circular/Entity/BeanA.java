package io.codegitz.spring.dependency.circular.Entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 张观权
 * @date 2021/3/15 17:37
 **/
public class BeanA {

    @Autowired
    private BeanB b;

    public BeanB getB() {
        return b;
    }

    public void setB(BeanB b) {
        this.b = b;
    }
}
