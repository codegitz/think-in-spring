package io.codegitz.spring.questions;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @author 张观权
 * @date 2020/11/6 12:53
 **/
public class Classroom {

    private String name;

    @Autowired
    private Collection<Student> students;

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
