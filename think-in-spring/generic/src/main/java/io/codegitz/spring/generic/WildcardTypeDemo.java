package io.codegitz.spring.generic;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 * @author 张观权
 * @date 2020/11/16 16:55
 **/
public class WildcardTypeDemo<T> {

    Map<? super String, ? extends List<T>> map;

    public static void main(String[] args) {
        Class<WildcardTypeDemo> wildcardTypeDemoClass = WildcardTypeDemo.class;
        Field[] declaredFields = wildcardTypeDemoClass.getDeclaredFields();
        for (Field field : declaredFields) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                // 使用了通配符表达泛型的，必定是一个参数化类型
                // 获取泛型的实际类型，就是获取<>中的内容,这里获取到的是<? super String, ? extends List<T>>
                Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    // 两个泛型都使用了通配符，都会进入这个判断
                    if (actualTypeArgument instanceof WildcardType) {
                        // 分別获取上界跟下界
                        // ? super String，这个表达式的下界为String,上界为Object
                        // ? extends List<T>，这个表达式的下界为Object,上界为List<T>，
                        // 同时List<T>又是一个参数化类型，而T又是一个类型变量
                        Type[] lowerBounds = ((WildcardType) actualTypeArgument).getLowerBounds();
                        Type[] upperBounds = ((WildcardType) actualTypeArgument).getUpperBounds();
                        // 这里我主要处理? extends List<T>
                        for (Type upperBound : upperBounds) {
                            if (upperBound instanceof ParameterizedType) {
                                System.out.println("参数化类型的名称为：" + upperBound.getTypeName());
                                Type[] actualTypeArguments1 = ((ParameterizedType) upperBound).getActualTypeArguments();
                                for (Type type : actualTypeArguments1) {
                                    if (type instanceof TypeVariable) {
                                        String name = ((TypeVariable) type).getName();
                                        System.out.println("类型变量名称为：" + name);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
// 程序输出：
// 参数化类型的名称为：java.util.List<T>
// 类型变量名称为：T