// Write a program that calls fork() and then calls some form of exec() to run the program /bin/ls. See if you can try all of the
// variants of exec(), including (on Linux) execl(), execle(), execlp(), execv(), execvp(), and execvpe(). Why do you think there are so many variants of the same basic call?

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
	printf("Parent Process, PID:%d\n", getpid());
	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
		exit(1);
	} else if(rc == 0) {
		// Child Process;
		printf("Child Process, PID:%d\n", getpid());

		char* args[3];
		args[0] = "ls";
		args[1] = ".";
		args[2] = NULL;

		execvp(args[0], args);
	} else {
		int rc_wait = wait(NULL);
		printf("Parent Process, PID:%d, now the parent of %d\n", getpid(), rc);
	}

	return 0;
}