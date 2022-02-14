package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 张观权
 * @date 2021/10/19 13:25
 *
 * 127. Word Ladder
 * Hard
 *
 * 6118
 *
 * 1519
 *
 * Add to List
 *
 * Share
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 *
 **/
public class WordLadder {
//    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        int ladderLength = ladderLength(beginWord, endWord, wordList);
//        System.out.println(ladderLength);
//    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)){
            return 0;
        }
        int step = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            char replace = beginWord.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                StringBuilder sb = new StringBuilder(beginWord);
                sb.replace(i,i + 1, String.valueOf(j));
                String newStrings = sb.toString();
                if (newStrings.equals(endWord)){
                    return step + 1;
                }
                if (dictionary.contains(newStrings)){
                    step++;
                    beginWord = newStrings;
                    i = -1;
                    dictionary.remove(newStrings);
                    break;
                }
            }
//            StringBuilder sb = new StringBuilder(beginWord);
//            sb.replace(i,i + 1, String.valueOf(replace));
//            beginWord = sb.toString();
        }
        return beginWord.equals(endWord) ? step : 0;
    }

    public static void main(String[] args) {
        int[] nums = {10, 23, -41, 0, 452, 1, -44, 42, 0, 1, 2, 3, 4, 5, 6, 7};
        reverse(nums);
        System.out.println(nums);
    }

    public static void reverse(int[] nums){
        if (nums == null){
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] > 0 && nums[right] <= 0){
                left++;
                right--;
            }else if (nums[left] > 0){
                left++;
            }else if (nums[right] <= 0){
                right--;
            }else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }

        }
    }
}
