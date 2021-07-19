package io.codegitz.spring.decode.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: think-in-spring
 * @Description:
 * @Author: <a href="http://codegitz.github.io">Codegitz</a>
 * @Create: 2020-12-24 23:51
 * @Since: 1.0
 **/
public class Mutil {
	public static void main(String[] args) {
		for (int i = 1 ; i < 10; i++){
			for (int j = 1 ; j <= i ;j++){
				System.out.printf("%d*%d= %d ",j,i,i*j);
			}
			System.out.println();
		}

		for (int i = 1 ; i <= 4; i++){
			for (int j = 1 ; j <= 4 ;j++){
				for ( int k = 1 ; k <= 4 ; k++ ){
					System.out.print(i*100+j*10+k+" ");
				}
			}
		}
	}
}
