// Last updated: 7/17/2026, 2:56:49 PM
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        
        if (deadSet.contains("0000")) {
            return -1;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer("0000");
        visited.add("0000");
        
        int turns = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(target)) {
                    return turns;
                }
                
                for (int wheel = 0; wheel < 4; wheel++) {
                    for (int move : new int[]{-1, 1}) {
                        int nextDigit = (current.charAt(wheel) - '0' + move + 10) % 10;
                        
                        String nextState = current.substring(0, wheel) + 
                                           nextDigit + 
                                           current.substring(wheel + 1);
                        
                        if (!deadSet.contains(nextState) && !visited.contains(nextState)) {
                            visited.add(nextState);
                            queue.offer(nextState);
                        }
                    }
                }
            }
            turns++;
        }
        
        return -1;
    }
}