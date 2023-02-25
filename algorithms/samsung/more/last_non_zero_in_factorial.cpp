#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int digit[] = {1,1,2,6,4,2,2,4,2,8};
int lastNonZeroDigit(int n) {
    if(n < 10) return digit[n];
    int temp = lastNonZeroDigit(n/5)*digit[n%10];
    if(((n/10)%10)%2 == 0) {
        return (6*temp)%10;
    } else {
        return (4*temp)%10;
    }
}
int main() {
    int n = 14;
    cout<<lastNonZeroDigit(n)<<endl;
}
