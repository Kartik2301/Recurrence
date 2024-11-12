#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char* argv[]) {
    int x = 2;
    int pid = fork();
    if(pid < 0) {
        fprintf(stderr, "Fork Failed");
    } else if(pid == 0) {
        // Child Process
        x++;
        printf("Child Process PID: %d\n", getpid());
        printf("Value of x in Child Process is %d\n", x);
    } else {
        // Parent Process
        int rc_wait = wait(NULL);
        printf("Parent Process PID: %d\n", getpid());
        printf("Value of x in Parent Process is %d\n", x);
    }
}