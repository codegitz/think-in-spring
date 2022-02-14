package io.codegitz.spring.common.mistakes.bytecode.callsite;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * 反射和方法句柄调用的性能差异比较
 */
public class ReflectVsMethodHandles {
    public static final int COUNT = 1000_000;
    int i = 0;
    public void method(){
        i++;
    }
    public static void callByHandler() throws Throwable{
        ReflectVsMethodHandles reflectVsMethodHandles = new ReflectVsMethodHandles();
        MethodType methodType = MethodType.methodType(void.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = lookup.findVirtual(reflectVsMethodHandles.getClass(), "method", methodType).bindTo(reflectVsMethodHandles);
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            methodHandle.invokeExact();
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    public static void callByReflection() throws Throwable{
        ReflectVsMethodHandles reflectVsMethodHandles = new ReflectVsMethodHandles();
        Method method = reflectVsMethodHandles.getClass().getMethod("method");
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            method.invoke(reflectVsMethodHandles);
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    public static void main(String[] args) throws Throwable {
        callByHandler();
        callByHandler();
        callByReflection();
        callByReflection();
    }
}
