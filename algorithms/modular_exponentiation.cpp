#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int power(int x, int y, int p) {
    x = x%p;
    if(x == 0) return 0;
    int res = 1;
    while(y > 0) {
        if(y % 2 == 1) {
            res = (res*x)%p;
        }
        y = y/2;
        x = (x*x)%p;
    }
    return res;
}

int main() {
    int x = 2;
    int y = 5;
    int p = 13;
    cout<<"("<<x<<"^"<<y<<")%"<<p<<" is "<<power(x,y,p)<<endl;
}
