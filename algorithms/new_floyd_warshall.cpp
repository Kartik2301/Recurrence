#include <iostream>
using namespace std;
# define INF 1e7
int main() {
	int test;
	cin>>test;
	while(test--) {
	    int V;
	    cin>>V;
	    int graph[V][V];
	    int dist[V][V];
	    int i,j;
	    for(i=0;i<V;i++) {
	        for(j=0;j<V;j++) {
	            cin>>graph[i][j];
	        }
	    }
	    for(i=0;i<V;i++) {
	        for(j=0;j<V;j++) {
	            dist[i][j] = graph[i][j];
	        }
	    }
	    int k;
	    for(k=0;k<V;k++) {
	        for(i=0;i<V;i++) {
	            for(j=0;j<V;j++) {
	                if(dist[i][j] > dist[i][k] + dist[k][j]) {
	                    dist[i][j] = dist[i][k] + dist[k][j];
	                }
	            }
	        }
	    }
	    for(i=0;i<V;i++) {
	        for(j=0;j<V;j++) {
	            if(dist[i][j] == INF){
	                cout<<"INF"<<" ";
	            } else
	            cout<<dist[i][j]<<" ";
	        }
	        cout<<"\n";
	    }
	}
	return 0;
}