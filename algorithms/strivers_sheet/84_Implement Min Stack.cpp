class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> s,s1;
    MinStack() {
        while(!s.empty()) s.pop();
        while(!s1.empty()) s1.pop();
    }
    
    void push(int x) {
        if(s1.empty() || s1.top() >= x) {
            s1.push(x);
        }  
        s.push(x);
    }
    
    void pop() {
        if(!s1.empty() && s.top() == s1.top()) {
            s1.pop();
        }
        s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return s1.top();
    }
};

Time complexity :- O(1)
Space complexity :- O(n)

Other solution :-
Design stack from scratch

class MinStack {
public:
    /** initialize your data structure here. */
    class StackNode {
        public:
        int val;
        int mn;
        StackNode* next;
    };
    StackNode* head = NULL;
    MinStack() {
        head = NULL;
    }
    StackNode* create_node(int val, int mn) {
        StackNode* new_node = new StackNode();
        new_node->val = val;
        if(head == NULL) {
            new_node->mn = val;
        } else {
            new_node->mn = min(head->mn, val);
        }
        return new_node;
    }
    void push(int x) {
        StackNode* new_node = create_node(x,x);
        if(head == NULL) {
            head = new_node;
            return;
        }
        new_node->next = head;
        head = new_node;
        return;
    }
    
    void pop() {
        StackNode* temp = head;
        head = head->next;
        delete(temp);
    }
    
    int top() {
        return head->val;
    }
    
    int getMin() {
        return head->mn;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */