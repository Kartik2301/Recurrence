Solution 1 (bases on insertion sort)
Time Complexity :- O(m*n)
Space Complexity :- O(1)

void merge(int arr1[], int arr2[], int n, int m) { 
    // code here 
    int i;
    for(i=0;i<n;i++) {
        if(arr1[i] > arr2[0]) {
            swap(arr1[i], arr2[0]);
            int first = arr2[0];
            int k=1;
            for(k=1;k<m && arr2[k] < first ;k++) {
                arr2[k-1] = arr2[k];
            }
            arr2[k-1] = first;
        }
    }
} 


Solution 2 (based on shell sort)

int nextGap(int gap) {
    if(gap <= 1) return 0;
    return gap/2 + (gap%2);
}
void merge(int arr1[], int arr2[], int n, int m) { 
    // code here 
    int i;
    int gap = m+n;
    int j;
    
    for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
        
        for(i=0;i+gap<n;i++) {
            if(arr1[i] > arr1[i+gap]) {
                swap(arr1[i], arr1[i+gap]);
            }
        }
        for(j= gap > n ? gap-n : 0; i < n && j < m; i++, j++) {
            if(arr1[i] > arr2[j]) {
                swap(arr1[i], arr2[j]);
            }
        }
        if(j < m) {
            for(j=0;j+gap<m;j++) {
                if(arr2[j] > arr2[j+gap]) {
                    swap(arr2[j], arr2[j+gap]);
                }
            }
        }
    }
}

O((n+m)*log(n+m)) time with O(1) extra space

Solution 3 (based on shell sort)

// { Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 


 // } Driver Code Ends
class Solution{
    public:
        //Function to merge the arrays.
        void merge(long long arr1[], long long arr2[], int n, int m)  { 
            // code here 
            int i = 0;
            int j = 0;
            int k = 0;
            long long mx = 0;
            for(i=0;i<n;i++) {
                mx = max(mx, arr1[i]);
            }
            for(i=0;i<m;i++) {
                mx = max(mx, arr2[i]);
            }
            i=0;
            mx++;
            while(i < n && j < m && k < n+m) {
                int e1 = arr1[i] % mx;
                int e2 = arr2[j] % mx;
                if(e1 <= e2) {
                    if(k < n) {
                        arr1[k] += e1*mx;
                    } else {
                        arr2[k-n] += e1*mx;
                    }
                    k++;
                    i++;
                } else {
                    if(k < n) {
                        arr1[k] += e2*mx;
                    } else {
                        arr2[k-n] += e2*mx;
                    }
                    k++;
                    j++;
                }
            }
            while(i < n) {
                int e1 = arr1[i] % mx;
                if(k < n) {
                    arr1[k] += e1*mx;
                } else {
                    arr2[k-n] += e1*mx;
                }
                k++;
                i++;
            }
            while(j < m) {
                int e1 = arr2[j] % mx;
                if(k < n) {
                    arr1[k] += e1*mx;
                } else {
                    arr2[k-n] += e1*mx;
                }
                k++;
                j++;
            }
            for(i=0;i<n;i++) {
                arr1[i] /= mx;
            }
            for(i=0;i<m;i++) {
                arr2[i] /= mx;
            }
        } 
};

// { Driver Code Starts.

int main() 
{ 
    
    int T;
    cin >> T;
    
    while(T--){
        int n, m;
        cin >> n >> m;
        
        long long arr1[n], arr2[m];
        
        for(int i = 0;i<n;i++){
            cin >> arr1[i];
        }
        
        for(int i = 0;i<m;i++){
            cin >> arr2[i];
        }
        Solution ob;
        ob.merge(arr1, arr2, n, m); 

        for (int i = 0; i < n; i++) 
            cout<<arr1[i]<<" "; 
        
       
        for (int i = 0; i < m; i++) 
            cout<<arr2[i]<<" "; 
        
        cout<<endl;
    }

    return 0; 
} 
  // } Driver Code Ends

Time Complexity :- O(m+n)