package io.codegitz.spring.argument.entity;

/**
 * @author 张观权
 * @date 2020/10/29 17:13
 **/
public class Contacts {

    private String name;

    private String phone;

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
