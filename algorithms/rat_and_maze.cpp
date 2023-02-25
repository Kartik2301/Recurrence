#include<iostream>
#include<bits/stdc++.h>
using namespace std;
#define N 4

void printSolution(int solution[N][N]) {
	int i,j;
	for(i=0;i<N;i++) {
		for(j=0;j<N;j++) {
			cout<<solution[i][j]<<" ";
		}
		cout<<"\n";
	}
}

void mazeHelper(int maze[N][N], int solution[N][N], int x, int y) {
	if(x == N-1 && y == N-1) {
		solution[x][y] = 1;
		printSolution(solution);
		return;
	}
	if(x >= N || x < 0 || y >= N || y < 0 || solution[x][y] == 1 || maze[x][y] == 0) {
		return;
	}
	solution[x][y] = 1;
	mazeHelper(maze,solution,x-1,y);
	mazeHelper(maze,solution,x+1,y);
	mazeHelper(maze,solution,x,y-1);
	mazeHelper(maze,solution,x,y+1);
	solution[x][y] = 0;
}

int main() {
	int maze[N][N] = {
					   { 1, 0, 0, 0 },
                       { 1, 1, 0, 1 },
                       { 0, 1, 0, 0 },
                       { 1, 1, 1, 1 }
                     };

    int solution[N][N];
    int i,j;
    for(i=0;i<N;i++) {
    	for(j=0;j<N;j++) {
    		solution[i][j] = 0;
    	}
    }
    mazeHelper(maze,solution,0,0);
}
