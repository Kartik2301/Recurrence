/*

They have given one question based on binary search.

they have given one strictly increasing polynomial function. For any value of x it’s output will be y.

Question link: https://www.geeksforgeeks.org/find-element-position-in-given-monotonic-sequence/


They have given the value of y and asked for the answer x if exist otherwise print -1.

I don’t remember the exact function.  

freq : 3

*/


#include<iostream>
using namespace std;
long long small = 1e6;
long long large = 1e15;

long long getLog(long long a) {
    long long res = 0;
    while(a) {
        a /= 2;
        res++;
    }
    return res-1;
}

long long func(long long a, long long b, long long c, long long n) {
    long long val = a*n;
    val += b*n*getLog(n);
    val += c*n*n*n;
    return val;
}

long long getN(long long a, long long b, long long c, long long k) {
    long long start = 1;
    long long end = small;
    if(c == 0) {
        end = large;
    }
    while(start <= end) {
        long long mid = start + (end - start)/2;
        long long val = func(a,b,c,mid);
        if(val == k) {
            return mid;
        } else if(val < k) {
            start = mid+1;
        } else {
            end = mid-1;
        }
    }
    return 0;
}

int main() {
    long long a = 2, b = 1, c = 1;
    long long k = 12168587437017;
    cout<<getN(a,b,c,k)<<endl;
}
