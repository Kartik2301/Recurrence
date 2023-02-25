Solution 1 :- 
Using concept of NSR
Time complexity :- O(n)
Space complexity :- O(n)

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        //heights.push_back(0);
        stack<pair<int,int>> stk;
        vector<int> left, right;
        int i;
        // find nearest smallest to the left        
        for(i=0;i<heights.size();i++) {
            if(stk.empty()) {
                left.push_back(-1);
            } else if(!stk.empty() && stk.top().first < heights[i]) {
                left.push_back(stk.top().second);
            } else if(!stk.empty() && stk.top().first >= heights[i]) {
                while(!stk.empty() && stk.top().first >= heights[i]) {
                    stk.pop();
                }
                if(stk.empty()) left.push_back(-1);
                else left.push_back(stk.top().second);
            }
            stk.push({heights[i],i});
        }
        while(!stk.empty()) stk.pop();
        // find nearest smallest to the right
        for(i=heights.size()-1;i>=0;i--) {
            if(stk.empty()) {
                right.push_back(-1);
            } else if(!stk.empty() && stk.top().first < heights[i]) {
                right.push_back(stk.top().second);
            } else if(!stk.empty() && stk.top().first >= heights[i]) {
                while(!stk.empty() && stk.top().first >= heights[i]) {
                    stk.pop();
                }
                if(stk.empty()) right.push_back(-1);
                else right.push_back(stk.top().second);
            }
            stk.push({heights[i],i});
        }
        reverse(right.begin(), right.end());
        int max_area = 0;
        for(i=0;i<heights.size();i++) {
            int r = right[i];
            int l = left[i];
            if(l == -1 && r == -1) {
                max_area = max(max_area, heights[i]*n);
                continue;
            }
            if(r == -1) {
                max_area = max(max_area, (n-1-l)*heights[i]);
                continue;
            }
            max_area = max(max_area,(r-l-1)*heights[i]);
        }
        return max_area;
    }
};

Solution 2 :-

Brute force to find NSR on left and right

Time complexity :- O(n^2)
Space complexity :- O(1)