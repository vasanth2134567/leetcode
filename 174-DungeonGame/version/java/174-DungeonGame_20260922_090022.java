// Last updated: 9/22/2026, 9:00:22 AM
1public class Solution {
2    public int solve(int i, int j, int[][] dungeon, int[][] dp) {
3        int m = dungeon.length;
4        int n = dungeon[0].length;
5
6        // Base case: Bottom-right cell (princess's room)
7        if (i == m - 1 && j == n - 1) {
8            return Math.max(1, 1 - dungeon[i][j]);
9        }
10
11        // If out of bounds
12        if (i >= m || j >= n) {
13            return Integer.MAX_VALUE;
14        }
15
16        // If the value is already calculated
17        if (dp[i][j] != -1) {
18            return dp[i][j];
19        }
20
21        // Recursive calculation for the minimum health needed
22        int right = solve(i, j + 1, dungeon, dp);
23        int down = solve(i + 1, j, dungeon, dp);
24
25        // The knight needs at least 1 health point to survive
26        int min_health = Math.min(right, down) - dungeon[i][j];
27        dp[i][j] = Math.max(1, min_health);
28
29        return dp[i][j];
30    }
31
32    public int calculateMinimumHP(int[][] dungeon) {
33        int m = dungeon.length;
34        int n = dungeon[0].length;
35
36        // Create a memoization table initialized with -1
37        int[][] dp = new int[m][n];
38        for (int[] row : dp) {
39            Arrays.fill(row, -1);
40        }
41
42        // Start from the top-left cell
43        return solve(0, 0, dungeon, dp);
44    }
45}