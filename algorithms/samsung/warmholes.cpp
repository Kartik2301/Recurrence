/*





There is a source (S) and destination (D) and a spacecraft has to go from S to D. There are N number of wormholes in between
which has following properties:

Each wormhole has an entry and an exit.
Each wormhole is bi-directional i.e. one can enter and exit from any of the ends.
The time to cross the wormhole is given and the space craft may or may not use the wormhole
to reach D.
The time taken to travel outside wormhole between two points (x1, y1) and (x2, y2) is given by a formula

|x1 – x2| + |y1 – y2|




where, (x1, y1) and (x2, y2) are the co-ordinates of two points.

The co-ordinates of S and D are given and we have to find the minimum time to reach D from S.

Note: It’s not mandatory to consider all the wormholes

Sample input: source=(0, 0), destination(100, 100), warmholes=3 .
coordinates are: (1, 2), (120, 120)
(4, 5), (120, 100)
(6, 8), (150, 180)
Sample output=48

freq = 10




*/


#include<iostream>
using namespace std;

int warmholes;
bool visited[100];
int ans;

struct Point {
    int x,y;
};

struct hole {
    int x1,y1,x2,y2,cost;
};

int abs(int x) {
    if(x < 0) {
        return -1*x;
    }
    return x;
}

int calculate(Point src, Point dest) {
    return abs(src.x - dest.x) + abs(src.y - dest.y);
}

int min(int a, int b) {
    if(a > b) return b;
    return a;
}

void solve(Point src, Point dest, hole holes[], int cost) {
    int tempAns = cost + calculate(src,dest);
    ans = min(ans, tempAns);
    int i;
    for(i=0;i<warmholes;i++) {
        if(!visited[i]) {
            visited[i] = true;
            Point temp1, temp2;
            temp1.x = holes[i].x1;
            temp1.y = holes[i].y1;
            temp2.x = holes[i].x2;
            temp2.y = holes[i].y2;
            int val;
            val = calculate(src,temp1);
            solve(temp2,dest,holes,cost + val + holes[i].cost);
            val = calculate(src,temp2);
            solve(temp1,dest,holes,cost+val+holes[i].cost);
            visited[i] = false;
        }
    }
}

int main() {
    int test;
    cin>>test;
    while(test--) {
        Point src, dest;
        cin>>src.x>>src.y>>dest.x>>dest.y;
        cin>>warmholes;
        hole holes[warmholes];
        int i;
        for(i=0;i<100;i++) {
            visited[i] = false;
        }
        for(i=0;i<warmholes;i++) {
            cin>>holes[i].x1>>holes[i].y1>>holes[i].x2>>holes[i].y2>>holes[i].cost;
        }
        ans = 1e7 + 1;
        solve(src,dest,holes,0);
        cout<<ans<<endl;
    }
}
