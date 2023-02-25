Minimum Number of Platforms Required for a Railway/Bus Station
Given arrival and departure times of all trains that reach a railway station, 
the task is to find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop.

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.


Given N lecture timings, with their start time and end time (both inclusive), 
the task is to find the minimum number of halls required to hold all the classes such that a single hall 
can be used for only one lecture at a given time. Note that the maximum end time can be 105.


Solution 1 :-

Line sweep algorithm

#include<bits/stdc++.h>
using namespace std;
int main() {
    int n;
    cin>>n;
    vector<pair<int,int>> vec;
    int i;
    for(i=0;i<n;i++) {
        int a,b;
        cin>>a>>b;
        vec.push_back({a,1});
        vec.push_back({b,0});
    }
    sort(vec.begin(), vec.end());
    int count = 0;
    int max_ = 0;
    for(i=0;i<vec.size();i++) {
        if(vec[i].second == 1) {
            count++;
        } else if(vec[i].second == 0) {
            count--;
        }
        max_ = max(max_, count);
    }
    cout<<max_<<endl;
}

Time complexity :- O(nlogn)
Space complexity :- O(n)

The following snippet could be added so that arrivals are served first

bool sortByVal(const pair<int,int> & a, const pair<int,int> & b) {
    if(a.first == b.first) return a.second > b.second;
    return a.first < b.first;
}

1 -> arrival
0 -> departure


Solution 2 :- 

Prefix sum array, to keep track of every moment


int findPlatform(int arr[], int dep[], int n) {
    // Your code here
    int prefixSum[2361];
    memset(prefixSum,0,sizeof(prefixSum));
    int i;
    for(i=0;i<n;i++) {
        prefixSum[arr[i]]++;
        prefixSum[dep[i]+1]--;
    }
    int ans = prefixSum[0];
    for(i=1;i<=2360;i++) {
        prefixSum[i] += prefixSum[i-1];
        ans = max(ans, prefixSum[i]);
    }
    return ans;
}

Time complexity :- O(n)
Space complexity :- O(n)


Solution 3 :-

Merge the 2 arrays, rather than creating a new array and sorting it.

Time complexity :- O(nlogn)
Space complexity :- O(1)

int findPlatform(int arr[], int dep[], int n)
{
    // Your code here
    sort(arr,arr+n);
    sort(dep,dep+n);
    int i=1;
    int j=0;
    int count = 1;
    int result = 1;
    while(i < n && j < n) {
        if(arr[i] <= dep[j]) {
            count++;
            i++;
        } else {
            count--;
            j++;
        }
        result = max(result,count);
    }
    return result;
}

# based on what is happening at any particular instant, arrival or departure

Solution 4 :-

Brute force Solution
Approach: The idea is to take every interval one by one and find the number of 
intervals that overlap with it. Keep track of the maximum number of intervals 
that overlap with an interval. Finally, return the maximum value.

