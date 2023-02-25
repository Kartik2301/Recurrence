#include<bits/stdc++.h>
# define ll long long
using namespace std;
int prime = 3;
ll calculate_hash(string str, int n) {
    ll result = 0;
    int i;
    for(i=0;i<n;i++) {
        result += (ll)(str[i]*(ll)pow(prime,i));
    }
    return result;
}
ll recalculate_hash(string str, int oldIndex, int newIndex, ll oldHash, int patLength) {
    ll newHash = oldHash - str[oldIndex];
    newHash /= prime;
    newHash += (ll) (str[newIndex]*(ll)pow(prime,patLength-1));
    return newHash;
}
bool checkEqual(string str1, string str2, int start1, int end1, int start2, int end2) {
    if((end1 - start1) != (end2 - start2)) return false;
    while(start1 <= end1 && start2 <= end2) {
        if(str1[start1] != str2[start2]) return false;
        start1++;
        start2++;
    }
    return true;
}
int main() {
    string str = "ababcabdabd";
    string pat = "abd";
    ll patHash = calculate_hash(pat,pat.length());
    ll strHash = calculate_hash(str,pat.length());
    int i;
    for(i=0;i+pat.length() <= str.length(); i++) {
        if(patHash == strHash && checkEqual(str,pat,i,i+pat.length()-1,0,pat.length()-1)) {
            cout<<i<<endl;
            return 0;
        }
        if(i + pat.length() < str.length()) {
            strHash = recalculate_hash(str,i,i+pat.length(),strHash,pat.length());
        }
    }
    return 0;
}


Another possible hash function (more suitable for extremely large strings)

class Solution {
public:
    int strStr(string haystack, string needle) {
        int N = haystack.length();
        int M = needle.length();
        if(M == 0) return 0;
        int d = 31;
        int q = 15486703;
        long long p = 0, h = 1, t = 0;
        int i;
        for(i=0;i<M-1;i++) {
            h = (h*d) % q;
        }
        for(i=0;i<M;i++) {
            p = (d*p + needle[i])%q;
            t = (d*t + haystack[i])%q;
        }
        for(i=0;i<=N-M;i++){
            if(p == t) {
                int j;
                for(j=0;j<M;j++) {
                    if(haystack[i+j] != needle[j]) {
                        break;
                    }
                }
                if(j == M) return i;
            }
            if(i < N-M) {
                t = (d*(t - haystack[i]*h) + haystack[i+M])%q;
                if(t < 0) t += q;
            }
        }
        return -1;
    }
};

Time comlexity :- O(m+n)
Space comlexity :- O(1)