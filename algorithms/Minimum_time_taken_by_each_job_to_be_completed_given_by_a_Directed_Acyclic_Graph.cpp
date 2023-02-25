int v,e;
vector<int> inDegree;
void addEdge(vector<int> adj[], int src, int dest) {
    adj[src].push_back(dest);
    inDegree[dest]++;
}
int main() {
    v = 10;
    e = 13;
    inDegree.resize(v+1);
    fill(inDegree.begin(), inDegree.end(), 0);
    vector<int> adj[v+1];
    addEdge(adj,1, 3);
    addEdge(adj,1, 4);
    addEdge(adj,1, 5);
    addEdge(adj,2, 3);
    addEdge(adj,2, 8);
    addEdge(adj,2, 9);
    addEdge(adj,3, 6);
    addEdge(adj,4, 6);
    addEdge(adj,4, 8);
    addEdge(adj,5, 8);
    addEdge(adj,6, 7);
    addEdge(adj,7, 8);
    addEdge(adj,8, 10);
    queue<int> q;
    vector<int> job(v+1, 0);
    for(int i=1;i<=v;i++) {
        if(inDegree[i] == 0) {
            q.push(i);
            job[i] = 1;
        }
    }
    while(!q.empty()) {
        int s = q.front();
        q.pop();
        for(auto it=adj[s].begin(); it != adj[s].end(); it++) {
            inDegree[*it]--;
            if(job[*it] < job[s]+1) {
                job[*it] = job[s]+1;
            }
            if(inDegree[*it] == 0) {
                q.push(*it);
            }
        }
    }
    for (int i = 1; i <= v; i++)
        cout << job[i] << " ";
    cout << "\n";
}