#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <time.h>

void* roll_die() {
    int value = (rand() % 6) + 1;
    printf("Value is %d\n", value);

    int* ptr = (int*) malloc(sizeof(int));
    *ptr = value;
    return ptr;
}

int main(int argc, char * argv[]) {
    srand(time(NULL));
    pthread_t th;
    if(pthread_create(&th, NULL, roll_die, NULL) != 0) {
        perror("This is a massive error, the company is down\n");
    }

    int* result;
    if(pthread_join(th, (void**) &result) != 0) {
        perror("Run, the building is down\n");
    }

    printf("%d\n", *result);

    if(result) {
        free(result);
    }

    return 0;
}