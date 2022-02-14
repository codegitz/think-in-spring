package io.codegitz.spring.common.mistakes.bytecode.dynamic;

import jdk.internal.org.objectweb.asm.*;
import jdk.internal.org.objectweb.asm.commons.GeneratorAdapter;
import jdk.internal.org.objectweb.asm.commons.Method;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class DynInvokerSample extends ClassLoader {
    private static final Handle BSM = new Handle(
            H_INVOKESTATIC,
            DynBootStrap.class.getName().replace('.','/'),
            "bootStrap",
            MethodType.methodType(CallSite.class, MethodHandles.Lookup.class,String.class,MethodType.class,Object.class).toMethodDescriptorString());


    public Class<?> createClass() throws IOException{
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(V1_7,ACC_PUBLIC | ACC_SUPER,"DynInvokerSampleMain",null,"java/lang/Object",null);
        Method method = Method.getMethod("void <init> ()");

        GeneratorAdapter generatorAdapter = new GeneratorAdapter(ACC_PUBLIC, method, null, null, classWriter);
        generatorAdapter.loadThis();
        generatorAdapter.invokeConstructor(Type.getType(Object.class),method);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();

        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "run", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
        methodVisitor.visitInvokeDynamicInsn("hashCode","()I",BSM,"Codegitz");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(I)V");
        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();
        classWriter.visitEnd();
        byte[] bytes = classWriter.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\code\\ideaCode\\think-in-spring\\think-in-spring\\50CommonMistakes\\src\\main\\java\\io\\codegitz\\spring\\common\\mistakes\\bytecode\\dynamic\\DynInvokerSampleMain.class"));
        fileOutputStream.write(bytes);
        return this.defineClass("DynInvokerSampleMain",bytes,0,bytes.length);
    }

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        DynInvokerSample dynInvokerSample = new DynInvokerSample();
        Object o = dynInvokerSample.createClass().newInstance();
        o.getClass().getMethod("run").invoke(null);
        System.out.println("Codegitz".hashCode());
    }
}
