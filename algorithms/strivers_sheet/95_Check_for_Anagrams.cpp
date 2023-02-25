Solution 1 :-

class Solution {
    public boolean isAnagram(String s, String t) {
        int [] freq = new int[26];
        int i;
        for(i=0;i<26;i++) freq[i] = 0;
        for(i=0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(i=0;i<t.length();i++) {
            freq[t.charAt(i) - 'a']--;
        }
        for(i=0;i<26;i++) {
            if(freq[i] != 0) return false;
        }
        return true;
        
    }
}

Time complexity :- O(n)
Space complexity :- O(1)


Solution 2 :-

Use sorting

class Solution {
    public boolean isAnagram(String s, String t) {
        char [] char_arr = s.toCharArray();
        Arrays.sort(char_arr);
        s = String.valueOf(char_arr);
        char_arr = t.toCharArray();
        Arrays.sort(char_arr);
        t = String.valueOf(char_arr);
        return s.equals(t);
    }
}

Time complexity :- O(nlogn)
Space complexity :- O(1)