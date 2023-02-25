// C++ program for Boggle game 
#include <cstring> 
#include <iostream> 
using namespace std; 

#define M 2 
#define N 2
int rowMoves[] = {1,-1,0,0};
int colMoves[] = {0,0,-1,1};


bool isValid(int newRow, int newCol, bool visited[3][4]){
    if((newRow>=0)&&(newRow<3)&&(newCol>=0)&&(newCol<4)&&(!visited[newRow][newCol])){
        return true;
    }
    return false;
}
// Let the given dictionary be following 
string dictionary[] = { "SEE", "FOR", "QUIZ", "GO" }; 
int n = sizeof(dictionary) / sizeof(dictionary[0]); 

// A given function to check if a given string is present in 
// dictionary. The implementation is naive for simplicity. As 
// per the question dictionary is given to us. 
bool isWord(string& str) 
{ 
    // Linearly search all words 
    for (int i = 0; i < n; i++) 
        if (str.compare(dictionary[i]) == 0) 
            return true; 
    return false; 
} 

// A recursive function to print all words present on boggle 
void findWordsUtil(char boggle[M][N], bool visited[M][N], int i, 
                int j, string& str) 
{ 
    // Mark current cell as visited and append current character 
    // to str 
    visited[i][j] = true; 
    str = str + boggle[i][j]; 

    // If str is present in dictionary, then print it 
    if (isWord(str)) 
        cout << str << endl; 

//   Traverse 8 adjacent cells of boggle[i][j] 

    for(int index = 0; index <4; index ++) {
        int newRow = i + rowMoves[index];
        int newCol = j + colMoves[index];
        if(newRow >= 0 && newCol >=0 && newRow < M && newCol < N && !visited[newRow][newCol]) {
            findWordsUtil(boggle, visited, newRow, newCol, str);
        }
    }
//  for (int row = i - 1; row <= i + 1 && row < M; row++) 
//      for (int col = j - 1; col <= j + 1 && col < N; col++) 
//          if (row >= 0 && col >= 0 && !visited[row][col]) 
//               

    // Erase current character from string and mark visited 
    // of current cell as false 
    str.erase(str.length() - 1); 
    visited[i][j] = false; 
} 

// Prints all words present in dictionary. 
void findWords(char boggle[M][N]) 
{ 
    // Mark all characters as not visited 
    bool visited[M][N] = { { false } }; 

    // Initialize current string 
    string str = ""; 

    // Consider every character and look for all words 
    // starting with this character 
    for (int i = 0; i < M; i++) 
        for (int j = 0; j < N; j++) 
            findWordsUtil(boggle, visited, i, j, str); 
} 

// Driver program to test above function 
int main() 
{ 
    char boggle[M][N] = { 
                         {'a','b'
                          } 
                        }; 

    cout << "Following words of dictionary are present\n"; 
    findWords(boggle); 
    return 0; 
} 

//[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//"SEE"
