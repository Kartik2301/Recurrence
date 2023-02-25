#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class QueueNode {
public:
	int data;
	QueueNode* next;
};

QueueNode* head = NULL;
QueueNode* tail = NULL;

QueueNode* create(int data) {
	QueueNode* node = new QueueNode();
	node->data = data;
	node->next = NULL;
	return node;
}

bool isEmpty() {
	return (head == NULL);
}

void enQueue(int data) {
	QueueNode* new_node = create(data);
	if(head == NULL) {
		head = new_node;
		tail = new_node;
		return;
	}
	tail->next = new_node;
	tail = new_node;
	return;
}

int deQueue() {
	if(isEmpty()) {
		return INT_MAX;
	}
	QueueNode* temp = head;
	head = head->next;
	int popped = temp->data;
	if(head == NULL) {
		tail = NULL;
	}
	free(temp);
	return popped;
}

int peek() {
	if(isEmpty()) return INT_MAX;
	return head->data;
}

int main() {
	head = NULL;
	tail = NULL;
	enQueue(10);
	enQueue(15);
	enQueue(20);
	enQueue(25);
	enQueue(30);
	enQueue(35);
	deQueue();
	cout<<peek()<<endl;
}
