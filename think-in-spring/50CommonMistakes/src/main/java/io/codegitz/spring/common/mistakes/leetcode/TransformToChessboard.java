package io.codegitz.spring.common.mistakes.leetcode;

/**
 *
 * 782. Transform to Chessboard
 * Hard
 *
 * 301
 *
 * 284
 *
 * Add to List
 *
 * Share
 * You are given an n x n binary grid board. In each move, you can swap any two rows with each other, or any two columns with each other.
 *
 * Return the minimum number of moves to transform the board into a chessboard board. If the task is impossible, return -1.
 *
 * A chessboard board is a board where no 0's and no 1's are 4-directionally adjacent.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 * Output: 2
 * Explanation: One potential sequence of moves is shown.
 * The first move swaps the first and second column.
 * The second move swaps the second and third row.
 * Example 2:
 *
 *
 * Input: board = [[0,1],[1,0]]
 * Output: 0
 * Explanation: Also note that the board with 0 in the top left corner, is also a valid chessboard.
 * Example 3:
 *
 *
 * Input: board = [[1,0],[1,0]]
 * Output: -1
 * Explanation: No matter what sequence of moves you make, you cannot end with a valid chessboard.
 *
 *
 * Constraints:
 *
 * n == board.length
 * n == board[i].length
 * 2 <= n <= 30
 * board[i][j] is either 0 or 1.
 * @author Codegitz
 * @date 2022/8/24 10:49
 **/
public class TransformToChessboard {
    public int movesToChessboard(int[][] board) {
        if (isChessBoard(board)){
            return 0;
        }
        boolean[][] used = new boolean[board.length][board.length];
        return move(board,used,0,0,0);
    }

    private int move(int[][] board, boolean[][] used, int row, int clo,int sum) {
        if (isChessBoard(board)){
            return sum;
        }
        for (int i = 0; i < board.length; i++) {

        }
        for (int j = 0; j < board.length; j++) {

        }
        return 0;
    }

    private boolean isChessBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(invalid(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean invalid(int[][] board, int i, int j) {
        if(i - 1 >= 0 && board[i][j] == board[i - 1][j]){
            return false;
        }
        if(j - 1 >= 0 && board[i][j] == board[i][j - 1]){
            return false;
        }
        if(i + 1 < board.length && board[i][j] == board[i + 1][j]){
            return false;
        }
        if(j + 1 < board[0].length && board[i][j] == board[i][j + 1]){
            return false;
        }
        return true;
    }
}
