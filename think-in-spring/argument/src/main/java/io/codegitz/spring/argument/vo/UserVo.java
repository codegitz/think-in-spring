package io.codegitz.spring.argument.vo;

/**
 * @author 张观权
 * @date 2020/10/29 17:20
 **/
public class UserVo {

    private String name;

    private int age;

    @Override
    public String
    toString() {
        return "UserVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
