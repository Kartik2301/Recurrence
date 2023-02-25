Solution 1 :-

The brute force algorithm iterates over the array, and then iterates again for each number to count its occurrences. 
As soon as a number is found to have appeared more than any other can possibly have appeared, return it.

class Solution {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;    
    }
}

Time complexity : O(n^2)
Space complexity : O(1)

Solution 2 :-

HashMap

Time complexity : O(n)
Space complexity : O(n)


Solution 3 :-

Boyer-Moore Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int majorityIndex = 0;
        int count = 1;
        int i;
        for(i=1;i<nums.length;i++) {
            if(nums[majorityIndex] == nums[i]) count++;
            else {
                count--;
            }
            if(count == 0) {
                majorityIndex = i;
                count++;
            }
        }
        return nums[majorityIndex];
    }
}

Time complexity : O(n)
Space complexity : O(1)