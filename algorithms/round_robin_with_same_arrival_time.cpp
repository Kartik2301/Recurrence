vector<int> findWaitingTimes(int process_ids[], int burst_time[], int quantum, int n) {
	int rem_bt[n];
	int i;
	for(i=0;i<n;i++) {
		rem_bt[i] = burst_time[i];
	}
	vector<int>waiting_times(n,0);
	int time = 0;
	int completed = 0;
	while(1) {
        bool done = true;
		for(i=0;i<n;i++) {
			if(rem_bt[i] > 0) {
                done = false;
				if(rem_bt[i] > quantum) {
					time += quantum;
					rem_bt[i] -= quantum;
				} else {
					time += rem_bt[i];
					rem_bt[i] = 0;
					waiting_times[i] = time - burst_time[i];
					completed++;
				}
			}
		}
        if(done == true) break;
	}
	return waiting_times;
}
void solve(int process_ids[], int burst_time[], int quantum, int n) {
	vector<int> wt = findWaitingTimes(process_ids,burst_time,quantum,n);
    vector<int> turaround_time(n,0);
    for(int i=0;i<n;i++){
        turaround_time[i] = wt[i] + burst_time[i];
    }
	for(int i=0;i<n;i++) {
		cout<<wt[i]<<" ";
	}
    for(int i=0;i<n;i++) {
		cout<<turaround_time[i]<<" ";
	}
}
int main() {
	int process_ids[] = {1,2,3};
	int burst_time[] = {10,5,8};
	int quantum = 2;
	solve(process_ids,burst_time,quantum,3);
}