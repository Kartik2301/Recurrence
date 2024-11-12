#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

int sum = 0;

void * start_routine() {
    for(int i = 0; i < 1e7; i++) {
        sum++;
    }
    return NULL;
}

int main(int argc, char* argv[]) {
    pthread_t t1, t2;
    if(pthread_create(&t1, NULL, start_routine, NULL) != 0) {
        printf("pthread_create failed\n");
    }

    if(pthread_create(&t2, NULL, start_routine, NULL) != 0) {
        printf("pthread_create failed\n");
    }

    if(pthread_join(t1, NULL) != 0) {
        printf("pthread_join failed\n");
    }

    if(pthread_join(t2, NULL) != 0) {
        printf("pthread_join failed\n");
    }

    printf("What's the sum? %d\n", sum);

    return 0;
}
