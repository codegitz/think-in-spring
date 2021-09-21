package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/9/14 13:26
 *
 * 68. Text Justification
 * Hard
 *
 * 1286
 *
 * 2319
 *
 * Add to List
 *
 * Share
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 **/
public class TextJustification {
    public static void main(String[] args) {
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
//        ["This    is    an","example  of text","justification.  "]
//        ["This     is    an","oftext"]
//        ["This    is    an","example  of text","justification.  "]
//        ["This    is    an","example  of text","justification.  "]
//        ["What","must","be","acknowledgment","shall","be"]
//        ["What   must   be","acknowledgment  ","shall be        "]
//        ["What   must   be","acknowledgment  ","shall be        "]
//        16
//        ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]
//        20
//        ["Science   is what we","understand      well","enough to explain to","a   computer. Art is","everything  else  we","do                  "]
//        ["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
//        ["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
        List<String> list = fullJustify(words, 20);
        System.out.println(list);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int sum = 0;
        int length = 0;
        StringBuilder sb = new StringBuilder();
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            sum += words[i].length();
            length += words[i].length();
            tmp.add(words[i]);
            if (sum > maxWidth){
                String remove = tmp.remove(tmp.size() - 1);
                combineResult(tmp,result,maxWidth,length - remove.length());
                i--;
                sum = 0;
                length = 0;
                continue;
            }else if (sum == maxWidth){
                combineResult(tmp,result,maxWidth,length);
                sum = 0;
                length = 0;
                continue;
            }
            sum++;
        }
        if (sum > 0){
            for (int i = 0; i < tmp.size(); i++) {
                sb.append(tmp.get(i));
                sb.append(" ");
            }
            int end = maxWidth - sb.length();
            if (end > 0){
                while (end > 0){
                    sb.append(" ");
                    end--;
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private static void combineResult(List<String> tmp, List<String> result, int maxWidth,int length) {
        StringBuilder sb = new StringBuilder();
        int space = maxWidth - length;
        int base = tmp.size() - 1 == 0 ? space : space / (tmp.size() - 1);
        int remainder = tmp.size() - 1 == 0 ? 0 : space % (tmp.size() - 1);
        int[] spaceArray = new int[tmp.size() - 1];
        Arrays.fill(spaceArray,base);
        int k = 0;
        while (remainder > 0 && k < spaceArray.length){
            spaceArray[k++]++;
            remainder--;
        }
        for (int i = 0; i < tmp.size(); i++) {
            sb.append(tmp.get(i));
            if (i == tmp.size() - 1){
                while (sb.length() < maxWidth){
                    sb.append(" ");
                }
                break;
            }
            int l = spaceArray[i];
            while (sb.length() < maxWidth && l > 0){
                sb.append(" ");
                l--;
            }
        }
        result.add(sb.toString());
        tmp.clear();
    }
}
