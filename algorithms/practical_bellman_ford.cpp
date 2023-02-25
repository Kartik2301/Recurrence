class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        int i,j;
        int e = times.size();
        vector<int> dist(N+1,INT_MAX);
        dist[K] = 0;
        dist[0] = 0;
        for(i=1;i<=N-1;i++) {
            for(j=0;j<e;j++) {
                int src = times[j][0];
                int dest = times[j][1];
                int weight = times[j][2];
                if(dist[src] != INT_MAX && dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }
        for(j=0;j<e;j++) {
            int src = times[j][0];
            int dest = times[j][1];
            int weight = times[j][2];
            if(dist[src] != INT_MAX && dist[dest] > dist[src] + weight) {
                return -1;
            }
        }
        int val = *max_element(dist.begin(), dist.end());
        return val == INT_MAX ? -1:val;
    }
};