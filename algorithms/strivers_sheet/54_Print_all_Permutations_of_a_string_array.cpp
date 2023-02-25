Solution

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,nums,new ArrayList<>());
        return list;
    }
    public void backtrack(List<List<Integer>> list, int [] nums, List<Integer> temp) {
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for(int i=0;i<nums.length;i++) {
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backtrack(list,nums,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}


// C++ program to print all 
// permutations with duplicates allowed 
#include <bits/stdc++.h> 
using namespace std; 


// Function to print permutations of string 
// This function takes three parameters: 
// 1. String 
// 2. Starting index of the string 
// 3. Ending index of the string. 
void permute(string a, int l, int r) 
{ 
	// Base case 
	if (l == r) 
		cout<<a<<endl; 
	else
	{ 
		// Permutations made 
		for (int i = l; i <= r; i++) 
		{ 

			// Swapping done 
			swap(a[l], a[i]); 

			// Recursion called 
			permute(a, l+1, r); 

			//backtrack 
			swap(a[l], a[i]); 
		} 
	} 
} 

// Driver Code 
int main() 
{ 
	string str = "ABC"; 
	int n = str.size(); 
	permute(str, 0, n-1); 
	return 0; 
} 

Time complexity :- O(n*n!)
Space complexity :-
If array containing output is returned O(n*n!)
If it is only printed O(n) [O(n) for call stack, max depth of recurssion tree]