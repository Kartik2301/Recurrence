#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main() {
	int num = 3;
	int space;
	int i,j;
	int lterm = 1;
	int rterm = num*num + 1;
	for(int i=num;i>0;i--) {
		for(space=num;space>i;space--) {
			cout<<" ";
		}
		for(j=1;j<=i;j++) {
			cout<<lterm;
			cout<<"*";
			lterm++;
		}
		for(j=1;j<=i;j++) {
			cout<<rterm;
			if(j < i) {
				cout<<"*";
			}
			rterm++;
		}
		rterm = rterm - (i-1)*2 - 1;
		cout<<"\n";
	}
}