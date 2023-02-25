#include <iostream>
using namespace std;
#include<bits/stdc++.h>

int lcs(string a, string b, int m, int n){
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
            if(a[i-1] == b[j-1]){
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    return dp[m][n];
}
int main() {
	int test;
	cin>>test;
	while(test--){
	    string a;
	    cin>>a;
	    string b = a;
	    reverse(b.begin(),b.end());
	    cout<<lcs(a,b,a.length(),b.length())<<endl;
	}
	return 0;
}
