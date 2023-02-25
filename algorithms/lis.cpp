#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){
	int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };  
    int n = sizeof(arr)/sizeof(arr[0]);
	int lis[n];
	lis[0] = 1;
	int i,j;
	for(i=1;i<n;i++){
		lis[i] = 1;
		for(j=0;j<i;j++){
			if(arr[i] > arr[j] && lis[i] < lis[j] + 1){
				lis[i] = lis[j] + 1;
			}
		}
	}
	cout<<*max_element(lis,lis+n)<<endl;  
}
