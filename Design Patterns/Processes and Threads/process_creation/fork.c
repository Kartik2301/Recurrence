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
		// Inside the child process
		printf("Child Process PID: %d\n", getpid());
	} else {
		// Parent process
		printf("Parent process pid: %d, is the parent of PID: %d\n", getpid(), rc);
	}
	return 0;
}