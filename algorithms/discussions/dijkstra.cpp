#include<iostream>
#include<bits/stdc++.h>
#include<limits.h>
using namespace std;
int v,e;
void addEdge(vector<pair<int,int>> adj [], int src, int dest, int weight) {
    adj[src].push_back({dest, weight});
}

int minDist(vector<int> dist, vector<bool> & visited){
    int min_dist = INT_MAX;
    int index = 0;
    for(int i=0;i<v;i++) {
        if(!visited[i] && dist[i] <= min_dist) {
            index = i;
            min_dist = dist[i];
        }
    }
    return index;
}

int dijkstra(vector<pair<int,int>> adj [], int src) {
    vector<int> dist(v,INT_MAX);
    vector<bool> visited(v, false);
    dist[src] = 0;
    for(int count = 0; count < v; count ++) {
        int u = minDist(dist,visited);
        visited[u] = true;
        for(auto it = adj[u].begin(); it != adj[u].end(); it++) {
            int v = (*it).first;
            int weight = (*it).second;
            if(dist[v] > dist[u] + weight) {
                dist[v] = dist[u] + weight;
            }
        }
    }
    for(int i=0;i<v;i++) {
        cout<<i<<" "<<dist[i]<<endl;
    }
    return 1;
}

int main() {
    v = 5;
    e = 8;
    vector<pair<int,int>> adj [v];
    addEdge(adj,0,1,1);
    addEdge(adj,0,2,4);
    addEdge(adj,1,3,2);
    addEdge(adj,1,4,2);
    addEdge(adj,3,2,5);
    addEdge(adj,3,1,1);
    addEdge(adj,4,3,3);
    addEdge(adj,1,2,3);
    if(dijkstra(adj,0) ==  -1) {
        cout<<"No Path"<<endl;
    }
}
