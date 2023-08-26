#include <stdio.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <unistd.h>
#include <arpa/inet.h>

int main() {
    struct sockaddr_in server_address;

    server_address.sin_family = AF_INET;
    server_address.sin_port = htons(2000);
    server_address.sin_addr.s_addr = inet_addr("127.0.0.1");

    int socket_desc = socket(AF_INET, SOCK_STREAM, 0);
    if(socket_desc < 0 ) {
        printf("Socket Creation Failed\n");
        exit(EXIT_FAILURE);
    }

    if(connect(socket_desc, (struct sockaddr *) &server_address, sizeof(server_address)) < 0) {
        printf("Failed to connect to server\n");
        exit(EXIT_FAILURE);
    }

    char client_message[] = "Hello server!!!";
    
    if(send(socket_desc, client_message, sizeof(client_message), 0) < 0) {
        printf("Could not send message to server\n");
        exit(EXIT_FAILURE);
    }

    printf("Connected with server successfully\n");

    close(socket_desc);

    return 0;
}
