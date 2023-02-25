class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        int i,j;
        vector<pair<int,int>> adj[N+1];
        for(i=0;i<times.size();i++) {
            adj[times[i][0]].push_back({times[i][1], times[i][2]});
        }
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        vector<int> dist(N+1,INT_MAX);
        dist[K] = 0;
        dist[0] = 0;
        pq.push({0,K});
        while(!pq.empty()) {
            int s = pq.top().second;
            pq.pop();
            for(auto it=adj[s].begin();it != adj[s].end(); it++) {
                int v = (*it).first;
                int weight = (*it).second;
                if(dist[v] > dist[s] + weight) {
                    dist[v] = dist[s] + weight;
                    pq.push({dist[v],v});
                }
            }
        }
        int val = -1;
        return (val = *max_element(dist.begin(),dist.end())) == INT_MAX ? -1 : val;
    }
};