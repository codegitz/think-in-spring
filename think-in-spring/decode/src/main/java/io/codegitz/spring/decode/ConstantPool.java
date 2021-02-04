package io.codegitz.spring.decode;

/**
 * @author Codegitz
 * @date 2021/1/5 17:10
 **/
public class ConstantPool {
    public static void main(String[] args) {
        String s1 = new StringBuilder().append("ja").append("va1").toString();
        String s2 = s1.intern();
        System.out.println(s1 == s2);

//        String s5 = "code";
        String s5 = new String("code");
        String s3 = new StringBuilder().append("co").append("de").toString();
        String s4 = s3.intern();
        System.out.println(s3 == s4);

        String s7 = new StringBuilder().append("s").append("pring").toString();
        String s8 = s7.intern();
        String s6 = "spring";
        System.out.println(s7 == s8);
    }
}
