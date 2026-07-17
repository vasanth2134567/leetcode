// Last updated: 7/17/2026, 2:58:36 PM
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length; j++) {

                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int s = j + 1;
                int e = nums.length - 1;

                while(s < e) {

                    long sum = (long)nums[i] + nums[j] + nums[s] + nums[e];

                    if(sum == target) {

                        List<Integer> lis = new ArrayList<>();

                        lis.add(nums[i]);
                        lis.add(nums[j]);
                        lis.add(nums[s]);
                        lis.add(nums[e]);

                        ans.add(lis);

                        while(s < e && nums[s] == nums[s + 1]) s++;
                        while(s < e && nums[e] == nums[e - 1]) e--;

                        s++;
                        e--;
                    }
                    else if(sum < target) {
                        s++;
                    }
                    else {
                        e--;
                    }
                }
            }
        }

        return ans;
    }
}