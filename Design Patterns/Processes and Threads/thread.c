#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

void* start_routine() {
    printf("This is the start Routine\n");
    return NULL;
}

int main(int argc, char * argv[]) {
    pthread_t t;
    if(pthread_create(&t, NULL, start_routine, NULL) != 0) {
        printf("Thread Creation Failed\n");
    }

    if(pthread_join(t, NULL) != 0) {
        printf("Thread Join Failed\n");
    }

    return 0;
}