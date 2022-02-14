package io.codegitz.spring.common.mistakes.leetcode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0){
            return false;
        }
        if(n == 0){
            return true;
        }
        int dis = 0;
        for(int i = 0 ; i < flowerbed.length ; i++){
            if(n == 0){
                return true;
            }
            if(dis == 1 && flowerbed[i] == 0){
                if(i + 1 >= flowerbed.length){
                    n--;
                }else if(flowerbed[i + 1] == 0){
                    n--;
                    dis = 0;
                }else{
                    dis = 0;
                }
            }
            if(flowerbed[i] == 0){
                dis++;
            }else{
                dis = 0;
            }
        }
        return false;
    }
}
