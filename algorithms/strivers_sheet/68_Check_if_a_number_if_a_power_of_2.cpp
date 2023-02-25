Using bitwise operators

Time complexity :- O(1)
Space complexity :- O(1)

#include<bits/stdc++.h>
using namespace std;
bool check(int x) {
	if(x <= 0) return false;
    return (x && !(x & (x-1)));
}
int main() {
    int n;
    cin>>n;
    cout<<boolalpha<<check(n)<<endl;
}