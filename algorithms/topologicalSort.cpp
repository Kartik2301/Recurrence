#include<iostream>
#include<limits.h>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
int V,E;
void addEdge(vector<int> adj[], int initial, int dest){
    adj[initial].push_back(dest);
}

void topologicalSorting(vector<int> adj[], bool visited[], int vertex, stack<int> &Stack){
    visited[vertex] = true;
    for(auto it = adj[vertex].begin(); it != adj[vertex].end(); it++){
        if(!visited[*it]){
            topologicalSorting(adj,visited,*it, Stack);
        }
    }
    Stack.push(vertex);
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
 
    bool visited[V];
    for(i=0;i<V;i++){
        visited[i] = false;
    }
    stack<int> Stack;
    for(i=0;i<V;i++){
        if(visited[i] == false){
            topologicalSorting(adj,visited,i,Stack);
        }
    }
    while(!Stack.empty()){
        cout<<Stack.top()<<" ";
        Stack.pop();
    }
}#include<iostream>
#include<limits.h>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
int V,E;
void addEdge(vector<int> adj[], int initial, int dest){
    adj[initial].push_back(dest);
}

void topologicalSorting(vector<int> adj[], bool visited[], int vertex, stack<int> &Stack){
    visited[vertex] = true;
    for(auto it = adj[vertex].begin(); it != adj[vertex].end(); it++){
        if(!visited[*it]){
            topologicalSorting(adj,visited,*it, Stack);
        }
    }
    Stack.push(vertex);
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
 
    bool visited[V];
    for(i=0;i<V;i++){
        visited[i] = false;
    }
    stack<int> Stack;
    for(i=0;i<V;i++){
        if(visited[i] == false){
            topologicalSorting(adj,visited,i,Stack);
        }
    }
    while(!Stack.empty()){
        cout<<Stack.top()<<" ";
        Stack.pop();
    }
}