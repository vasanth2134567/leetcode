// Last updated: 9/15/2026, 9:03:45 PM
1class Solution {
2    public int singleNumber(int[] nums) {
3        int result = 0;
4        for (int num:nums) {
5            result ^= num;
6        }
7        return result;
8    }
9}