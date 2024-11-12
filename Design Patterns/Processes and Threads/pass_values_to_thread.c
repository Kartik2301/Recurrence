#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

int primes[10] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

void* print_prime(void* arg) {
    int* value = (int*) arg;
    printf("The prime is: %d\n", *value);
    return NULL;
}

int main(int argc, char* argv[]) {
    pthread_t th[10];
    for(int i = 0; i < 10; i++) {
        if(pthread_create(&th[i], NULL, print_prime, primes + i) != 0) {
            perror("This is a catastrophic failure, company is down\n");
        }
    }

    for(int i = 0; i < 10; i++) {
        if(pthread_join(th[i], NULL) != 0) {
            perror("Thread join failed\n");
        }
    }
}