package io.codegitz.spring.decode;

/**
 * @author 张观权
 * @date 2021/1/12 19:44
 **/
public class Float {
    public static void main(String[] args) {
        float a = 1f;
        float b = 0.9f;
        System.out.println(a - b);
        String version = "1.2";
        String[] split = version.split("\\.");

        double v = Double.valueOf(version) + 0.1;
//        System.out.printf("%x\n",v);
        System.out.printf("%f\n",v);
    }
}
