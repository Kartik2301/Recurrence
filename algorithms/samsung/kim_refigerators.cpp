/*


ques 12: Mr. Kim has to deliver refrigerators to N customers.
From the office, he is going to visit all the customers and then return to his home.
Each location of the office, his home, and the customers is given in the form of integer coordinates
(x, y) (-1<x<101, -1<y<101). The distance between two arbitrary locations (x1, y1) and (x2, y2) is computed by |x1-x2| + |y1-y2|,
where |x| denotes the absolute value of x; for instance, |3|=|-3|=3. The locations of the office, his home,
and the customers are all distinct. You should plan an optimal way to visit all the N customers and return to his among all the possibilities.


https://www.geeksforgeeks.org/samsung-interview-experience-set-30-campus/

You are given the locations of the office, Mr. Kim’s home, and the customers; the number of the customers is in the range of 5 to 10. Write a program that, starting at the office, finds a (the) shortest path visiting all the customers and returning to his home. Your program only has to report the distance of a (the) shortest path.

You don’t have to solve this problem efficiently. You could find an answer by looking up all the possible ways. If you can look up all the possibilities well, you will get a perfect score.

[Constraints]
4<N<11. Each location (x, y) is in a bounded grid, -1<x<101, -1<y<101, and x, y are integers.

[Input]
You are given 10 test cases. Each test case consists of two lines; the first line has N, the number of the customers, and the following line enumerates the locations of the office, Mr. Kim’s home, and the customers in sequence. Each location consists of the coordinates (x, y), which is represented by ‘x y’.

[Output]
Output the 10 answers in 10 lines. Each line outputs the distance of a (the) shortest path. Each line looks like ‘#x answer’ where x is the index of a test case. ‘#x’ and ‘answer’ are separated by a space.

[I/O Example]
Input (20 lines in total. In the first test case, the locations of the office and the home are (0, 0) and (100, 100) respectively, and the locations of the customers are (70, 40), (30, 10), (10, 5), (90, 70), (50, 20).)

5 (Starting test case #1)
0 0 100 100 70 40 30 10 10 5 90 70 50 20

6 (Starting test case #2)
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14

Mr. Kim and Refrigerators

This was a 3 hours coding round in which we had to code 1 problem having 10 test cases. Only those students were selected for the next round who passed all the test cases.
Note- You can compile your code as many number of times as you want, but a maximum of 5 submissions were allowed to test on the given test cases.

Here is the question:-

Mr. Kim has to deliver refrigerators to N customers. From the office, he is going to visit all the customers and then return to his home. Each location of the office, his home, and the customers is given in the form of integer coordinates (x,y) (-1<x<101, -1<y<101) . The distance between two arbitrary locations (x1, y1) and (x2, y2) is computed by |x1-x2| + |y1-y2|, where |x| denotes the absolute value of x; for instance, |3|=|-3|=3. The locations of the office, his home, and the customers are all distinct. You should plan an optimal way to visit all the N customers and return to his among all the possibilities.

You are given the locations of the office, Mr. Kim’s home, and the customers; the number of the customers is in the range of 5 to 10. Write a program that, starting at the office, finds a (the) shortest path visiting all the customers and returning to his home. Your program only have to report the distance of a (the) shortest path.

You don’t have to solve this problem efficiently. You could find an answer by looking up all the possible ways. If you can look up all the possibilities well, you will get a perfect score.

freq: 4

*/


/* NOTE FOR MR. X */



/*


ques 6 : Mr. X has to deliver software to N customers. From the office, he is going to visit all the customers and then return to his office.
Each location of the office and the customers is given in the form of integer coordinates 
(x, y) (-1<x<500, -1<y<500). The distance between two arbitrary locations (x1, y1) and 
(x2, y2) is computed by |x1-x2| + |y1-y2|, where |x| denotes the 
absolute value of x; for instance, |3|=|-3|=3.
The locations of the office and the customers are all distinct. 
You should plan an optimal way to visit all the N customers and return to his office.

You are given the locations of the office and the customers; 
the number of customers is in the range of 1 to 100. 
Write a program that, starting at the office, 
finds a (the) shortest path visiting all the customers and returning to his office. 
Your program only has to report the distance of a (the) shortest path.

[Constraints]
1<N<100. Each location (x, y) is in a bounded grid, -1<x<500, -1<y<500, and x, y are integers.

[Input]
Each test case consists of two lines; the first line has N, the number of the customers and the following line enumerates the locations 
of the office and the customers in sequence. Each location consists of the coordinates (x, y), which is represented by ‘x y’.

[Output]
Each line outputs the distance of a (the) shortest path. Each line looks like ‘#x answer’ where x is the index of a test case. ‘#x’ and ‘answer’ are separated by a space.




Examples:

Input : 
In the first test case, the locations of the office are (0, 0) and the locations of the customers are (70, 40), 
(30, 10), (10, 5), (90, 70), (50, 20).

5 (Starting test case #1)
0 0 70 40 30 10 10 5 90 70 50 20
Output :
#1 320



freq : 2



*/

#include<iostream>
using namespace std;

int visited[40] = {0};
struct cord {
    int x,y;
};

int abs(int x) {
    if(x < 0) {
        return -1*x;
    }
    return x;
}

int solve(cord p[], int n, int x, int y, int index, int hx, int hy, int count) {
    if(count == n) {
        return abs(x - hx) + abs(y - hy);
    }
    int ans = INT_MAX;
    int i;
    for(i=0;i<n;i++) {
        if(!visited[i]) {
            visited[i] = true;
            cord c = p[i];
            int val = abs(c.x - x) + abs(c.y - y);
            ans = min(ans, val + solve(p,n,c.x,c.y,i,hx,hy,count+1));
            visited[i] = false;
        }
    }
    return ans;
}
int main() {
    int test;
    cin>>test;
    while(test--) {
        int n;
        cin>>n;
        int ox,oy;
        cin>>ox>>oy;
        int hx,hy;
        cin>>hx>>hy;
        cord p[n];
        for(int i=0;i<n;i++) {
            int x,y;
            cin>>x>>y;
            cord a;
            a.x = x;
            a.y = y;
            p[i] = a;
        }
        cout<<solve(p,n,ox,oy,0,hx,hy,0)<<endl;
    }
}



