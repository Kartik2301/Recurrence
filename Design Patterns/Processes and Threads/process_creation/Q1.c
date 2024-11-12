// Write a programthat calls fork(). Before calling fork(), have the main process access a variable (e.g., x) and set its value to something
// (e.g., 100). What value is the variable in the child process? What happens to the variablewhen both the child and parent change the value of x?


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
	
	int x = 250;
	printf("parent process PID:%d, value of x:%d\n", getpid(), x);

	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
	} else if(rc == 0) {
		printf("Before modificaiton: Inside the child process, PID:%d, value of x:%d\n", getpid(), x);
		x = 750;
		printf("Post modification: Inside the child process, PID:%d, value of x:%d\n", getpid(), x);
	} else {
		int rc_wait = wait(NULL);
		printf("Parent Process, PID:%d, value of x:%d, and now I am the parent of %d\n", getpid(), x, rc);
	}

	return 0;
}
