package io.codegitz.spring.data.binding;

/**
 * @author 张观权
 * @date 2020/10/13 11:10
 **/
public class Parent {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
