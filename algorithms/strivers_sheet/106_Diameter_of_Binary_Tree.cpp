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
    int ans = INT_MIN;
    int diameterOfBinaryTree(TreeNode* root) {
        if(root == NULL) return 0;
        ans = INT_MIN;
        solve(root);
        return ans-1;
    }
    int solve(TreeNode *root) {
        if(root == NULL) return 0;
        int left = solve(root->left);
        int right = solve(root->right);
        int temp = max(left,right) + 1;
        int res = max(temp, left+right+1);
        ans = max(ans,res);
        return temp;
    }
};

Time complexity :- O(N)
Space complexity :- O(N)