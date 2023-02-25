/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Node> list = new ArrayList<>();
            int size = queue.size();
            while(size-->0) {
                Node temp = queue.poll();
                list.add(temp);
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            for(int i=0;i<list.size()-1;i++) {
                list.get(i).next = list.get(i+1);
            }
            list.get(list.size()-1).next = null;
        }
        return root;
    }
}