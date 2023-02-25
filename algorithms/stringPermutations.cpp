#include<iostream>
using namespace std;
void printPermutations(string str, char res[], int count[], int level){
    if(level == str.length()){
        int i;
        for(i=0;i<str.length();i++){
            if(i == str.length() -1){
                cout<<res[i];
            } else {
                cout<<res[i]<<", ";
            }
        }
        cout<<"\n";
        return;
    } else {
        for(int index = 0; index<str.length();index++){
            if(count[index] == 0){
                continue;
            } else {
                res[level] = str[index];
                count[index]--;
                printPermutations(str,res,count,level+1);
                count[index]++;
            }
        }
    }
}
int main(){
    string str = "abc";
    char res[str.length()];
    int count[str.length()];
    int i;
    for(i=0;i<str.length();i++){
        count[i] = 1;
    }
    printPermutations(str,res,count,0);
}