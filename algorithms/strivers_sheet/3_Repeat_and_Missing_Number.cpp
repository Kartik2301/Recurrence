Repeat and Missing Number 

Solution 1. Use sorting

***********************************
for(int i=0;i<n;i++) {
	if(arr[i] != i+1) {
		return arr[i]; // duplicate
	}
}
***********************************

Time Complexity :- O(nlogn)
Space Complexity :- O(1);

**********************************************************************

Solution 2. Use hashMap

Time Complexity :- O(n) // 2 passes
Space Complexity :- O(n)

**********************************************************************

Solution 3. Negation of Index

int i;
cout << " The repeating element is ";

for (i = 0; i < size; i++) {
    if (arr[abs(arr[i]) - 1] > 0)
        arr[abs(arr[i]) - 1] = -arr[abs(arr[i]) - 1];
    else
        cout << abs(arr[i]) << "\n";
}

cout << "and the missing element is ";
for (i = 0; i < size; i++) {
    if (arr[i] > 0)
        cout << (i + 1);
}

Time Complexity :- O(n)
Space Complexity :- O(1)
Array is modified

**********************************************************************

Solution 4. Make 2 equations

int *findTwoElement(int *arr, int n) {
	// code here
	long long sum = 0;
	long long squares = 0;
	for(long long i=0;i<n;i++) {
	    sum += (long long)arr[i];
	    squares += (long long)arr[i]*arr[i];
	}

	long long s1 = (long long) n*(n+1)/2;
	long long s2 = (long long)n*(n+1)*(2*n+1)/6;
	long long b = s1 - sum;
	long long a = s2 - squares;
	//cout<<a<<" "<<b<<endl;
	long long  missing = (a/b + b)/2;
	long long repeat = a/b - missing;
	int _arr[2];
	_arr[0] = repeat;
	_arr[1] = missing;
	int *ptr = _arr;
	return ptr;
}

2 equations for sum of elements and sum of (squares)

Time Complexity :- O(n)
Space Complexity :- O(1)

**********************************************************************

Solution 5 :- Swap sort

Time Complexity :- O(n)
Space Complexity :- O(1)
Array is modified

int[] findTwoElement(int arr[], int n) {
    // code here
    int i=0;
    int size=arr.length;
    while(i < size) {
        if(arr[i] != arr[arr[i]-1]) {
            int temp = arr[i];
            arr[i] = arr[arr[i]-1];
            arr[arr[i]-1] = temp;
        } else {
            i++;
        }
    }
    int [] result = new int[2];
    for(i=0;i<size;i++) {
        if(arr[i] != i+1) {
            result[0] = arr[i];
            result[1] = i+1;
        } 
    }
    return result;
}

**********************************************************************

Solution 6 :-

int[] findTwoElement(int arr[], int n) {
    // code here
     int xor1;
     int set_bit_no;

    int i;
    int x,y;
    x = 0;
    y = 0;

    xor1 = arr[0];

    for (i = 1; i < n; i++)
        xor1 = xor1 ^ arr[i];
    for (i = 1; i <= n; i++)
        xor1 = xor1 ^ i;

    set_bit_no = xor1 & ~(xor1 - 1);
    for (i = 0; i < n; i++) {
        if ((arr[i] & set_bit_no) != 0)
            x = x ^ arr[i];

        else
            y = y ^ arr[i];
    }
    for (i = 1; i <= n; i++) {
        if ((i & set_bit_no) != 0)
            x = x ^ i;

        else
            y = y ^ i;
    }

    int [] result = new int[2];
    for(i=0;i<n;i++) {
        if(arr[i] == x) {
            result[0] = x;
            result[1] = y;
            break;
        }  else if(arr[i] == y) {
            result[0] = y;
            result[1] = x;
            break;
        }
      }
    return result;
  }

Time Complexity: O(n)
This method doesn’t cause overflow, 
but it doesn’t tell which one occurs twice and which one is 
missing. We can add one more step that checks which one is missing and which one is repeating. This can be easily done in O(n) time.