#include <bits/stdc++.h>
using namespace std;
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
# define ull unsigned long long 
# define ll long long
# define pb push_back
void dfs(int s, int p, vector<int> & count, vector<int> adj[]) {
    count[s] = 1;
    for(auto it=adj[s].begin(); it != adj[s].end(); it++) {
        int u = (*it);
        if(s != u) {
            dfs(u,s,count,adj);
            count[s] += count[u];
        }
    }
}
int main() {
    fast_io;
    int n;
    cin>>n;
    int i;
    vector<int> adj[n+1];
    for(i=2;i<=n;i++) {
        int value;
        cin>>value;
        adj[value].pb(i);
    }
    vector<int> count(n+1,0);
    dfs(1,-1,count,adj);
    for(i=1;i<=n;i++) {
        cout<<count[i]-1<<" ";
    }
    cout<<"\n";
    return 0;
}