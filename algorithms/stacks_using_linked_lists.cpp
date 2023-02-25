#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class StackNode {
public:
	int data;
	StackNode * next;
};

StackNode* head;
StackNode* create(int data) {
	StackNode* node = new StackNode();
	node->data = data;
	node->next = NULL;
	return node;
}

void push(int val) {
	StackNode* get_node = create(val);
	get_node->next = head;
	head = get_node;
	return;
}

bool isEmpty() {
	if(head == NULL) return true;
	return false;
}

int pop() {
	if(isEmpty()) {
		return INT_MAX;
	}
	StackNode* temp = head;
	head = head->next;
	int popped = temp->data;
	free(temp);
	return popped;
}

int peek() {
	if(isEmpty()) return INT_MAX;
	return head->data;
}
int main(){
	head = NULL;
	push(10);
	push(20);
	push(30);
	while(!isEmpty()) {
        cout<<pop()<<endl;
	}
}
