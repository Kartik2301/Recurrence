#include <stdio.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <unistd.h>

#define PORT 2000

int main() {
    /*
        Socket Address -

        #include <netinet/in.h>

        struct sockaddr_in {
            short            sin_family;   // e.g. AF_INET
            unsigned short   sin_port;     // e.g. htons(3490)
            struct in_addr   sin_addr;     // see struct in_addr, below
            char             sin_zero[8];  // zero this if you want to
        };

        struct in_addr {
            unsigned long s_addr;  // load with inet_aton()
        };
    */
    struct sockaddr_in server_address, client_address;
    
    // The AF_INET address family is the address family for IPv4.
    // The AF_INET6 address family is the address family for IPv6.

    server_address.sin_family = AF_INET;
    server_address.sin_port = htons(PORT);
    server_address.sin_addr.s_addr = INADDR_ANY;

    // Socket Creation
    // Protocol value for Internet Protocol(IP), which is 0
    int socket_desc = socket(AF_INET, SOCK_STREAM, 0);

    if(socket_desc < 0) {
        printf("Socket Creation Failed\n");
        exit(EXIT_FAILURE);
    }

    /*
        int bind(int sockfd, const struct sockaddr *addr, socklen_t addrlen);

            After the creation of the socket, the bind function binds the socket
            to the address and port number specified in addr(custom data structure).
    */

    if(bind(socket_desc, (struct sockaddr *) &server_address, sizeof(server_address)) < 0) {
        printf("Bind Failed\n");
        exit(EXIT_FAILURE);
    }

    /*
        int listen(int sockfd, int backlog);

            It puts the server socket in a passive mode, where it waits for the client to 
            approach the server to make a connection. The backlog, defines the maximum
            length to which the queue of pending connections for sockfd may grow. 
            If a connection request arrives when the queue is full, the client may receive an 
            error with an indication of ECONNREFUSED.
    */

    if(listen(socket_desc, 3) < 0) {
        printf("Listen failure\n");
        exit(EXIT_FAILURE);
    }

    /*
        int new_socket= accept(int sockfd, struct sockaddr *addr, socklen_t *addrlen);

            It extracts the first connection request on the queue of pending connections for the 
            listening socket, sockfd. The connection is established between client and server,
            and they are ready to transfer data.
            The server-side code stops and waits at accept() until a client calls connect().
            The accept() function creates a new socket from the 
            first connection request for the specified socket_descriptor and returns the 
            file descriptor of the new socket. 
    */

    // Accept an incoming connection
    int client_size = sizeof(client_address);
    int client_sock = accept(socket_desc, (struct sockaddr *) &server_address, (socklen_t *) &client_size);

    if(client_sock < 0) {
        printf("Failure during Accept system call\n");
        exit(EXIT_FAILURE);
    }
    
    char client_message[1024];
    if(recv(client_sock, client_message, sizeof(client_message), 0) < 0) {
        printf("Couldn't receive\n");
        exit(EXIT_FAILURE);
    }

    printf("%s", client_message);

    close(client_sock);
    close(socket_desc);
}
