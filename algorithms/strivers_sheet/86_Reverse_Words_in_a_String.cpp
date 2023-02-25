Solution 1 :-

class Solution {
    public String reverseWords(String s) {
        String [] words = s.split("\\s++");
        int i;
        String result = "";
        for(i=words.length-1;i>=0;i--) {
            result += (words[i] + " ");
        }
        return result.trim();
    }
}

Time complexity :- O(n)
Space complexity :- O(n)

Solution 2 :-

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int i;
        String res = "";
        String temp = "";
        for(i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == ' ') {
                if(temp.length() == 0) continue;
                res += (temp + " ");
                temp = "";
            } else {
                temp = s.charAt(i) + temp;
            }
        }
        res += (temp + " ");
        return res.trim();
    }
}

Time complexity :- O(n)
Space complexity :- O(1)