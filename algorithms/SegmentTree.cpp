#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void buildTree(int arr[], vector<int> & tree, int start, int end, int treeNode) {
	if(start == end) {
		tree[treeNode] = arr[start];
		return;
	}
	int mid = (start + end)/2;
	buildTree(arr,tree,start,mid,2*treeNode+1);
	buildTree(arr,tree,mid+1,end,2*treeNode+2);
	tree[treeNode] = tree[2*treeNode+1] + tree[2*treeNode + 2];
}
int getSumUtil(vector<int> & tree, int arr[], int query_start, int query_end, int n, int start, int end, int treeNode) {
	if(query_start <= start && query_end >= end) {
		return tree[treeNode];
	}
	if(end < query_start || start > query_end) {
		return 0;
	}
	int mid = (start) + (end - start)/2;
	return getSumUtil(tree,arr,query_start,query_end,n,start,mid,2*treeNode+1) + 
	getSumUtil(tree,arr,query_start,query_end,n,mid+1,end,2*treeNode+2);
}
int getSum(vector<int> & tree, int arr[], int start , int end, int n) {
	if(start < 0 || end > n || start > end) {
		return -1;
	}
	return getSumUtil(tree,arr,start,end,n,0,n-1,0);
}
void updateValueUtils(vector<int> & tree, int arr[], int diff, int start, int end, int treeNode, int i) {
	if(i < start || i > end) {
		return;
	}
	tree[treeNode] = tree[treeNode] + diff;
	if(start != end) {
		int mid = (start) + (end - start)/2;
		updateValueUtils(tree,arr,diff,start,mid,2*treeNode+1,i);
		updateValueUtils(tree,arr,diff,mid+1,end,2*treeNode+2,i);
	}
}
void updateValue(vector<int> & tree, int arr[], int i, int value, int n) {
	if(i < 0 || i > n-1) {
		return;
	}
	int diff = value - arr[i];
	arr[i] = value;
	updateValueUtils(tree,arr,diff,0,n-1,0,i);
}
int main() {
	int arr[] = {1,2,3,4,5,6,7,8,9};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x = (int) (ceil(log2(n)));
	int max_size = 2*(int)pow(2,x) - 1;
	vector<int>tree;
	tree.resize(max_size);
	
	buildTree(arr,tree,0,n-1,0);
	int i;
	cout<<getSum(tree,arr,1,3,n)<<endl;
	updateValue(tree,arr,1,10,n);
	cout<<getSum(tree,arr,1,3,n);
}