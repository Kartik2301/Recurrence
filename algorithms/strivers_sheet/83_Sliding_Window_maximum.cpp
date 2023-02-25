Solution 1 :-
Time complexity :- O(n)
Space complexity :- O(n)
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> Q;
        int i;
        for(i=0;i<k;i++) {
            while(!Q.empty() && nums[i] > nums[Q.back()]) {
                Q.pop_back();
            }
            Q.push_back(i);
        }
        vector<int> result;
        for(i=k;i<nums.size();i++) {
            result.push_back(nums[Q.front()]);
            while(!Q.empty() && Q.front() <= i-k) Q.pop_front();
            while(!Q.empty() && nums[i] > nums[Q.back()]) Q.pop_back();
            Q.push_back(i);
        }
        result.push_back(nums[Q.front()]);
        return result;
    }
};

Solution 2 :- Brute force based
Time complexity :- O(n*k)
Space complexity :- O(1)