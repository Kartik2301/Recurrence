Solution 1 :- 
Using bit manipulation
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res = 0;
        while(n) {
            n &= (n-1);
            res++;
        }
        return res;
    }
};

The run time depends on the number of 1-bits in n. 
In the worst case, all bits in nn are 1-bits. 
In case of a 32-bit integer, the run time is O(1).

The space complexity is O(1), since no additional space is allocated.

Solution 2 :- 

public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
        if ((n & mask) != 0) {
            bits++;
        }
        mask <<= 1;
    }
    return bits;
}

The run time depends on the 
number of bits in n. Because n in this piece of code is a 32-bit integer, 
the time complexity is O(1).

The space complexity is O(1), since no additional space is allocated.