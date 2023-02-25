bool representsBST(int pre[], int n) {
	int i;
	int root = INT_MIN;
	stack<int> s;
	for(i=0;i<n;i++) {
		if(pre[i] < root) {
			return false;
		}
		while(!s.empty() && s.top() < pre[i]) {
			root = s.top();
			s.pop();
		}
		s.push(pre[i]);
	}
	return true;
}



