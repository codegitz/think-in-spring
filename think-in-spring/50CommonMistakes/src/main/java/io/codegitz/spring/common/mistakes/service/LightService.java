package io.codegitz.spring.common.mistakes.service;

import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/4/28 14:34
 **/
@Service
public class LightService implements Closeable {

    public static final String dd = null;

    public void check() {
        System.out.println("check()...");
    }

    public void shutdown() {
        System.out.println("shutdown()...");
    }

    public void close1() {
        System.out.println("close()...");
    }

    public void close() throws IOException {
        System.out.println("Closeable close()...");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        for (String code : demo.getStrings()){
            System.out.println(code);
        }
    }

    static class Demo {
        List<String> strings;

        public List<String> getStrings() {
            return strings;
        }

        public void setStrings(List<String> strings) {
            this.strings = strings;
        }
    }

//    public static <T> T convertEnum(String enumCode,Class<T> clz){
//        T[] enumConstants = clz.getEnumConstants();
//        T enumConstant = enumConstants[0];
//        for (T t : enumConstants){
//            if (t.getCode.equals(enumCode)){
//                return t;
//            }
//        }
//        return null;
//    }
}
