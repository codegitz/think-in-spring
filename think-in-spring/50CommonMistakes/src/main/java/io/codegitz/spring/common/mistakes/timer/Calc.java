package io.codegitz.spring.common.mistakes.timer;

public class Calc {
    private Calc(){}
    public int call(){
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) / c;
    }

    private void print(Object o){
        System.out.println(o.toString());
    }

    private void print3(char[] cs,short[] s){
        System.out.println(cs[1]);
        System.out.print(s[2]);
        print(cs[5]);
        print(s[6]);
    }

    private void print4(char[] cs,short[] s,int a,Object o){
        int i,j,k,y,x;
        x = 99;
        s[0] = 77;
    }

    private void print5(int i){
        Object object = new Object();
        object.toString();
    }

    public void print6(int i){
        long l = i;
        float f = l;
        int j = (int) l;
    }

    public byte print7(byte i){
        int k = i;
        long l = i;
        return i;
    }

    public void print8(){
        float i = 8;
        float j = -i;
        i = -j;
    }

    /**
     *   {@Attention 这里的字节码跟书上的不一致，方法print10才是书上的字节码} {@Page No.376 Example 11-7}
     *   public void print9();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=2, locals=2, args_size=1
     *          0: bipush        123
     *          2: istore_1
     *          3: iload_1
     *          4: bipush        10
     *          6: iadd
     *          7: istore_1
     *          8: return
     *       LineNumberTable:
     *         line 53: 0
     *         line 54: 3
     *         line 55: 8
     */
    public void print9(){
        int i = 123;
        i = i + 10;
    }

    /**
     *   public void print10();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=1, locals=2, args_size=1
     *          0: bipush        123
     *          2: istore_1
     *          3: iinc          1, 1
     *          6: return
     *       LineNumberTable:
     *         line 76: 0
     *         line 77: 3
     *         line 78: 6
     */
    public void print10(){
        int i = 123;
        i++;
    }

    /**
     *   {@Attention iconst_m1 express -1. -1 binary is a string of data with all ones (0xFF).ixor exclusive or}
     *   public void print11();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: bipush        123
     *          2: istore_1
     *          3: iload_1
     *          4: iconst_m1
     *          5: ixor
     *          6: istore_2
     *          7: return
     *       LineNumberTable:
     *         line 97: 0
     *         line 98: 3
     *         line 99: 7
     */
    public void print11(){
        int i = 123;
        int j = ~i;
    }

    public void create(){
        int[] intArrays = new int[10];
        Object[] objArrays = new Object[10];
        int[][] multiArrays = new int[10][10];
    }

    public void print12(){
        System.out.println(new String("hello"));
    }

    public String checkCast(Object obj){
        if (obj instanceof String){
            return (String) obj;
        }else {
            return null;
        }
    }
}
