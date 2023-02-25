Solution 1 :-
Brute force
Put all the elements of the matrix in a vector and sort it
Time complexity :- O(nlogn)
Space complexity :- O(n)

Solution 2 :-
Better brute force using merge of merge sort
Time complexity :- O(m+n)
Space complexity :- O(m+n)

Solution 3 :-
Use binary search
Time complexity :- O(logn)
Space complexity :- O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if(x > y) return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = nums1.length;
        while(low <= high) {
            int partition_x = low + (high - low)/2;
            int partition_y = (x+y+1)/2 - partition_x;
            int max_left_x = (partition_x == 0) ? Integer.MIN_VALUE : nums1[partition_x-1];
            int max_left_y = (partition_y == 0) ? Integer.MIN_VALUE : nums2[partition_y-1];
            int min_right_x = (partition_x == x) ? Integer.MAX_VALUE : nums1[partition_x];
            int min_right_y = (partition_y == y) ? Integer.MAX_VALUE : nums2[partition_y];
            if(max_left_x <= min_right_y && max_left_y <= min_right_x) {
                int left = Math.max(max_left_x,max_left_y);
                int right = Math.min(min_right_x,min_right_y);
                if((x+y)%2 == 0) return (double) (left + (double) right)/2.0;
                return left;
            } else if(max_left_x > min_right_y) {
                high = partition_x-1;
            } else {
                low = partition_x+1;
            }
        }
        return 0;
    }
}