package io.codegitz.spring.decode.dto;

import java.util.stream.IntStream;

/**
 * @Program: think-in-spring
 * @Description:
 * @Author: <a href="http://codegitz.github.io">Codegitz</a>
 * @Create: 2020-12-25 00:28
 * @Since: 1.0
 *
 *                volevolev           volevolov
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
 **/
public class Christmas {
	public static void main(String[] args) {
		IntStream.range(-15, 15).map(y -> -y)
				.forEach(y -> IntStream.range(-30, 30)
						.forEach(x ->
								System.out.print(Math.pow(Math.pow((x * 0.05), 2)
										+ Math.pow((y * 0.1), 2) - 1, 3)
										- Math.pow(x * 0.05, 2) * Math.pow(y * 0.1, 3) <= 0 ?
										"love".charAt(Math.abs((y - x) % 4)) : " " + (x == 29 ? "\n" : ""))));
	}
}
