// Last updated: 9/21/2026, 9:29:25 PM
1class Solution {
2    public String getHint(String secret, String guess) {
3        int bulls = 0;
4        int cows = 0;
5        int[] secretCount = new int[10];
6        int[] guessCount = new int[10];
7
8        for (int i = 0; i < secret.length(); i++) {
9            char s = secret.charAt(i);
10            char g = guess.charAt(i);
11            if (s == g) {
12                bulls++;
13            } else {
14                secretCount[s - '0']++;
15                guessCount[g - '0']++;
16            }
17        }
18
19        for (int i = 0; i < 10; i++) {
20            cows += Math.min(secretCount[i], guessCount[i]);
21        }
22
23        return bulls + "A" + cows + "B";
24    }
25}