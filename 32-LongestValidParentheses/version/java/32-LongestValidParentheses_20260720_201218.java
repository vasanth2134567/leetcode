// Last updated: 7/20/2026, 8:12:18 PM
1class Solution {
2    static List<List<String>> list = new ArrayList<>();
3
4    public List<List<String>> solveNQueens(int n) {
5        list = new ArrayList<>();
6
7        int[][] arr = new int[n][n];
8        place(0, arr);
9        return list;
10    }
11
12    private static void place(int row, int[][] arr) {
13        if (row == arr.length) {
14            print(arr);
15            return;
16        }
17        for (int col = 0; col < arr.length; col++) {
18            if (isSafe(row, col, arr)) {
19                arr[row][col] = 1;
20                place(row + 1, arr);
21                arr[row][col] = 0;
22            }
23        }
24    }
25
26    private static boolean isSafe(int row, int col, int[][] arr) {
27        int r = row;
28        int c = col;
29
30        //        Up
31        while (r >= 0)
32            if (arr[r--][c] == 1)
33                return false;
34
35        //        left diagonal
36        r = row;
37        while (r >= 0 && c >= 0)
38            if (arr[r--][c--] == 1)
39                return false;
40
41        //        right diagonal
42        r = row;
43        c = col;
44        while (r >= 0 && c < arr.length)
45            if (arr[r--][c++] == 1)
46                return false;
47
48        return true;
49    }
50
51    private static void print(int[][] arr) {
52        List<String> ans = new ArrayList<>();
53        for (int row = 0; row < arr.length; row++) {
54            String s = "";
55            for (int col = 0; col < arr.length; col++)
56                s += (arr[row][col] == 1 ? 'Q' : '.');
57            ans.add(s);
58        }
59        list.add(ans);
60    }
61}