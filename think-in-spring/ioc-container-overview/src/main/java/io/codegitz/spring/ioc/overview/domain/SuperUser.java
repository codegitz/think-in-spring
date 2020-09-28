package io.codegitz.spring.ioc.overview.domain;


import io.codegitz.spring.ioc.overview.annotation.Super;

/**
 * 超级用户
 * @author 张观权
 * @date 2020/9/9 18:38
 **/
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} ==" + super.toString();
    }
}
