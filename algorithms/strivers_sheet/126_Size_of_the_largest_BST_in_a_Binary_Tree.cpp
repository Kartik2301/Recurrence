Time complexity :- O(n)

class SubTreeInfo {
    int min;
    int max;
    int size;
    boolean isBST;
    SubTreeInfo(int min, int max, int size, boolean isBST) {
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static SubTreeInfo findLargestBST(Node root) {
        if(root == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        SubTreeInfo left = findLargestBST(root.left);
        SubTreeInfo right = findLargestBST(root.right);
        SubTreeInfo info = null;
        if(left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            info = new SubTreeInfo(
                                  Math.min(root.data,Math.min(left.min,right.min)),
                                  Math.max(root.data,Math.max(left.max,right.max)),
                                  left.size+right.size+1,
                                  true
                                  );
        } else {
            info = new SubTreeInfo(0,0,Math.max(left.size,right.size),false);
        }
        return info;
    }
    static int largestBst(Node root) {
        if(root == null) return 0;
        return findLargestBST(root).size;
    }
    
}



Time complexity :- O(n*n)

#include <iostream>
#include <climits>
using namespace std;
 
// Data structure to store a BST node
struct Node
{
    // stores value of this node
    int data;
 
    // stores left and right child pointer for this node
    Node *left, *right;
 
    // Constructor
    Node(int data)
    {
        this->data = data;
        this->left = this->right = nullptr;
    }
};
 
// Recursive function to calculate the size of a given binary tree
int size(Node* root)
{
    // base case: empty tree has size 0
    if (root == nullptr)
        return 0;
 
    // recursively calculate the size of left and right subtrees and
    // return sum of size of left and right subtrees + 1 (for root node)
    return size(root->left) + 1 + size(root->right);
}
 
// Recursive function to determine if given Binary Tree is a BST or not
// by keeping a valid range (starting from [MIN_VALUE, MAX_VALUE]) and
// keep shrinking it down for each node as we go down recursively
bool isBST(Node* node, int min, int max)
{
    // base case
    if (node == nullptr)
        return true;
 
    // if node's value fall outside valid range
    if (node->data < min || node->data > max)
        return false;
 
    // recursively check left and right subtrees with updated range
    return isBST(node->left, min, node->data) &&
           isBST(node->right, node->data, max);
}
 
// Recursive function to find the size of the largest BST in a given binary tree
int findLargestBST(Node* root)
{
    if (isBST(root, INT_MIN, INT_MAX))
        return size(root);
 
    return max(findLargestBST(root->left), findLargestBST(root->right));
}
 
int main()
{
    /* Construct below binary tree
 
              10
            /    \
           /      \
          15       8
         / \      / \
        /   \    /   \
       12   20  5     2
    */
 
    Node* root = new Node(10);
 
    root->left = new Node(15);
    root->right = new Node(8);
 
    root->left->left = new Node(12);
    root->left->right = new Node(20);
 
    root->right->left = new Node(5);
    root->right->right = new Node(2);
 
    cout << "The size of the largest BST is " << findLargestBST(root);
 
    return 0;
}