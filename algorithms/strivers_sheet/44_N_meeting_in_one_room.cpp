Solution 1 :- Use greedy approach by sorting with ending time

Time Complexity: O(N log(N)) 
Space Complexity :- O(n)

bool sortByVal(const pair<int,pair<int,int>> & a, const pair<int,pair<int,int>> & b) {
    if(a.second.first == b.second.first) return a.second.second < b.second.second;
    return a.second.first < b.second.first;
}
void maxMeetings(int start[], int end[], int n) {
    // Your code here
    vector<pair<int,pair<int,int>>> vec;
    int i;
    for(i=0;i<n;i++) {
        vec.push_back({start[i], {end[i],i}});
    }
    sort(vec.begin(), vec.end(), sortByVal);
    cout<<1+vec[0].second.second<<" ";
    int last = vec[0].second.first;
    for(i=1;i<n;i++){
        if(vec[i].first > last) {
            cout<<vec[i].second.second+1<<" ";
            last = vec[i].second.first;
        }
    }
}

Solution 2 :-

Brute force based solutions

Time Complexity :- O(n^2)
Space Complexity :- O(1)