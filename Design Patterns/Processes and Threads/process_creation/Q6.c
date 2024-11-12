// Write a slight modification of the previous program, this time using waitpid() instead of wait(). When would waitpid() be useful?

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
	printf("Parent-Process with PID:%d\n", getpid());
	int ppid = getpid();

	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
	} else if(rc == 0) {
		printf("Child-Process with PID:%d\n", getpid());
	} else {
		int rc_wait = waitpid(rc, NULL, 0);
		printf("Parent-Process PID:%d, waiting for %d\n", getpid(), rc_wait);
	}
	return 0;
}