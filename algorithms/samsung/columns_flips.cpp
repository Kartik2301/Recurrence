/*

Given a binary matrix of size m*n. A laser when applied along a column, complement the e
ntire column(changes 0’s to 1’s and vice versa).
Given k, the number of times laser to be applied along columns.
You can apply laser on any column any number of times such that total number of times laser applied is k.
Rank of matrix is the number of rows with each entire row consisting of 1’s.
After applying the laser k times on the given matrix, the problem is to find the maximum rank.


I have created a binary array of size m.
0 and 1 at ith index in the array indicates laser is applied even and odd number of
times across the ith column(1 in ith index of binary array indicates to complement i
th column in binary matrix). Let s be the sum of the binary array.
If (k-s) is a multiple of 2 then it is the case that laser is applied k times. For each permutation of the binary array if the above condition is satisfied, rank will be calculated from the laser applied matrix by counting the number of rows with each element
as 1 and max_rank will be updated with rank if rank>max_rank.





A binary matrix of nxm was given, you have to toggle any column k number of times so that you can get the maximum number of rows having all 1’s.




for eg, n=3, m=3,

            1 0 0

            1 0 1

            1 0 0

if k=2, then we will toggle column 2 and 3 once and we will get rows 1 and 3 with 1 1 1 and 1 1 1 i.e. all 1’s so answer is 2 as there are 2 rows with all 1’s.

if k=3, then we will toggle column 2 thrice and we will get row 2 with 1 1 1 i.e. all 1’s so answer is 1 as there is 1 row with all 1’s.

Only those students who passed all the test cases were shortlisted for the interviews.





flip k columns for max ones


freq : 1


*/




#include<iostream>
using namespace std;

int m,n;
int arr[100][100];
int hash[1000][2];
int k;

int max(int a, int b) {
	return (a > b) ? a : b;
}

int solve() {
	int i,j;
	for(i=0;i<1000;i++) {
		for(j=0;j<2;j++) {
			hash[i][j] = 0;
		}
	}
	for(i=0;i<m;i++) {
		int val = 0;
		int base = 1;
		int numZeros = 0;
		for(j=n-1;j>=0;j--) {
			if(arr[i][j] == 0) {
				numZeros++;
			}
			val += arr[i][j]*base;
			base *= 2;
		}
		if(numZeros <= k) {
			if(((numZeros - k) % 2) == 0) {
				hash[val][1]++;
			}
		}
	}


	int max_freq = 0;
	for(i=0;i<1000;i++) {
		max_freq = max(max_freq,hash[i][1]);
	}
	return max_freq;
}

int main() {
	int test;
	cin>>test;
	while(test--) {
		cin>>m>>n;
		int i,j;
		for(i=0;i<m;i++) {
			for(j=0;j<n;j++) {
				cin>>arr[i][j];
			}
		}
		cin>>k;
		cout<<solve()<<endl;
	}
}
