Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int row = 0;
        int i,j;
        for(i=0;i<matrix.length;i++) {
            if(matrix[i][matrix[0].length-1] >= target) {
                row = i;
                break;
            }
        }
        int low=0;
        int high = matrix[0].length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}

Time Complexity :- O(n + log(m))
Space Complexity :- O(1)

Solution 2 :- Brute force O(n^2), Space Complexity :- O(1)



***************************************************************************************



Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.



Solution 1 :- Brute force O(n^2)
Space Complexity :- O(1)


Solution 2 :-

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i,j;
        i = 0;
        j = matrix[0].length-1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] > target) {
                j--;
            } else if(matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}


Time Complexity :- O(m+n)
Space Complexity :- O(1)