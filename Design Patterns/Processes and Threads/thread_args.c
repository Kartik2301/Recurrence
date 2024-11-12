#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

int mails = 0;
pthread_mutex_t mutex;

void* thread_routine(void *arg) {
	for(int i = 0; i < 1000; i++) {
		pthread_mutex_lock(&mutex);
		mails++;
		pthread_mutex_unlock(&mutex);
	}
	return NULL;
}

int main(int argc, char const *argv[])
{
	pthread_t t[4];
	pthread_mutex_init(&mutex, NULL);

	for(int i = 0; i < 4; i++) {
		if(pthread_create(&t[i], NULL, thread_routine, NULL) != 0) {
			fprintf(stderr, "Thread creation failed");
		}
	}

	for(int i = 0; i < 4; i++) {
		if(pthread_join(t[i], NULL) != 0) {
			fprintf(stderr, "Thread Join failed\n");
		}
	}

	printf("%d\n", mails);

	pthread_mutex_destroy(&mutex);

	return 0;
}