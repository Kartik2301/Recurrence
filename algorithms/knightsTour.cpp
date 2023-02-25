#include <iostream>

using namespace std;
       int rowMoves[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
       int columnMoves[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    
bool isValidMove(int visited[8][8], int newRow, int newColumn){
    if((newRow >=0) && (newRow<8) && (newColumn >=0) && (newColumn <8) && (visited[newRow][newColumn] == 0)){
        return true;
    }
    return false;
}

bool SolveKT(int visited[8][8], int row, int column, int move){
    if(move == 64){
        int i,j;
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                cout<<visited[i][j]<<" ";
            }
            cout<<"\n";
        }
        return true;
    } else {
        for(int index = 0; index<8 ;index++){
            int newRow = row + rowMoves[index];
            int newColumn = column + columnMoves[index];
            if(isValidMove(visited,newRow,newColumn)){
                move++;
                visited[newRow][newColumn] = move;
                if(SolveKT(visited,newRow,newColumn,move)){
                    return true;
                }
                move--;
                visited[newRow][newColumn] = 0;
            }
        }
    }
    return false;
}

int main() {
    int visited[8][8];
    int i,j;
    for(i=0;i<8;i++){
        for(j=0;j<8;j++){
            visited[i][j] = 0;
        }
    }
    visited[0][0] = 1;
    SolveKT(visited,0,0,1);
}