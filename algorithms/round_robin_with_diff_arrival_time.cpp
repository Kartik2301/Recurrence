#include<iostream>
#include<bits/stdc++.h>
using namespace std;
vector<int> findCompletionTimes(int arrival_time[], int process_ids[], int burst_time[], int quantum, int n) {
	vector<int> completionTimes(n,0);
	int time = 0;
	int arrival = 0;
	int rem_bt[n];
	int i;
	for(i=0;i<n;i++) {
		rem_bt[i] = burst_time[i];
	}
	while(true) {
		bool done = true;
        for(i=0;i<n;i++) {
            if(rem_bt[i] > 0) {
                done = false;
                if(arrival_time[i] <= arrival && rem_bt[i] > quantum){
                    time += quantum;
                    rem_bt[i] -= quantum;
                    arrival++;
                } else if(arrival_time[i] <= arrival) {
                    time += rem_bt[i];
                    rem_bt[i] = 0;
                    arrival++;
                    completionTimes[i] = time;
                }
            }
        }
		if(done == true) break;
	}
    return completionTimes;
}
void solve(int arrival_time[], int process_ids[], int burst_time[], int quantum, int n) {
	vector<int> ct = findCompletionTimes(arrival_time,process_ids,burst_time,quantum,n);
	int i;
	for(i=0;i<ct.size();i++) {
		cout<<ct[i]<<" ";
	}
    cout<<"\n";
    vector<int> turnaround_time(n), wt(n);
    for(i=0;i<n;i++) {
        turnaround_time[i] = ct[i] - arrival_time[i];
        wt[i] = turnaround_time[i] - burst_time[i];
    }
    for(i=0;i<n;i++) {
        cout<<turnaround_time[i]<<" ";
    }
    cout<<"\n";
    for(i=0;i<n;i++) {
        cout<<wt[i]<<" ";
    }
}
int main(){
	int arrival_time[] = {0,1,2,3};
    int process_ids[] = {1,2,3,4};
    int burst_time[] = {5,4,2,1};
    int quantum = 2;
    int n = 4;
    solve(arrival_time,process_ids,burst_time,quantum,n);
}