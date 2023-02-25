#include<iostream>
using namespace std;
#include<bits/stdc++.h>
int lc_string(string x, string y, int m, int n){
	int result = 0;
	int dp[m+1][n+1];
	int i,j;
	for(i=0;i<m+1;i++){
		for(j=0;j<n+1;j++){
			if(i==0 || j==0){
				dp[i][j] = 0;
			}
		}
	}
	for(i=1;i<m+1;i++){
		for(j=1;j<n+1;j++){
			if(x[i-1] == y[j-1]){
				dp[i][j] = dp[i-1][j-1] + 1;
				result = max(result,dp[i][j]);
			} else {
				dp[i][j] = 0;
			}
		}
	}
	return result;
}
int main(){
	string x = "OldSite:GeeksforGeeks.org";
	string y = "NewSite:GeeksQuiz.com";
	cout<<lc_string(x,y,x.length(),y.length())<<endl;
}
