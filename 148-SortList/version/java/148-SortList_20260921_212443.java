// Last updated: 9/21/2026, 9:24:43 PM
1//If this solution helped you consider giving it an upvote
2class Solution {
3    public int calculate(String s) {
4        int res = 0, n = 0;
5        Stack<Integer> st = new Stack<>();
6        s += '+';
7        char op = '+';
8        for(int i = 0; i < s.length(); i++){
9            char c = s.charAt(i);
10
11            if(c == ' ') continue;
12
13            if(Character.isDigit(c)){
14                n = n * 10 + (c - '0');
15                continue;
16            }
17
18            if(op == '+') st.push(n);
19            else if(op == '-') st.push(-n);
20            else if(op == '*') st.push(st.pop() * n);
21            else if(op == '/') st.push(st.pop() / n);
22
23            op = c;
24            n = 0;
25        }
26
27        for(int i : st){
28            res += i;
29        }
30
31        return res;
32    }
33}