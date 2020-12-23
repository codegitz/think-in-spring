package io.codegitz.spring.decode.dto;

/**
 * @author 张观权
 * @date 2020/12/9 12:55
 **/
public class PrintStars {
    public static void main(String[] args) {
        for (int i = 0 ; i < 10 ; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0 ; j < i ; j++){
                stringBuilder.append("*");
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
