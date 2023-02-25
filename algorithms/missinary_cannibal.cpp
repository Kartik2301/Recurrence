/*Missionaries and Cannibals with 3 Missionaries and 3 Cannibals, using one boat, where max capacity of boat = 2 */

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

bool MissionariesAndCannibals() {
	queue<pair<pair<int,int>,int>> q;
	q.push({{3,3},0}); //initial state
	int level = 1;
	bool visited[4][4][2];
	memset(visited,false,sizeof(visited));
	while(!q.empty()) {
		int size = q.size();
        cout<<"\n";
		for(int i=0;i<size;i++) {
			int l = q.front().first.first; //missionary
			int r = q.front().first.second; //cannibals
			int boat_side = q.front().second;
            q.pop();
			if(l == 0 && r == 0 && boat_side == 1) {
                cout<<"( "<<l<<" "<<r<<" "<<boat_side<<")";
                return true;
            }

            if(l >= 0 && r >= 0 && l <= 3 && r <= 3 && l >= r && !visited[l][r][boat_side]) {
                cout<<"( "<<l<<" "<<r<<" "<<boat_side<<")";
                //taking care of other shore
				//possibilities
				//1. Send one missionary alone
				//2. Send one cannibal alone
				//3. Send two (one missionary + one cannibal)
				//4. Send two missionaries
				//5. Send two 2 cannibals
				visited[l][r][boat_side] = true;
				if(boat_side == 1) {
                    int rowMoves[] = {1,0,1,2,0};
                    int colMoves[] = {0,1,1,0,2};
                    for(int index=0;index<5;index++) {
                        int newRow = l + rowMoves[index];
                        int newCol = r + colMoves[index];
                        if(newRow >= 0 && newCol >= 0 && newRow < 4 && newCol < 4) {
                            q.push({{newRow,newCol},0});
                        }
                    }
				} else {
                    int rowMoves[] = {-1,0,-1,-2,0};
                    int colMoves[] = {0,-1,-1,0,-2};
                    for(int index=0;index<5 ;index++) {
                        int newRow = l + rowMoves[index];
                        int newCol = r + colMoves[index];
                        if(newRow >= 0 && newCol >= 0 && newRow < 4 && newCol < 4) {
                            q.push({{newRow,newCol},1});
                        }
                    }
				}
		    } 
        }
	}
	return false;
}
int main() {
    cout<<"\n";
    MissionariesAndCannibals();
}