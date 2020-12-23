package io.codegitz.spring.decode;

/**
 * @author 张观权
 * @date 2020/12/9 13:01
 **/
public class Daffodil {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int hundreds = i / 100;
            int ten = (i % 100) / 10;
            int one = i % 100 % 10;
            int sum = hundreds * hundreds * hundreds + ten * ten * ten + one * one * one;
            if (sum == i) {
                System.out.println(i + " : 为水仙花数");
            }

        }
    }
}
