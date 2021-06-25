package io.codegitz.spring.aop.service;

/**
 * @author 张观权
 * @date 2021/4/8 13:14
 **/
public class DefaultEchoService implements EchoService {
    public String echo() {
        System.out.println("DefaultEchoService print echo...");
        return "echo";
    }

    public String study() {
        System.out.println("DefaultEchoService print study...");
        return "study";
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aaa")
                .append(",")
                .append("bbbb")
                .append(";")
                .append("ccc")
                .append(",")
                .append("dddd")
                .append(";");
        System.out.println(stringBuilder.substring(0,stringBuilder.length() - 2));
    }
}
