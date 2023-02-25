//Floyd Warshall
///Bellman Ford, single source shortest parth algorithm
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