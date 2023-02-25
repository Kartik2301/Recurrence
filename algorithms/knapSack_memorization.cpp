#include <iostream>
#include<bits/stdc++.h>
#include <string.h>
using namespace std;
int t[101][1001];

int knapSack(int W, int wt[], int val[], int n){
    if(n == 0 || W == 0){
        return 0;
    }
    if(t[n][W] != -1){
        return t[n][W];
    }
    else if(wt[n-1] <= W){
        return t[n][W] = max((val[n-1]+ knapSack(W-wt[n-1],wt,val,n-1)),
                    (knapSack(W-wt[n-1],wt,val,n-1)));
    }
    else if(wt[n-1] > W){
        return t[n][W] = knapSack(W,wt,val,n-1);
    }
}
int main() 
{ 
    int val[] = { 60, 100, 120 }; 
    int wt[] = { 10, 20, 30 }; 
    memset(t,-1,sizeof(t));
    int W = 50; 
    int n = sizeof(val) / sizeof(val[0]); 
    cout << knapSack(W, wt, val, n); 
    return 0; 
} 
