Solution 1 :- Brute Force 
Time complexity :- O(n^3) or O(n^2) 
Space Complexity :- O(1)


Solution 2 :- Use prefix xor

int Solution::solve(vector<int> &A, int B) {
    long long ans = 0;
    int i;
    int n = A.size();
    vector<int> xorArr(n,A[0]);
    for(i=1;i<A.size();i++) {
        xorArr[i] = xorArr[i-1]^A[i];
    }
    unordered_map<int,int> freq;
    for(i=0;i<n;i++) {
        int curXor = B^xorArr[i];
        if(xorArr[i] == B) ans++;
        ans += (long long) freq[curXor];
        freq[xorArr[i]]++;
    }
    return ans;
}

Time Complexity: O(n)

Space Complexity: O(n)