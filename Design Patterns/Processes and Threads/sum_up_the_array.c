#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define THREAD_NUM 2

int primes[10] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

void* sum_prime(void* arg) {
    int sum = 0;
    int* index = (int*) arg;
    
    for(int i = 0; i < 5; i++) {
        sum += primes[*index + i];
    }
    *(int*) arg = sum;
    return arg;
}

int main(int argc, char* argv[]) {
    pthread_t th[THREAD_NUM];

    for(int i = 0; i < THREAD_NUM; i++) {
        int* ptr = (int*) malloc(sizeof(int));
        if(i == 0) {
            *ptr = 0;
        } else {
            *ptr = 5;
        }
        if(pthread_create(&th[i], NULL, sum_prime, ptr) != 0) {
            perror("Pthread Create Failed\n");
        }
    }

    int sum = 0;
    int* value;

    for(int i = 0; i < THREAD_NUM; i++) {
        if(pthread_join(th[i], (void**) &value) != 0) {
            perror("Pthread Join Failed\n");
        }
        sum += *value;
        free(value);
    }

    printf("The sum is: %d\n", sum);
}