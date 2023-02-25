// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

vector <int> topoSort(int N, vector<int> adj[]);

/*  Function to check if elements returned by user
*   contains the elements in topological sorted form
*   V: number of vertices
*   *res: array containing elements in topological sorted form
*   adj[]: graph input
*/
bool check(int V, vector <int> &res, vector<int> adj[]) {
    vector<int> map(V, -1);
    for (int i = 0; i < V; i++) {
        map[res[i]] = i;
    }
    for (int i = 0; i < V; i++) {
        for (int v : adj[i]) {
            if (map[i] > map[v]) return false;
        }
    }
    return true;
}

// Driver Code
int main() {
    int T;
    cin >> T;
    while (T--) {
        int N, E;
        cin >> E >> N;
        int u, v;

        vector<int> adj[N];

        for (int i = 0; i < E; i++) {
            cin >> u >> v;
            adj[u].push_back(v);
        }

        vector <int> res = topoSort(N, adj);

        cout << check(N, res, adj) << endl;
    }
}// } Driver Code Ends


// The Graph structure is as folows

/*  Function which sorts the graph vertices in topological form
*   N: number of vertices
*   adj[]: input graph
*/
void topological_sort(vector<bool> & visited, vector<int> adj[], int v, stack<int> & s) {
    visited[v] = true;
    for(auto it=adj[v].begin(); it != adj[v].end(); it++) {
        if(!visited[*it]) {
            topological_sort(visited,adj,*it,s);
        }
    }
    s.push(v);
}
vector<int> topoSort(int V, vector<int> adj[]) {
    // Your code here
    vector<bool> visited(V,false);
    stack<int> s;
    int i;
    for(i=0;i<V;i++) {
        if(!visited[i]) {
            topological_sort(visited,adj,i,s);
        }
    }
    vector<int> result;
    while(!s.empty()) {
        result.push_back(s.top());
        s.pop();
    }
    return result;
}
