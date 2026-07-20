// Last updated: 7/20/2026, 8:08:34 PM
1class Solution {
2    public int lower(int[] nums, int n, int target) {
3        int high = n - 1;
4        int ans = n;
5        int low = 0;
6
7        while (low <= high) {
8            int mid = (low + high) / 2;
9
10            if (nums[mid] >= target) {
11                ans = mid;
12                high = mid - 1;
13            } else {
14                low = mid + 1;
15            }
16        }
17
18        return ans;
19    }
20
21    public int higher(int[] nums, int n, int target) {
22        int low = 0;
23        int high = n - 1;
24        int ans = n;
25
26        while (low <= high) {
27            int mid = (low + high) / 2;
28
29            if (nums[mid] > target) {
30                ans = mid;
31                high = mid - 1;
32            } else {
33                low = mid + 1;
34            }
35        }
36
37        return ans;
38    }
39
40    public int[] searchRange(int[] nums, int target) {
41        int n = nums.length;
42
43        int lowee = lower(nums, n, target);
44
45        if (lowee == n || nums[lowee] != target) {
46            return new int[] {-1, -1};
47        }
48
49        return new int[] {lowee, higher(nums, n, target) - 1};
50    }
51}