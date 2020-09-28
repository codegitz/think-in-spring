package io.codegitz.spring.ioc.overview.domain;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 张观权
 * @date 2020/9/9 18:12
 **/
public class User implements BeanNameAware {

    private Long id;

    private String name;

    private String beanName;

    public static User createUser() {
        return new User();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("User bean { "+beanName+" }初始化....");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("User bean { "+beanName+" }销毁....");
    }


    public void setBeanName(String name) {
        this.beanName = name;
    }
}