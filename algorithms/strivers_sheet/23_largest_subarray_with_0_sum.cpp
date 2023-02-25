Solution 1 :- Brute force
Time complexity O(n^3) or O(n^2)
Space complexity O(1)

Solution 2 :-
Prefix sum 
Time complexity :- O(n)
Space complexity :- O(1)

int maxLen(int A[], int n)
{
    // Your code here
    int max_len = 0;
    unordered_map<int,int> freq;
    freq[0] = -1;
    int i, runner = 0;
    for(i=0;i<n;i++) {
        runner += A[i];
        if(freq.find(runner) != freq.end()) {
            int begin = freq[runner];
            max_len = max(max_len, i-begin);
        }
        if(freq.find(runner) == freq.end()) {
            freq[runner] = i;
        }
    }
    return max_len;
}