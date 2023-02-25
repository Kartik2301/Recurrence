/* Problem solved for standard case with a 3*3 puzzle board, with a given start point and a definite (constant) goal to achieve. */

/* Empty space is denoted by 0, in this case it has co-ordinates of (1,2) */
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
string target = "";
string convertToString(vector<vector<int>> & vec) {
    string s = "";
    for(int outer=0;outer<3;outer++) {
        for(int inner=0;inner<3;inner++) {
            s += (to_string(vec[outer][inner]) + ".");
        }
    }
    return s;
}
bool puzzle_8_puzzle(unordered_map<string,string> & parent) {
    parent.clear();
    vector<vector<int>> vec(3, vector<int>(3));
    target = "";
    // start point
    vec[0][0] = 1;
    vec[0][1] = 2;
    vec[0][2] = 3;
    vec[1][0] = 5;
    vec[1][1] = 6;
    vec[1][2] = 0;
    vec[2][0] = 7;
    vec[2][1] = 8;
    vec[2][2] = 4;
    // goal
    vector<vector<int>> goal(3, vector<int>(3));
    goal[0][0] = 1;
    goal[0][1] = 2;
    goal[0][2] = 3;
    goal[1][0] = 5;
    goal[1][1] = 8;
    goal[1][2] = 6;
    goal[2][0] = 0;
    goal[2][1] = 7;
    goal[2][2] = 4;
    int level = 1;
    queue<pair<pair<int,int>,vector<vector<int>>>> q;
    q.push(make_pair(make_pair(1,2), vec));
    int rowMoves [] = {0,0,-1,1};
    int colMoves[] = {1,-1,0,0};
    unordered_map<string,bool> visited;
    string stateController = "";
    stateController = convertToString(vec);
    target = convertToString(goal);

    parent[stateController] = stateController;
    int count = 0;
    while(!q.empty()) {
        int size = q.size();
        for(int i=0;i<size;i++) {
            int l = q.front().first.first;
            int r = q.front().first.second;
            vector<vector<int>> currentPuzzle;
            currentPuzzle.insert(currentPuzzle.end(),q.front().second.begin(),q.front().second.end());
            q.pop();
            string stateController1 = "";
            stateController1 = convertToString(currentPuzzle);
        
            if(stateController1.compare(target) == 0) {
                return true;
            }
            if(l >= 0 && r >= 0 && l < 3 && r < 3 && (visited.find(stateController1) == visited.end())) {
                count++;
                visited[stateController1] = true;
                for(int index=0;index<4;index++) {
                    int newX = l + rowMoves[index];
                    int newY = r + colMoves[index];
                    vector<vector<int>> temp;
                    temp.insert(temp.end(),currentPuzzle.begin(),currentPuzzle.end());
                    if(newX >= 0 && newY >= 0 && newX < 3 && newY < 3) {
                        swap(temp[newX][newY], temp[l][r]);
                        string org = "";
                        org = convertToString(temp);

                        if(visited.find(org) == visited.end()) {
                            q.push(make_pair(make_pair(newX,newY),temp));
                            parent[org] = stateController1;
                        }

                    } 
                }
            }
        }
    level++;
    }
    return false;
}
int compare(vector<vector<int>> & a, vector<vector<int>> & b) {
    int i,j;
    for(i=0;i<a.size();i++) {
        for(j=0;j<a[0].size();j++) {
            if(a[i][j] != b[i][j]) {
                return false;
            }
        }
    }
    return true;
}
void convertTo2D(string s) {
    int i;
    int count = 0;
    for(i=0;i<s.length();i++) {
        if(s[i] == '.') {
            count++;
            if(count == 3) {
                count = 0;
                cout<<"\n";
            } 
        } else {
            cout<<s[i]<<" ";
        }
    }
}
int main() {
    unordered_map<string,string> parent;
    bool foundOrNot = puzzle_8_puzzle(parent);
    
    if(foundOrNot) {
        cout<<"Target Found"<<endl;
        cout<<"Path to the target :-"<<endl;
        cout<<"\n";
        vector<string> result;
        while(target.compare(parent[target]) != 0) {
            result.push_back(target);
            target = parent[target];
        }
        result.push_back(target);
        for(int i=result.size()-1;i>=0;i--) {
             convertTo2D(result[i]);
            cout<<"\n";
        }
    } else {
        cout<<"Target Not found" <<endl;
    }
}