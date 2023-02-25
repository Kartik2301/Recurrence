Solution 1 :- time Complexity O(n^2) and O(n) space (can be done in O(1) space)

approach is to start from the first interval and compare it with all other intervals for overlapping, 
if it overlaps with any other interval, then remove the other interval from the list and merge the other 
into the first interval. Repeat the same steps  for remaining intervals after first. This approach cannot be implemented in better than O(n^2) time.

Solution 2 :- time Complexity O(nlogn) and O(1) space

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> mergedIntervals;
        if(intervals.size() == 0) return intervals;
        sort(intervals.begin(), intervals.end());
        vector<int> tempInterval = intervals[0];
        for(auto it : intervals) {
            if(it[0] <= tempInterval[1]) {
                tempInterval[1] = max(tempInterval[1], it[1]);
            } else {
                mergedIntervals.push_back(tempInterval);
                tempInterval = it;
            }
        }
        mergedIntervals.push_back(tempInterval);
        return mergedIntervals;
    }
}; 