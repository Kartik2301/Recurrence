#include<iostream>
#include<bits/stdc++.h>
#include<limits.h>
using namespace std;
int V,E;
void addEdge(list< pair<int, int> > *adj, int initial, int dest, int weight){
    adj[initial].push_back(make_pair(dest,weight));
}
void Bellman_Ford(list< pair<int, int> > *adj, int start){
    int i,j;
    int dist[V];
    for(i=0;i<V;i++){
        dist[i] = INT_MAX;
    }
    dist[start] = 0;
    for(i=1;i<=V-1;i++){
        for(j=0;j<V;j++){
          for(auto it = adj[j].begin(); it != adj[j].end(); it++){
              int u = j;
              int v = (*it).first;
              int weight = (*it).second;
              if(dist[u]!=INT_MAX && dist[v]>dist[u]+weight){
                  dist[v]=dist[u]+weight;
              }
          }
        }
    }
        for(i=1;i<=V-1;i++){
        for(j=0;j<V;j++){
          for(auto it = adj[j].begin(); it != adj[j].end(); it++){
              int u = j;
              int v = (*it).first;
              int weight = (*it).second;
              if(dist[u]!=INT_MAX && dist[v]>dist[u]+weight){
                  return;
              }
          }
        }
    }
         for(j=0;j<V;j++){
             cout<<"0 -> "<<j<<"\t"<<dist[j]<<endl;
         }
}

int main(){
    cin>>V>>E;
    list< pair<int, int> > *adj = new list< pair<int, int>> [V];
    int i, ivertex, fvertex,weight;
    for(i=0;i<E;i++){
        cin>>ivertex>>fvertex>>weight;
        addEdge(adj,ivertex,fvertex,weight);
    }
    Bellman_Ford(adj, 0);
}///Bellman Ford, single source shortest parth algorithm
#include<iostream>
#include<bits/stdc++.h>
#include<limits.h>
#define V 4
using namespace std;
#define INF INT_MAX
void floyd_warshall(int graph[][V]){
    int dist[V][V];
    int i,j;
    for(i=0;i<V;i++){
        for(j=0;j<V;j++){
            dist[i][j] = graph[i][j];
        }
    }
    int k;
    for(k=0;k<V;k++){
        for(i=0;i<V;i++){
            for(j=0;j<V;j++){
                if(dist[i][k] != INF && dist[k][j] != INF &&dist[i][k] + dist[k][j] < dist[i][j]){
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    for(i=0;i<V;i++){
        for(j=0;j<V;j++){
            if(dist[i][j] == INF){
                cout<<"INF"<<" ";
            } else 
            cout<<dist[i][j]<<" ";
        }
        cout<<"\n";
    }
}
int main(){
    int graph[V][V] = { {0, 5, INF, 10},  
                        {INF, 0, 3, INF},  
                        {INF, INF, 0, 1},  
                        {INF, INF, INF, 0}  
                      };
                      
    floyd_warshall(graph);
}