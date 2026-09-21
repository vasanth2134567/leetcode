// Last updated: 9/21/2026, 9:03:00 PM
1class Solution {
2    private int n;
3    private boolean[][] palindrome;
4    private int[] dp;
5
6    private int solve(String s, int i) {
7        if (i == n)
8            return -1;
9
10        if (dp[i] != -1)
11            return dp[i];
12
13        int cuts = n - 1;
14
15        for (int j = i; j < n; j++)
16            if (palindrome[i][j])
17                cuts = Math.min(cuts, 1 + solve(s, j + 1));
18
19        return dp[i] = cuts;
20    }
21
22    public int minCut(String s) {
23        n = s.length();
24        palindrome = new boolean[n][n];
25        dp = new int[n];
26        Arrays.fill(dp, -1);
27
28        for (int len = 1; len <= n; len++) {
29            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
30                if (i == j)
31                    palindrome[i][j] = true;
32                else if (i + 1 == j)
33                    palindrome[i][j] = (s.charAt(i) == s.charAt(j));
34                else
35                    palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1]);
36            }
37        }
38
39        return solve(s, 0);
40    }
41}