// C++ program to count appearances of
// a digit 'd' in range from [0..n]
#include <bits/stdc++.h>
using namespace std;

int getOccurence(int n, int d)
{
    int result = 0; // Initialize result

    int itr = d;
    while (itr <= n)
    {
        if (itr%10 == d)
            result++;

        if (itr != 0 && itr/10 == d)
        {
            result++;
            itr++;
        }

        else if (itr/10 == d-1)
            itr = itr + (10 - d);
        else
            itr = itr+10;
    }
    return result;
}

int countOccurence(int n)
{
    return getOccurence(n,0) + getOccurence(n,2) + getOccurence(n,4);
}
