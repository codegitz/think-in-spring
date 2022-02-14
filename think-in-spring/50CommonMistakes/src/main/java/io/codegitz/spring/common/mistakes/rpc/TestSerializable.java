package io.codegitz.spring.common.mistakes.rpc;

import java.io.*;

public class TestSerializable {
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String home = System.getProperty("user.home");
//        FileOutputStream fileOutputStream = new FileOutputStream(home + "/student.data");
//        Student student = new Student();
//        student.setId("1");
//        student.setName("Codegitz");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(student);
//        objectOutputStream.flush();
//        objectOutputStream.close();
//
//        FileInputStream fileInputStream = new FileInputStream(home + "/student.data");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Student s = (Student) objectInputStream.readObject();
//        System.out.println(s.toString());
//        System.out.println(student == s);
//    }
public static void main(String[] args) {
    int a = 3;
    a+=a-=a*=a;
    System.out.println('\"');
}
}
