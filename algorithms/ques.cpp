#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int max_h = 0;
int findDist(unordered_map<int,vector<vector<int>>> & floors, int f1, int x1, int y1, int f2, int x2, int y2) {
	queue<pair<int,pair<int,pair<int,int>>>> q;
	q.push({f1,{x1,{y1,0}}});
	while(!q.empty()) {
		int size = q.size();
		for(int i=0;i<size;i++) {
			int f = q.front().first;
			int x = q.front().second.first;
			int y = q.front().second.second.first;
			int cost = q.front().second.second.second;
			if(f == f2 && x == x2 && y == y2) {
				return cost;
			}
			q.pop();
			if(floors[f][x][y] == 1) {
				if(floors[f][x-1][y] != 0) {
					q.push({f,{x-1,{y,cost + 1}}});
				}
				if(floors[f][x][y+1] != 0) {
					q.push({f,{x,{y+1,cost + 1}}});
				}
				if(floors[f][x][y-1] != 0) {
					q.push({f,{x,{y-1,cost + 1}}});
				}
				if(floors[f][x+1][y] != 0) {
					q.push({f,{x+1,{y,cost + 1}}});
				}
			} else if(floors[f][x][y] == 2) {
				if(f == 0) {
					if(floors[f+1][x][y] != 0) {
						q.push({f+1,{x,{y,cost + 2}}});
					}
				} else if(f == max_h) {
					if(floors[f-1][x][y] != 0) {
						q.push({f-1,{x,{y,cost + 1}}});
					}
				} else if(f != 0 && f != max_h) {
					if(floors[f+1][x][y] != 0) {
						q.push({f+1,{x,{y,cost + 2}}});
					}
					if(floors[f-1][x][y] != 0) {
						q.push({f-1,{x,{y,cost + 1}}});
					}	
				}
			}
		}
	}
	return -1;
}

int main() {
	int test;
	cin>>test;
	while(test--) {
		int m,n,h;
		cin>>m>>n>>h;
		max_h = h-1;
		int i;
		unordered_map<int,vector<vector<int>>> floors;
		for(i=0;i<h;i++) {
			int j,k;
			vector<vector<int>> vec(m, vector<int>(n));
			for(j=0;j<m;j++) {
				for(k=0;k<n;k++) {
					int value;
					cin>>value;
					vec[j][k] = value;
				}
			}
			floors.insert({i, vec});
		}
		int queries;
		cin>>queries;
		while(queries--) {
			int src_floor, src_row, src_col;
			cin>>src_floor>>src_row>>src_col;
			int dest_floor, dest_row, dest_col;
			cin>>dest_floor>>dest_row>>dest_col;
			cout<<findDist(floors,src_floor,src_row,src_col,dest_floor,dest_row,dest_col)<<endl;
		}
	}
	return 0;
}