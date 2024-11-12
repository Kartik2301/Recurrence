// Write a program that creates two children, and connects the standard
// output of one to the standard input of the other, using the
// pipe() system call

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char const *argv[])
{
	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
		exit(1);
	} else if(rc == 0) {
		// inside child process - 1
		close(STDOUT_FILENO);
		int fd = open("connect.txt", O_CREAT | O_WRONLY | O_TRUNC, S_IRWXU);
		write(fd, "Hello World Claimed\n", strlen("Hello_World_Claimed\n"));
		close(fd);
	} else {
		// inside parent process
		int ret = fork();
		if(ret < 0) {
			fprintf(stderr, "Fork Failed\n");
			exit(1);
		} else if(ret == 0) {
			// inside the child process
			close(STDIN_FILENO);
			int fd = open("connect.txt", O_RDONLY, S_IRWXU);

			char data[25];
			scanf("%[^\n]", data);
			printf("%s\n", data);
		} else {
			// back in the parent process.
		}
	}
	return 0;
}
