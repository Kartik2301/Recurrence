// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

bool utils(vector<bool> & visited, vector<bool> & recStack, int v, vector<int> adj[]) {
    visited[v] = true;
    recStack[v] = true;
    for(int i=0;i<adj[v].size();i++) {
        if(!visited[adj[v][i]]) {
            if(utils(visited,recStack,adj[v][i], adj)) return true;
        } else {
            if(recStack[adj[v][i]]) return true;
        }
    }
    recStack[v] = false;
    return false;
}
bool isCyclic(int V, vector<int> adj[])
{
    // Your code here
    int i;
    vector<bool> visited(V,false);
    vector<bool> recStack(V,false);
    for(i=0;i<V;i++) {
        if(!visited[i]) {
            if(utils(visited,recStack,i,adj)) return true;
        } 
    }
    return false;
}


bool utils(vector<int> g[], int v, vector<bool> & visited, int parent) {
    visited[v] = true;
    for(int i=0;i<g[v].size();i++) {
        if(!visited[g[v][i]]) {
            if(utils(g,g[v][i],visited,v)) {
                return true;
            }
        } else {
            if(g[v][i] != parent) {
                return true;
            }
        }
    }
    return false;
}
bool isCyclic(vector<int> g[], int V)
{
   // Your code here
   int i;
   vector<bool> visited(V,false);
   
   for(i=0;i<V;i++) {
       if(!visited[i]) {
           if(utils(g,i,visited,-1)) return true;
       }
   }
   return false;
}
