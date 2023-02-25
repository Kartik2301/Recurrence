Recursive

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(list,root);
        return list;
    }
    public void solve(List<Integer> list, TreeNode root) {
        if(root == null) return;
        solve(list,root.left);
        solve(list,root.right);
        list.add(root.val);
    }
}

Time complexity :- O(n)
Space complexity :- O(n)

Iterative 

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.addFirst(temp.val);
            if(temp.left != null) {
                stack.push(temp.left);
            }
            if(temp.right != null) {
                stack.push(temp.right);
            }
        }
        return list;
    }
}

Time complexity :- O(n)
Space complexity :- O(n)