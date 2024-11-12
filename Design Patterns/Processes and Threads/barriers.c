#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define THREAD_NUM 9
pthread_barrier_t barrier;

void* start_routine() {
    printf("At the barrier\n");
    pthread_barrier_wait(&barrier);
    printf("Crossed the Barrier\n");
}

int main(int argc, char* argv[]) {
    pthread_t th[THREAD_NUM];
    pthread_barrier_init(&barrier, NULL, 3);

    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_create(&th[i], NULL, start_routine, NULL) != 0) {
            perror("Error create");
        }
    }

    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_join(th[i], NULL) != 0) {
            perror("Error create");
        }
    }

    pthread_barrier_destroy(&barrier);
}
