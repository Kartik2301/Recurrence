#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main() {
    int n = 5;
    int q[3][4] = {{ 0, 0, 1, 2 },
                   { 1, 2, 3, 4 },
                   { 1, 4, 3, 4 }};

    int arr[n][n];
    int res[n][n];
    int i,j;
    for(i=0;i<n;i++) {
        for(j=0;j<n;j++) {
            arr[i][j] = 0;
        }
    }
    for(int i=0;i<3;i++) {
        int x1 = q[i][0];
        int y1 = q[i][1];
        int x2 = q[i][2];
        int y2 = q[i][3];
        arr[x1][y1]++;
        if(y2 + 1 < n) {
            arr[x2][y2+1]--;
        } else if(x2 + 1 < n) {
            arr[x2+1][0]--;
        }
    }
    int sum = 0;
    for(i=0;i<n;i++) {
        for(j=0;j<n;j++) {
            sum += arr[i][j];
            res[i][j] = sum;
        }
    }
    for(i=0;i<n;i++) {
        for(j=0;j<n;j++) {
            cout<<res[i][j]<<" ";
        }
        cout<<"\n";
    }
}
