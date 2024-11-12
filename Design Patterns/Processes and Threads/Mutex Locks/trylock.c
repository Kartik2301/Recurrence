#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define THREAD_NUM 4

pthread_mutex_t mutex;

void* start_routine() {
    if(pthread_mutex_trylock(&mutex) == 0) {
        printf("Got lock\n");
        sleep(1);
        pthread_mutex_unlock(&mutex);
    } else {
        printf("Didn't get the lock\n");
    }
    return NULL;
}

int main(int argc, char* argv[]) {
    pthread_t th[THREAD_NUM];
    pthread_mutex_init(&mutex, NULL);
    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_create(&th[i], NULL, start_routine, NULL) != 0) {
            perror("Thread Creation Failed\n");
        }
    }

    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_join(th[i], NULL) != 0) {
            perror("Thread Join Failed\n");
        }
    }

    pthread_mutex_destroy(&mutex);
    return 0;
}
