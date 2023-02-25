#include <iostream>
using namespace std;
#include<bits/stdc++.h>
int main() {
	//code
	int test;
	cin>>test;
	while(test--) {
	    int k,n;
	    cin>>k>>n;
	    int arr[n];
	    int i;
	    for(i=0;i<n;i++) {
	        cin>>arr[i];
	    }
	    priority_queue<int, vector<int>, greater<int>> pq;
	    for(i=0;i<n;i++) {
	        pq.push(arr[i]);
	        if(pq.size() < k) {
	            cout<<-1<<" ";
	            continue;
	        }
	        if(pq.size() > k) {
	            pq.pop();
	        }
	        cout<<pq.top()<<" ";
	    }
	    cout<<"\n";
	}
	return 0;
}