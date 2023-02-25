class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        int i;
        for(i=0;i<s.length();i++) {
            if(s[i] == '(' || s[i] == '[' || s[i] == '{' || stk.empty()) {
                stk.push(s[i]);
            } else {
                if(s[i] == ']') {
                    if(stk.top() == '[') stk.pop();
                    else return false;
                } 
                if(s[i] == '}') {
                    if(stk.top() == '{') stk.pop();
                    else return false;
                } 
                if(s[i] == ')') {
                    if(stk.top() == '(') stk.pop();
                    else return false;
                }
            }
        }
        return stk.empty() == true;
    }
};

Time complexity : O(n) because we simply traverse the given string one character at a 
time and push and pop operations on a stack take O(1) time.
Space complexity : O(n) as we push all opening brackets onto the stack and
in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
