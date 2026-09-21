// Last updated: 9/21/2026, 9:21:58 PM
1class Solution {
2    public int computeArea(int ax1, int ay1, int ax2, int ay2,
3                           int bx1, int by1, int bx2, int by2) {
4
5        int area1 = (ax2 - ax1) * (ay2 - ay1);
6        int area2 = (bx2 - bx1) * (by2 - by1);
7
8        int overlap_width =
9            Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
10
11        int overlap_height =
12            Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
13
14        int overlap_area = overlap_width * overlap_height;
15
16        int total_area = area1 + area2 - overlap_area;
17
18        return total_area;
19    }
20}