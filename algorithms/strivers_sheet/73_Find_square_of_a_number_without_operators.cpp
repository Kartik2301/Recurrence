Solution 1 :- Using bitwise/ divided and conquer

#include<bits/stdc++.h>
using namespace std;
int solve(int num) {
    if(num < 2) return num;
    int half = num>>1;
    if(num & 1) {
        return (solve(half)<<2) + 1 + (half<<2); 
    } else {
        return (solve(half)<<2);
    }
}
int main() {
    int n;
    cin>>n;
    n = abs(n);
    cout<<solve(n)<<endl;
}

The time complexity of the above solution is O(Logn).
Space complexity :- O(1)

Solution 2 :-

Add n to n, (n-1) times

Time complexity :- O(n)
Space complexity :- O(1)