package io.codegitz.spring.mock.template;

import io.codegitz.spring.mock.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张观权
 * @date 2021/2/4 11:10
 **/
@Service
public class Children extends SuperClass  {

    @Autowired
    private UserService userService;

    private String childProperty;

    public String getChildProperty() {
        return childProperty;
    }

    public void setChildProperty(String childProperty) {
        this.childProperty = childProperty;
    }

    @Override
    public String subMethod() {
        return "subMethodImplements";
    }

    public String childrenMethodInvokeSuper(){
        return super.sayHello() + userService.getName();
    }
}
