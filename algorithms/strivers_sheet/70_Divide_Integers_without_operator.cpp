Solution 1 :-
Using bit manipulation

Use the fact that any number can be represented as a power of 2
class Solution {
public:
    int divide(int dividend, int divisor) {
        if(dividend == INT_MIN && divisor == -1) return INT_MAX;
        int sign = ((dividend ^ divisor) < 0) ? -1 : 1;
        long long a = abs(dividend);
        long long b = abs(divisor);
        long long t = 0;
        long long q = 0;
        for(long long i=31;i>=0;i--) {
            if((t + (b<<i)) <= a) {
                q |= (1LL<<i);
                t += b<<i;
            }
        }
        return q*sign;
    }
};

Time complexity :- O(log(dividend)) [every time we are essentially dividing the dividend by power of 2]
Space complexity :- O(1)

Soution 2 :-
Using simple repeatitive subtraction

Time complexity :- O(dividend)
Space complexity :- O(1)