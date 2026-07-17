// Last updated: 7/17/2026, 2:55:48 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getLength(int[] nums) {
        int[] dremovical = nums;
        int n = dremovical.length;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            Map<Integer, Integer> freqOfFreq = new HashMap<>();
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int num = dremovical[j];
                int currentFreq = freqMap.getOrDefault(num, 0);

                if (currentFreq > 0) {
                    freqOfFreq.put(currentFreq, freqOfFreq.get(currentFreq) - 1);
                    if (freqOfFreq.get(currentFreq) == 0) {
                        freqOfFreq.remove(currentFreq);
                    }
                }
                
                int newFreq = currentFreq + 1;
                freqMap.put(num, newFreq);
                freqOfFreq.put(newFreq, freqOfFreq.getOrDefault(newFreq, 0) + 1);

                if (newFreq > maxFreq) {
                    maxFreq = newFreq;
                }

                int currentLength = j - i + 1;

                if (currentLength == 1) {
                    maxLen = Math.max(maxLen, currentLength);
                } else if (freqOfFreq.size() == 1) {
                    if (freqMap.size() == 1) {
                        maxLen = Math.max(maxLen, currentLength);
                    }
                } else if (freqOfFreq.size() == 2) {
                    int otherFreq = -1;
                    for (int f : freqOfFreq.keySet()) {
                        if (f != maxFreq) {
                            otherFreq = f;
                            break;
                        }
                    }
                    if (maxFreq == 2 * otherFreq) {
                        maxLen = Math.max(maxLen, currentLength);
                    }
                }
            }
        }
        return maxLen;
    }
}