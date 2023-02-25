#include<iostream>
using namespace std;
int unboundedKnapsack(int W, int n, int val[], int wt[]){
	int dp[n+1][W+1];
	int i,j;
	for(i=0;i<n+1;i++){
		for(j=0;j<W+1;j++){
			if(i == 0 || j == 0){
				dp[i][j] = 0;
			} else if(wt[i-1] <= j){
				dp[i][j] = max((val[i-1]+dp[i][j-wt[i-1]]), dp[i-1][j]);
			} else {
				dp[i][j] = dp[i-1][j];
			}
		}
	}
	return dp[n][W];
}
int main(){
	int W = 100; 
    int val[] = {10, 30, 20}; 
    int wt[] = {5, 10, 15}; 
    int n = sizeof(val)/sizeof(val[0]); 
  
    cout << unboundedKnapsack(W, n, val, wt); 
}
