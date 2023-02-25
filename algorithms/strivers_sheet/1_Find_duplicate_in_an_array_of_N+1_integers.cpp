Solution 1

Time Complexity :- O(n), 
Memory :- O(n)
Without modification of array


class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
};

Solution 2

Time Complexity :- O(n), 
Memory :- O(n)
With modification of array

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int i;
        for(int n: nums) {
            if(nums[abs(n)-1] < 0) return abs(n);
            nums[abs(n)-1] *= -1;
        } 
        return 0;
    }
};

Brute force Solutions

Solution 3. Sorting :- Time complexity O(nlogn) and Space complexity O(1)
Solution 4. Hashing and Sets :- Time complexity(O(n)) and Space complexity O(n) 