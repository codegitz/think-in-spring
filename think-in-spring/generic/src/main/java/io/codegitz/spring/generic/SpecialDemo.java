package io.codegitz.spring.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 张观权
 * @date 2020/11/16 15:13
 **/
public class SpecialDemo<T extends Type> {

    T t;

    public static void main(String[] args) {
        Class<SpecialDemo> specialDemoClass = SpecialDemo.class;
//        SpecialDemo<ParameterizedType> specialDemo = new SpecialDemo<>();
        Field[] declaredFields = specialDemoClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Type genericType = declaredField.getGenericType();
            if (genericType instanceof ParameterizedType) {
                System.out.println("t是一个参数化类型");
            } else {
                System.out.println("t不是一个参数化类型");
            }
        }
    }
    // 程序输出：t不是一个参数化类型
}
