#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void merge(int arr[], int l, int m, int r) {
    int i,j,k;
    int n1 = m - l + 1;
    int n2 = r - m;
    int L[n1];
    int R[n2];
    for(i=0;i<n1;i++) {
        L[i] = arr[l+i];
    }
    for(j=0;j<n2;j++) {
        R[j] = arr[m+1+j];
    }
    i = 0;
    j = 0;
    k = l;
    while(i < n1 && j < n2) {
        if(L[i] <= R[j]) {
            arr[k] = L[i];
            k++;
            i++;
        } else {
            arr[k] = R[j];
            k++;
            j++;
        }
    }
    while(i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    while(j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }

}
void mergesort(int arr[], int l, int r) {
    if(l < r) {
        int mid = l + (r - l)/2;
        mergesort(arr,l,mid);
        mergesort(arr,mid+1,r);

        merge(arr,l,mid,r);
    }
}
int main() {
    int arr[] = {5,1,8,2,6,1,0,3};
    int n = sizeof(arr)/sizeof(arr[0]);
    mergesort(arr,0,n-1);
    int i;
    for(i=0;i<n;i++) {
        cout<<arr[i]<<" ";
    }
}
