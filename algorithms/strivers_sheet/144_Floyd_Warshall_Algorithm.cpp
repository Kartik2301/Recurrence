#include <iostream>
using namespace std;
# define INF 1e7
int main() {
	//code
	int test;
	cin>>test;
	while(test--) {
	    int n;
	    cin>>n;
	    int i,j;
	    int graph[n][n];
	    for(i=0;i<n;i++) {
	        for(j=0;j<n;j++) {
	            cin>>graph[i][j];
	        }
	    }
	    for(int k=0;k<n;k++) {
	        for(i=0;i<n;i++) {
	            for(j=0;j<n;j++) {
	                if(graph[i][k] + graph[k][j] < graph[i][j]) {
	                    graph[i][j] = graph[i][k] + graph[k][j];
	                }
	            }
	        }
	    }
	    for(i=0;i<n;i++) {
	        for(j=0;j<n;j++) {
	            if(graph[i][j] == INF) {
	                cout<<"INF"<<" ";
	                continue;
	            }
	            cout<<graph[i][j]<<" ";
	        }
	        cout<<"\n";
	    }
	}
	return 0;
}