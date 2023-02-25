Solution 1 :-

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int i,j;
        int m = matrix.size();
        int n = matrix[0].size();
        for(i=0;i<m;i++) {
            for(j=0;j<n;j++) {
                int newRow = j;
                int colRow = i;
                if(newRow >= i) {
                    swap(matrix[newRow][colRow], matrix[i][j]);
                }
            }
            int low = 0;
            int high = n-1;
            while(low<high) {
                swap(matrix[i][low], matrix[i][high]);
                low++;
                high--;
            }
        }
    }
};

Time complexity : (N^2)
Space complexity : (1)