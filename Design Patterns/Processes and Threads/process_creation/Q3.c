// Write another program using fork(). The child process should print “hello”; the parent process should print “goodbye”. You should
// try to ensure that the child process always prints first; can you do this without calling wait() in the parent?

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
	} else if (rc == 0) {
		printf("Hello ");
	} else {
		// int rc_wait = wait(NULL);
		sleep(1);
		printf("Goodbye ");
	}
	return 0;
}