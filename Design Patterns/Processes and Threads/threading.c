#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <stdbool.h>

static volatile int counter = 0;

void * thread_routine(void * arg) {
	printf("%s\n", (char *) arg);

	for(int i = 0; i < 1e7; i++) {
		counter++;
	}
	
	return NULL;
}

int main(int argc, char const *argv[])
{
	pthread_t t1, t2;
	printf("main:begin coutner = %d\n", counter);

	pthread_create(&t1, NULL, thread_routine, "A");
	pthread_create(&t2, NULL, thread_routine, "B");

	pthread_join(t1, NULL);
	pthread_join(t2, NULL);

	printf("main:end counter = %d\n", counter);
	return 0;
}