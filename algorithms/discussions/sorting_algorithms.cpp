////////////////
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void swap(int *a, int * b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
void selectionSort(int arr[], int size) {
    int i,j;
    for(i=0;i<size;i++) {
        int min_index = i;
        for(j=i+1;j<size;j++) {
            if(arr[j] < arr[min_index]) {
                min_index = j;
            }
        }
        swap(arr[min_index], arr[i]);
    }
}

void bubbleSort(int arr[], int size) {
    int i,j;
    for(i=0;i<size-1;i++) {
        for(j=0;j<size-i-1;j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr[j], arr[j+1]);
            }
        }
    }
}

void countingSort(int arr[], int size) {
    int i,j;
    int max_element = 0;
    for(i=0;i<size;i++) {
        if(arr[i] > max_element) {
            max_element = arr[i];
        }
    }
    int freq[max_element+1];
    for(i=0;i<max_element+1;i++) {
        freq[i] = 0;
    }
    for(i=0;i<size;i++) {
        freq[arr[i]]++;
    }
    for(i=1;i<max_element+1;i++){
        freq[i] += freq[i-1];
    }
    int output[size];

    for(i=size-1;i>=0;i--) {
        output[freq[arr[i]]-1] = arr[i];
        freq[arr[i]]--;
    }
    for(i=0;i<size;i++) {
        arr[i] = output[i];
    }
}

void countingSortForRadix(int arr[], int n, int exp) {
    int output[n];
    int count[10] = {0};
    int i;
    for(i=0;i<n;i++) {
        count[(arr[i]/exp)%10]++;
    }
    for(i=1;i<=9;i++) {
        count[i] += count[i-1];
    }
    for(i=n-1;i>=0;i--) {
        output[count[(arr[i]/exp)%10]-1] = arr[i];
        count[(arr[i]/exp)%10]--;
    }
    for(i=0;i<n;i++) {
        arr[i] = output[i];
    }
}

void radixSort(int arr [], int n) {
    int i;
    int max_element = 0;
    for(i=0;i<n;i++) {
        if(arr[i] > max_element) {
            max_element = arr[i];
        }
    }
    int exp;
    for(exp = 1; max_element/exp > 0; exp *= 10) {
        countingSortForRadix(arr,n,exp);
    }
}

void printArray(int arr[], int size){
    int i;
    for (i=0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main() {
    int arr[] = {64, 25, 12, 22, 11};
    int n = sizeof(arr)/sizeof(arr[0]);
    //countingSort(arr, n);
    int new_arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
    int n1 = sizeof(new_arr)/sizeof(new_arr[0]);
    radixSort(new_arr,n1);
    cout << "Sorted array: \n";
    printArray(new_arr, n1);
    return 0;
}
