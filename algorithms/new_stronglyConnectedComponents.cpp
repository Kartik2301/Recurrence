#include<bits/stdc++.h>
using namespace std;
int v,e;
void addEdge(vector<int> adj[], vector<int> transpose[], int src, int dest) {
    adj[src].push_back(dest);
    transpose[dest].push_back(src);
}
void dfs(vector<int> adj[],  vector<bool> & visited, stack<int> & Stack, int v) {
    visited[v] = true;
    for(auto it=adj[v].begin(); it != adj[v].end(); it++) {
        if(!visited[*it]) {
            dfs(adj,visited,Stack,*it);
        }
    }
    Stack.push(v);
}
void dfs_util(vector<int> adj[],  vector<bool> & visited, int v) {
    visited[v] = true;
    cout<<v<<" "; 
    for(auto it=adj[v].begin(); it != adj[v].end(); it++) {
        if(!visited[*it]) {
            dfs(adj,visited,Stack,*it);
        }
    }
}
void printSCC(vector<int> adj[], vector<int> transpose[]) {
    vector<bool> visited(v,false);
    stack<int> Stack;
    for (int i = 0; i < v; ++i) {
        if(!visited[i]) {
            dfs(adj,visited,stack,i);
        }
    }
    fill(visited.begin(), visited.end(), false);
    while(!Stack.empty()) {
        int src = Stack.top();
        Stack.pop();
        if(!visited[src]) {
            dfs_util(transpose,visited,src);
            cout<<"\n"<<endl;
        }
    }
}
int main() {
    v = 5;
    e = 5;
    vector<int> adj[v];
    vector<int> transpose[v];
    addEdge(adj,transpose,1, 0); 
    addEdge(adj,transpose,0, 2); 
    addEdge(adj,transpose,2, 1); 
    addEdge(adj,transpose, 3); 
    addEdge(adj,transpose,3, 4); 
    printSCC(adj,transpose);
}