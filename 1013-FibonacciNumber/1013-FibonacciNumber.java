// Last updated: 7/17/2026, 2:56:40 PM
class Solution {
    public int fib(int n) {
     if(n<=1) return n;
        return fib(n-1) + fib(n-2);   
    }
}