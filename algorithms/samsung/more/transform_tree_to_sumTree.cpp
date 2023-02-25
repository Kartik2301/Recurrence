int solve(Node* node) {
    if(node == NULL) {
        return 0;
    }
    int old = node->data;
    int leftSum = solve(node->left);
    int rightSum = solve(node->right);
    node->data = leftSum + rightSum;
    return node->data + old;
}