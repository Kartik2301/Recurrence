#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
	printf("Inside the parent process PID: %d\n", getpid());

	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed");
	} else if(rc == 0) {
		// inside child process
		printf("Child process PID: %d\n", getpid());
	} else {
		int rc_wait = wait(NULL);
		printf("Parent Process: %d, with child: %d waiting for %d to complete execution\n", getpid(), rc, rc_wait);
	}

	return 0;
}