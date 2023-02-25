#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void Graph::printPath(vector<int> & s_parent, vector<int> & t_parent, int s, int d, int intersectNode) { 
    vector<int> path; 
    path.push_back(intersectNode); 
    int i = intersectNode; 
    while (i != s) { 
        path.push_back(s_parent[i]); 
        i = s_parent[i]; 
    } 
    reverse(path.begin(), path.end()); 
    i = intersectNode; 
    while(i != d) { 
        path.push_back(d_parent[i]); 
        i = d_parent[i]; 
    } 
  
    vector<int>::iterator it; 
    cout<<"*****Path*****\n"; 
    for(it = path.begin();it != path.end();it++) 
        cout<<*it<<" "; 
    cout<<"\n"; 
}
void do_bfs(queue<int> & q, vector<bool> & visited, vector<int> & parent, vector<int> adj[]) {
	int s = q.front();
	q.pop();
	for(auto it = adj[s].begin(); it != adj[s].end(); it++) {
		int v = (*it);
		if(!visited[v]) {
			visited[v] = true;
			parent[v] = s;
			q.push(v);
		}
	}
}
int main() {
	int v,e;
	cin>>v>>e;
	vector<int> adj[v];
	int i;
	for(i=0;i<e;i++) {
		int src,dest;
		cin>>src>>dest;
		adj[src].push_back(dest);
		adj[dest].push_back(src);
	}
	int s,d;
	cin>>s>>d;
	int point = 0;
	vector<bool> s_visited(v, false);
	vector<bool> d_visited(v, false);
	vector<int> s_parent(v, -1);
	vector<int> d_parent(v, -1);
	queue<int> s_q;
	queue<int> d_q;
	s_q.push(s);
	d_q.push(d);
	s_visited[s] = true;
	d_visited[d] = true;
	bool flag = false;
	while(!s_q.empty() && !d_q.empty()) {
		do_bfs(s_q,s_visited,s_parent,adj);
		do_bfs(d_q,d_visited,d_parent,adj);
		flag = false;
		for(int i=0;i<v;i++) {
			if(s_visited[i] && d_visited[i]) {
				point = i;
				flag = true;
				break;
			}
		}
		if(flag) break;
	}
	if(flag) {
		//there is a solution
		printPath(s_parent,d_parent,s,d,point);
	} else {
		cout<<"NIL"<<endl;
	}
}