package io.codegitz.spring.ioc.overview.domain;

/**
 * 公司类
 * @author 张观权
 * @date 2020/10/12 13:20
 **/
public class Company {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
