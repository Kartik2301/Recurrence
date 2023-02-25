/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "null,";
        }
        String leftPart = serialize(root.left);
        String rightPart = serialize(root.right);
        return root.val + "," + leftPart + rightPart;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    public TreeNode deserializeHelper(Queue<String> queue) {
        String s = queue.poll();
        if(s.equals("null")) return null;
        TreeNode new_node = new TreeNode(Integer.parseInt(s));
        new_node.left = deserializeHelper(queue);
        new_node.right = deserializeHelper(queue);
        return new_node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));