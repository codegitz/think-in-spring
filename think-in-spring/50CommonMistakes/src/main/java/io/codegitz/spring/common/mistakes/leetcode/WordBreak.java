package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2021/10/28 13:10
 *
 * 139. Word Break
 * Medium
 *
 * 8408
 *
 * 389
 *
 * Add to List
 *
 * Share
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 **/
public class WordBreak {
//    public static void main(String[] args) {
//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
//        boolean b = wordBreak(s, wordDict);
//        System.out.println(b);
//    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0){
            return true;
        }
        Set<String> dictionary = new HashSet<>(wordDict);
        return dfs(s,wordDict,dictionary);
    }

    private static boolean dfs(String s, List<String> wordDict,Set<String> dictionary) {
        if (dictionary.contains(s)){
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)){
                String sub = s.substring(word.length());
                if (dfs(sub,wordDict,dictionary)){
                    return true;
                }else{
                    s = word + sub;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.right = node5;
        node1.right = node3;
        List<String> list = binaryTreePaths(node1);
        System.out.println(list);

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        helper(result,root,new ArrayList<>());
        List<String> fine = new ArrayList<>();
        for(List<String> s : result){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < s.size() ; i++){
                String v = s.get(i);
                sb.append(v);
                if(i != s.size() - 1){
                    sb.append("->");
                }
            }
            fine.add(sb.toString());
        }
        return fine;
    }
    public static void helper(List<List<String>> result,TreeNode root,List<String> tmp){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            tmp.add(root.val + "");
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        tmp.add(root.val + "");
        helper(result,root.left,tmp);
        helper(result,root.right,tmp);
        tmp.remove(tmp.size() - 1);
    }
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
