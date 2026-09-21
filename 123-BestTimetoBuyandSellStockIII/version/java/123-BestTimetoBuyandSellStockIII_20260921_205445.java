// Last updated: 9/21/2026, 8:54:45 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4
5        int[] suffixProfit = new int[n];
6
7        int maxPrice = prices[n - 1];
8
9        for (int i = n - 1; i >= 0; i--) {
10            maxPrice = Math.max(maxPrice, prices[i]);
11            suffixProfit[i] = maxPrice - prices[i];
12        }
13
14        int minPrice = prices[0];
15        int prefixProfit = 0;
16        int answer = suffixProfit[0];
17
18        for (int i = 1; i < n; i++) {
19            prefixProfit = Math.max(prefixProfit, prices[i] - minPrice);
20            minPrice = Math.min(minPrice, prices[i]);
21            answer = Math.max(answer, prefixProfit + suffixProfit[i]);
22        }
23
24        return answer;
25    }
26}