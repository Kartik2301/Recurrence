#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void lcs_path(string x, string y, int m, int n){
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
	string res = "";
	i=m, j=n;
	while(i>0 && j>0){
		if(x[i-1] == y[j-1]){
			res += (x[i-1]);
			i--;
			j--;
		} else {
			if(dp[i][j-1] > dp[i-1][j]){
				j--;
			} else {
				i--;
			}
		}
	}
	reverse(res.begin(),res.end());
	cout<<res<<endl;
}
int main(){
	string x = "AGGTAB";
	string y = "GXTXAYB";
	lcs_path(x,y,x.length(),y.length());
}
