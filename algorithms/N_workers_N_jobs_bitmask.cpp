#include <bits/stdc++.h>
using namespace std;
# define ll long long
# define ull unsigned long long 
# define test long long t; cin>>t; while(t--)
# define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
# define add push_back;
# define sort_vec(v) sort(v.begin(),v.end())
# define sort_arr(arr,n) sort(arr,arr+n)
# define set_bits(x)  __builtin_popcount (x)
# define gcd(a,b) __gcd(a,b)
# define Len(s) s.length()
// cout<< fixed << setprecision(10) << x << endl;
// cout<< boolalpha << true << endl;
# define loop(i,a,b)  for(int i=a;i<=b;i++)
# define loop_step(i,a,b,step)  for(int i=a;i<=b;i+=step)
# define input(a,n)  for(int i=0;i<n;i++) cin>>a[i]
# define display(a,n)  for(int i=0;i<n;i++) cout<<a[i]<<" ";
# define println cout<<"\n";
# define print_flag(flag) if(flag) {cout << "YES" <<endl;} else {cout << "NO" <<endl;}
int dp[21][1<<21];
int cost[21][21];


/*
Problem Statement

Let there be N workers and N jobs. Any worker can be assigned to perform any job, incurring some cost that may vary depending on the work-job assignment. It is required to perform all jobs by assigning exactly one worker to each job and exactly one job to each agent in such a way that the total cost of the assignment is minimized.

Input Format
Number of workers and job: N
Cost matrix C with dimension N*N where C(i,j) is the cost incurred on assigning ith Person to jth Job.

Sample Input
4

[
9 2 7 8
6 4 3 7
5 8 1 8
7 6 9 4
]

Sample Output
13

Constraints
N <= 20
*/
int solve(int i, int mask, int n) {
    if(i == n) {
        return 0;
    }
    if(dp[i][mask] != -1) return dp[i][mask];
    int answer = INT_MAX;
    for(int j=0;j<n;j++) {
        if(mask & (1 << j)) {
            answer = min(answer, solve(i+1, mask ^ (1 << j), n) + cost[i][j] );
        }
    }
    return dp[i][mask] = answer;
}
int main() { 
    fast_io;
    int n;
    cin>>n;
    int i,j;
    memset(dp,-1,sizeof(dp));
    for(i=0;i<n;i++) {
        for(j=0;j<n;j++) {
            cin>>cost[i][j];
        }
    }
    cout<<solve(0,(1<<n)-1,n)<<endl;
    return 0;
}