// Last updated: 7/17/2026, 2:57:24 PM
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // .add() returns false if the element was already present in the set
            if (!seen.add(num)) {
                return true; 
            }
        }
        
        // If the loop finishes, all elements are unique
        return false;
    }
}