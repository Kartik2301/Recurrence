Solution 1 :-
Brute force 
Time complexity :- O(n^2)
Space complexity :- O(1)

Solution 2 :-
Using stack
vector<int> Solution::prevSmaller(vector<int> &A) {
    stack<int> s;
    int i;
    vector<int> vec;
    for(i=0;i<A.size();i++) {
        if(s.empty()) vec.push_back(-1);
        else if(!s.empty() && s.top() < A[i]) vec.push_back(s.top());
        else if(!s.empty() && s.top() >= A[i]) {
            while(!s.empty() && s.top() >= A[i]) {
                s.pop();
            }
            if(s.size() == 0) vec.push_back(-1);
            else vec.push_back(s.top());
        }
        s.push(A[i]);
    }
    return vec;
}

Time complexity :- O(n)
Space complexity :- O(n)