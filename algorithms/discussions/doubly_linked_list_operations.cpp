#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class Node {
public:
	int data;
	Node* next;
	Node* prev;
};

Node* head;

void insBeg(int data) {
	Node* new_node = new Node();
	new_node->data = data;
	new_node->next = head;
	new_node->prev = NULL;
	if(head != NULL) {
		head->prev = new_node;
	}
	head = new_node;
}


void insEnd(int data){
	Node* new_node = new Node();
	Node* temp = head;
	new_node->data = data;
	new_node->next = NULL;
	if(head == NULL) {
		new_node->prev = NULL;
		head = new_node;
		return;
	}
	while(temp->next != NULL) {
		temp = temp->next;
	}
	temp->next = new_node;
	new_node->prev = temp;
	return;
}


void insertAfter(Node* prev_node, int data) {
	if(prev_node == NULL) {
		return;
	}
	Node* new_node = new Node();
	new_node->data = data;
	new_node->next = prev_node->next;
	prev_node->next = new_node;
	new_node->prev = prev_node;
	if(new_node->next != NULL) {
		new_node->next->prev = new_node;
	}
	return;
}

void insertBefore(Node* next_node, int data) {
    if(next_node == NULL) {
        return;
    }
    Node* new_node = new Node();
    new_node->data = data;
    new_node->prev = next_node->prev;
    next_node->prev = new_node;
    new_node->next = next_node;
    if(new_node->prev != NULL) {
        new_node->prev->next = new_node;
    } else {
        head = new_node;
    }
}

void delNode(Node* del) {
    if(del == NULL || head == NULL) return;
    if(head == del) {
        head = head->next;
    }
    if(del->next != NULL) {
        del->next->prev = del->prev;
    }
    if(del->prev != NULL) {
        del->prev->next = del->next;
    }
    delete(del);
    return;
}


void printList() {
	Node* forward = head;
	Node* backward;
	while(forward != NULL) {
		backward = forward;
		cout<<forward->data<<" ";
		forward = forward->next;
	}
    cout<<"\n";
	while(backward != NULL) {
		cout<<backward->data<<" ";
		backward = backward->prev;
	}
}

int main() {
	head = NULL;
	insEnd(6);
    insBeg(7);
    insBeg(1);
    insEnd(4);
    insertAfter(head->next, 8);
    insertBefore(head->next->next,42);
    delNode(head->next->next);
    printList();
}
