package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张观权
 * @date 2021/9/17 9:39
 *
 * 79. Word Search
 * Medium
 *
 * 6824
 *
 * 266
 *
 * Add to List
 *
 * Share
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 *
 **/
public class WordSearch {

    public static void main(String[] args) {
//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//        "ABCCED"
        char[][] board = new char[4][];
        String a = "ABCE";
        String b = "SFCS";
        String c = "ADEE";
        board[0] = a.toCharArray();
        board[1] = b.toCharArray();
        board[2] = c.toCharArray();
        boolean abcced = exist(board, "ABCCED");
        System.out.println(abcced);
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] usage = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && isValid(board,word,usage,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(char[][] board, String word, boolean[][] usage, int i, int j,int pos) {
        if (pos == word.length()){
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length){
            return false;
        }
        if (usage[i][j]){
            return false;
        }
        boolean left = false;
        boolean right = false;
        boolean top = false;
        boolean down = false;
        if (board[i][j] == word.charAt(pos)){
            usage[i][j] = true;
            left = isValid(board,word,usage,i - 1,j,pos + 1);
            right = isValid(board,word,usage,i + 1,j,pos + 1);
            top = isValid(board,word,usage,i,j - 1,pos + 1);
            down = isValid(board,word,usage,i ,j + 1,pos + 1);
            usage[i][j] = false;
            return left || right || top || down;
        }
        return false;
    }
}
