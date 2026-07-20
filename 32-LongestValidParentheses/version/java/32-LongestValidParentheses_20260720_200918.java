// Last updated: 7/20/2026, 8:09:18 PM
1class Solution {
2    public void solveSudoku(char[][] board) {
3        solve(board);
4    }
5
6    private boolean solve(char[][] board) {
7        for (int row = 0; row < 9; row++) {
8            for (int col = 0; col < 9; col++) {
9                if (board[row][col] == '.') {
10                    for (char num = '1'; num <= '9'; num++) {
11                        if (isValid(board, row, col, num)) {
12                            board[row][col] = num;
13                            if (solve(board)) return true;
14                            board[row][col] = '.';
15                        }
16                    }
17                    return false;
18                }
19            }
20        }
21        return true;
22    }
23
24    private boolean isValid(char[][] board, int row, int col, char num) {
25        for (int i = 0; i < 9; i++) {
26            if (board[row][i] == num || board[i][col] == num) return false;
27        }
28        int startRow = (row / 3) * 3;
29        int startCol = (col / 3) * 3;
30        for (int i = startRow; i < startRow + 3; i++) {
31            for (int j = startCol; j < startCol + 3; j++) {
32                if (board[i][j] == num) return false;
33            }
34        }
35        return true;
36    }
37}