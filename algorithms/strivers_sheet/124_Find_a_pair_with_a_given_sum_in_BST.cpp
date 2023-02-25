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
    bool findTarget(TreeNode* root, int k) {
        if(root == NULL) return false;
        vector<int> vec;
        inorder(root,vec);
        int low = 0;
        int high = vec.size()-1;
        while(low < high) {
            if(vec[low] + vec[high] == k) {
                return true;
            } else if(vec[low] + vec[high] < k) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
    void inorder(TreeNode* root, vector<int> & vec) {
        if(root == NULL) return;
        inorder(root->left,vec);
        vec.push_back(root->val);
        inorder(root->right,vec);
    }
};

Time complexity :- O(n)
Space complexity :- O(n)