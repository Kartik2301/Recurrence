Solution 1 :-
Brute force 
Time complexity :- O(n^3)
Space complexity :- O(1) 

Solution 2 :- 2 pointers

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(i=0;i<nums.length;i++) {
            int begin = i+1;
            int end = nums.length-1;
            while(begin < end) {
                if(nums[begin] + nums[end] + nums[i] == 0) {
                    list.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    while(begin < end && nums[begin] == nums[begin+1]) begin++;
                    while(begin < end && nums[end] == nums[end-1]) end--;
                    begin++;
                    end--;
                } else if(nums[begin] + nums[end] + nums[i] < 0) {
                    begin++;
                } else {
                    end--;
                }
            }
            while(i+1<nums.length && nums[i] == nums[i+1]) i++;
        }
        return list;
    }
}

Time complexity :- O(n^2)
Space complexity :- O(1)


Some O(n^2logn) Solution is also possible