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
ll power(ll x, ll y, ll p) {
    if(y == 0) return 1 % p;
    ll u = power(x,y/2,p);
    u = (u*u) % p;
    if(y % 2 == 1) u = (u*x) % p;
    return u;
}
ll modinverse(ll a, ll p) {
    return power(a,p-2,p);
}
int main() { 
    fast_io;
    test {
        ll n,p;
        cin>>n>>p;
        if(n >= p) {
            cout<<0<<endl;
        } else {
            ll res = p-1;
            ll i;
            for(i=n+1;i<p;i++) {
                res = (res * modinverse(i,p)) % p;
            }
            cout<<res<<endl;
        }
    }
    return 0;
}