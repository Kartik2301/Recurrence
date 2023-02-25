Solution 1 :-
Time complexity :- O(n^2)
Space complexity: O(1)

Solution 2 :-
Time complexity :- O(n)
Space complexity :- O(n)

Dynamic programming based

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        int [] max_from_left = new int[n];
        int [] max_from_right = new int[n];
        int i;
        max_from_left[0] = height[0];
        max_from_right[n-1] = height[n-1];
        for(i=1;i<n;i++) {
            max_from_left[i] = Math.max(max_from_left[i-1], height[i]);
        }
        for(i=n-2;i>=0;i--) {
            max_from_right[i] = Math.max(max_from_right[i+1], height[i]);
        }
        int ans = 0;
        for(i=1;i<=n-2;i++) {
            int temp = Math.min(max_from_left[i-1], max_from_right[i+1]);
            if(height[i] >= temp) continue;
            ans += temp - height[i];
        }
        return ans;
    }
}

Solution 3 :-

class Solution {
public:
    int trap(vector<int>& height) {
        int i;
        int left = 0;
        int right = height.size()-1;
        int left_max = 0;
        int right_max = 0;
        int ans = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                left_max = max(left_max,height[left]);
                if(left_max != height[left]) {
                    ans += (left_max - height[left]);
                }
                left++;
            } else {
                right_max = max(right_max,height[right]);
                if(right_max != height[right]) {
                    ans += (right_max - height[right]);
                }
                right--;
            }
        }
        return ans;
    }
};

Time complexity :- O(n)
Space complexity :- O(1)