Solution 1 :-

Use KMPs lps array

#include<bits/stdc++.h>
using namespace std;

int main() {
    string s;
    cin>>s;
    int size = s.length();
    string copy = s;
    reverse(copy.begin(), copy.end());
    s += ("$"+copy);
    cout<<s<<endl;
    vector<int> lps(s.length(),0);
    int i = 1;
    int len = 0;
    while(i < s.length()) {
        if(s[i] == s[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if(len == 0) {
                lps[i] = len;
                i++;
            } else {
                len = lps[len-1];
            }
        }
    }
    cout<<"min insertions "<<size-lps.back()<<endl;
}

Time complexity :- O(n)
Space complexity :- O(n)

Solution 2 :-
Brute force 
Start checking the string each time if it is a palindrome and if not, then delete the last character and check again. 
When the string gets reduced to wither a palindrome or empty then the number of characters deleted from the end till 
now will be the answer as those characters could have been inserted at the beginning of the original string in the order 
which will will make the string a palindrome.

Time complexity :- O(n*n)
Space complexity :- O(1)