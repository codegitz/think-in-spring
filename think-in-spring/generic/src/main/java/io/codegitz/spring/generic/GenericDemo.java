package io.codegitz.spring.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Java 泛型示例
 * @author 张观权
 * @date 2020/10/16 20:36
 **/
public class GenericDemo {
    public static void main(String[] args) {
        // Java 7 diamond grammar
        Collection<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
//        list.add(1); compile fail
        // Generic erasure
        Collection tmp=list;
        tmp.add(1); // compile success,cheated the compiler.

        System.out.println(tmp);
    }
}
