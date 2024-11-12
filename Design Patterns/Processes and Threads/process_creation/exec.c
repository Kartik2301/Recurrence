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
		// inside the child process
		printf("Child Process PID: %d\n", getpid());

		// exec inside the child
		char* args[3];
		args[0] = "wc";
		args[1] = "exec.c";
		args[2] = NULL;

		execvp(args[0], args);
	} else {
		// inside the parent process
		int rc_wait = wait(NULL);
		printf("Parent Process: %d, now the parent of %d, wait for %d\n", getpid(), rc, rc_wait);
	}

	return 0;
}