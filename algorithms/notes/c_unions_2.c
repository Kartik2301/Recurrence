// Online C compiler to run C program online
#include <stdio.h>
#include <string.h>

union person {
    int age;
    int weight;
    char fav_c;
    char name[32];
} p1;

int main() {
    // Write C code here
    
    p1.age = 15;
    p1.weight = 90;
    p1.fav_c = 'a';
    strcpy(p1.name, "Elephant");
    
    printf("a - %d\n", p1.age);
    printf("b - %d\n", p1.weight);
    printf("fav_c - %d\n", p1.fav_c);
    printf("byt - %s\n", p1.name);
    

    return 0;
}
