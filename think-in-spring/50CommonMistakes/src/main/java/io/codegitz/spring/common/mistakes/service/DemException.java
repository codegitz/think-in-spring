package io.codegitz.spring.common.mistakes.service;

/**
 * @author 张观权
 * @date 2021/11/16 13:25
 **/
public class DemException {
    public static void main(String[] args) {
        int[] intArray = new int[3];
        System.out.println(intArray.length);
        try {
            for (int i = 0; i <= intArray.length; i++) {
                intArray[i] = i;
                System.out.println(i);
//                System.out.println("intArray[" + i + "] =" + intArray[i]);
//                System.out.println("intArray[" + i + "]模 "  + (i - 2) + "的值:  " + intArray[i] % (i - 2));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("intArray数组下标越界异常。");
        } catch (ArithmeticException e) {
            System.out.println("除数为0异常。");
        }
        System.out.println("程序正常结束。");
    }

}