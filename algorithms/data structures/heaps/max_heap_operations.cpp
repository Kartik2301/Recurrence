#include<bits/stdc++.h>
using namespace std;
int parent(int i) {
    return (i-1)/2;
}
int left(int i) {
    return 2*i+1;
}
int right(int i) {
    return 2*i+2;
}
int heap_size = 0;
int capacity = 0;
void max_heapify(int i, int harr[]) {
    int largest = i;
    if(left(i) < heap_size && harr[left(i)] > harr[largest]) {
        largest = left(i);
    }
    if(right(i) < heap_size && harr[right(i)] > harr[largest]) {
        largest = right(i);
    }
    if(largest != i) {
        swap(harr[i], harr[largest]);
        max_heapify(largest, harr);
    }
}
void insertKey(int key, int harr[]) {
    if(heap_size == capacity) {
        cout<<"Heap is full"<<endl;
        return;
    }
    heap_size++;
    int i = heap_size-1;
    harr[i] = key;
    while(i != 0 && harr[parent(i)] < harr[i]) {
        swap(harr[parent(i)], harr[i]);
        i = parent(i);
    }
}
int getMax(int harr[]) {
    if(capacity > 0) return harr[0];
    return INT_MAX;
}
void extractMax(int harr[]) {
    if(capacity == 0) {
        cout<<"Heap is empty"<<endl;
        return;
    }
    int root = harr[0];
    harr[0] = harr[heap_size-1];
    heap_size--;
    max_heapify(0, harr);
}
void IncreaseKey(int i, int new_val, int harr[]) {
    harr[i] = new_val;
    while(i != 0 && harr[parent(i)] < harr[i]) {
        swap(harr[parent(i)], harr[i]);
        i = parent(i);
    }
}
void deleteKey(int i, int harr[]) {
    IncreaseKey(i, INT_MAX,harr);
    extractMax(harr);
}
int main() {
    heap_size = 0;
    capacity = 10;
    int harr[capacity];
    insertKey(3,harr);
    insertKey(2,harr);
    deleteKey(1, harr);
    insertKey(15,harr);
    insertKey(5,harr);
    insertKey(4,harr);
    insertKey(45,harr);
    cout<<getMax(harr)<<endl;
    // extractMax(harr);
    for(int i=0;i<heap_size;i++) {
        cout<<harr[i]<<" ";
    }
}