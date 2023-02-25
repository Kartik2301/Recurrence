Z algorithm

#include<bits/stdc++.h>
using namespace std;
vector<int> compute_z(string str) {
    vector<int> Z (str.size());
    Z[0] = 0;
    int left = 0;
    int right = 0;
    for(int k=1;k<str.length();k++) {
        if(k > right) {
            left = k;
            right = k;
            while(right < str.length() && str[right] == str[right-left]) {
                right++;
            }
            Z[k] = right - left;
            right--;
        } else {
            int k1 = k-left;
            if(Z[k1] + k <= right) {
                Z[k] = Z[k1];
            } else {
                int left = k;
                while(right < str.length() && str[right] == str[right-left]) {
                    right++;
                }
                Z[k] = right - left;
                right--;
            }
        }
    }
    return Z;
}
int main() {
    string text = "GEEKS FOR GEEKS"; 
    string pattern = "GEEK"; 
    string str = pattern + "$" + text;
    vector<int> Z = compute_z(str);
    for(int i=pattern.length()+1;i<str.length();i++) {
        if(Z[i] == pattern.length()) {
            cout<<i-pattern.length()-1<<endl;
        }
    }
}

Time complexity :- O(n)
Space complexity :- O(n)
