package io.codegitz.spring.common.mistakes.bytecode.deadlock;

public class DeadLockDemo extends Thread{
    private char flag;
    private String name;

    public DeadLockDemo(char flag){
        this.flag = flag;
        this.setName("Thread" + flag);
    }

    @Override
    public void run() {
        try {
            Class.forName("io.codegitz.spring.common.mistakes.bytecode.deadlock.Static" + flag);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(getName() + "over");
    }

    public static void main(String[] args) {
        DeadLockDemo loadA = new DeadLockDemo('A');
        loadA.start();
        DeadLockDemo loadB = new DeadLockDemo('B');
        loadB.start();
    }
}
