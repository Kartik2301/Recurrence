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

bool doBFS(vector<int> adj[], int start, int dest, int dist[], int pred[]){
    bool visited[V];
    list<int> queue;
    for(int i=0;i<V;i++){
        visited[i] = false;
        dist[i] = INT_MAX;
        pred[i] = -1;
    }
    dist[start] = 0;
    visited[start] = true;
    queue.push_back(start);
    while(!queue.empty()){
        int s = queue.front();
        queue.pop_front();
        for(auto it = adj[s].begin(); it != adj[s].end(); it++){
            if(!visited[*it]){
                visited[*it] = true;
                queue.push_back(*it);
                    pred[*it]  = s;
                    if(dist[*it] > dist[s] + 1){
                    	dist[*it] = dist[s] + 1;
                    }
                    if(*it == dest){
                        return true;
                    }
            }
        }
        
    }
    return false;
}

void shortestPath(vector<int> adj[], int start, int end){
    int dist[V], pred[V];
    if(start ==0 && end == 0){
        cout<<"shortest distance: 0"<<"\n";
        cout<<"path:"<<"\n";
        cout<<"0";
    } else {
    if(!doBFS(adj,start,end,dist,pred)){
        cout<<"NO PATH EXISTS"<<endl;
    } else {
        cout<<"shortest distance: "<<dist[end]<<endl;
        vector<int>path;
        cout<<"path:"<<endl;
        for(int i = 0; i<sizeof(pred)/(sizeof(pred[0])); i++){
          if(pred[i] == -1){
              continue;
          } else {
              if(find(path.begin(), path.end(), pred[i]) != path.end()){
                  continue;
              } else {
                  cout<<pred[i]<<" ";
                  path.push_back(pred[i]);
              }
          }
        }
        cout<<end<<" ";
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
    for(int v = 0; v<V;v++){
        shortestPath(adj,start,v);
        cout<<"\n";
    }
    
}