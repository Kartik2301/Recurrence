#include<iostream>
#include<bits/stdc++.h>
using namespace std;
bool isPalindrome(string s, int start, int end){
	while(start < end){
		if(s[start] != s[end]){
			return false;
		}
		start++;
		end--;
	}
	return true;
}
int palindromic_partitioning(string s, int i, int j){
	if(i >= j){
		return 0;
	}
	
	if(isPalindrome(s,i,j)){
		return 0;
	}
	int min_ = INT_MAX;
	for(int k=i;k<j;k++){
		int temp = palindromic_partitioning(s,i,k) + palindromic_partitioning(s,k+1,j) + 1;
		if(temp < min_){
			min_ = temp;
		}
	}
	return min_;
}
int main(){
	string input = "ababbbabbababa";
	cout<<palindromic_partitioning(input,0,input.length()-1)<<endl;
}
