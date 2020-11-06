package io.codegitz.spring.questions;

import org.springframework.beans.factory.annotation.Autowired;
import sun.util.resources.ga.LocaleNames_ga;

/**
 * @author 张观权
 * @date 2020/11/6 12:52
 **/
public class Student {

    private String name;

    private Long age;

    @Autowired
    private Classroom classroom;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classroom.name=" + classroom.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
