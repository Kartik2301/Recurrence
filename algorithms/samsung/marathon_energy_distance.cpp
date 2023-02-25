 /*

Marathon Problem

 Energy distance problem.


Question: There was given total physical energy H and total distance D. Five pace information
speed and corresponding physical energy was given. Find the minimum time that is required in order to
complete total distance D making sure that some of the physical energy does not exceed H
( I don’t remember the question exactly, but it is something like this).



Question: There was given total physical energy H and total distance D.
Five pace information speed and corresponding physical energy was given.
Find the minimum time that is required in order to complete total distance D making sure that some of the physical energy does not exceed H.

Time Limit: 3 secs

I solved using dynamic programming.

Physical Energy Problem

There was given total physical energy H and total distance D. Five pace information speed and corresponding physical energy was given.
Find the minimum time that is
required in order to complete total distance D making sure that some of the physical energy does not exceed H.

*/



#include<iostream>
using namespace std;

int d,e;
int a[5][2];
int dp[1000][1000];

int solve(int d, int e) {
	if(d == 0) return 0;

	if(dp[d][e] == -1) return dp[d][e];


	int ans = 1e7;
	int i;
	for(i=0;i<5;i++) {
		if(e >= a[i][1]) {
			int temp = a[i][0] + solve(d-1,e - a[i][1]);
			ans = min(ans,temp);
		}
	}
	return dp[d][e] = ans;
}

int main() {
	cin>>d>>e;
	int i;
	for(i=0;i<5;i++) {
		cin>>a[i][0]>>a[i][1];
	}
	for(i=0;i<1000;i++) {
		for(int j=0;j<1000;j++) {
			dp[i][j] = -1;
		}
	}
	cout<<solve(d,e)<<endl;
}
