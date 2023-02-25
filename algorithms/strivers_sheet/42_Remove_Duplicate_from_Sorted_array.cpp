there are 2 variants of this problem on leetcode

Solution 1 :-
Brute force based, use an additional data structure like maps

Time complexity :- O(n)
Space complexity :- O(n)

Solution 2 :-

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(count <= 1) {
                nums[count] = nums[i];
                count++;
                continue;
            }
            if(nums[i] == nums[count-1] && nums[i] == nums[count-2]) {
                continue;
            } 
            nums[count] = nums[i];
            count++;
        }
        return count;
    }
}

Time complexity :- O(n)
Space complexity :- O(1)