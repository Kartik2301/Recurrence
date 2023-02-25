Solution 1 :-
using binary search

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

Time complexity :- O(log(number))*O(logn)
Space complexity :- O(1)

Solution 2 :-
Brute force based

Time complexity :- O(sqrt(number))
Time complexity :- O(1)