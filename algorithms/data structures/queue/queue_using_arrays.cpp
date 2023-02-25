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