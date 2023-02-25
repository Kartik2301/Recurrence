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
long long mod = 1e9+7;

long long dp[1025][101];

long long int countWays(int allmask, int mask, int i, vector<int> capList[]) {
    if(mask == allmask) return 1;
    if(i > 100) return 0;
    if(dp[mask][i] != -1) return dp[mask][i];
    long long ways = countWays(allmask, mask, i+1,capList);
    int size = capList[i].size();
    for(int j=0; j<size; j++) {
        if(mask & (1 << capList[i][j])) continue;
        ways += countWays(allmask, mask | (1 << capList[i][j]), i+1,capList);
        ways %= mod;
    }
    return dp[mask][i] = ways;
}
int main() { 
    fast_io;
    test {
        int n;
        cin>>n;
        int i;
        string str, temp;
        getline(cin, str);
        memset(dp,-1,sizeof(dp));
        int x; 
        vector<int> capList[101];
        for(i=0;i<n;i++) {
            getline(cin, str);
            stringstream ss(str);
            
            while(ss >> temp) {
                stringstream s;
                s << temp;
                s >> x;
                capList[x].push_back(i);
            }
        }
        int allmask = (1 << n) - 1;
        cout<<countWays(allmask,0,1,capList)<<endl;
    }
    return 0;
}