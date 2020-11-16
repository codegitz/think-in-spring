package io.codegitz.spring.generic;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2020/11/16 15:32
 **/
public class TypeVariableDemo<T, K extends Integer & Type> {

    public <U extends Long, V> void testTypeVariable(Map<U, V> map) {

    }

    public static void main(String[] args) {
        Class<TypeVariableDemo> typeVariableDemoClass = TypeVariableDemo.class;
        TypeVariable<Class<TypeVariableDemo>>[] typeParameters = typeVariableDemoClass.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            TypeVariable<Class<TypeVariableDemo>> typeParameter = typeParameters[i];
            Type[] bounds = typeParameter.getBounds();
            String name = typeParameter.getName();
            AnnotatedType[] annotatedBounds = typeParameter.getAnnotatedBounds();
            Class<TypeVariableDemo> genericDeclaration = typeParameter.getGenericDeclaration();
            System.out.println("第" + (i + 1) + "个类型变量的名称为：" + name);
            System.out.println("通过getBounds方法获取到，第" + (i + 1) + "个类型变量的边界为：" + Arrays.toString(bounds));
            System.out.println("第" + (i + 1) + "个类型变量的申明的位置为：" + genericDeclaration);
            System.out.println("通过getAnnotatedBounds方法获取到，第" + (i + 1) + "个类型变量的边界为："
                    + Arrays.stream(annotatedBounds).map(AnnotatedType::getType).collect(Collectors.toList()));
            for (AnnotatedType annotatedType : annotatedBounds) {
                Annotation[] annotations = annotatedType.getAnnotations();
                if (annotations.length > 0) {
                    System.out.println("第" + (i + 1) + "个类型变量的上界上添加了注解，注解为" + annotations[0]);
                }
            }
        }
        System.out.println("===================基于方法获取类型变量====================");
        Method[] declaredMethods = typeVariableDemoClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            if (methodName.equals("main")) {
                // 为了方便，直接排除main函数了
                continue;
            }
            TypeVariable<Method>[] typeVariables = declaredMethod.getTypeParameters();
            int i = 1;
            for (TypeVariable<Method> typeVariable : typeVariables) {
                System.out.println("方法：\"" + methodName + "\"的第" + (i++) + "个类型变量为" + typeVariable.getName());
            }
        }
    }
}