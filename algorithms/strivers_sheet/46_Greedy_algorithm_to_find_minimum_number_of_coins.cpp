Solution 1 :-

Time complexity :- O(nlogn)
Space complexity :- O(n)

#include <iostream>
using namespace std;
#include<bits/stdc++.h>
int main() {
	//code
	int test;
	cin>>test;
	while(test--) {
	    int n,k;
	    cin>>n>>k;
	    int i;
	    vector<int>arr(n);
	    for(i=0;i<n;i++) {
	        cin>>arr[i];
	    }
	    sort(arr.begin(), arr.end());
	    vector<int>copy(n);
	    copy[0] = arr[0];
	    for(i=1;i<n;i++) {
	        copy[i] = copy[i-1] + arr[i];
	    }
	    int ans = INT_MAX;
	    int prev = 0;
	    for(i=0;i<n;i++) {
	        int pos = upper_bound(arr.begin()+i,arr.end(),arr[i]+k) - arr.begin();
	        if(i > 0 && arr[i] != arr[i-1]) prev = copy[i-1];
	        ans = min(ans, prev + copy[n-1] - copy[pos-1] - (n-pos)*(arr[i]+k));
	    }
	    cout<<ans<<endl;
	}
	return 0;
}

Solution 2 :-

Brute force 
Time complexity :- O(n^2)
Space complexity :- O(1)