Given an array of jobs where every job has a deadline and associated profit if the job is finished before the 
deadline. It is also given that every job takes the single unit of time, 
so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.

Solution 1 :-
Time complexity :- O(n^2)
Space complexity :- O(n)

Solution 2 :-
Time complexity :- O(nlogn)
Space complexity :- O(n)

// { Driver Code Starts
// Program to find the maximum profit job sequence from a given array 
// of jobs with deadlines and profits 
#include<bits/stdc++.h>
using namespace std; 

// A structure to represent a job 
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
}; 


 // } Driver Code Ends


// Prints minimum number of platforms reqquired 
bool sortProfit(Job a, Job b) {
    if(a.profit == b.profit) {
        return a.dead < b.dead;
    }
    return a.profit > b.profit;
}
pair<int,int> JobScheduling(Job job[], int n) 
{ 
    // your code here
    int i;
    int profit = 0;
    int jobs = 0;
    sort(job,job+n,sortProfit);
    multiset<int,greater<int>> st;
    for(i=1;i<=100;i++) {
        st.insert(i);
    }
    for(i=0;i<n;i++) {
        auto it = st.lower_bound(job[i].dead);
        if(it == st.end()) continue;
        st.erase(it);
        profit += job[i].profit;
        jobs++;
    }
    return {jobs,profit};
} 


