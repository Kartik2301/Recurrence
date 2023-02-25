solution 1 :-

A brute-force solution would be to try all possible subset with all different fraction but that will be too much time taking. 


solution 2 :-
Greedy approach
Time complexity :- O(nlogn)
Space complexity :- O(1)

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Item{
    int value;
    int weight;
};


 // } Driver Code Ends


//class implemented
/*
struct Item{
    int value;
    int weight;
};
*/

bool sortByRatio(const Item a, const Item b) {
    double one = (double) a.value/(double)a.weight;
    double two = (double) b.value/(double)b.weight;
    return one >= two;
}
// function to return fractionalweights
double fractionalKnapsack(int W, Item arr[], int n)
{
    // Your code here
    sort(arr,arr+n,sortByRatio);
    int i;
    int cur_w = 0;
    double cur_v = 0.0;
    for(i=0;i<n;i++) {
        if(cur_w + arr[i].weight <= W) {
            cur_v += arr[i].value;
            cur_w += arr[i].weight;
        } else {
            double remaining = W - cur_w;
            double temp_val = (remaining/arr[i].weight)*arr[i].value;
            cur_v += temp_val;
            break;
        }
    }
    return cur_v;
}

// { Driver Code Starts.
int main()
{
	int t;
	//taking testcases
	cin>>t;
	cout<<setprecision(2)<<fixed;
	while(t--){
	    //size of array and weight
		int n, W;
		cin>>n>>W;
		
		Item arr[n];
		//value and weight of each item
		for(int i=0;i<n;i++){
			cin>>arr[i].value>>arr[i].weight;
		}
		
		//function call
		cout<<fractionalKnapsack(W, arr, n)<<endl;
	}
    return 0;
}  // } Driver Code Ends