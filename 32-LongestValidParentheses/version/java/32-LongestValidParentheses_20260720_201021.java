// Last updated: 7/20/2026, 8:10:21 PM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int si = 0, pi = 0, match = 0, star = -1;
4        int sn = s.length(), pn = p.length();
5        while (si < sn) {
6            if (pi < pn && (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si))) {
7                si++;
8                pi++;
9            } else if (pi < pn && p.charAt(pi) == '*') {
10                star = pi;
11                match = si;
12                pi++;
13            } else if (star != -1) {
14                pi = star + 1;
15                match++;
16                si = match;
17            } else {
18                return false;
19            }
20        }
21        while (pi < pn && p.charAt(pi) == '*') {
22            pi++;
23        }
24        return pi == pn;
25    }
26}