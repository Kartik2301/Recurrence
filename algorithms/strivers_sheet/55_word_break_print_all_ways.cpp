class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        return solve(s,list,set, new ArrayList<>(), map);
    }
    public List<String> solve(String s, List<String> list, Set<String> set,  List<String> tempList, Map<String,List<String>> map) {
        if(map.containsKey(s)) return map.get(s);
        if(s.length() == 0) {
            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        List<String> res = new ArrayList<>();
        for(String word: set) {
            if(s.indexOf(word) == 0) {
                List<String> subList = solve(s.substring(word.length()),list,set,tempList,map); 
                for(String str: subList) {
                    res.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

Time complexity :- https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below

The answer is exponential, to be precise O(2^(n-2)). (2 power (n-2)

In each call you are calling the recursive function with length 1,2....n-1(in worst case). 
To do the work of length n you are recursively doing the work of all the strings of length n-1, n-2, to 1. 
So T(n) is the time complexity of your current call, you are internally doing a work of sum of T(n-1),T(n-2)....T(1).

Mathematically :

  T(n) = T(n-1) + T(n-2) + upto + T(1);
  T(1) = T(2) = 1 
If you really don't know how to solve this, an easier way to solve the above recurrence is by just substitute values.

  T(1) = T(2) = 1
  T(3) = T(1) + T(2) = 1+1 =2; // 2^1
  T(4) = T(1)+ T(2) + T(3) = 1+1+2 =4; //2^2
  T(5) = T(1) + T(2) +T(3) +T(4) = 1+1+2+4 =8; //2^3
So if you substitute first few values, it will be clear that the Time complexity is 2^(n-2)

Time complexity :- O(n^2) for iterative Solution


The word break problem takes O(n) auxiliary space.
