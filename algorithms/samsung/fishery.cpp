/*

ques: It consisted of a single coding question to be solved under 3 hrs. There were two slots –
First slot recieved this question-
There are N fishing spots and 3 gates. At each gate there are some fishermen waiting to reach the nearest unoccupied fishing spot. (Total no of fisherman <=N)
Distance between consecutive spots = distance between gate and nearest spot = 1 m
Only 1 gate can be opened at a time and all fishermen of that gate must occupy the spots before the next gate is opened.
Distance is calculated as gate to nearest spot + nearest spot to closest vacant spot.
Find the total sum of minimum distances need to walk for all the fishermen.


https://www.geeksforgeeks.org/samsung-semiconductor-institute-of-research-ssir-software-intern-fte-set-1/

Inputs to be taken:
Number of fishing spots
Position of the gates
Number of fishermen at each gates

Second slot recieved this –

https://www.geeksforgeeks.org/samsung-semiconductor-institute-of-researchssir-software-intern-fte-set-3/

*/

#include<iostream>
using namespace std;
int n;

int pos[4];
int val[4];
int a[1000];
int ans = 1e7;;

void init() {
    int i;
    for(i=1;i<1000;i++) {
        a[i] = 0;
    }
}


int posRight(int index) {
    for(int i=index; i<= n; i++) {
        if(a[i] == 0) return i;
    }
    return 1e7;
}

int posLeft(int index) {
    for(int i=index-1; i> 0; i--) {
        if(a[i] == 0) return i;
    }
    return 1e7;
}

int abs(int x) {
    if(x < 0) {
        return -1*x;
    }
    return x;
}

void solve(int x, int y, int z, int curPos, int cost) {
    if(cost > ans) return;
    if(val[curPos] == 0) {
        if(curPos == x) {
            curPos = y;
        } else if(curPos == y) {
            curPos = z;
        } else {
            ans = min(ans,cost);
            return;
        }
    }
    int l = posLeft(pos[curPos]);
    int ll = abs(pos[curPos] - l + 1);
    int r = posRight(pos[curPos]);
    int rr = abs(r - pos[curPos] + 1);

    int distance = (ll > rr) ? r : l;
    int tempx = min(ll,rr);
    if(val[curPos] == 1 && ll == rr) {
        a[l] = 1;
        val[curPos]--;
        solve(x,y,z,curPos,cost+ll);
        a[l] = 0;
        val[curPos]++;


        a[r] = 1;
        val[curPos]--;
        solve(x,y,z,curPos,cost+rr);
        a[r] = 0;
        val[curPos]++;
    } else {
        a[distance] = 1;
        val[curPos]--;
        solve(x,y,z,curPos,cost+tempx);
        a[distance] = 0;
        val[curPos]++;
    }
}

int main() {
    int test;
    cin>>test;
    while(test--) {
        cin>>n;
        int i;
        for(i=1;i<=3;i++) {
            cin>>pos[i]>>val[i];
        }
        ans = 1e7;
        init();
        solve(1,2,3,1,0);
        init();
        solve(1,3,2,1,0);
        init();
        solve(2,1,3,2,0);
        init();
        solve(2,3,1,2,0);
        init();
        solve(3,1,2,3,0);
        init();
        solve(3,2,1,3,0);

        cout<<ans<<endl;
    }
}
