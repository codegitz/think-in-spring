package io.codegitz.spring.generic;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author 张观权
 * @date 2020/11/16 16:50
 **/
public class GenericArrayTypeDemo<T> {
    T[] t1;

    T[][] t2;

    List<T>[] list;

    List<String>[] stringListArray;

    String[][] stringArray;

    public static void main(String[] args) {
        Class<GenericArrayTypeDemo> genericArrayTypeDemoClass = GenericArrayTypeDemo.class;
        Field[] declaredFields = genericArrayTypeDemoClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            Type genericType = declaredField.getGenericType();
            if (genericType instanceof GenericArrayType) {
                System.out.println(name + "是一个泛型数组");
                Type genericComponentType = ((GenericArrayType) genericType).getGenericComponentType();
                System.out.println("数组的元素类型为：" + genericComponentType);
            } else {
                System.out.println(name + "不是一个泛型数组");
            }
        }
    }
}