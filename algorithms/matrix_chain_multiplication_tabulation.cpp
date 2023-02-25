#include<iostream>
#include<string.h>
#include<limits.h>
#include<bits/stdc++.h>
int dp[101][101];
using namespace std;
int mcm(int arr[], int i, int j){
	if(i == j){
		return 0;
	}
	int min_ = INT_MAX;
	if(dp[i][j] != -1){
		return dp[i][j];
	}
	for(int k=i;k<j;k++){
		int temp = mcm(arr,i,k) + mcm(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
		if(temp < min_){
			min_ = temp;
		}
	}
	return dp[i][j] = min_;
}
int main(){
	memset(dp,-1,sizeof(dp));
	int arr[] = {1, 2, 3, 4, 3}; 
    int n = sizeof(arr)/sizeof(arr[0]); 
    cout<<mcm(arr,1,n-1)<<endl;
}
