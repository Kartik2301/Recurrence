#include<iostream>
using namespace std;
int rowMoves[] = {0,0,1,-1};
int columnMoves[] = {-1,1,0,0};

bool isValid(int maze[4][4], int visited[4][4], int newRow, int newColumn){
    if((newRow >= 0)&&(newRow<4)&&(newColumn >= 0)&& (newColumn <4) && (maze[newRow][newColumn] == 1) && (visited[newRow][newColumn] == 0)){
        return true;
    }
    return false;
}

void RatMaze(int maze[4][4], int visited[4][4], int startRow, int startColumn, int destRow, int destColumn, int size, int move){
    if((startRow == destRow) && (startColumn == destColumn)){
        int i,j;
        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                cout<<visited[i][j]<<" ";
            }
            cout<<"\n";
        }
        cout<<"//////////////////"<<endl;
    } else {
        for(int index = 0; index<size; index++){
            int newRow = startRow + rowMoves[index];
            int newColumn = startColumn + columnMoves[index];
            if(isValid(maze,visited,newRow,newColumn)){
                move++;
                visited[newRow][newColumn] = move;
                RatMaze(maze,visited,newRow,newColumn,destRow,destColumn,size,move);
                move--;
                visited[newRow][newColumn] = 0;
            }
        }
    }
}


int main(){
    int maze[][4] =  {{1,1,0,1 },
                    {0,1,1,1 },
                    {0,1,0,1 },
                    {0,1,1,1 } };
                    
    int visited[4][4];
    int i,j;
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            visited[i][j] = 0;
        }
    }
    visited[0][0] = 1;
    RatMaze(maze,visited,0,0,3,3,4,1);
}