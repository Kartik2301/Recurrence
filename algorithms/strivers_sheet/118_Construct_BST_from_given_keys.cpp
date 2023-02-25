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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    public TreeNode buildTree(int [] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if(start == end) return node;
        node.left = buildTree(nums,start,mid-1);
        node.right = buildTree(nums,mid+1,end);
        return node;
    }
}