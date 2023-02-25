#include<iostream>
#include<limits.h>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
int V,E;
void addEdge(vector<int> adj[], int initial, int dest){
    adj[initial].push_back(dest);
    adj[dest].push_back(initial);
}

void doDFS(vector<int> adj[], int start, bool visited[]){
    visited[start] = true;
    cout<<start<<" ";
    for(auto it = adj[start].begin(); it != adj[start].end(); it++){
        if(!visited[*it]){
            doDFS(adj,*it,visited);
        }
    }
}

int main(){
    int ivertex,fvertex;
    int i;
    cin>>V>>E;
     vector<int> adj[V];
    for(i=0;i<E;i++){
        cin>>ivertex>>fvertex;
        addEdge(adj,ivertex,fvertex);
    }
    int start;
    cin>>start;
    bool visited[V];
    for(i=0;i<V;i++){
        visited[i] = false;
    }
    doDFS(adj,start,visited);
    
}