Solution 1 :-
Brute force based
Use a hash map
Time complexity :- O(n)
Space complexity :- O(n)

Solution 2 :-

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if(nums[mid] == nums[mid-1]) {
                int elements_on_right = nums.length - mid-1;
                if(elements_on_right % 2 == 0) {
                    high = mid-2;
                } else {
                    low = mid+1;
                }
            } else if(nums[mid] == nums[mid+1]) {
                int elements_on_left = mid;
                if(elements_on_left % 2 == 0) {
                    low = mid+2;
                } else {
                    high = mid-1;
                }
            }
        }
        return nums[low];
    }
}

Time complexity :- O(log(n))
Space complexity :- O(1)