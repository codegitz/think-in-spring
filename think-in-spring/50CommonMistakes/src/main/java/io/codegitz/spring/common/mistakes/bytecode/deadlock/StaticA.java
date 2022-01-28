package io.codegitz.spring.common.mistakes.bytecode.deadlock;

public class StaticA {
    static {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
        }
        try {
            Class.forName("io.codegitz.spring.common.mistakes.bytecode.deadlock.StaticB");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("io.codegitz.spring.common.mistakes.bytecode.deadlock.StaticA init is OK!");
    }
}
