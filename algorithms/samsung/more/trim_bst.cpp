/*

The function accepts a pointer to the root of a BST along with the two integer values ‘minValue’ and ‘maxValue’. The function was to trim the BST such that all the data in the trimmed BST are between minValue and maxValue(both inclusive).


*/


node* removeOutsideRange(node* root, int min, int max) {
    if(root == NULL) return NULL;
    root->left = removeOutsideRange(root->left,min,max);
    root->right = removeOutsideRange(root->right,min,max);
    if(root->key < min) {
    	node* rright = root->right;
    	delete root;
    	return rright;
    }
    if(root->key > max) {
    	node* lleft = root->left;
    	delete root;
    	return lleft;
    }
    return root;
}