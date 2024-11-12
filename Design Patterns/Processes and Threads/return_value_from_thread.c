#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

void* start_routine_return_int() {
    int value = 23;
    int * ptr = (int*) malloc(sizeof(int));
    *ptr = value;
    return ptr;
}

void* start_routine_return_string() {
    char* str = "abcd";
    return str;
}

int main(int argc, char* argv[]) {
    pthread_t t1, t2;
    if(pthread_create(&t1, NULL, start_routine_return_int, NULL) != 0) {
        perror("Thread Creation failed\n");
    }

    int* val;

    if(pthread_join(t1, (void**) &val) != 0) {
        perror("Thread Join failed\n");
    }

    printf("Value is: %d\n", *val);

    if(val) {
        free(val);
        val = NULL;
    }

    if(pthread_create(&t2, NULL, start_routine_return_string, NULL) != 0) {
        perror("Thread Creation failed\n");
    }

    char* sval;

    if(pthread_join(t2, (void**) &sval) != 0) {
        perror("Thread Join failed\n");
    }

    printf("%s\n", sval);

}