Solution 1 :- 
Brute force solution 
Time complexity :- O(n^4)
Space complexity :- O(n)

Solution 2 :-
Brute force + binary search
Time complexity :- O(n^3logn)
Space complexity :- O(n)

Solution 3 :-
2 pointers solution
Time complexity :- O(n^3)
Space complexity :- O(1)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i,j;
        List<List<Integer>> list = new ArrayList<>();
        for(i=0;i<nums.length;i++) {
            for(j=i+1;j<nums.length;j++) {
                int begin = j+1;
                int end = nums.length-1;
                while(begin < end) {
                    if(nums[i]+nums[j]+nums[begin]+nums[end] == target) {
                        list.add(Arrays.asList(nums[i],nums[j],nums[begin],nums[end]));
                        while(begin < end && nums[begin] == nums[begin+1]) begin++;
                        while(begin < end && nums[end] == nums[end-1]) end--;
                        begin++;
                        end--;
                    } else if(nums[i]+nums[j]+nums[begin]+nums[end] < target) {
                        begin++;
                    } else if(nums[i]+nums[j]+nums[begin]+nums[end] > target) {
                        end--;
                    }
                }
                while(j + 1 < nums.length && nums[j+1] == nums[j]) j++;
            }
            while(i + 1 < nums.length && nums[i+1] == nums[i]) i++;
        }
        return list;
    }
}

Using a hashset in solution 3
Time complexity :- O(n^3)
Space complexity :- O(1)