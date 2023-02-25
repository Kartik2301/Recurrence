Solution 1 :-
Brute Force 
Time complexity :- O(n^2)
Space complexity :- O(1)


Solution 2 :-

Using BIT 

Time complexity: O(nlogn)
Space complexity: O(n)

class Solution {
public:
    int N;
    vector<int> BITree;
    vector<int> countSmaller(vector<int>& nums) {
        if(nums.size() == 0) return nums;
        vector<int> temp;
        temp.insert(temp.end(), nums.begin(), nums.end());
        sort(temp.begin(), temp.end());
        int i;
        for(i=0;i<nums.size();i++) {
            nums[i] = lower_bound(temp.begin(), temp.end(), nums[i]) - temp.begin() + 1;
        }
        N = *max_element(nums.begin(), nums.end());
        BITree.resize(N+1);
        fill(BITree.begin(), BITree.end(), 0);
        vector<int> result;
        for(i=nums.size()-1;i>=0;i--) {
            result.push_back(getSum(nums[i]-1));
            update(nums[i], 1);
        }
        reverse(result.begin(), result.end());
        return result;
    }
    void update(int i, int val) {
        while(i <= N) {
            BITree[i] += val;
            i += (i & (-i));
        }
    }
    int getSum(int i) {
        int sum = 0;
        while(i > 0) {
            sum += BITree[i];
            i -= (i & (-i));
        }
        return sum;
    }
};


Solution 3 :-

Using modified merge sort


// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


// Function to find inversion count in the array

// arr[]: Input Array
// N : Size of the Array arr[]
long long merge(long long arr[], long long temp[], long long low, long long mid, long long high) {
    long long inversions = 0;
    long long i = low;
    long long j = mid;
    long long k = low;
    while((i <= mid-1) && (j <= high)) {
        if(arr[i] <= arr[j]) {
            temp[k++] = arr[i++]; 
        } else {
            temp[k++] = arr[j++];
            inversions += (mid - i);
        }
    }
    while(i <= mid-1) {
        temp[k++] = arr[i++];
    }
    while(j <= high) {
        temp[k++] = arr[j++];
    }
    for(i=low;i<=high;i++) arr[i] = temp[i];
    return inversions;
}
long long merge_sort_helper(long long arr[], long long temp[], long long low, long long high) {
    long long int inversions = 0;
    if(high > low) {
        long long mid = low + (high - low)/2;
        inversions += merge_sort_helper(arr,temp,low,mid);
        inversions += merge_sort_helper(arr,temp,mid+1,high);
        inversions += merge(arr,temp,low,mid+1,high);
    }
    return inversions;
}
long long int merge_sort(long long arr[], long long N) {
    long long temp[N];
    return merge_sort_helper(arr,temp,0,N-1);
}
long long int inversionCount(long long arr[], long long N)
{
    // Your Code Here
    return merge_sort(arr,N);
    
}


// { Driver Code Starts.

int main() {
    
    long long T;
    cin >> T;
    
    while(T--){
        long long N;
        cin >> N;
        
        long long A[N];
        for(long long i = 0;i<N;i++){
            cin >> A[i];
        }
        
        cout << inversionCount(A,N) << endl;
    }
    
    return 0;
}
  // } Driver Code Ends


Time Complexity: O(n log n).
Space Complexity: O(n), Temporary array.