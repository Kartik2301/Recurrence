#include<iostream>
using namespace std;
bool isValid(bool board[8][8], int newRow, int col, int size){
    int i,j;
    bool valid = true;
    for(i = 0; i<size; i++){
        if(board[i][col]){
            valid = false;
        }
    }
    for(i=newRow,j=col;i>=0&&j>=0;i--,j--){
        if(board[i][j]){
            valid = false;
        }
    }
    for(i=newRow,j=col;i>=0&&j<size;i--,j++){
        if(board[i][j]){
        valid = false;
        }
    }
    return valid;
}
bool NQueens(bool board[8][8],int size, int row){
    if(row == size-1){
        int i,j;
        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                cout<<board[i][j]<<" ";
            }
            cout<<"\n";
        }
        return true;
    } else {
        int newRow = row + 1;
        int col;
        for(col = 0; col<size; col++){
            if(isValid(board, newRow, col, size)){
                board[newRow][col] = true;
                if(NQueens(board,size,newRow)){
                    return true;
                }
                board[newRow][col] = false;
            }
        }
    }
    return false;
}
int main(){
    bool board[8][8];
    int i,j;
    for(i=0;i<8;i++){
        for(j=0;j<8;j++){
            board[i][j] = false;
        }
    }
    NQueens(board,8,-1);
}