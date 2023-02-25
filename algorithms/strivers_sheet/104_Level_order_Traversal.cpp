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
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<vector<int>> vec;
        if(root == NULL) return vec;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            vector<int> temp;
            while(size--) {
                TreeNode *node = q.front();
                q.pop();
                temp.push_back(node->val);
                if(node->left != NULL) {
                    q.push(node->left);
                }
                if(node->right != NULL) {
                    q.push(node->right);
                }
            }
            vec.push_back(temp);
        }
        return vec;
    }
};