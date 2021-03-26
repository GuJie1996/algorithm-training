package com.gujie1996.pruning;

public class SudokuSolver {

    int[] row = new int[9];
    int[] col = new int[9];
    int[][] block = new int[3][3];
    int fillCount = 0;

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new SudokuSolver().solveSudoku(board);
        for (char[] line : board) {
            System.out.println(line);
        }
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int blockX = j / 3;
                int blockY = i / 3;
                if (board[i][j] != '.') {
                    int state = 1 << board[i][j] - '0';
                    row[i] |= state;
                    col[j] |= state;
                    block[blockX][blockY] |= state;
                    fillCount++;
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int index) {
        if (index >= 81) {
            // 全都填完了返回
            return;
        }
        int i = index / 9;
        int j = index % 9;
        int blockX = j / 3;
        int blockY = i / 3;
        if (board[i][j] == '.') {
            // 1~9依次填入
            for (int n = 1; n <= 9; n++) {
                int state = 1 << n;
                // 确保填入不会重复
                if ((state & row[i]) == 0 && (state & col[j]) == 0 && (state & block[blockX][blockY]) == 0) {
                    // 加状态
                    row[i] |= state;
                    col[j] |= state;
                    block[blockX][blockY] |= state;
                    // 填字符
                    board[i][j] = (char) ('0' + n);
                    // 计数
                    fillCount++;
                    // 填下一格
                    dfs(board, index + 1);
                    if (fillCount != 81) {
                        // 没填完整还原现场
                        row[i] ^= state;
                        col[j] ^= state;
                        block[blockX][blockY] ^= state;
                        board[i][j] = '.';
                        fillCount--;
                    }
                }
            }
        } else {
            dfs(board, index + 1);
        }
    }
}
