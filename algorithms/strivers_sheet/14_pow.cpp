Solution 1 :- Brute force O(n) time complexity
Space complexity :- O(1)

note :- x^(-n) = 1/x^n

Solution 2 :- O(log(n)) time complexity, space complexity O(1) 

Recursive solution

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double temp = myPow(x,n/2);
        if(n % 2 == 0) return temp*temp;
        if(n > 0) return temp*temp*x;
        if(n < 0) return temp*temp/x;
        return temp*temp/x;
    }
}

Iterative solution

class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        boolean isNeg = false;
        if(n < 0) {
            isNeg = true;
            nn = -1*nn;
        }
        double ans = 1;
        while(nn > 0) {
            if(nn % 2 == 0) {
                x = x*x;
                nn /= 2;
            } else {
                ans = ans*x;
                nn--;
            }
        }
        if(isNeg) return (double) 1.0/ans;
        return ans;
    }
}