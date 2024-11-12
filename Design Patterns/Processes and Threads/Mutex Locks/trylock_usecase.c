#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <time.h>

#define THREAD_NUM 10

pthread_mutex_t mutex[4];
int stoveFuel[4] = {100, 100, 100, 100};

void* start_routine(void* arg) {
    for(int i = 0; i < 4; i++) {
        if(pthread_mutex_trylock(&mutex[i]) == 0) {
            // Lock acquired
            int tid = *(int*) arg;
            int fuelNeeded = rand() % 30;
            if(fuelNeeded > stoveFuel[i]) {
                printf("Cook %d: No fuel left, going home\n", tid);
            } else {
                stoveFuel[i] -= fuelNeeded;
                usleep(500000);
                printf("Cook: %d, Fuel Needed: %d, Fuel left: %d\n", tid, fuelNeeded, stoveFuel[i]);
            }
            free(arg);
            pthread_mutex_unlock(&mutex[i]);
            break;

        } else {
            if(i == 3) {
                sleep(1);
                i = 0;
            }
        }
    }

    return NULL;
}

int main(int argc, char* argv[]) {
    srand(time(NULL));
    pthread_t th[THREAD_NUM];

    for(int i = 0; i < 4; i++) {
        pthread_mutex_init(&mutex[i], NULL);
    }
    
    for(int i = 0; i < THREAD_NUM; i++) {
        int* ptr = (int*) malloc(sizeof(int));
        *ptr = i;
        if(pthread_create(&th[i], NULL, start_routine, ptr) != 0) {
            perror("Thread Creation Failed\n");
        }
    }

    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_join(th[i], NULL) != 0) {
            perror("Thread Join Failed\n");
        }
    }

    for(int i = 0; i < 4; i++) {
        pthread_mutex_destroy(&mutex[i]);
    }

    return 0;
}
