#include<iostream>
#include<bits/stdc++.h>
using namespace std;
class BST {
public:
    BST *left, *right;
    int data;
};

BST* create(int data) {
    BST* new_node = new BST();
    new_node->data = data;
    new_node->left = new_node->right = NULL;
    return new_node;
}
BST* _insert(BST *root, int data) {
    if(root == NULL) {
        return create(data);
    } else if(data > root->data) {
        root->right = _insert(root->right,data);
    } else {
        root->left = _insert(root->left,data);
    }
    return root;
}
bool _search(BST *root, int data) {
    if(root == NULL || root->data == data) {
        return true;
    }
    if(data > root->data) {
        return _search(root->right,data);
    }
    return _search(root->left,data);
}
void inorder(BST* root) {
    if(root == NULL) return;
    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}

BST* minValue(BST * node) {
    BST* current = node;
    while(current->left != NULL) {
        current = current->left;
    }
    return current;
}

BST* deletenode(BST * root, int data) {
    if(root == NULL) return root;
    if(data < root->data) {
        root->left = deletenode(root->left,data);
    }
    else if(data > root->data) {
        root->right = deletenode(root->right,data);
    } else {
        if(root->left == NULL) {
            BST* temp = root->right;
            free(root);
            return temp;
        } else if(root->right == NULL) {
            BST* temp = root->left;
            free(root);
            return temp;
        }
        BST* temp = minValue(root->right);
        root->data = temp->data;
        root->right = deletenode(root->right,temp->data);
    }
    return root;
}
int main(){
    BST *root = NULL;
    root = _insert(root,30);
    root = _insert(root,24);
    root = _insert(root,105);
    root = _insert(root,90);
    root = _insert(root,50);
    inorder(root);
    root = deletenode(root,90);
    cout<<"\n";
    inorder(root);
    cout<<"\n";
    cout<<boolalpha<<_search(root,90)<<endl;
}
