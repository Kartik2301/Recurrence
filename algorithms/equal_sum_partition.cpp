#include<iostream>
#include<bits/stdc++.h>
using namespace std;
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
			if(arr[i-1] <= j){
				dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
			} else if(arr[i-1] > j){
				dp[i][j] = dp[i-1][j];
			}
		}
	}
	return dp[n][sum];
}
int main(){
	int arr[] = {1,7,3,2,9};
	int n = 5;
	int i, sum = 0;
	for(i=0;i<n;i++){
		sum += arr[i];
	}
	if(sum %2 == 1){
		cout<<boolalpha<<false<<endl;
	} else {
		cout<<boolalpha<<subset_sum(arr,n,sum/2)<<endl;
	}
}
