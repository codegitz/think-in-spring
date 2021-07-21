package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张观权
 * @date 2021/7/20 17:56
 *
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 **/
public class LetterCombinations {
    public static void main(String[] args) {
        List<String> list = letterCombinations2("23");
        System.out.println(list);
    }
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int length = digits.length();
        if (length == 0){
            return result;
        }
        if (length == 1){
            String letters = map.get(digits);
            return getStringList(letters);
        }
        int i = 1;
        result = getStringList(map.get(String.valueOf(digits.charAt(0))));
        while (i < length){
            result = combine(result,getStringList(map.get(String.valueOf(digits.charAt(i)))));
            i++;
        }
        return result;
    }

    private static List<String> combine(List<String> result, List<String> stringList) {
        List<String> res = new ArrayList<>();
        for (int i = 0 ; i < result.size(); i++){
            for (int j = 0 ; j < stringList.size() ; j++){
                res.add(result.get(i) + stringList.get(j));
            }
        }
        return res;
    }

    private static List<String> getStringList(String letters) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < letters.length(); i++){
            result.add(String.valueOf(letters.charAt(i)));
        }
        return result;
    }

    //backtracking , easy solution
    private static String array[];
    public static List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        array= new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        recursion(digits,new StringBuilder(),list);
        return list;
    }
    private static void recursion(String digits,StringBuilder temp,List<String> list) {
        if(digits.length() == 0){
            list.add(temp.toString());
            return ;
        }
        char[] str = array[digits.charAt(0)-'0'].toCharArray();
        for(char i : str){
            temp.append(i);
            recursion(digits.substring(1),temp,list);
            temp.delete(temp.length()-1,temp.length());
        }
    }
}
