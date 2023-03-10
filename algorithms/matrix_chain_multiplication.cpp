#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int mcm(int arr[], int i, int j){
	if(i == j){
		return 0;
	}
	int min_ = INT_MAX;
	int temp = 0;
	for(int k=i;k<j;k++){
		temp = mcm(arr,i,k) + mcm(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
		if(temp < min_){
			min_ = temp;
		}
	}

	return min_;
}
int main(){
	int arr[] = {1, 2, 3, 4, 3}; 
    int n = sizeof(arr)/sizeof(arr[0]); 
    cout<<mcm(arr,1,n-1);
}
