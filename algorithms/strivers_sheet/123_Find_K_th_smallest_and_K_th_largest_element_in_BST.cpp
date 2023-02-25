/*Complete the function below

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
void inorder(vector<int> & vec, Node * root) {
    if(root == NULL) return;
    inorder(vec,root->left);
    vec.push_back(root->data);
    inorder(vec,root->right);
}
// Return the Kth smallest element in the given BST 
int KthSmallestElement(Node *root, int K)
{
    //add code here.
    vector<int> vec;
    inorder(vec,root);
    if(K > vec.size()) return -1;
    if(K <= 0) return -1;
    return vec[K-1];
}