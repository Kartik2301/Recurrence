Solution 1 :-
Brute force Solutions
O(n^3) to O(n^2) to generate all possible substrings and O(n) time to check for duplicates
Space Complexity :- O(1)

Solution 2 :-
Sliding window approach O(n)
Space Complexity O(n) for set

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int len = 0;
        while(i < s.length()) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
            } else {
                int sz = set.size();
                len = Math.max(len, sz);
                set.remove(s.charAt(j));
                j++;
            }
        }
        int sz = set.size();
        len = Math.max(len, sz);
        return len;
    }
}