int v,e;
void addEdge(int src, int dest, vector<int> adj[]) {
    adj[src].push_back(dest);
}
void topologicalSortUtil(vector<int> adj[], int v, stack<int> & st, vector<bool> & visited) {
    visited[v] = true;
    for(auto it=adj[v].begin(); it != adj[v].end(); it++) {
        if(!visited[*it]) {
            topologicalSortUtil(adj,*it,st,visited);
        } 
    }
    st.push(v);
}
void topologicalSort(vector<int> adj[]) {
    vector<bool> visited(v,false);
    stack<int> st;
    for(int i=0;i<v;i++) {
        if(!visited[i]) {
            topologicalSortUtil(adj,i,st,visited);
        }
    }
    while(!st.empty()) {
        cout<<st.top()<<" ";
        st.pop();
    }
    cout<<"\n";
}
int main() {
    v = 6;
    e = 6;
    vector<int> adj[v];
    int i;
    addEdge(5, 2,adj); 
    addEdge(5, 0,adj); 
    addEdge(4, 0,adj); 
    addEdge(4, 1,adj); 
    addEdge(2, 3,adj); 
    addEdge(3, 1,adj);
    topologicalSort(adj);
}