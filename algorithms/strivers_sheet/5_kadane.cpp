Solution 1:
Brute force 
Time complexity O(n^3)
Space O(1)

Solution 2:
Brute force (better)
Time complexity O(n^2)
Space O(1)

Solution 3:
Kadane's algorithm

Time complexity O(n)
Space complexity O(1)

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int cur_max = nums[0];
        int fin_max = nums[0];
        int i;
        for(i=1;i<nums.size();i++) {
            cur_max = max(cur_max+nums[i], nums[i]);
            fin_max = max(cur_max, fin_max);
        }
        return fin_max;
    }
};