#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int lcs_tabulation(string x, string y, int m, int n){
	int dp[m+1][n+1];
	int i,j;
	for(i=0;i<m+1;i++){
		for(j=0;j<n+1;j++){
			if(i == 0 || j == 0){
				dp[i][j] = 0;
			}
		}
	}
	for(i=1;i<m+1;i++){
		for(j=1;j<n+1;j++){
			if(x[i-1] == y[j-1]){
				dp[i][j] = 1 + dp[i-1][j-1];
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	return dp[m][n];
}
int main(){
	string x = "AGGTAB";
	string y = "GXTXAYB";
	int m = x.length();
	int n = y.length();
	cout<<lcs_tabulation(x,y,m,n)<<endl;
}
