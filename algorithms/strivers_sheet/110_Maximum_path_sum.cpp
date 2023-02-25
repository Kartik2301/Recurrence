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
    int res = INT_MIN;
    int maxPathSum(TreeNode* root) {
        res = INT_MIN;
        solve(root);
        return res;
    }
    int solve(TreeNode * root) {
        if(root == NULL) return 0;
        int left = solve(root->left);
        int right = solve(root->right);
        int temp = max(left,right) + root->val;
        temp = max(temp, root->val);
        int ans = max(temp, left+right+root->val);
        res = max(res, ans);
        return temp;
    }
};