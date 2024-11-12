// Write a program that creates a child process, and then in the child closes standard output (STDOUT FILENO). What happens if the child
// calls printf() to print some output after closing the descriptor?

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char const *argv[])
{
	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
	} else if(rc == 0) {
		close(STDOUT_FILENO);
		open("output.txt", O_CREAT | O_WRONLY | O_TRUNC, S_IRWXU);
		
		printf("Testing printing hello world\n");
	} else {
		int rc_wait = wait(NULL);
		printf("In the Parent Process PID:%d, and I am the parent of %d\n", getpid(), rc);
	}


	return 0;
}