package io.codegitz.spring.common.mistakes.leetcode;

/**
 * @author 张观权
 * @date 2021/7/19 12:34
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = new String[]{"","",""};
        String s = longestCommonPrefix(strings);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0){
            return "";
        }
        if (length == 1){
            return strs[0];
        }
        boolean flag = true;
        int j = 0;
        String result = "";
        while (flag){
            for (int i = 1 ; i < strs.length;i++){
                if ("".equals(strs[i - 1])){
                    return "";
                }
                flag = j < strs[i-1].length() && j < strs[i].length() && strs[i-1].charAt(j) == strs[i].charAt(j);
                if (!flag){
                    result = strs[i].substring(0,j);
                    break;
                }
            }
            j++;
        }
        return result;
    }
}
