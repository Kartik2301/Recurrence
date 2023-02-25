Implement stacks

1. Using arrays

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

2. Using linked lists

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




Implement queues

1. Using arrays

#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int front, capacity, size, rear;
#define MAX_SIZE 100
int que[MAX_SIZE];


bool isFull() {
    return (size == capacity);
}

bool isEmpty() {
    return (size == 0);
}

void enQueue(int data) {
    if(isFull()) return;
    size++;
    rear = (rear + 1)%MAX_SIZE;
    que[rear] = data;
}

int deQueue() {
    if(isEmpty()) return -1;
    size--;
    int val = que[front];
    front = (front + 1)%MAX_SIZE;
    return val;
}

int top() {
    if(isEmpty()) return -1;
    return que[front];
}

int main() {
    front = 0;
    capacity = 100;
    size = 0;
    rear = capacity-1;
    enQueue(10);
    enQueue(20);
    enQueue(30);
    cout<<top()<<endl;
    deQueue();
    cout<<top()<<endl;
}


2. Using linked lists

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
