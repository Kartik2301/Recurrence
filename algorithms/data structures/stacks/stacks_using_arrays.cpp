#include<iostream>
using namespace std;
#define MAX_SIZE 100
int stk[MAX_SIZE];

int top = -1;

void push(int x) {
    if(top >= MAX_SIZE-1) {
        return;
    }
    top++;
    stk[top] = x;
}

int pop() {
    if(top < 0) return -1;
    int x = stk[top];
    stk[top] = -1;
    top--;
    return x;
}

int peek() {
    if(top < 0) {
        return -1;
    }
    return stk[top];
}

bool isEmpty() {
    return (top < 0);
}

int main() {
    push(10);
    push(20);
    push(30);
    cout<<pop()<<endl;
    cout<<peek()<<endl;
    cout<<boolalpha<<isEmpty()<<endl;
}
