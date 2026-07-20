// Last updated: 7/20/2026, 8:07:46 PM
1class Solution {
2    public int longestValidParentheses(String s) {
3        Stack<Integer> stack = new Stack<>();
4        stack.push(-1);
5        int max_len = 0;
6
7        for (int i = 0; i < s.length(); i++) {
8            if (s.charAt(i) == '(') {
9                stack.push(i);
10            } else {
11                stack.pop();
12                if (stack.isEmpty()) {
13                    stack.push(i);
14                } else {
15                    max_len = Math.max(max_len, i - stack.peek());
16                }
17            }
18        }
19
20        return max_len;        
21    }
22}