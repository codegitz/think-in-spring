package io.codegitz.spring.argument.entity;

import java.util.List;

/**
 * User 类
 * @author 张观权
 * @date 2020/10/29 17:11
 **/
public class User {

    private String name;

    private int age;

    private List<Contacts> contacts;

    public List<Contacts> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contacts=" + contacts +
                '}';
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
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
