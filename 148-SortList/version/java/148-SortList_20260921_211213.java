// Last updated: 9/21/2026, 9:12:13 PM
1
2class Solution {
3    long resolves(long a, long b, char Operator) {
4        if (Operator == '+') return a + b;
5        else if (Operator == '-') return a - b;
6        else if (Operator == '*') return a * b;
7        return a / b;
8    }
9
10    public int evalRPN(String[] tokens) {
11        Stack<Long> stack = new Stack<>();
12        int n = tokens.length;
13        for (int i = 0; i < n; i++) {
14            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
15                long integer2 = stack.pop();
16                long integer1 = stack.pop();
17                char operator = tokens[i].charAt(0);
18                long resolvedAns = resolves(integer1, integer2, operator);
19                stack.push(resolvedAns);
20            } else {
21                stack.push(Long.parseLong(tokens[i]));
22            }
23        }
24        return stack.pop().intValue();
25    }
26}