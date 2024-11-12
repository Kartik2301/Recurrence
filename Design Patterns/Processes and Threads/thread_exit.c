#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>

void* start_routine() {
    int die = (rand() % 6 + 1);
    int* ptr = (int*) malloc(sizeof(int));
    *ptr = die;
    pthread_exit(ptr);
}

int main(int argc, char* argv[]) {
    srand(time(NULL));

    pthread_t t;
    if(pthread_create(&t, NULL, start_routine, NULL) != 0) {
        perror("Thread Creation Failed\n");
    }

    int* value;
    if(pthread_join(t, (void**) &value) != 0) {
        perror("Thread Join Failed");
    }

    printf("Value is: %d\n", *value);
    return 0;
}
