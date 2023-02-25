#include <iostream>
#include<bits/stdc++.h>
using namespace std;
vector<int>res;
int detect(int level, long long pos, int guess){
    if(level == 2){
    	res.push_back(pos);
    	res.push_back(guess);
        return guess;
    } else {
    	int new_guess;
        if(pos % 2 == 0){
            if(guess == 1){
                new_guess = 0;
            } else {
                new_guess = 1;
            }
        }
        else if(pos % 2 == 1){
            if(guess == 1){
                new_guess = 1;
            } else {
                new_guess = 0;
            }
        }
        if(pos %2 != 0){
        	pos++;
		}
       return detect(level-1,ceil(pos/2),new_guess);
    }
}
int main() {
	int test;
	cin>>test;
	while(test--){
		res.clear();
	    long long level,pos;
	    cin>>level>>pos;
	    int initial_guess = 1, other = 0;
	    string arr[2] = {"Engineer", "Doctor"};
	    //0 -> engineer, 1 -> doctor
	    int f = detect(level,pos,1);
	    int final_pos = res[0];
	    int final_guess = res[1];
	    cout<<final_pos<<" "<<final_guess<<endl;
 	    if(final_pos == 1){
	    	if(final_guess == 0){
	    		//correctness
	    		cout<<"Doctor"<<endl;
			} else {
				cout<<"Engineer"<<endl;
			}
		}
		else if(final_pos == 2){
	    	if(final_guess == 1){
	    		//correctness
	    		cout<<"Doctor"<<endl;
			} else {
				cout<<"Engineer"<<endl;
			}
		}
	}
	return 0;
}
