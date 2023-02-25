// { Driver Code Starts
#include<bits/stdc++.h>

using namespace std;

 // } Driver Code Ends





/*  Function to find the number of strongly connected components
*   using Kosaraju's algorithm
*   V: number of vertices
*   adj[]: array of vectors to represent graph
*/
void dfs1(vector<int> adj[], int v, vector<bool> & visited, stack<int> & Stack) {
    visited[v] = true;
    for(auto it=adj[v].begin(); it != adj[v].end(); it++) {
        if(!visited[*it]) {
            dfs1(adj,*it,visited,Stack);
        }
    }
    Stack.push(v);
}
void dfs2(vector<int> adj[], int v, vector<bool> & visited) {
    visited[v] = true;
    for(auto it=adj[v].begin(); it != adj[v].end(); it++) {
        if(!visited[*it]) {
            dfs2(adj,*it,visited);
        }
    }
}
int kosaraju(int V, vector<int> adj[])
{
    // Your code here
    vector<int> transpose[V];
    int i,j;
    for(i=0;i<V;i++) {
        for(auto it = adj[i].begin(); it != adj[i].end(); it++) {
            int v = (*it);
            transpose[v].push_back(i);
        }
    }
    stack<int> Stack;
    vector<bool> visited(V,false);
    for(i=0;i<V;i++) {
        if(!visited[i]) {
            dfs1(adj,i,visited, Stack);
        }
    }
    int count = 0;
    fill(visited.begin(),visited.end(),false);
    while(!Stack.empty()) {
        int v = Stack.top();
        Stack.pop();
        if(!visited[v]) {
            count++;
            dfs2(transpose,v,visited);
        }
    }
    return count;
}


// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int a, b;
        cin >> a >> b;
        int m, n;
        vector<int> adj[a];
        for (int i = 0; i < b; i++) {
            cin >> m >> n;
            adj[m].push_back(n);
        }
        cout << kosaraju(a, adj) << endl;
    }
    return 0;
}
  // } Driver Code Ends