#include<iostream>
using namespace std;
int rod_cutting(int price[], int len[], int n){
	int dp[n+1][n+1];
	int i,j;
	for(i=0;i<n+1;i++){
		for(j=0;j<n+1;j++){
			if(i == 0 || j == 0){
				dp[i][j] = 0;
			} else if(len[i-1] <= j){
				dp[i][j] = max(price[i-1]+dp[i][j - len[i-1]], dp[i-1][j]);
			} else {
				dp[i][j] = dp[i-1][j];
			}
		}
	}
	return dp[n][n];
}
int main(){
	int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
	int n = sizeof(price)/sizeof(price[0]);
	int i;
	int length[n];
	for(i=1;i<=n;i++){
		length[i-1] = i;
	}
	cout<<rod_cutting(price,length,n)<<endl;
}
