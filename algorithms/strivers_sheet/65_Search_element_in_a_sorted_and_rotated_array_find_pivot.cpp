Solution 1 :-
Time complexity :- O(logn)
Space complexity :- O(1)

class Solution {
    public int search(int[] nums, int target) {
        int val,pivot;
        return (nums[(pivot = findPivotIndex(nums))] == target) ? 
            pivot : ((val = binary_search(nums,target,0,pivot-1)) != -1) ? 
                val : binary_search(nums,target,pivot+1,nums.length-1);
    }
    public int binary_search(int [] nums, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    public int findPivotIndex(int [] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            if(nums[low] <= nums[high]) return low;
            int mid = low + (high - low)/2;
            int next = (mid + 1) % nums.length;
            int prev = (mid - 1 + nums.length) % nums.length;
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            } else if(nums[mid] <= nums[high]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}

Solution 2 :-

Find min element in O(n) Time [total = O(n) + O(logn)]
Time complexity :- O(n)
Space complexity :- O(1)

Solution 3 :-

Sort the whole thing again
Time complexity :- O(nlogn)
Space complexity :- O(1)

Solution 4 :- linear search
Time complexity :- O(n)
Space complexity :- O(1)