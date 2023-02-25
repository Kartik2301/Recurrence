Solution 1 :-
Merge both array, using merge of merge sort
Time complexity :- O(n+m)
Space complexity :- O(n+m) or O(1) [dont use array]

Solution 2 :-
Use max Heap
Time complexity :- O(nlogk)
Space complexity :- O(n)

Solution 3:-

Use binary search (similat to the method of finding median)
Time complexity :- O(log(n)) [exactly :- O(logm)*O(logn)]
#include <iostream>
using namespace std;
#include<bits/stdc++.h>
int main() {
	//code
	long long int test;
	cin>>test;
	while(test--) {
	    long long int n,m;
	    cin>>n>>m;
	    long long int ans = -1;
	    long long int low = 1;
	    long long int high = m;
	    while(low <= high) {
	        long long int mid = low + (high - low)/2;
	        long long int val = pow(mid,n);
	        if(val == m) {
	            ans=mid;
	            break;
	        } else if(val < m) {
	            low = mid+1;
	        } else {
	            high = mid-1;
	        }
	    }
	    cout<<ans<<endl;
	}
	return 0;
}