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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(list,root);
        return list;
    }
    public void solve(List<Integer> list, TreeNode root) {
        if(root == null) return;
        solve(list,root.left);
        list.add(root.val);
        solve(list,root.right);
    }
}


Time complexity : O(n). 
The time complexity is O(n) because the recursive function is T(n) = 2*T(n/2)+1.

Space complexity : The worst case space required is O(n), and in the average case its O(logn) where n is number of nodes.


Iterative

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        TreeNode cur = root;
        while(cur != null || ! stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

Time complexity : O(n)

Space complexity : O(n).