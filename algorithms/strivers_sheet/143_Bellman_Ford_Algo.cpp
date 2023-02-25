class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        int i;
        vector<int> dist(N+1,INT_MAX);
        dist[0]  = 0;
        dist[K] = 0;
        for(i=1;i<=N-1;i++) {
            for(int j=0;j<times.size();j++) {
                int src = times[j][0];
                int dest = times[j][1];
                int w = times[j][2];
                if(dist[src] != INT_MAX && dist[dest] > dist[src] + w) {
                    dist[dest] = dist[src] + w;
                }
            }
        }
        int val = -1;
        return (val = *max_element(dist.begin(),dist.end())) == INT_MAX ? -1 : val;
    }
};