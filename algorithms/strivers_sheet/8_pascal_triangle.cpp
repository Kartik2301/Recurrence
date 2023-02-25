Questions :-

1. Print triangle upto R rows

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        if(numRows == 1) return result;
        result.add(new ArrayList<>());
        result.get(1).add(1);
        result.get(1).add(1);
        if(numRows == 2) return result;
        for(int rowNum=2;rowNum<numRows;rowNum++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> temp = result.get(rowNum-1);
            int runner = 0;
            for(int i=0;i<2;i++) {
                runner += temp.get(i);
            }
            row.add(runner);
            for(int i=2;i<rowNum;i++) {
                runner = runner + temp.get(i) - temp.get(i-2);
                row.add(runner);
            }
            
            row.add(1);
            result.add(row);
        }
        return result;
    }
}

Time complexity : O(numRows^2)
Space complexity : O(numRows^2)


2. Print the element in row R and column c

formula is (R-1)C(c-1)

3. Print a give row

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        int n = rowIndex+1;
        vector<int> row(n);
        int i;
        row[0] = 1;
        row[rowIndex] = 1;
        for(i=1;i<=rowIndex-1;i++) {
            row[i] = (long long int)row[i-1]*(n-i)/i;
        }
        return row;
    }
};


Time complexity O(n)
Space complexity O(n)

