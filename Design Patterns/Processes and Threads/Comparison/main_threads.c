#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

void* start_routine() {
    printf("Hello everyone from %d, now get\n", getpid());
    return NULL;
}

int main(int argc, char* argv[]) {
    pthread_t t1, t2;
    if(pthread_create(&t1, NULL, start_routine, NULL) != 0) {
        fprintf(stderr, "Thread Creation Failed");
    }
    
    if(pthread_create(&t2, NULL, start_routine, NULL) != 0) {
        fprintf(stderr, "Thread Creation Failed");
    }

    if(pthread_join(t1, NULL)) {
        fprintf(stderr, "Thread Join Failed");
    }

    if(pthread_join(t2, NULL)) {
        fprintf(stderr, "Thread Join Failed");
    }
}