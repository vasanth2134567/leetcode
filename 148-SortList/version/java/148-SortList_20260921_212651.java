// Last updated: 9/21/2026, 9:26:51 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> diffWaysToCompute(String expression) {
5        List<Integer> res = new ArrayList<>();
6        for (int i = 0; i < expression.length(); ++i) {
7            char oper = expression.charAt(i);
8            if (oper == '+' || oper == '-' || oper == '*') {
9                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
10                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
11                for (int a : s1) {
12                    for (int b : s2) {
13                        if (oper == '+') res.add(a + b);
14                        else if (oper == '-') res.add(a - b);
15                        else if (oper == '*') res.add(a * b);
16                    }
17                }
18            }
19        }
20        if (res.isEmpty()) res.add(Integer.parseInt(expression));
21        return res;
22    }
23}