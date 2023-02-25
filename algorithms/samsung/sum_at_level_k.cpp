/*


it was quite simple, the question was similar to , given a level K , you have to find out the sum of data of all the nodes at level K in a binary tree.

it was bit tricky the input is in the form

(P(C()())(C()()))

P is for Parent, C is for child.




if parent has one child : (P(C()())())

if parent has no child : (P()())



Online test consisting of a coding question, which was to be solved in 3 hours.

Given an integer ‘K’ and a tree in string format. We had to print the sum of all elements at Kth level from root.
For example:-

                            0
                          /     \
                       5         7
                    /    \      /   \
                   6       4    1     3
                            \
                             9
Tree was given in the form: (node value(left subtree)(right subtree))
For tree given above: (0(5(6()())(4()(9()())))(7(1()())(3()())))
Input format: K Tree
Output format: Sum
For example, for given tree:
Input: 2 (0(5(6()())(4()(9()())))(7(1()())(3()())))
Output: 14



*/

#include<iostream>
using namespace std;

int solve(char s[], int k) {
	int ans = 0;
	int i = 0;
	int level = -1;
	while(s[i] != '\0') {
		if(s[i] == '(') {
			level++;
		} else if(s[i] == ')') {
			level--;
		} else if(level == k) {
			ans += (s[i] - 48);
		}
		i++;
	}
	return ans;
}

int main() {
	int test;
	cin>>test;
	while(test--) {
		char s[100];
		cin>>s;
		int k;
		cin>>k;
		cout<<solve(s,k)<<endl;
	}
}
