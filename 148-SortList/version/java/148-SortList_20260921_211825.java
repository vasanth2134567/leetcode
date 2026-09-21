// Last updated: 9/21/2026, 9:18:25 PM
1class Solution {
2    public int maxPoints(int[][] points) {
3
4        if(points.length<=2)
5            return points.length; 
6
7        int max = 0; 
8
9        for(int i = 0; i<points.length; i++){
10            HashMap<Double, Integer> mp = new HashMap<>(); 
11            for(int j = i+1; j<points.length; j++){
12                int x1 = points[i][0]; 
13                int x2 = points[j][0]; 
14                int y1 = points[i][1]; 
15                int y2 = points[j][1]; 
16
17                double slope; 
18                if(x1 == x2)
19                    slope = Double.POSITIVE_INFINITY;
20                else{
21                    slope = (double)(y1-y2)/(x2-x1);
22                    if(slope == -0.0)
23                        slope = 0.0; 
24                } 
25
26                mp.put(slope, mp.getOrDefault(slope, 0) + 1); 
27            }
28            for(int value: mp.values())
29                max = Math.max(max, value+1); 
30        }
31
32        return max; 
33    }
34}