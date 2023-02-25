Solution 1 :-
Brute force Solution 
Time Complexity :- O(n^2)
Space Complexity :- O(1)

Solution 2 :-
Time Complexity :- O(n)
Space Complexity :- O(n)

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i;
        for(i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        int max_len = 0;
        for(i=0;i<nums.length;i++) {
            int cur = nums[i];
            if(!set.contains(cur-1)) {
                int streak = 1;
                cur++;
                while(set.contains(cur)) {
                    cur++;
                }
                max_len = Math.max(cur-nums[i], max_len);
            }
            
        }
        return max_len;
    }
}