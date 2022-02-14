package io.codegitz.spring.common.mistakes.bytecode.dynamic;

import java.lang.invoke.*;

public class DynBootStrap {
    public static CallSite bootStrap(MethodHandles.Lookup lookup, String name, MethodType methodType, Object value) throws Throwable{
        System.out.println("bootStrap called,name = " + name);
        MethodHandle methodHandle = lookup.findVirtual(value.getClass(), name, MethodType.methodType(int.class)).bindTo(value);
        return new ConstantCallSite(methodHandle);
    }
}
