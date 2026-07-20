// Last updated: 7/20/2026, 8:13:43 PM
1class Solution {
2    public int[][] insert(int[][] intervals, int[] newInterval) {
3        List<int[]> result = new ArrayList<>();
4        
5        // Iterate through intervals and add non-overlapping intervals before newInterval
6        int i = 0;
7        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
8            result.add(intervals[i]);
9            i++;
10        }
11        
12        // Merge overlapping intervals
13        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
14            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
15            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
16            i++;
17        }
18        
19        // Add merged newInterval
20        result.add(newInterval);
21        
22        // Add non-overlapping intervals after newInterval
23        while (i < intervals.length) {
24            result.add(intervals[i]);
25            i++;
26        }
27        
28        return result.toArray(new int[result.size()][]);
29    }
30}