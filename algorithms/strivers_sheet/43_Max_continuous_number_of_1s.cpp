Solution 1 :-

Use sliding window

Time complexity :- O(n)
Space complexity :- O(1)

class Solution {
    public int longestOnes(int[] A, int K) {
        int zeroCount = 0;
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < A.length) {
            zeroCount += (A[i] == 0) ? 1 : 0;
            if(zeroCount > K) {
                while(zeroCount > K) {
                    zeroCount -= (A[j] == 0) ? 1 : 0;
                    j++;
                }
            }
            res = Math.max(res, i-j+1);
            i++;
        }
        return res;
    }
}