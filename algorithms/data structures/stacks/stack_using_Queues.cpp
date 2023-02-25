#include<iostream>
#include<bits/stdc++.h>
using namespace std;
queue<int> q1;
void push(int data) {
	queue<int> q2;
	q2.push(data);
	while(!q1.empty()) {
		q2.push(q1.front());
		q1.pop();
	}
	queue<int> temp = q1;
	q1 = q2;
	q2 = temp;
}

void pop() {
	if(q1.empty()) return;
	q1.pop();
}

int top() {
	if(q1.empty()) return -1;
	return q1.front();
}

bool empty() {
	return (q1.empty());
}

int main() {
	push(10);
	push(20);
	push(30);
	cout<<top()<<endl;
	pop();
	cout<<top()<<endl;
	cout<<boolalpha<<empty()<<endl;
}
