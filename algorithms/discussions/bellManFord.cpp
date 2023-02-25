#include<iostream>
#include<bits/stdc++.h>
#include<limits.h>
using namespace std;
int v,e;
void addEdge(vector<pair<int,pair<int,int>>> & adj, int src, int dest, int weight) {
    adj.push_back({src, {dest, weight}});
}
int bellman_ford(vector<pair<int,pair<int,int>>> & adj, int src) {
    int dist[v];
    int i;
    for(i=0;i<v;i++) {
        dist[i] = INT_MAX;
    }
    dist[src] = 0;
    int j;
    for(i=0;i<v;i++) {
        for(j=0;j<adj.size();j++) {
            int u = adj[j].first;
            int v = adj[j].second.first;
            int weight = adj[j].second.second;
            if(dist[u] != INT_MAX && dist[v] > dist[u] + weight) {
                dist[v] = dist[u] + weight;
            }
        }
    }
    for(i=0;i<v;i++) {
        for(j=0;j<adj.size();j++) {
            int u = adj[j].first;
            int v = adj[j].second.first;
            int weight = adj[j].second.second;
            if(dist[u] != INT_MAX && dist[v] > dist[u] + weight) {
                return -1;
            }
        }
    }
    for(i=0;i<v;i++) {
        cout<<i<<" "<<dist[i]<<endl;
    }
    return 1;
}
int main() {
    v = 5;
    e = 8;
    vector<pair<int,pair<int,int>>> adj;
    addEdge(adj,0,1,-1);
    addEdge(adj,0,2,4);
    addEdge(adj,1,3,2);
    addEdge(adj,1,4,2);
    addEdge(adj,3,2,5);
    addEdge(adj,3,1,1);
    addEdge(adj,4,3,-3);
    addEdge(adj,1,2,3);
    if(bellman_ford(adj,0) ==  -1) {
        cout<<"No Path"<<endl;
    }
}
