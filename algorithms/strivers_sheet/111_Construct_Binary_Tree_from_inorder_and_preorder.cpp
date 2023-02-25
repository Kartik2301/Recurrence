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
    int preIndex = 0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        preIndex = 0;
        return _buildTree(preorder,inorder,0,preorder.size()-1);
    }
    TreeNode* _buildTree(vector<int> & preorder, vector<int> & inorder, int start, int end) {
        if(start > end) return NULL;
        TreeNode *new_node = new TreeNode(preorder[preIndex++],NULL,NULL);
        if(start == end) return new_node;
        int inIndex = search(inorder,new_node->val);
        new_node->left = _buildTree(preorder,inorder,start,inIndex-1);
        new_node->right = _buildTree(preorder,inorder,inIndex+1,end);
        return new_node;
    }
    int search(vector<int> & inorder, int val) {
        int inIndex = -1;
        for(int i=0;i<inorder.size();i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return inIndex;
    }
};

Time complexity :- O(n*n)
Can be reduced to O(n) using a hash map