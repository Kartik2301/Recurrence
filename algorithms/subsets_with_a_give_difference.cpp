#include<iostream>
using namespace std;
int count_subsets_with_given_sum(int arr[], int sum, int n){
	int dp[n+1][sum+1];
	int i,j;
	for(j=0;j<sum+1;j++){
		dp[0][j] = 0;
	}
		dp[0][0] = 1;
	
	for(i=1;i<n+1;i++){
		for(j=0;j<sum+1;j++){
			if(arr[i-1] <= j){
				dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
			} else {
				dp[i][j] = dp[i-1][j];
			} 
		}
	}
	return dp[n][sum];
}
int main(){
	int n = 9;
	int arr[] = {0,0,0,0,0,0,0,0,1};
	int diff = 1;
	int i, sum = 0;
	for(i=0;i<n;i++){
		sum += arr[i];
	}
	int req_sum = (sum + diff)/2;
	cout<<count_subsets_with_given_sum(arr,req_sum,n)<<endl;
}
