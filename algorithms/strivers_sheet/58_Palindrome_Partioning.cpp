class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        solve(list,s, new ArrayList<>(),0);
        return list;
    }
    public void solve(List<List<String>> list, String s, List<String> tempList, int start) {
        if(start == s.length()) {
            list.add(new ArrayList<>(tempList));
            return;
        } else {
            int i;
            for(i=start;i<s.length();i++) {
                if(isValid(s.substring(start,i+1))) {
                    tempList.add(s.substring(start,i+1));
                    solve(list,s,tempList,i+1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
    public boolean isValid(String s) {
        int low = 0;
        int high = s.length()-1;
        while(low <= high) {
            if(s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}


Time Complexity : O(N⋅2^N), where N is the length of string s. This is the worst-case time complexity when all the possible substrings are palindrome.
Space Complexity: O(N), where N is the length of the string s. 
This space will be used to store the recursion stack. For s = aaa, the maximum depth of the 
recursive call stack is 3 which is equivalent to N.