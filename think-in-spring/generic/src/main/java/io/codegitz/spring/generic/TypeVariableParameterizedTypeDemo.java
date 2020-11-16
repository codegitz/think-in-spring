package io.codegitz.spring.generic;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张观权
 * @date 2020/11/16 16:05
 **/
public class TypeVariableParameterizedTypeDemo<T, K extends  Integer & Type> {

    private K k;

    private List<T> list;

    public static void main(String[] args) {
        Class<TypeVariableParameterizedTypeDemo> typeVariableParameterizedTypeDemoClass = TypeVariableParameterizedTypeDemo.class;

        Field[] declaredFields = typeVariableParameterizedTypeDemoClass.getDeclaredFields();
        for (Field field : declaredFields) {
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
                for (Type actualTypeArgument : actualTypeArguments) {
                    if (actualTypeArgument instanceof TypeVariable) {
                        System.out.println("字段：" + name + "中包含一个类型变量");
                        String name1 = ((TypeVariable) actualTypeArgument).getName();
                        AnnotatedType[] annotatedBounds = ((TypeVariable) actualTypeArgument).getAnnotatedBounds();
                        Type[] bounds = ((TypeVariable) actualTypeArgument).getBounds();
                        GenericDeclaration genericDeclaration = ((TypeVariable) actualTypeArgument).getGenericDeclaration();
                        System.out.println("类型变量的名称为：" + name1);
                        System.out.println("个类型变量的边界为：" + Arrays.toString(bounds));
                        System.out.println("类型变量的申明的位置为：" + genericDeclaration);
                        System.out.println("通过getAnnotatedBounds方法获取到，类型变量的边界为：" + annotatedBounds[0].getType());
                    }
                }
            } else if (genericType instanceof TypeVariable) {
                System.out.println(name + "是一个类型变量,类型名称为：" + typeName);
                TypeVariable typeVariable = (TypeVariable) genericType;
                Type[] bounds = typeVariable.getBounds();
                String name1 = typeVariable.getName();
                AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
                GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
                System.out.println("类型变量的名称为：" + name1);
                System.out.println("个类型变量的边界为：" + Arrays.toString(bounds));
                System.out.println("类型变量的申明的位置为：" + genericDeclaration);
                System.out.println("通过getAnnotatedBounds方法获取到，类型变量的边界为：" + annotatedBounds[0].getType() + "  " + annotatedBounds[1].getType());
            }
        }
    }
}