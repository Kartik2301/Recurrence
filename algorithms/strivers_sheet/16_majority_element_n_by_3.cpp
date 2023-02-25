Solution 1 :- 
Brute force O(n^2)
Space complexity :- O(1)


Solution 2 :-

class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int count1 = 0;
        int count2 = 0;
        int n = nums.size();
        int first = INT_MAX;
        int second = INT_MAX;
        int i;
        for(i=0;i<nums.size();i++) {
            if(first == nums[i]) {
                count1++;
            } else if(second == nums[i]) {
                count2++;
            } else if(count1 == 0) {
                first = nums[i];
                count1++;
            } else if(count2 == 0) {
                second = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(i=0;i<nums.size();i++) {
            if(first == nums[i]) count1++;
            if(second == nums[i]) count2++;
        }
        vector<int> res;
        if(count1 > n/3)
        res.push_back(first);
        if(count2 > n/3)
        res.push_back(second);
        return res;
    }
};

Time complexity :- O(n)
Space complexity :- O(1)