#include<iostream>
#include<string.h>
#include<bits/stdc++.h>
using namespace std;
int dp[101][101];
int lcs_memorization(string x, string y, int m, int n){
	if(m == 0 || n == 0){
		return 0;
	}
	if(dp[m][n] != -1){
		return dp[m][n];
	} 
	if(x[m-1] == y[n-1]){
		return dp[m][n] = 1 + lcs_memorization(x,y,m-1,n-1);
	} else {
		return max(lcs_memorization(x,y,m-1,n), lcs_memorization(x,y,m,n-1));
	}
}
int main(){
	memset(dp,-1,sizeof(dp));
	string x = "AGGTAB";
	string y = "GXTXAYB";
	cout<<lcs_memorization(x,y,x.length(),y.length())<<endl;
}
