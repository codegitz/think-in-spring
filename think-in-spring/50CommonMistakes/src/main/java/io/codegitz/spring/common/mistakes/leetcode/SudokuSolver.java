package io.codegitz.spring.common.mistakes.leetcode;

import java.util.HashSet;

/**
 * @author 张观权
 * @date 2021/8/3 13:25
 **/
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == '.'){
                    for(char nums = '1' ; nums <= '9'; nums++){
                        if(isValid(board,i,j,nums)){
                            board[i][j] = nums;
                            if (helper(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int row,int clo,char nums) {
        for (int i = 0 ; i < 9 ; i++){
            if (board[i][clo] == nums) return false;
            if (board[row][i] == nums) return false;
            if (board[3*(row / 3) + i / 3][3 *(clo / 3) + i % 3] == nums) return false;
        }
        return true;
    }



        public boolean isValidSudoku(char[][] board,int row,int clo,char nums) {
        HashSet<String> set = new HashSet<>();
        board[row][clo] = nums;
        for (int i = 0;i < 9;i++){
            for (int j = 0 ; j < 9 ; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                if (!set.add(board[i][j] + "in row " + i) ||
                        !set.add(board[i][j] + "in columns" + j) ||
                        ! set.add(board[i][j] + "in sub box" + i /3 + j /3)){
                    board[row][clo] = '.';
                    return false;
                }
            }
        }
        return true;
    }
}
