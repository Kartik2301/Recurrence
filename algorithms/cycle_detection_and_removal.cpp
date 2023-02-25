#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Node {
public:
	int data;
	Node* next;
};

Node* head;

Node* create(int data) {
	Node* new_node = new Node();
	new_node->data = data;
	new_node->next = NULL;
	return new_node;
}

void detectAndRemovedLoop() {
	Node* slow = head;
	Node* fast = head;
	while(fast != NULL && fast->next != NULL) {
		fast = fast->next->next;
		slow = slow->next;
		if(slow == fast) {
			break;
		}
	}
	if(slow == fast) {
		slow = head;
		while(slow->next != fast->next) {
			slow = slow->next;
			fast = fast->next;
		}
		fast->next = NULL;
	}
}

void display(){
	Node* temp = head;
	while(temp != NULL) {
		cout<<temp->data<<" ";
		temp = temp->next;
	}
}

int main() {
	head = create(50);
	head->next = head;
    head->next = create(20);
    head->next->next = create(15);
    head->next->next->next = create(4);
    head->next->next->next->next = create(10);
    head->next->next->next->next->next = head->next->next;
    detectAndRemovedLoop();
    display();
}
