package io.codegitz.spring.questions;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 循环引用示例
 * @author 张观权
 * @date 2020/11/6 15:11
 **/
public class CircularReferencesDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(CircularReferencesDemo.class);
//        applicationContext.setAllowCircularReferences(false);

        applicationContext.refresh();


        System.out.println("student: "+ applicationContext.getBean(Student.class));
        System.out.println("Classroom: "+ applicationContext.getBean(Classroom.class));

        applicationContext.close();
    }

    @Bean
    public static Student student(){
        Student student = new Student();
        student.setAge(23L);
        return student;
    }

    @Bean
    public static Classroom classroom(){
        Classroom classroom = new Classroom();
        classroom.setName("classroom");
        return classroom;
    }

}
