#include<bits/stdc++.h>
using namespace std;
int V = 9;
void addEdge(vector<pair<int,int>> adj[], int src, int dest, int weight) {
	adj[src].push_back({dest,weight});
	adj[dest].push_back({src,weight});
}
void primsMST(vector<pair<int,int>> adj[]) {
	priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
	int src = 0;
	pq.push({0,src});
	vector<int> key(V,INT_MAX);
	key[src] = 0;
	vector<bool> inMst(V, false);
	vector<int> parent(V,-1);
	while(!pq.empty()) {
		int s = pq.top().second;
		pq.pop();
		inMst[s] = true;
		for(auto it=adj[s].begin(); it != adj[s].end(); it++) {
			int v = (*it).first;
			int weight = (*it).second;
			if(inMst[v] == false && key[v] > weight) {
				key[v] = weight;
				pq.push({key[v],v});
				parent[v] = s;
			}
		}
	}
	for(int i=1;i<V;i++) {
		cout<<parent[i]<<" "<<i<<endl;
	}
}
int main() {
	V = 9;
	vector<pair<int,int>> adj[V];
	addEdge(adj, 0, 1, 4); 
    addEdge(adj, 0, 7, 8); 
    addEdge(adj, 1, 2, 8); 
    addEdge(adj, 1, 7, 11); 
    addEdge(adj, 2, 3, 7); 
    addEdge(adj, 2, 8, 2); 
    addEdge(adj, 2, 5, 4); 
    addEdge(adj, 3, 4, 9); 
    addEdge(adj, 3, 5, 14); 
    addEdge(adj, 4, 5, 10); 
    addEdge(adj, 5, 6, 2); 
    addEdge(adj, 6, 7, 1); 
    addEdge(adj, 6, 8, 6); 
    addEdge(adj, 7, 8, 7); 
    primsMST(adj);
}