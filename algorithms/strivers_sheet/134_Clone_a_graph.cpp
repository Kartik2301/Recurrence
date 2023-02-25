/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Integer,Node> map = new HashMap<>();
        return cloneGraph(node,map);
    }
    public Node cloneGraph(Node root, HashMap<Integer,Node> map) {
        if(root == null) return null;
        if(map.containsKey(root.val)) return map.get(root.val);
        Node new_node = new Node(root.val);
        map.put(root.val,new_node);
        for(Node neigbors : root.neighbors) {
            new_node.neighbors.add(cloneGraph(neigbors,map));
        }
        return new_node;
    }
}