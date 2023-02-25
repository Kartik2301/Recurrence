#include<iostream>
using namespace std;
int no_ways(int coins[], int sum, int n){
	int dp[n+1][sum+1];
	int i,j;
	for(j=0;j<sum+1;j++){
		dp[0][j] = 0;
	}
	for(i=0;i<n+1;i++){
		dp[i][0] = 1;
	}
	for(i=1;i<n+1;i++){
		for(j=1;j<sum+1;j++){
			if(coins[i-1] <= j){
				dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
			} else {
				dp[i][j] = dp[i-1][j];
			}
		}
	}
	return dp[n][sum];
}
int main(){
	int coins[] = {1,2,5};
	int sum = 5;
	int n = 3;
	cout<<no_ways(coins,sum,n);
}
