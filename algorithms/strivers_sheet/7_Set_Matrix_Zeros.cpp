Solution :-
Without extra space 

class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j;
        boolean row_contains_zero = false;
        boolean col_contains_zero = false;
        for(j=0;j<matrix[0].length;j++) {
            if(matrix[0][j] == 0) {
                row_contains_zero = true;
                break;
            }
        }
        for(i=0;i<matrix.length;i++) {
            if(matrix[i][0] == 0) {
                col_contains_zero = true;
                break;
            }
        }
        for(i=1;i<matrix.length;i++) {
            for(j=1;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(i=1;i<matrix.length;i++) {
            if(matrix[i][0] == 0) {
                for(j=0;j<matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }        
        for(j=1;j<matrix[0].length;j++) {
            if(matrix[0][j] == 0) {
                for(i=0;i<matrix.length;i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row_contains_zero) {
            for(j=0;j<matrix[0].length;j++) {
                matrix[0][j] = 0;
            }
        }
        if(col_contains_zero) {
            for(i=0;i<matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

Time Complexity : O(M×N)
Space Complexity : O(1)


Other solutions also run in O(MXN) time but not in O(1) space 