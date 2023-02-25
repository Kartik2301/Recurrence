// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
int spanningTree(int V, int E, vector<vector<int>> &graph);
// Driver code

int main() {
    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;
        vector<vector<int> > graph(V, vector<int>(V, 0));
        int i=0;
        while (i++<E) {
            int u, v, w;
            cin >> u >> v >> w;
            u--, v--;
            graph[u][v] = w;
            graph[v][u] = w;
        }

        cout << spanningTree(V, E, graph) << endl;
    }
    return 0;
}
// } Driver Code Ends


// Function to construct and print MST for
// a graph represented using adjacency
// matrix representation, with V vertices.
// graph[i][j] = weight if edge exits else 0

int spanningTree(int V, int E, vector<vector<int>> &graph) {
    // code here
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    vector<pair<int,int>> adj[V+1];
    int i;
    for(i=0;i<graph.size();i++) {
        for(int j=0;j<graph[0].size();j++) {
            if(graph[i][j] != 0) {
                adj[i+1].push_back({j+1, graph[i][j]});
            }
        }
    }
    pq.push({0,1});
    
    vector<int> parent(V+1,-1);
    vector<bool> visited(V+1,false);
    
    vector<int> dist(V+1,INT_MAX);
    dist[1]=0;
    while(!pq.empty()) {
        int s = pq.top().second;
        pq.pop();
        visited[s] = true;
        for(auto it=adj[s].begin(); it != adj[s].end(); it++) {
            int v = (*it).first;
            int key = (*it).second;
            
            if(!visited[v] && dist[v] > key) {
                dist[v] = key;
                parent[v] = s;
                
                pq.push({dist[v],v});
            }
        }
    }
    int weight = 0;
    for(i=2;i<=V;i++) {
        weight += graph[parent[i]-1][i-1];
    }
    return weight;
}