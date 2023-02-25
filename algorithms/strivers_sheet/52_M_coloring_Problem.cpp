Solution 1:- Naive. 
Naive Approach: Generate all possible configurations of colours. Since each node can be coloured using 
any of the m available colours, the total number of colour configurations possible are m^V. 
After generating a configuration of colour, check if the adjacent vertices have the same colour or not. 
If the conditions are met, print the combination and break the loop.
Algorithm: 

Create a recursive function that takes current index, number of vertices and output color array.
If the current index is equal to number of vertices. 
Check if the output color configuration is safe, i.e check if the adjacent 
vertices does not have same color. If the conditions are met, print the configuration and break.
Assign color to a vertex (1 to m).
For every assigned color recursively call the function with next index and number of vertices
If any recursive function returns true break the loop and return true.

Time Complexity: O(m^V). 
Space Complexity: O(V). 


Solution 2 :-
Backtracking

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends

int assignedAll(vector<int> & color, int V) {
    int i;
    for(i=1;i<=V;i++) {
        if(color[i] == -1) return i;
    }
    return -1;
}
bool isValid(int c, int v, vector<int> adj[], vector<int> & color) {
    for(auto it=adj[v].begin(); it != adj[v].end(); it++) {
        int v = (*it);
        if(color[v] == c) return false;
    }
    return true;
}
bool solve(vector<int> adj[], int m, int V, vector<int> & color) {
    int v = assignedAll(color,V);
    if(v == -1) return true;
    for(int j=1;j<=m;j++) {
        if(isValid(j,v,adj,color)) {
            color[v] = j;
            if(solve(adj,m,V,color)) return true;
            color[v] = -1;
        }
    }
    return false;
}
bool graphColoring(bool graph[101][101], int m, int V) {
    vector<int> adj[V+1];
    int i,j;
    for(i=0;i<V;i++) {
        for(j=0;j<V;j++) {
            if(graph[i][j] != 0) {
                adj[i+1].push_back(j+1);
            }
        }
    }
    vector<int> color(V+1,-1);
    return solve(adj,m,V,color);
}

Time Complexity: O(m^V). 
There are total O(m^V) combination of colors. So time complexity is O(m^V). 
The upperbound time complexity remains the same but the average time taken will be less.
Space Complexity: O(V). 
