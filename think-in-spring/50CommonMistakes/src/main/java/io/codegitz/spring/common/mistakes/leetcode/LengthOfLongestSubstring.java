package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author 张观权
 * @date 2021/7/14 13:00
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        int index = lengthOfLongestSubstring("ohomm");
//        System.out.println(index);
        List<Boolean> result = new ArrayList<>();
        int flag = 40;
        for (int i = 0 ; i < 100000000 ; i++){
            result.add(flag >= (int) (Math.random() * (100)));
//            System.out.println((int) (Math.random() * (100)));
        }
        Map<Boolean, Long> sum = result.stream().collect(groupingBy(s -> s, counting()));
        System.out.println(sum);
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int max = 0;
        int max1 = 0;
        int start = 0;
        Map<Character, Integer> repeat = new HashMap<>();
        for (int i = start ; i < s.length(); i++){
            char c = s.charAt(i);
            if (repeat.containsKey(c)){
                max1 = i - repeat.get(c) > max1 ? i - repeat.get(c) : max1;
                repeat.clear();
            }
            repeat.put(c,i);
        }

        int max2 = 0;
        Map<Character, Integer> inverseRepeat = new HashMap<>();
        for (int i = s.length() - 1 ; i >=  0; i--){
            char c = s.charAt(i);
            if (inverseRepeat.containsKey(c)){
                max2 = i - inverseRepeat.get(c) > max2 ? i - inverseRepeat.get(c) : max2;
                inverseRepeat.clear();
            }
            inverseRepeat.put(c,i);
        }
        max = max1 > max2 ? max1 : max2;
        int remain = repeat.keySet().size() > inverseRepeat.keySet().size() ? repeat.keySet().size() : inverseRepeat.keySet().size();
        return remain > max ? remain : max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int max = 0;
        int start = 0;
        int index = 0;
        Map<Character, Integer> repeat = new HashMap<>();
        for (int i = start ; i < s.length(); i++){
            char c = s.charAt(i);
            if (repeat.containsKey(c)){
                max = i - repeat.get(c) > max ? i - index : max;
                index = i;
                repeat.clear();
            }
            repeat.put(c,i);
        }
        if (max == 0){
            return repeat.keySet().size();
        }
        return repeat.keySet().size() > max ? repeat.keySet().size() : max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int max = 0;
        Map<Character, Integer> repeat = new HashMap<>();
        int start = 0;
        for (int i = start ; i < s.length(); i++){
            char c = s.charAt(i);
            if (repeat.containsKey(c)){
                max = i > max ? i  : max;
                s = s.substring(repeat.get(c) + 1);
                repeat.clear();
                i = -1;
                continue;
            }
            repeat.put(c,i);
        }
        return repeat.keySet().size() > max ? repeat.keySet().size() : max;
    }
}
