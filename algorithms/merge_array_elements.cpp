#include<bits/stdc++.h>
#include<iostream>
#include<limits.h>
using namespace std;
int main() {
	int len,i,j,k;
	int arr[] = { 6, 4, 4, 6 };
	int n = 4; 
	int prefixSum[n+1] = {0};
	for(i=1;i<=n;i++) {
		prefixSum[i] = prefixSum[i-1] + arr[i-1];
	}
	int dp[n+1][n+1];
	for(i=1;i<=n;i++) {
		dp[i][i] = 0;
	}
	for(len = 2; len <= n; len++) {
		for(i=1;i<=n-len+1;i++) {
			j = i + len-1;
			dp[i][j] = INT_MAX;
			int sum = prefixSum[j] - prefixSum[i-1];
			for(k=i;k<j;k++) {
				dp[i][j] = min(dp[i][j],dp[i][k] + dp[k+1][j] + sum);
			}
		}
	}
	cout<<dp[1][n]<<endl;
}