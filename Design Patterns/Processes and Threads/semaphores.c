#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

#define THREAD_NUM 4

sem_t semaphore;

void* thread_routine(void *arg) {
    sem_wait(&semaphore);
    sleep(1);
    int id = *(int*)arg;
    printf("Hello from thread: %d\n", id);
    if(arg) {
        free(arg);
        arg = NULL;
    }
    sem_post(&semaphore);
    if(arg) {
        free(arg);
        arg = NULL;re
    }
    
    return NULL;
}

int main() {
    pthread_t th[THREAD_NUM];
    sem_init(&semaphore, 0, 1);

    for(int i = 0; i < THREAD_NUM; i++) {
        int* a = (int*) malloc(sizeof(int));
        *a = i;
        if(pthread_create(&th[i], NULL, thread_routine, a) != 0) {
            fprintf(stderr, "Thread Creation Failed");
        }
    }

    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_join(th[i], NULL) != 0) {
            fprintf(stderr, "Thread Join failed");
        }
    }

    sem_destroy(&semaphore);
}