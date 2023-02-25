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
void min_heapify(int i, int harr[], int n) {
    int smallest = i;
    int l = left(i);
    int r = right(i);
    if(l < n && harr[l] < harr[smallest]) {
        smallest = l;
    }
    if(r < n && harr[r] < harr[smallest]) {
        smallest = r;
    }
    if(smallest != i) {
        swap(harr[smallest], harr[i]);
        min_heapify(smallest, harr,n);
    }
}
int main() {
     int harr[] = { 1, 3, 5, 4, 6, 13, 10,
                      9, 8, 15, 17 };
    int i;
    int n = 11;
    for(i=n/2-1;i>=0;i--) {
        min_heapify(i,harr,n);
    }
    for(i=0;i<n;i++) {
        cout<<harr[i]<<" ";
    }
}