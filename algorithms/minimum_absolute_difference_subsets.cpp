#include<iostream>
#include<bits/stdc++.h>
#include<limits.h>
using namespace std;
vector<int>result;
bool subset_sum(int arr[], int n, int sum){
	bool dp[n+1][sum+1];
	int i,j;
	for(j=0;j<sum+1;j++){
		dp[0][j] = false;
	}
	for(i=0;i<n+1;i++){
		dp[i][0] = true;
	}
	for(i=1;i<n+1;i++){
		for(j=1;j<sum+1;j++){
			if(arr[i-1] <= sum){
				dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
			} else {
				dp[i][j] = dp[i-1][j];
			}
		}
	}
	for(j=0;j<sum+1;j++){
		if((j <= sum/2) && dp[n][j]){
			result.push_back(j);
		}
	}
}
int main(){
	int arr[] = {1,6,11,5};
	int n = 4;
	int range = 0;
	int i;
	for(i=0;i<n;i++){
		range += arr[i];
	}
	subset_sum(arr,n,range);

	int min_ = INT_MAX;
	for(i=0;i<result.size();i++){
		min_ = min(min_, range - 2*result[i]);
	}
	cout<<min_<<endl;
}
