#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define THREAD_NUM 30

int sum = 0;
pthread_mutex_t mutex;

void * start_routine() {
    for(int i = 0; i < 1e7; i++) {
        pthread_mutex_lock(&mutex);
        sum++;
        pthread_mutex_unlock(&mutex);
    }
    return NULL;
}

int main(int argc, char* argv[]) {
    pthread_t th[THREAD_NUM];
    pthread_mutex_init(&mutex, NULL);
    
    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_create(&th[i], NULL, start_routine, NULL) != 0) {
            perror("Thread Creation Failed");
        }
        
        printf("Thread %d created\n", i);
    }

    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_join(th[i], NULL) != 0) {
            perror("Thread Join Failed");
        }


        printf("Thread %d exited\n", i);
    }

    printf("Sum: %d\n", sum);
    pthread_mutex_destroy(&mutex);

    return 0;
}
