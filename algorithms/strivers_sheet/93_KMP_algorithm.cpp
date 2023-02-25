KMP

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length() == 0) return 0;
        vector<int> lps = generate_prefix_arr(needle);
        return search(haystack,needle,lps);
    }
    int search(string text, string pattern, vector<int> & lps) {
        int i = 0;
        int j = 0;
        while(i < text.length() && j < pattern.length()) {
            if(text[i] == pattern[j]) {
                i++;
                j++;
            } 
            if(j == pattern.length()) {
                return i-j;
            } else if(i < text.length() && text[i] != pattern[j]) {
                if(j == 0) i++;
                else j = lps[j-1];
            }
        }
        return -1;
    }
    vector<int> generate_prefix_arr(string s) {
        int len = 0;
        vector<int> lps(s.length());
        lps[0] = 0;
        int i = 1;
        while(i < s.length()) {
            if(s[i] == s[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len == 0) {
                    lps[i] = len;
                    i++;
                } else {
                    len = lps[len-1];
                }
            }
        }
        return lps;
    }
};

Time complexity :- O(n)
Space complexity :- O(n)
