void topView(struct Node *root)
{
    //Your code here
       queue<pair<Node*,int>> q;
       q.push({root,0});
       map<int,int> freq;
       vector<int> vec;
       while(!q.empty()) {
           int size = q.size();
           while(size--) {
               Node* temp = q.front().first;
               int hd = q.front().second;
               if(freq[hd] == 0) freq[hd] = temp->data;
               q.pop();
               if(temp->left != NULL) {
                   q.push({temp->left,hd-1});
               }
               if(temp->right != NULL) {
                   q.push({temp->right,hd+1});
               }
           }
       }
       for(auto it: freq) {
           cout<<it.second<<" ";
       }
}