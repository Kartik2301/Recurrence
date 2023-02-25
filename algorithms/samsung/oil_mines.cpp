/*
There is an island surrounded by oil mines. 
You will be given n companies and m oil mines having values. You have to distribute 
the mines to "n" companies in fair manner. 
Remember the companies can have oil mines adjacent to each other and not in between of each others.
After distributing them compute the difference of oil mines from the company getting highest and company getting lowest. 
This number should be minimum.(then only the distribution can be termed as fair).
 
  Example
  Input
  2
  2 4
  6 13 10 2
  2 4
  6 10 13 2
 
  output
  5
  1
  
*/


#include<iostream>
using namespace std;

int c,n;
int a[100];
int b[100];
int pre[100];
int dp[100][100][2];

void init() {
	int i,j,k;
	for(i=0;i<100;i++) {
		pre[i] = 0;
	}
	for(i=0;i<100;i++) {
		for(j=0;j<100;j++) {
			for(k=0;k<2;k++) {
				dp[i][j][k] = 0;
			}
		}
	}
}

int max(int a, int b) {
    return (a > b) ? a : b;
}

int min(int a, int b) {
    return (a > b) ? b : a;
}

void sum() {
	int i;
	for(i=1;i<=n;i++) {
		pre[i] = pre[i-1] + a[i];
	}
}

int solve() {
	for(int j=1;j<=n;j++) {
		for(int k=1;k<=min(c,j);k++) {
			if(k == 1) {
				dp[j][k][0] = pre[j];
				dp[j][k][1] = pre[j];
			} else {
				int temp = 1e7;
				for(int l=j; l>=k; l--) {
					int mn = min((pre[j] - pre[l-1]), min(dp[l-1][k-1][0], dp[l-1][k-1][1]));
					int mx = max((pre[j] - pre[l-1]), max(dp[l-1][k-1][0], dp[l-1][k-1][1]));
					if(mx - mn < temp) {
						temp = mx - mn;
						dp[j][k][0] = mn;
						dp[j][k][1] = mx;
					}
				}
			}
		}
	}
	return dp[n][c][1] - dp[n][c][0];
}

int main() {
	int test;
	cin>>test;
	while(test--) {
		cin>>c>>n;
		int i;
		for(i=1;i<=n;i++) {
			cin>>b[i];
		}
		for(i=n+1;i<=2*n;i++) {
			b[i] = b[i-n];
		}
		int ans = 1e7;
		for(i=1;i<=n+1;i++) {
			int j = i + n - 1;
			init();
			int temp = 1;
			for(int k=i;k<=j;k++) {
				a[temp] = b[k];
				temp++;
			}
			sum();
			ans = min(ans, solve());
		}
		if(c > n) {
			ans = -1;
		}
		cout<<ans<<endl;
	}
}
