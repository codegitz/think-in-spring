package io.codegitz.spring.common.mistakes.bytecode.callsite;

import javax.sound.midi.Track;
import java.lang.invoke.*;

public class CallSiteDemo {
    public static void main(String[] args) throws Throwable {
        mutableCallSiteSample();
    }
    public static void constantCallSiteSample() throws Throwable{
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle methodHandle = lookup.findVirtual(String.class, "substring", methodType);
        ConstantCallSite constantCallSite = new ConstantCallSite(methodHandle);
        MethodHandle invoker = constantCallSite.dynamicInvoker();
        String result = (String) invoker.invoke("12345678", 2, 4);
        System.out.println("ConstantCallSite return : " + result);
    }

    public static void mutableCallSiteSample() throws Throwable{
        MethodType methodType = MethodType.methodType(double.class, double.class);
        MutableCallSite mutableCallSite = new MutableCallSite(methodType);
        MethodHandle invoker = mutableCallSite.dynamicInvoker();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle sin = lookup.findStatic(Math.class, "sin", methodType);
        MethodHandle cos = lookup.findStatic(Math.class, "cos", methodType);
        mutableCallSite.setTarget(sin);
        double result = (double) invoker.invoke(Math.PI / 2);
        System.out.println("sin(90）=" + result);
        mutableCallSite.setTarget(cos);
        result = (double) invoker.invoke(Math.PI / 2);
        System.out.println("cos(90)=" + result);
    }
}
