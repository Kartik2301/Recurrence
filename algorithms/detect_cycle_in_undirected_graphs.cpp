// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


/* This function is used to detect a cycle in undirected graph

*  g[]: array of vectors to represent graph
*  V: number of vertices
*/
bool containsCycle(int v, vector<int> adj[],vector<bool> & visited, int parent) {
    visited[v] = true;
    for(auto it = adj[v].begin(); it != adj[v].end() ; it++) {
        if (!visited[*it]) {
            if(containsCycle(*it,adj,visited,v))  { 
              return true; 
            }  
        }
        else {
            if(*it != parent) return true;
        }
    }
    return false; 
}
bool isCyclic(vector<int> adj[], int V) {

   // Your code here
   vector<bool> visited(V,false);
   int i;
   for(i=0;i<V;i++) {
       if(!visited[i]) {
           if(containsCycle(i,adj, visited, -1)) return true;
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