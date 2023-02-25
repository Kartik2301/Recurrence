Solution 1: Brute Force
Algorithm

In this approach, we find out every possible permutation of 
list formed by the elements of the given array and find out the 
permutation which is just larger than the given one. But this one will be a very 
naive approach, since it requires us to find out every possible permutation 
which will take really long time and the implementation is complex. 
Thus, this approach is not acceptable at all. Hence, we move on directly to the correct approach.

Complexity Analysis

Time complexity : O(n!). Total possible permutations is n!n!.
Space complexity : O(n). Since an array will be used to store the permutations.


Solution 2 :


class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0) {
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(i+1,nums);
    }
    public void reverse(int index, int [] nums) {
        int low = index;
        int high = nums.length-1;
        while(low<=high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
}

Time complexity : O(n). In worst case, only two scans of the whole array are needed.

Space complexity : O(1). No extra space is used. In place replacements are done.



**************************************************
there is an inbuilt library in c++ stl next_permutation(nums.begin(), nums.end()) for this purpose