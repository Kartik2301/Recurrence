#include<iostream>
#include<bits/stdc++.h>
#include<limits.h>
using namespace std;
void buildTree(vector<int> & tree, int arr[], int start, int end, int treeNode) {
	if(start == end) {
		tree[treeNode] = arr[start];
		return;
	}
	int mid = (start) + (end - start)/2;
	buildTree(tree,arr,start,mid,2*treeNode+1);
	buildTree(tree,arr,mid+1,end,2*treeNode+2);
	tree[treeNode] = min(tree[2*treeNode+1] , tree[2*treeNode+2]);
}
int getMinUtil(vector<int> & tree, int arr[], int start, int end, int query_start, int query_end, int treeNode) {
	if(query_start <= start && query_end >= end) {
		return tree[treeNode];
	}
	if(end < query_start || start > query_end) {
		return INT_MAX;
	}
	int mid = (start) + (end - start)/2;
	return min(getMinUtil(tree,arr,start,mid,query_start,query_end,2*treeNode+1), getMinUtil(tree,arr,mid+1,end,query_start,query_end,2*treeNode+2));
}
int getMin(vector<int> & tree, int arr[], int start, int end, int n) {
	if(start < 0 || end > n-1 || start > end) {
		return -1;
	}
	getMinUtil(tree,arr,0,n-1,start,end,0);
}
int main() {
	vector<int>tree;
	int arr[] = {1, 3, 2, 7, 9, 11};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x = (int)(ceil(log2(n)));
	int max_size = 2*(int) pow(2,x) - 1;
	tree.resize(max_size);
	buildTree(tree,arr,0,n-1,0);
	cout<<getMin(tree,arr,1,3,n)<<endl;
}