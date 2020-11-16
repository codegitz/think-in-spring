package io.codegitz.spring.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 张观权
 * @date 2020/11/16 14:53
 **/
public class ParameterizedTypeDemo extends OwnerTypeDemo<String> {

    private List<String> stringList;

    private Map<String, String> stringStringMap;

    private Map.Entry<String, ?> entry;

    private OwnerTypeDemo<String>.Test<String> testOwnerType;

    private List list;

    private Map map;

    public void test(List<String> stringList, List list) {

    }

    public static void main(String[] args) {
        Class<ParameterizedTypeDemo> ParameterizedTypeDemoClass = ParameterizedTypeDemo.class;
        Field[] fields = ParameterizedTypeDemoClass.getDeclaredFields();
        for (Field field : fields) {
            Type genericType = field.getGenericType();
            String typeName = genericType.getTypeName();
            String name = field.getName();
            if (genericType instanceof ParameterizedType) {
                System.out.println(name + "是一个参数化类型,类型名称为：" + typeName);
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                System.out.println(name + "的actualTypeArguments：" + Arrays.toString(actualTypeArguments));
                Type ownerType = parameterizedType.getOwnerType();
                System.out.println(name + "的ownerType：" + ownerType);
                Type rawType = parameterizedType.getRawType();
                System.out.println(name + "的rawType：" + rawType);
            } else {
                System.out.println(name + "不是一个参数化类型,类型名称为：" + typeName);
            }
        }
        System.out.println("===================开始测试方法中的参数=========================");
        Method[] declaredMethods = ParameterizedTypeDemoClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
            for (int i = 0; i < genericParameterTypes.length; i++) {
                Type parameterType = genericParameterTypes[i];
                String typeName = parameterType.getTypeName();
                System.out.println("打印" + methodName + "方法的参数，" + "第" + (i + 1) + "个参数为：" + parameterType);
                if (parameterType instanceof ParameterizedType) {
                    System.out.println("第" + (i + 1) + "个参数是一个参数化类型, 类型名称为 ： " + typeName);
                } else {
                    System.out.println("第" + (i + 1) + "个参数不是一个参数化类型, 类型名称为 ： " + typeName);
                }
            }
        }
        System.out.println("===================开始测试父类中的泛型=========================");
        // 获取带有泛型的父类
        Type genericSuperclass = ParameterizedTypeDemoClass.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            System.out.println("父类是一个参数化类型，类型名称为：" + genericSuperclass.getTypeName());
        }

    }
}

class OwnerTypeDemo<T> {
    class Test<T> {

    }
}