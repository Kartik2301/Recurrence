/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

Recursive 

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(list,root);
        return list;
    }
    public void solve(List<Integer> list, TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        solve(list,root.left);
        solve(list,root.right);
    }
}

Iterative 

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null) {
                stack.add(temp.right);
            }
            if(temp.left != null) {
                stack.add(temp.left);
            }
        }
        return list;
    }
}

Time complexity :- O(n)
Space complexity :- O(n)