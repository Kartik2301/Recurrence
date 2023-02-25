#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main() { 
    int val[] = { 60, 100, 120 }; 
    int wt[] = { 10, 20, 30 }; 
    int W = 50;
    int n = 3;
	int dp[n+1][W+1];
	for(int i=0;i<n+1;i++){
		for(int j=0; j<W+1; j++){
			if(i == 0 || j == 0){
				dp[i][j] = 0;
			} else if(wt[i-1] <= j){
				dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
			} else if(wt[i-1] > j){
				dp[i][j] = dp[i-1][j];
			}
		}
	} 
    printf("%d", dp[n][W]); 
    return 0; 
}
