Solution 1.

Time complexity O(n)
Space complexity O(1)

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
        int i = low;
        while(i <= high) {
            if(nums[i] == 0) {
                swap(nums[low], nums[i]);
                low++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums[i], nums[high]);
                high--;
            } else {
                i++;
            }
        }
    }
};

Solution 2.

Use counting sort :-
Time complexity O(n)
Space complexity O(1)

2-pass Solution


Brute force Solutions

Solution 3. Sorting (Time complexity :- nlogn)