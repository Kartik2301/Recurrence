1. atoi 
class Solution {
    public int myAtoi(String s) {
        boolean isNegative = false;
        int i=0;
        while(i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if(i == s.length()) return 0;
        if(s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if(s.charAt(i) == '+') {
            i++;
        }
        long base = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if(base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && s.charAt(i) > '7')) {
                if(isNegative == true) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            base = base*10 + (s.charAt(i) - 48);
            i++;
        }
        if(isNegative) return (int)-1*(int)base;
        return (int) base;
    }
}


2. strstr

a. Using KMP

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length() == 0) return 0;
        vector<int> lps = generate_prefix_arr(needle);
        return search(haystack,needle,lps);
    }
    int search(string text, string pattern, vector<int> & lps) {
        int i = 0;
        int j = 0;
        while(i < text.length() && j < pattern.length()) {
            if(text[i] == pattern[j]) {
                i++;
                j++;
            } 
            if(j == pattern.length()) {
                return i-j;
            } else if(i < text.length() && text[i] != pattern[j]) {
                if(j == 0) i++;
                else j = lps[j-1];
            }
        }
        return -1;
    }
    vector<int> generate_prefix_arr(string s) {
        int len = 0;
        vector<int> lps(s.length());
        lps[0] = 0;
        int i = 1;
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
        return lps;
    }
};

Time complexity :- O(m+n)
Space complexity :- O(n)

b. Using Rabin Karp

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

Time complexity :- O(m+n)
Space complexity :- O(1)

c. Z or Prefix algorithm

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

Time complexity :- O(m+n)
Space complexity :- O(m+n)


Other brute force solutions

Time complexity :- O(mn)
Space complexity :- O(1)