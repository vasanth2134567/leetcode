// Last updated: 7/17/2026, 2:55:53 PM
class Solution {
    public int passThePillow(int n, int time) {
       int completed = time / (n-1);
        int remaining = time % (n-1);
        int ans = 0;
        if (completed % 2 != 0) {
            ans = n - remaining;
        } else {
            ans = remaining + 1;
        }
        return ans;
    }
}