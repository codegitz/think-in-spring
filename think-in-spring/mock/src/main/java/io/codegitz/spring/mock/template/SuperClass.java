package io.codegitz.spring.mock.template;

import io.codegitz.spring.mock.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 张观权
 * @date 2021/2/4 11:08
 **/
public abstract class SuperClass {

    private String name;
    private String age;

    @Autowired
    private UserService userService;

    public String sayHello(){
        return "hello,super";
    }

    public String getMsgPushConfig(){
        return "super#getMsgPushConfig()" + userService.getName();
    }

    private String sayHi(){
        return "hi,super";
    }

    public abstract String subMethod();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
