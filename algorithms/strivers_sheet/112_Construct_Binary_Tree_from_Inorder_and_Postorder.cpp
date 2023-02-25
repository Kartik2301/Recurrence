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
    int postIndex = 0;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        postIndex = inorder.size()-1;
        return _buildTree(inorder,postorder,0,postIndex);
    }
    TreeNode* _buildTree(vector<int> & inorder, vector<int> & postorder, int start, int end) {
        if(start > end) return NULL;
        TreeNode* new_node = new TreeNode(postorder[postIndex--]);
        if(start == end) return new_node;
        int inIndex = 0;
        for(int i=0;i<inorder.size();i++) {
            if(inorder[i] == new_node->val) {
                inIndex = i;
                break;
            }
        }
        
        new_node->right = _buildTree(inorder,postorder,inIndex+1,end);
        new_node->left = _buildTree(inorder,postorder,start,inIndex-1);
        return new_node;
    }
};

Time complexity :- O(n*n) can be reduced to O(n) using hash map