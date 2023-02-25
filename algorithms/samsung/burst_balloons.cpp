/*


burst balloon to maximize the coins.


This was a 3 hr coding round which consisted of one coding question with 50 test cases.You were allowed to submit the 
code only for 10 times but you can run the code any number of times.The question was there are n balloons and each 
balloon is assigned with a particular number(point). Whenever a particular balloon is shot the no of points increases by
1.the multiplication of point assigned to balloon on left and that of right side.
2.point assigned to left if no right exists
3.point assigned to right if no left exists.
4.the point assigned to itself if no other balloon exists.
You need to pass all the 50 test cases for qualifying to the next round.






There are N Balloons marked with value Bi (where B(i…N)).
User will be given Gun with N Bullets and user must shot N times.
When any balloon explodes then its adjacent balloons becomes next to each other.
User has to score highest points to get the prize and score starts at 0.
Below is the condition to calculate the score.
When Balloon Bi Explodes then score will be a product of Bi-1 & Bi+1 (score = Bi-1 * Bi+1).
When Balloon Bi Explodes and there is only left Balloon present then score will be Bi-1.
When Balloon Bi Explodes and there is only right Balloon present then score will be Bi+1.
When Balloon Bi explodes and there is no left and right Balloon present then score will be Bi.
Write a program to score maximum points.

Example: 
Input: B[] = {1, 2, 3, 4}
Output: 20
Explanation:
For max score:
3 explodes, score= 4*2=8 (product of adjacent balloons) 
2 explodes score= 4*1 + 8 = 12 (product of adjacent balloons) 
1 explodes score=  4 + 12= 16  (only 4 is left on the left side)
4 explodes score = 4 + 16 = 20 (no balloons left so add 4)
score =20
other combinations will result in lesser scores.



This was a coding round.There are n balloons and n bullets and each balloon is assigned with a particular number (point).
Whenever a particular balloon is shot the no of points increases by 1.the multiplication of point assigned to balloon on left and that of right side.

2.point assigned to left if no right exists

3.point assigned to right if no left exists.

4.the point assigned to itself if no other balloon exists.



*/

int dp[101][101];

#include<iostream>
using namespace std;

int solve(int arr[], int n) {
	for(int len = 1; len <= n; len++) {
		for(int left = 1; left <= n-len+1; left++) {
			int right = left+len-1;
			for(int k=left;k<=right;k++) {
				int temp = dp[left][k-1] + dp[k+1][right];
				if(left == 1 && right == n) {
					temp += arr[k];
				} else {
					temp += arr[left-1]*arr[right+1];
				}
				dp[left][right] = max(dp[left][right], temp);
			}
		}
	}
	return dp[1][n];
}

int main() {
	int n;
	cin>>n;
	int arr[n+2];
	arr[0] = 1;
	arr[n+1] = 1;
	for(int i=1;i<=n;i++) {
		cin>>arr[i];
	}
	for(int i=0;i<101;i++) {
		for(int j=0;j<101;j++) {
			dp[i][j] = 0;
		}
	}
	cout<<solve(arr,n);
}