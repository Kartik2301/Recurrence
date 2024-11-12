// Write a program that opens a file (with the open() system call)
// and then calls fork() to create a new process. Can both the child
// and parent access the file descriptor returned by open()? What
// happens when they are writing to the file concurrently, i.e., at the
// same time?

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char const *argv[])
{
	int fd = open("info.txt", O_CREAT | O_WRONLY | O_TRUNC, S_IRWXU);
	printf("File Descriptor Created, fd = %d\n", fd);

	int rc = fork();
	if(rc < 0) {
		fprintf(stderr, "Fork Failed\n");
	} else if(rc == 0) {
		printf("Child-Process PID:%d\n", getpid());
		printf("Child-Process, access the descriptor %d\n", fd);

		write(fd, "hello Child-Process\n", strlen("hello Child-Process\n"));
	} else {
		int rc_wait = wait(NULL);
		printf("Parent-Process PID: %d, now the parent of %d\n", getpid(), rc);
		printf("Parent-Process, access the descriptor %d\n", fd);

		write(fd, "hello Parent-Process\n", strlen("hello Parent-Process\n"));
	}

	return 0;
}
