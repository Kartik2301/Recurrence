class GfG
{
    Node head = null;
    static Node prev = null;
    void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        if(prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        inorder(root.right);
    }
    Node bToDLL(Node root) {
        head = null;
        prev = null;
	//  Your code here	
	    inorder(root);
	    return head;
    }
}