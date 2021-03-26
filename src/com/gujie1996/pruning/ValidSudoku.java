package com.gujie1996.pruning;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[][] block = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = c - '0';
                    int state = 1 << n-1;
                    int blockX = j / 3;
                    int blockY = i / 3;
                    if ((state & row[i]) != 0 || (state & col[j]) != 0 || (state & block[blockX][blockY]) != 0) {
                        return false;
                    }
                    row[i] |= state;
                    col[j] |= state;
                    block[blockX][blockY] |= state;
                }
            }
        }
        return true;
    }
}
