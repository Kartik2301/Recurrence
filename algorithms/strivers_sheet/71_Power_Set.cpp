A power set of S is the set of all subsets of S, including the empty set and S itself.

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();
        int N = pow(2,n);
        int i;
        vector<vector<int>> result;
        for(i=0;i<N;i++) {
            vector<int> sub;
            for(int j=0;j<n;j++) {
                if(i & (1 << j)) {
                    sub.push_back(nums[j]);
                }
            }
            result.push_back(sub);
        }
        return result;
    }
};

Time complexity: O(N×2^N)
to generate all subsets and then copy them into output list.

Space complexity: O(N×2^N)