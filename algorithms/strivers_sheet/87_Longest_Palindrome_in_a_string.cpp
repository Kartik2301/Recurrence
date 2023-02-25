Solution 1 :-

class Solution {
    private int max_len = 0;
    private int start = 0;
    public String longestPalindrome(String s) {
        start = 0;
        max_len = 0;
        int i;
        for(i=0;i<s.length();i++) {
            expandFromCenter(s,i,i);
            expandFromCenter(s,i,i+1);
        }
        return s.substring(start,start+max_len);
    }
    public void expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if(right - left - 1 > max_len) {
            max_len = right-left-1;
            start = left+1;
        }
    }
}

Time complexity :- O(n^2)
Space complexity :- O(1)

Solution 2 :-

Brute force (generate all substrings)

Time complexity :- O(n^3) or O(n^4)
Note :- generating all substrings takes O(n^3) or better O(n^2)
Space complexity :- O(1)