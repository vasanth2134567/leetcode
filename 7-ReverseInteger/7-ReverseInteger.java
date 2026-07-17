// Last updated: 7/17/2026, 2:58:52 PM
class Solution {
    public int reverse(int x) {
              boolean isPositive = (x > 0) ? true : false;

        return (isPositive) ? reverseNumber(x) : -reverseNumber(-x);
    }

    int reverseNumber(int n){
        int revNum = 0;
        while(n > 0){
            int lastDigit = n%10;
            if(revNum > (Integer.MAX_VALUE - lastDigit)/10){
                return 0;
            }
            revNum = revNum*10 + lastDigit;
            n /= 10;
        }
        return revNum;
    }
}