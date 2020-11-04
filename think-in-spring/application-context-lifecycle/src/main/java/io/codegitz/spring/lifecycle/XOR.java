package io.codegitz.spring.lifecycle;

/**
 * @author 张观权
 * @date 2020/11/4 16:22
 **/
public class XOR {
    public static void main(String[] args) {
        System.out.println(~-0 ^ (1 << 31));
        System.out.println(1 << 31);
        System.out.println(~0);
    }
}
