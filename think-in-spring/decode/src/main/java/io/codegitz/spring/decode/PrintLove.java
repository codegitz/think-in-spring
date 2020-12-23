package io.codegitz.spring.decode;

import java.util.stream.IntStream;

/**
 * @author 张观权
 * @date 2020/12/23 19:19
 *
 *
 *                 volevolev           volevolov
 *             olevolevolevolevo   olevolevolovelove
 *           volevolevolevolevolevolevolevolovelovelov
 *          volevolevolevolevolevolevolevolovelovelovel
 *         volevolevolevolevolevolevolevolovelovelovelov
 *         olevolevolevolevolevolevolevolovelovelovelove
 *         levolevolevolevolevolevolevolovelovelovelovel
 *         evolevolevolevolevolevolevolovelovelovelovelo
 *         volevolevolevolevolevolevolovelovelovelovelov
 *         olevolevolevolevolevolevolovelovelovelovelove
 *          evolevolevolevolevolevolovelovelovelovelove
 *           olevolevolevolevolevolovelovelovelovelove
 *           levolevolevolevolevolovelovelovelovelovel
 *             olevolevolevolevolovelovelovelovelove
 *              evolevolevolevolovelovelovelovelove
 *               olevolevolevolovelovelovelovelove
 *                 volevolevolovelovelovelovelov
 *                   evolevolovelovelovelovelo
 *                     levolovelovelovelovel
 *                        lovelovelovelov
 *                           lovelovel
 *                              lov
 *                               v
 *
 **/
public class PrintLove {
    public static void main(String[] args) {
        IntStream.range(-15, 15).map(y -> -y).forEach(y -> IntStream.range(-30, 30).forEach(x -> System.out.print(Math.pow(Math.pow((x * 0.05), 2) + Math.pow((y * 0.1), 2) - 1, 3) - Math.pow(x * 0.05, 2) * Math.pow(y * 0.1, 3) <= 0 ? "love".charAt(Math.abs((y - x) % 4)) : " " + (x == 29 ? "\n" : ""))));
    }
}
