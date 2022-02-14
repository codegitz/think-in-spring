package io.codegitz.spring.common.mistakes.bytecode.deadlock;

public class StaticB {
    static {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
        }
        try {
            Class.forName("io.codegitz.spring.common.mistakes.bytecode.deadlock.StaticA");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("io.codegitz.spring.common.mistakes.bytecode.deadlock.StaticB init is OK!");
    }
}
