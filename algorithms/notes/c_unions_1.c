// Online C compiler to run C program online
#include <stdio.h>
#include <string.h>

typedef struct {
        int marks;
        int size;
        int age;
} hdr;
    
union student {
    hdr header;
    long id;
} s1, s2;

int main() {
    // Write C code here
    // strcpy(s1.header.name, "Ninja");
    s1.header.marks = 89;
    s1.header.size = 40;
    s1.header.age = 4;
    
    printf("Address of s1.header.marks\n");
    printf("%x\n", &s1.header.marks);
    
    printf("Address of s1.header.size\n");
    printf("%x\n", &s1.header.size);
    
    printf("Address of s1.header.age\n");
    printf("%x\n", &s1.header.age);
    
    s1.id = 18993030000;
    printf("Address of s1.id\n");
    printf("%x\n", &s1.id);

    printf("age - %d\n", s1.header.age);
    printf("size - %d\n", s1.header.size);
    printf("marks - %d\n", s1.header.marks);
    
    printf("id - %ld\n", s1.id);

    return 0;
}
