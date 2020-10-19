package io.codegitz.spring.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Java 泛型 api 示例
 * @author 张观权
 * @date 2020/10/18 23:25
 **/
public class GenericApiDemo {
    public static void main(String[] args) throws InterruptedException {

        // 原生类型 primitive types : int float double
        Class intClass = int.class;

        // 数组类型 Array types : int[] Object[]
        Class arrayClass = Object[].class;

        // 原始类型 raw types : java.lang.String
        Class rawClass = String.class;

        // 泛型参数类型 parameterized type
        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();
        // parameterizedType.getRawType() = java.util.AbstractList

        // 泛型类型变量 Type Variable
        System.out.println(parameterizedType.toString());

        // <E>
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        Stream.of(actualTypeArguments).map(TypeVariable.class::cast).forEach(System.out::println);

        while (true){
            Thread.sleep(1000L);
            System.out.println("Thread.sleep(1000L);");
        }
    }
}
