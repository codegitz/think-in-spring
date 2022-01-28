package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        boolean b = wordPattern("abba", "dog cat cat dog");
        System.out.println(b);
    }
    public static boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null){
            return false;
        }
        Map<String,String> cache = new HashMap<>();
        Map<String,String> cache2 = new HashMap<>();
        String[] split = s.split(" ");
        if(split.length != pattern.length()){
            return false;
        }
        for(int i = 0 ; i < pattern.length() ; i++){
            if(cache2.containsKey(split[i])){
                if(!(cache2.get(split[i]).equals(pattern.substring(i,i + 1)))){
                    return false;
                }

            }
            if(cache.containsKey(pattern.substring(i,i + 1))){
                if(!(cache.get(pattern.substring(i,i + 1)).equals(split[i]))){
                    return false;
                }
            }
            cache.put(pattern.substring(i,i + 1),split[i]);
            cache2.put(split[i],pattern.substring(i,i + 1));

        }
        return true;
    }
}
