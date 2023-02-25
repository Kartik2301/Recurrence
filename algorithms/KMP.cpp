#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void KMP_pattern_match(string text, string pattern, int lps[]){
    int i=0,j=0;
    while(i<text.length()){
        if(pattern[j] == text[i]){
            i++;
            j++;
        } else if(j == pattern.length()){
            cout<<"Pattern found at index: "<<(i-j)<<" in the text";
            j = lps[j-1];
        } else {
            if(j != 0){
                j = lps[j-1];
            } else {
                i++;
            }
        }
    }
}

void pre_process(string text, string pattern){
    //Make lps array
    int lps[pattern.length()];
    int len = 0;
    int i = 1;
    lps[0] = 0;
    while(i<pattern.length()){
        if(pattern[i] == pattern[len]){
            len++;
            lps[i] = len;
            i++;
        } else {
            if(len == 0){
                lps[i] = len;
                i++;
            } else {
                len = lps[len-1];
            }
        }
    }
    KMP_pattern_match(text,pattern,lps);
}
int main(){
    string text = "ABABDABACDABABCABAB";
    string pattern = "ABABCABAB";
    pre_process(text,pattern);
}