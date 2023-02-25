// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


/* This function is used to detect a cycle in undirected graph

*  g[]: array of vectors to represent graph
*  V: number of vertices
*/
bool bfs(vector<int> adj[], int V, int src, vector<bool> & visited) {
    queue<int> q;
    vector<int> parent(V,-1);
    q.push(src);
    visited[src] = true;
    while(!q.empty()) {
        int s = q.front();
        q.pop();
        for(auto it=adj[s].begin(); it != adj[s].end(); it++) {
            if(!visited[*it]) {
                visited[*it] = true;
                parent[*it] = s;
                q.push(*it);
            } else if(parent[s] != *it) return true;
        }
    }
    return false;
}
bool isCyclic(vector<int> adj[], int V) {

    vector<bool> visited(V,false);
    int i;
    for(i=0;i<V;i++) {
        if(!visited[i]) {
            if(bfs(adj,V,i,visited)) return true;
        }
    }
    return false;
}

// { Driver Code Starts.


int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        int V, E;
        cin>>V>>E;
        
        // array of vectors to represent graph
        vector<int> adj[V];
        
        int u, v;
        for(int i=0;i<E;i++)
        {
            cin>>u>>v;
            
            // adding edge to the graph
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        cout << isCyclic(adj, V)<<endl;

    }
}
  // } Driver Code Ends