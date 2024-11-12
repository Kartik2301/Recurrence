// Nowwrite a programthat uses wait() to wait for the child process to finish in the parent. What does wait() return? What happens if you use wait() in the child?

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
	printf("Parent-Process with PID:%d\n", getpid());
	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
	} else if(rc == 0) {
		printf("Child-Process with PID:%d\n", getpid());
	} else {
		int rc_wait = wait(NULL);
		printf("Parent-Process PID:%d, waiting for %d\n", getpid(), rc_wait);
	}
	return 0;
}