#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void point_to_other_memory_success_mat(int ***matrix, int m, int n) {
    int **temp = malloc(m * sizeof(int*));
    for(int i = 0; i < m; i++) {
        temp[i] = malloc(n * sizeof(int));
    }
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            temp[i][j] = 64;
        }
    }

    *matrix = temp;
}

void point_to_other_memory_failure_mat(int **matrix, int m, int n) {
    int **temp = malloc(m * sizeof(int*));
    for(int i = 0; i < m; i++) {
        temp[i] = malloc(n * sizeof(int));
    }
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            temp[i][j] = 64;
        }
    }

    matrix = temp;
}

void modify_matrix_elements(int **matrix, int m, int n) {
    for(int i = 0; i < m; i++) {
        matrix[i][i] = (i + 2) * 40;
    }
}

int* return_array(int size) {
    int *temp = calloc(size, sizeof(int));
    for(int i = 0; i < size; i++) {
        *(temp + i) = (i + 3)*4;
    }
    return temp;
}

void point_to_other_memory_success(int **arr, int size) {
    int *temp = calloc(5, sizeof(int));
    *arr = temp;
}  


void point_to_other_memory_failure(int *arr, int size) {
    int *temp = calloc(5, sizeof(int));
    arr = temp;
}  

void modify_array_elements(int * arr, int size) {
    arr[0] = 23;
    arr[2] = 35;
    arr[4] = 44;
}

int main() {
    int i,j;
    int m = 5, n = 5;
    // Arrays and Pointers

    // 1D Arrays

    // Create a 1D integer array using pointers.
    // n = size of the array
    int *ptr_arr = (int*) malloc(n * sizeof(int)); // n contingious blocks, each of size 4 bytes.
    // With malloc, each block is initialised with garbage values

#define PRINT_1D {\
    for(i = 0; i < n; i++) {\
        printf("%d ", ptr_arr[i]);\
    }\
    printf("\n");\
}

#define PRINT1D {\
    for(i = 0; i < n; i++){\
        printf("%d ", *(ptr_arr + i));\
    }\
    printf("\n");\
}   

    PRINT_1D
    // to initialise the blocks, to a given value using memset
    memset(ptr_arr, 0, sizeof(n * sizeof(int))); // note can't use sizeof(ptr_arr), because sizeof(ptr_arr) = sizeof(int*) = 8 bytes.
    // note memset only works with a value of 0.
    PRINT1D

    // Another way of printing a 1-D array
    PRINT1D

    // Remember arr[i] is equivalent to *(arr + i)

    // Modifying the value

    for(i = 0; i < n; i++) {
        *(ptr_arr + i) = (i + 5) * 7;
    }

    PRINT1D

    // Passing 1-D arrays to function as paramters (IN)
    // When we pass the pointer which is pointing to the array as is, then we can only change the values of the array elements, we cannot change the array itself
    // => ie we cannot make the pointer, ptr_arr point to any other piece of memory. This is because just as with any other variable type, pointers too are 
    // passed by value in C.

    modify_array_elements(ptr_arr, n);
    PRINT1D

    // Next, we attempt to make the pointer ptr_arr point to another piece of memory (another array, created by malloc'ing)
    // Failure case, pass the parmeters as in the last case

    point_to_other_memory_failure(ptr_arr, n);
    PRINT1D

    // Result: Failure, the pointer is still pointing to the original memory, this is because pointers are passed by value just like ints, bools, chars etc, and while it is 
    // possible to make changes to individual elements in this way but the pointer itself cannot be changed.

    // Success case, if we want to change the value pointed to by the pointer then rather than just passing the pointer, pass a reference to the pointer.
    // This is literally true for all datatypes, 
    // For example, Want to change the value of an integer inside a function? pass the interger as *x rather than just x;

    /*
        Pointers are passed by value as anything else. That means the contents of the pointer variable (the address of the object pointed to) is copied. 
        That means that if you change the value of the pointer in the function body, that change will not be reflected in the external
        pointer that will still point to the old object. But you can change the value of the object pointed to.

        If you want to reflect changes made to the pointer to the external pointer (make it point to something else), you need two 
        levels of indirection (pointer to pointer). When calling functions it's done by putting a & before the name of the pointer. It is the standard C way of doing things.
    */

    point_to_other_memory_success(&ptr_arr, n);
    PRINT1D


    // Returning 1D arrays from functions in C
    ptr_arr = return_array(n);
    PRINT1D

    printf("///////////////////////\n");

    // Matrix or 2D arrays

    // Create a mxn Matrix using pointers.

    // Break it into 2 parts
    // Remember, int* represents an array.
    // So we first create an array of integer pointers (int *).
    // Next, allocate memory for each of these individual arrays. Which will be pointed to by the pointers created in the above step

    // Step - I: Create an array of integer pointers
    // Why **?
    // Integer array = int*, and this is an array of arrays (int*)

    int **ptr_mat = malloc(m * sizeof(int*));
    // Now Step - II, initialise each of these individual integer arrays
    for(i = 0; i < m; i++) {
        ptr_mat[i] = malloc(n * sizeof(int)); // notice int here and not int*
    }

    for(i = 0; i < m; i++) {
        for(j = 0; j < n; j++) {
            ptr_mat[i][j] = i*j;
        }
    }

#define PRINT_2D {\
    for(i = 0; i < m; i++) {\
        for(j = 0; j < n; j++) {\
            printf("%d ", ptr_mat[i][j]-1);\
        }\
        printf("\n");\
    }\
}

#define PRINT2D {\
    for(i = 0; i < m; i++) {\
        for(j = 0; j < n; j++) {\
            printf("%d ", *(*(ptr_mat + i) + j));\
        }\
        printf("\n");\
    }\
}

    // Printing elements of the matrix
    PRINT_2D
    
    PRINT2D

    // Passing a matrix to functions as parameter

    // Change the values inside the matrix
    modify_matrix_elements(ptr_mat, m, n);
    PRINT2D

    // Change the matrix itself, make the pointer currently pointing to ptr_mat, point to another matrix altogether
    point_to_other_memory_failure_mat(ptr_mat, m, n);
    PRINT2D

    point_to_other_memory_success_mat(&ptr_mat, m, n);
    PRINT2D
}
