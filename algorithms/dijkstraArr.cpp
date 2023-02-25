#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int V;
unordered_map<int,string> vertices;
unordered_map<string,string> edge_names;
string input_src;
int computeNearest(unordered_map<string,int> & dist,  unordered_map<string,bool> & visited) { 
    int min = INT_MAX, index = 0; 
    for (int v = 0; v < V; v++) {
        if (!visited[vertices[v]] && dist[vertices[v]] <= min) {
            min = dist[vertices[v]];
            index = v;
        }
    }
    return index; 
} 
void printUtil(unordered_map<string,string> & parent, string j,vector<string> & path) {
    if (parent[j].compare("-1") == 0) {
        return;
    }
    printUtil(parent, parent[j],path);
    path.push_back(j);
}

void print(unordered_map<string,int> & dist, unordered_map<string,string> & parent) {
    int src = 0;
    for (int i = 0; i < V; i++) {
        vector<string> path;
        path.push_back(input_src);
        printUtil(parent, vertices[i],path);
        cout<<input_src<<"->"<<vertices[i]<<" Distance -> "<<dist[vertices[i]]<<" Path:- ";
        if(dist[vertices[i]] == INT_MAX) {
            cout<<"NIL"<<endl;
            continue;
        }
        for(int j=0;j<path.size();j++) {
            if(j > 0) {
                cout<<edge_names[path[j-1] + " " + path[j]]<<" ";
            }
            cout<<path[j]<<" ";
        }
        cout<<"\n";
    }
}
int main() {
	int test;
	cin>>test;
	while(test--) {
		int v,e;
		cin>>v>>e;
		V = v;
		vertices.clear();
		edge_names.clear();
		unordered_map<string,vector<pair<string,int>>> adj;
		int i;
		unordered_map<string,int> dist;
		unordered_map<string,string> parent;
		unordered_map<string,bool> visited;
		for(i=0;i<v;i++) {
			string ver;
			cin>>ver;
			dist[ver] = INT_MAX;
			parent[ver] = "-1";
			visited[ver] = false;
			vertices[i] = ver;
		}
		for(i=0;i<e;i++) {
			string src,dest,name;
			int weight;
			cin>>src>>name>>dest>>weight;
			edge_names[src + " " + dest] = name;
	        edge_names[dest + " " + src] = name;
			adj[src].push_back({dest,weight});
		}
		cin>>input_src;
		dist[input_src] = 0;
		int count;
		for(count = 0; count < V; count++) {
		    int s = computeNearest(dist, visited); 
            visited[vertices[s]] = true; 
            for(i=0;i<adj[vertices[s]].size();i++) {
                string v = adj[vertices[s]][i].first;
				int weight = adj[vertices[s]][i].second;
				if((dist[v] > dist[vertices[s]] + weight) && !visited[v]) {
				    dist[v] = dist[vertices[s]] + weight;
				    parent[v] = vertices[s];
				}
            }
		}
		print(dist, parent);
	}
}