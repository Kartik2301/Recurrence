//prims algorithm
#include <iostream>
#include<bits/stdc++.h>
#include<limits.h>
using namespace std;
#define INF INT_MAX
int V,E;
void addEdge(list<pair<int,int>> *adj, int initial, int dest, int weight){
    adj[initial].push_back(make_pair(dest,weight));
    //adj[dest].push_back(make_pair(initial,weight));
}
void prims(list<pair<int,int>> *adj){
    int src = 0;
    vector<int> key(V,INF);
    vector<int> parent(V,-1);
    vector<bool> inMST(V,false);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    pq.push(make_pair(0,src));
    key[src]=0;
    while(!pq.empty()){
        int u = pq.top().second;
        inMST[u] = true;
        pq.pop();
        
        for(auto it = adj[u].begin(); it != adj[u].end(); it++){
            int dest = (*it).first;
            int weight = (*it).second;
            if(inMST[dest] == false && key[dest] > weight){
                key[dest] = weight;
                parent[dest] = u;
                cout<<parent[dest]<<" -- "<<dest<<" == "<<weight<<endl;
                pq.push(make_pair(key[dest],dest));
            }
        }
    }
    //  for (int i = 1; i < V; ++i) {
    //     printf("%d - %d\n", parent[i], i);
    // }
}
int main() {
    cin>>V>>E;
    list<pair<int,int>> *adj = new list<pair<int,int>>[V];
    int i,ivertex,fvertex,weight;
    for(i=0;i<E;i++){
        cin>>ivertex>>fvertex>>weight;
        addEdge(adj,ivertex,fvertex,weight);
    }
    prims(adj);
}