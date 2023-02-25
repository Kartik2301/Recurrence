#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main() { 
    int arr[] = { 2,3,7,8,10 };  
    int sum = 11;
    int n = 5;
	bool dp[n+1][sum+1];
	int i,j;
	for(j=0;j<sum+1;j++){
		dp[0][j] = false;
	}
	for(i=0;i<n+1;i++){
		dp[i][0] = true;
	}
	for(i=1;i<n+1;i++){
		for(j=1; j<sum+1; j++){
			if(arr[i-1] <= j){
				dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
			} else if(arr[i-1] > j){
				dp[i][j] = dp[i-1][j];
			}
		}
	} 
    cout<<boolalpha<<dp[n][sum]<<endl;
    return 0; 
} 
