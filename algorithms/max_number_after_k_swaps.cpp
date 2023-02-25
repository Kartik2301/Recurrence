#include<bits/stdc++.h>
using namespace std;
void findMaxString(string s, int k, string & max, int current) {
    if(k == 0) return;
    int n = s.length();
    char maxc = s[current];
    for(int j=current+1;j<n;j++) {
        if(maxc < s[j]) {
            maxc = s[j];
        }
    }
    if(maxc != s[current]) {
        k--;
    }
    for(int j=current;j<n;j++) {
        if(s[j] == maxc) {
            swap(s[current], s[j]);
            if(s.compare(max) > 0) {
                max = s;
            }
            findMaxString(s,k,max,current+1);
            swap(s[current], s[j]);
        }
    }
}
int main() {
	int test;
	cin>>test;
	while(test--) {
	    int k;
	    string s;
	    cin>>k;
	    cin>>s;
	    string max = s;
	    findMaxString(s,k,max,0);
	    cout<<max<<endl;
	}
	return 0;
}