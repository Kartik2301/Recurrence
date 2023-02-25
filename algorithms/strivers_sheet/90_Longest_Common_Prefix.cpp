class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int i;
        for(i=0;i<strs.length;i++) {
            while(strs[i].indexOf(prefix) != 0) {
                if(prefix.length() == 0) return "";
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}

Time complexity : O(S), where S is the sum of all characters in all strings.

In the worst case all nn strings are the same. 
The algorithm compares the string S1 with the other strings [S_2 to S_n]
​   
There are S character comparisons, where S is the sum of all characters in the input array.

Space complexity : O(1). We only used constant extra space.