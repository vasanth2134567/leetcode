// Last updated: 7/17/2026, 2:58:02 PM
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry forward, safe to return early
            }
            // If it's 9, it becomes 0
            digits[i] = 0;
        }
        
        // Edge case: If all digits were 9 (e.g., 999 -> 1000)
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Remaining elements default to 0
        
        return newDigits;
    }
}