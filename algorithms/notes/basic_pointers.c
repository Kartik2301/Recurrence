#include<stdio.h>


// *(arr + i) is same as arr[i]
// arr + i is same as &arr[i]
// Pointer arithmetic
// int *ptr = var;
// ptr + 1 means :=: ptr = ptr + 1 * (sizeof(int)) [since, ptr is an integer pointer]
// similarly
// char *s = svar;
// s += 2 means :=: s = s + 2*(sizeof(char))

// in general
// ptr += x means :=: ptr = ptr + x * sizeof(ptr)

int main(void) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int *ptr = arr;
    
    printf("%d\n", arr[0]);
    printf("%d\n\n", *ptr);
    
    printf("%d\n", arr[3]);
    printf("%d\n\n", *(arr + 3));
    
    ptr++;
    printf("%d\n\n", *ptr);
    
    ptr += 2;
    printf("%d\n\n", *ptr);
    
    printf("%d\n", arr);
    printf("%d\n", arr + 1);
    
    printf("%x\n", arr);
    printf("%x\n\n", arr + 1);
    
    ptr = arr;
    *ptr += 300;
    
    for(int i = 0; i < 9; i++) {
        printf("%d\t", arr[i]);
    }
    
    printf("\n%d", *ptr);
    
    ptr = arr;
    ptr += 8;
    printf("\n%d", *ptr);
    
    return 0;
}