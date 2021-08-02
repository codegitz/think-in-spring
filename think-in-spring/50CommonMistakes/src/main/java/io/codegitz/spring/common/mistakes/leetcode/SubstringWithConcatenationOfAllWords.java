package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张观权
 * @date 2021/7/29 19:46
 *
 *You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lower-case English letters.
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] consists of lower-case English letters.
 *
 **/
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
//        List<Integer> barfoothefoobarman = findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
//        System.out.println(barfoothefoobarman);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.forEach(s -> {

        });
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null){
            return new ArrayList<>();
        }
        int m = words.length;
        int n = words[0].length();
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < s.length() - m*n; i++){
            Map<String,Integer> copy = new HashMap<>(map);
            int k = m;
            int j = i;
            while (k > 0){
                String key = s.substring(j,j + n);
                if (!copy.containsKey(key) || copy.get(key) < 1){
                    break;
                }
                copy.put(key,copy.get(key) - 1);
                k--;
                j += n;
            }
            if (k == 0){
                result.add(i);
            }
        }
        return result;
    }
}
