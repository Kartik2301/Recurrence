Solution 1 :-
Using stack

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        map<int,int> freq;
        stack<int> s;
        vector<int> v;
        int i;
        for(i=nums2.size()-1;i>=0;i--){
            if(s.empty()){
                freq[nums2[i]] = -1;
            } else if(!s.empty() && s.top() > nums2[i]){
                freq[nums2[i]] = s.top();
            } else if(!s.empty() && s.top() <= nums2[i]){
                while(s.size() >0 && s.top() <= nums2[i]){
                    s.pop();
                }
                if(s.size() == 0){
                    freq[nums2[i]] = -1;
                } else {
                    freq[nums2[i]] = s.top();
                }
            }
            s.push(nums2[i]);
        }
        for(i=0;i<nums1.size();i++){
            v.push_back(freq[nums1[i]]);
        }
        return v;
    }
};

Time complexity :- O(n)
Space complexity :- O(n)

Solution 2 :-

Brute force Solution
Time complexity :- O(n^2)
Space complexity :- O(1)