Solution 1 :
Using bit manipulation
// CPP program to find MSB 
// number for given n. 
#include <bits/stdc++.h> 
using namespace std; 

int setBitNumber(int n) 
{ 

	// To find the position 
	// of the most significant 
	// set bit 
	int k = (int)(log2(n)); 

	// To return the the value 
	// of the number with set 
	// bit at k-th position 
	return (int)(pow(2, k)); 
} 

// Driver code 
int main() 
{ 
	int n = 273; 
	cout << setBitNumber(n); 
	return 0; 
} 


Time complexity :- O(1)
Space complexity :- O(1)

Other solutions :-
Repeated division by 2 or slight variation in the algo used to compute the number of set bits.
Time comlexity :- O(log(n)) or O(n) 