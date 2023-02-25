#include<iostream>
using namespace std;
int main(){
	int coins[] = {1, 2, 5};
	int n = 3;
	int amount = 11;
    int dp[n+1][amount+1];
    int i,j;
    for(j=0;j<amount+1;j++){
        dp[0][j] = INT_MAX-1;
    }
    for(i=1;i<n+1;i++){
        dp[i][0] = 0;
    }
    for(j=1;j<amount+1;j++){
        if(j % coins[0] == 0){
            dp[1][j] = j/coins[0];
        } else {
            dp[1][j] = INT_MAX-1;
        }
    }
    for(i=2;i<n+1;i++){
        for(j=1;j<amount+1;j++){
            if(coins[i-1] <= j){
                dp[i][j] = min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
            } else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    cout<<dp[n][amount]<<endl;
}
