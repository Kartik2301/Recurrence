#include<bits/stdc++.h>
using namespace std;
int v,e;
int main() {
	int test;
	cin>>test;
	while(test--) {
		cin>>v>>e; 
		vector<int> adj[v];
		int i;
		for(i=0;i<e;i++) {
			int src,dest;
			cin>>src>>dest;
			adj[src].push_back(dest);
		}
		queue<int> q;
		vector<bool> visited(v, false);
		vector<int> dist(v,INT_MAX);
		q.push(0);
		dist[0] = 0;
		visited[0] = true;
		while(!q.empty()) {
			int s = q.front();
			q.pop();
			for(auto it=adj[s].begin(); it != adj[s].end(); it++) {
				if(!visited[*it]) {
					if(dist[*it] > dist[s] + 1) {
						dist[*it] = dist[s]+1;
						q.push(*it);
						visited[*it] = true;
					}
				}
			}
		}
		for(i=0;i<v;i++) {
			if(dist[i] == INT_MAX) {
				cout<<-1<<endl;
			} else {
				cout<<dist[i]<<endl;
			}
		}
	}
}