/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root == NULL) return true;
        return isSymmetric(root->left,root->right);
    }
    bool isSymmetric(TreeNode * leftSubTree, TreeNode * rightSubTree) {
        if(leftSubTree == NULL && rightSubTree == NULL) return true;
        if(leftSubTree == NULL || rightSubTree == NULL) return false;
        if(leftSubTree->val != rightSubTree->val) return false;
        return isSymmetric(leftSubTree->left, rightSubTree->right) && isSymmetric(leftSubTree->right, rightSubTree->left);
    }
};

ime complexity : O(n). Because we traverse the entire input tree once, 
the total run time is O(n), where nn is the total number of nodes in the tree.

Space complexity : The number of recursive calls is bound by the height of the tree. 
In the worst case, the tree is linear and the height is in O(n). 
Therefore, space complexity due to recursive calls on the stack is 
O(n) in the worst case.