#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Node {
public:
	int data;
	Node* next;
};

Node* head;

Node* create_node(int data) {
	Node* node = new Node();
	node->data = data;
	node->next = NULL;
	return node;
}

void insertAtEnd(int data) {
	Node* new_node = create_node(data);
	if(head == NULL) {
		head = new_node;
		return;
	}
	Node* temp = head;
	while(temp->next != NULL) {
		temp = temp->next;
	}
	temp->next = new_node;
	return;
}

void insertAtBeginning(int data) {
	Node* new_node = create_node(data);
	if(head == NULL) {
		head = new_node;
		return;
	}
	new_node->next = head;
	head = new_node;
}

void insertAfter(int data, Node* prev_node) {
	Node* new_node = create_node(data);
	if(prev_node == NULL) return;
	new_node->next = prev_node->next;
	prev_node->next = new_node;
}

void display() {
	Node* temp = head;
	while(temp != NULL) {
		cout<<temp->data<<" ";
		temp = temp->next;
	}
}


void delfirst() {
    if(head == NULL) return;
    Node* temp = head;
    head = head->next;
    delete(temp);
}

void delend() {
    if(head == NULL) return;
    if(head->next == NULL) {
        delete(head);
        return;
    }
    Node* second_last_node = head;
    while(second_last_node->next->next != NULL) {
        second_last_node = second_last_node->next;
    }
    delete(second_last_node->next);
    second_last_node->next = NULL;
    return;
}

void delAt(int position) {
    if(head == NULL) {
        return;
    }
    Node* temp = head;
    if(position == 0) {
        head = head->next;
        delete(temp);
        return;
    }
    for(int i=0;temp != NULL && i < position-1;i++) {
        temp = temp->next;
    }
    if(temp == NULL || temp->next == NULL) {
        return;
    }
    Node* next = temp->next->next;
    free(temp->next);
    temp->next = next;
}

int main() {
	head = NULL;
	insertAtEnd(6);
    insertAtBeginning(7);
    insertAtBeginning(1);
    insertAtEnd(4);
    insertAfter(8,head->next);
    delfirst();
    delend();
    delAt(1);
    display();
}
