#include<iostream>
#include<bits/stdc++.h>
#include<limits.h>
using namespace std;
int V,E;
void addEdge(vector<int> adj[], vector<int> tra[], int initial, int dest){
    adj[initial].push_back(dest);
    tra[dest].push_back(initial);
}

void fillOrder(vector<int> adj[], bool visited[], stack<int> &Stack, int vertex){
    visited[vertex] = true;
    for(auto it = adj[vertex].begin();it != adj[vertex].end(); it++){
        if(!visited[*it]){
            fillOrder(adj,visited,Stack,*it);
        }
    }
    Stack.push(vertex);
}

void DFS(vector<int> adj[], bool visited[], int v){
    visited[v] = true;
    cout<<v<<" ";
    for(auto it = adj[v].begin(); it != adj[v].end(); it++){
        if(!visited[*it]){
            DFS(adj,visited,*it);
        }
    }
}

int main(){
    cin>>V>>E;
    vector<int> adj[V];
    vector<int> tra[V];
    int i, ivertex, fvertex,weight;
    for(i=0;i<E;i++){
        cin>>ivertex>>fvertex;
        addEdge(adj,tra,ivertex,fvertex);
    }
    bool visited[V];
    for(i=0;i<V;i++){
        visited[i] = false;
    }
    stack<int> Stack;
    for(i=0;i<V;i++){
        if(!visited[i]){
            fillOrder(adj,visited,Stack,i);
        }
    }
    for(i=0;i<V;i++){
        visited[i] = false;
    }
    while(!Stack.empty()){
        int v = Stack.top();
        Stack.pop();
        if(!visited[v]){
            DFS(tra,visited,v);
            cout<<"\n";
        }
    }
}