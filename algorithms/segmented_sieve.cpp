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

# define MAX 100001

vector<ll> sieve() {
    bool isPrime[MAX];
    memset(isPrime,true,sizeof(isPrime));
    for(ll p=2;p*p<MAX;p++) {
        if(isPrime[p]) {
            for(ll i=p*p;i<MAX;i+=p) {
                isPrime[i] = false;
            }
         }
    }
    vector<ll> primes;
    ll i;
    primes.push_back(2);
    for(i=3;i<MAX;i+=2) {
        if(isPrime[i]) {
            primes.push_back(i);
        }
    }
    return primes;
}

void findPrimes(ll l, ll r, vector<ll> & primes) {
    ll i;
    bool isPrime[r-l+1];
    for(i=0;i<=r-l;i++) {
        isPrime[i] = true;
    }
    for(i=0;primes[i]*(ll)primes[i] <= r; i++) {
        ll curPrime = primes[i];
        ll base = (l / curPrime)*curPrime;
        if(base < l) {
            base += curPrime;
        }
        for(ll j=base;j<=r;j+=curPrime) {
            isPrime[j-l] = false;
        }
        if(base == curPrime) {
            isPrime[base - l] = true;
        }
    }
    for(i=0;i<=r-l;i++) {
        if(isPrime[i]) {
            cout<<i+l<<endl;
        }
    }
}

int main() { 
    fast_io;
    vector<ll> primes = sieve();
    test {
        ll l,r;
        cin>>l>>r;
        findPrimes(l,r,primes);
    }
    return 0;
}