// Last updated: 9/21/2026, 9:14:27 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        
4        int max = nums[0], min = nums[0], ans = nums[0];
5        
6        for (int i = 1; i < nums.length; i++) {
7            
8            int temp = max;  // store the max because before updating min your max will already be updated
9            
10            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
11            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
12            
13            if (max > ans) {
14                ans = max;
15            }
16        }
17        
18        return ans;
19
20    }
21}