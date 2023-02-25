Iterative solution

void leftView(Node root) {
    if(root == null) return;
  // Your code here
  Queue<Node> q = new LinkedList<>();
  q.add(root);
  while(!q.isEmpty()){
      int size = q.size();
      for(int i=0;i<size;i++) {
          Node temp = q.poll();
          if(i == 0) {
              System.out.print(temp.data + " ");
          }
          if(temp.left != null) {
              q.add(temp.left);
          }
          if(temp.right != null) {
              q.add(temp.right);
          }
      }
  }
}

Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n). 
Auxiliary Space: O(n), due to the stack space during recursive call.  

Recursive solution

void solve(Node *root, vector<int> & vec, int level, int & max_level) {
    if(root == NULL) return;
    if(level > max_level) {
        vec.push_back(root->data);
        max_level = level;
    }
    solve(root->left,vec,level+1,max_level);
    solve(root->right,vec,level+1,max_level);
}