/*

 There are N pots. Every pot has some water in it. 
 They may be partially filled. 
 Every pot is associated with overflow number O 
 which tell how many minimum no. of stones required for that pot to overflow. 
 The crow knows O1 to On(overflow no. for all the pots). 
 Crow wants some K pots to be overflow. So the task is the minimum number of stones he can make K pots overflow in the worst case. 

An array of overflow no--. {1,...On} 
Number of pots--n 
No of pots to overflow-- k
Let say two pots are there with overflow no.s {5,58}, and the crow has 
to overflow one pot(k=1). So crow will put 5 stones in 
the pot with overflow no.(58), it will not 
overflow, then he will put them in the pot with overflow no.(5), hence the total no. of stones to make overflow one pot is=10. 


*/


#include<iostream>
using namespace std;
int n,z;
int a[1009];
int dp[1009][1009];
int ans;

int large = 1e7;

void sort() {
	for(int i=1;i<=n;i++) {
		for(int j=i+1;j<=n;j++) {
			if(a[i] > a[j]) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
}

int min(int a, int b) {
	return (a > b) ? b : a;
}

int solve() {
	for(int i=1;i<=n;i++) {
		dp[i][1] = a[i]*(n - i + 1);
	}
	for(int i=n;i>0;i--) {
		for(int j=2;j<=z;j++) {
			for(int k=i+1;k<=n;k++) {
				dp[i][j] = min(dp[i][j], dp[k][j-1] + (k-i)*a[i]);
			}
		}
	}
	for(int i=1;i<=n;i++) {
		ans = min(ans, dp[i][z]);
	}
	return ans;
}

int main() {
	int test;
	cin>>test;
	while(test--) {
		cin>>n>>z;
		int i;
		ans = large;
		for(i=1;i<=n;i++) {
			cin>>a[i];
		}
		sort();
		for(i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				dp[i][j] = large;
			}
		}
		cout<<solve()<<endl;
	}
}