// Last updated: 9/21/2026, 9:04:11 PM
1class Solution {
2
3    private boolean isPalindrome(String s, int start, int end) {
4
5        while (start <= end) {
6            if (s.charAt(start++) != s.charAt(end--)) {
7                return false;
8            }
9        }
10
11        return true;
12    }
13
14    private void func(int idx, String s, List<String> path, List<List<String>> ans) {
15
16        if (idx == s.length()) {
17            ans.add(new ArrayList<>(path));
18            return;
19        }
20
21        for (int i = idx; i < s.length(); i++) {
22
23            if (isPalindrome(s, idx, i)) {
24
25                path.add(s.substring(idx, i + 1));
26
27                func(i + 1, s, path, ans);
28
29                path.remove(path.size() - 1);
30            }
31        }
32    }
33
34    public List<List<String>> partition(String s) {
35
36        List<List<String>> ans = new ArrayList<>();
37        List<String> path = new ArrayList<>();
38
39        func(0, s, path, ans);
40
41        return ans;
42    }
43}