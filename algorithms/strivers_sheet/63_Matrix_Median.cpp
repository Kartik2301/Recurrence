Solution 1 :-
Time complexity :- (32*r*log(c))
Space complexity :- O(1)

int Solution::findMedian(vector<vector<int> > &matrix) {
        int i;
        int r = matrix.size();
        if(r == 0) return 0;
        int c = matrix[0].size();
        int low = INT_MAX;
        int high = INT_MIN;
        for(i=0;i<r;i++) {
            low = min(low,matrix[i][0]);
        }
        
        for(i=0;i<r;i++) {
            high = max(high,matrix[i][c-1]);
        }
        int ans = 0;
        int desired = (r*c+1)/2;;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int smaller = 0;
            for(int i=0;i<r;i++) {
                smaller += upper_bound(matrix[i].begin(), matrix[i].end(), mid) - matrix[i].begin();
            }
            if(smaller == desired) {
                ans = mid;
                high = mid;
            }
         else if(smaller < desired) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
}


Solution 2 :-
Brute force based Solution, put all elements in a vector and sort it
Time complexity :- (r*clog(r*c))
Space complexity :- O(r*c)