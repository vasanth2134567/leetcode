// Last updated: 7/17/2026, 2:57:07 PM
class Solution {
    public int findComplement(int num) {
        int result = 0;
        int bitPos = 0;
        
        while (num > 0) {
            int bit = num & 1;
            int flipped = 1 - bit;
            
            result |= (flipped << bitPos);
            
            num >>= 1;
            bitPos++;
        }
        
        return result;
    }
}
