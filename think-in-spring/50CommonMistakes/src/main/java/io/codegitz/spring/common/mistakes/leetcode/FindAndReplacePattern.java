package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 890. Find and Replace Pattern
 * Medium
 *
 * 1989
 *
 * 122
 *
 * Add to List
 *
 * Share
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
 * Example 2:
 *
 * Input: words = ["a","b","c"], pattern = "a"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 20
 * 1 <= words.length <= 50
 * words[i].length == pattern.length
 * pattern and words[i] are lowercase English letters.
 * Accepted
 * 103,699
 * Submissions
 * 136,748
 *
 * @author Codegitz
 * @date 2022/7/29 17:46
 **/
public class FindAndReplacePattern {

    /**
     * Your input
     * ["abc","deq","mee","aqq","dkd","ccc"]
     * "abb"
     * Output
     * ["abc","deq","mee","aqq"]
     * Expected
     * ["mee","aqq"]
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0){
            return result;
        }
        char[] pc = pattern.toCharArray();
        for (String word : words) {
            Map<Character,Character> map = new HashMap<>();
            char[] wc = word.toCharArray();
            boolean flag = true;
            for (int i = 0; i < wc.length; i++) {
                if(!map.containsKey(wc[i])){
                    map.put(wc[i],pc[i]);
                }else if (map.get(wc[i]) != pc[i]){
                    flag = false;
                    break;
                }
            }
            map.clear();
            for (int i = 0; i < pc.length; i++) {
                if(!map.containsKey(pc[i])){
                    map.put(pc[i],wc[i]);
                }else if (map.get(pc[i]) != wc[i]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                result.add(word);
            }
        }
        return result;
    }
}
