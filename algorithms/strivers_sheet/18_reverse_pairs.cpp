Solution 1 :- Reverse Pairs

class Solution {
public:
    int N;
    int reversePairs(vector<int>& nums) {
        N = nums.size();
        vector<int> BITree;
        BITree.resize(N+1);
        fill(BITree.begin(), BITree.end(),0);
        int i;
        vector<int> temp(nums);
        sort(temp.begin(), temp.end());
        int count = 0;
        for(i=0;i<nums.size();i++) {
            count += getSum(BITree,lower_bound(temp.begin(), temp.end(), 2*(long long)nums[i]+1) - temp.begin() + 1);
            update(BITree, lower_bound(temp.begin(), temp.end(), nums[i]) - temp.begin() + 1, 1);
        } 
        return count;
    }
    void update(vector<int> & BITree, int index, int val) {
        while(index > 0) {
            BITree[index] += val;
            index -= (index & (-index));
        }
    }
    int getSum(vector<int> & BITree, int index) {
        int sum = 0;
        while(index <= N) {
            sum += BITree[index];
            index += (index & (-index));
        }
        return sum;
    }
};

Time complexity: O(nlogn)
Space complexity: O(n)


Solution 2 :- 

Brute force 
Time complexity :- O(n^2)
Space complexity :- O(1)