#include<iostream>
#include<bits/stdc++.h>
using namespace std;
string convertToString(int a, int b) {
    string returnValue = to_string(a) + " " + to_string(b);
    return returnValue;
}
string target = "";
int water_jug_problem(int m, int n, int req, unordered_map<string,string> & parent) {
	queue<pair<int,int>> q;
    target = "";
    vector<vector<bool>> visited(m+1, vector<bool> (n+1, false));
	q.push({0,0});
    string temporal = convertToString(0,0);
    parent[temporal] = temporal;
	while(!q.empty()) {
		int size = q.size();
		for(int i=0;i<size;i++) {
			int l = q.front().first;
			int r = q.front().second;
            q.pop();
			if(l == req || r == req) {
                target = convertToString(l,r);
				return true;
			}
			if(l >= 0 && r >= 0 && l <=  m && r <= n && !visited[l][r]) {
                string precompute = convertToString(l,r);
				//Possible actions
				// 1. Empty jug1
				// 2. Empty jug2
				// 3. Fully fill jug1
				// 4. Fully fill jug2
				// 5. Transfer process
				visited[l][r] = true;
				q.push({0,r});
                if(parent.find(convertToString(0,r)) == parent.end()) {
                    parent[convertToString(0,r)] = precompute;
                }
                
				q.push({l,0});
                if(parent.find(convertToString(l,0)) == parent.end()) {
                    parent[convertToString(l,0)] = precompute;
                }
				q.push({m,r});
                if(parent.find(convertToString(m,r)) == parent.end()) {
                    parent[convertToString(m,r)] = precompute;
                }
				q.push({l,n});
                if(parent.find(convertToString(l,n)) == parent.end()) {
                    parent[convertToString(l,n)] = precompute;
                }
				// Transfer from jug2 to jug1, stop when either jug1 is full or jug2 is empty
				int a = l;
				int b = r;
				int to_make_jug1_full = m - l;
				int to_make_jug2_empty = r;
				if(to_make_jug1_full >= to_make_jug2_empty) {
                    if(parent.find(convertToString(l+to_make_jug2_empty,0)) == parent.end()) {
                        parent[convertToString(l+to_make_jug2_empty,0)] = precompute;
                    }
					q.push({l+to_make_jug2_empty,0});
				} else {
                    if(parent.find(convertToString(m,r - to_make_jug1_full)) == parent.end()) {
                        parent[convertToString(m,r - to_make_jug1_full)] = precompute;
                    }
					q.push({m,r - to_make_jug1_full});
				}
				// Transfer from jug1 to jug2, stop when either jug2 is full or jug1 is empty
				int to_make_jug1_empty = l;
				int to_make_jug2_full = n - r;
				if(to_make_jug2_full >= to_make_jug1_empty) {
                    if(parent.find(convertToString(0,r+to_make_jug1_empty)) == parent.end()) {
                        parent[convertToString(0,r+to_make_jug1_empty)] = precompute;
                    }
					q.push({0,r+to_make_jug1_empty});
				} else {
                    if(parent.find(convertToString(l - to_make_jug2_full,n)) == parent.end()) {
                        parent[convertToString(l - to_make_jug2_full,n)] = precompute;
                    }
					q.push({l - to_make_jug2_full,n});
				}
			}
		}
	}
	return false;
}
int main() {
	int m = 4; //capacity of first jug
	int n = 3; //capacity of second jug
	int required_measure = 2;
    unordered_map<string,string> parent;
	bool ans = water_jug_problem(m,n,required_measure,parent);
    
    if(ans) {
        vector<string> result;
        cout<<"SOLUTION FOUND"<<endl;
        cout<<"Path :-"<<endl;
        while(target.compare(parent[target]) != 0) {
            result.push_back(target);
            target = parent[target];
        }
        result.push_back(target);
        for(int i=result.size()-1;i>=0;i--) {
            cout<<result[i]<<endl;
        }
    } else {
        cout<<"NO POSSIBLE SOLUTION"<<endl;
    }
}