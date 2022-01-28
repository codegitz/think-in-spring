package io.codegitz.spring.common.mistakes.bytecode;

public class SyncDemo {
    private int i = 0;
    public void add2(){
        synchronized (this){
            i++;
        }
    }
}
