#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>  // exit

// port number and IP address of the server we want to connect to:
const unsigned short int PORT = 1234;
const char * SERVER = "127.0.0.1"; //"192.168.1.1";

int main(void)
{
  char buffer[256];
    int fd;
    struct sockaddr_in remoteAddress;

    //create a socket:
    if( (fd = socket(PF_INET, SOCK_STREAM, 0)) == -1 )
        //SOCK_STREAM=TCP, 0=IP
    {
        perror( "socket" );
        exit(1);
    }

    //IP address and port number of the server we would like to connect to:
    remoteAddress.sin_family = AF_INET;  //AF_INET=IPv4
    remoteAddress.sin_port = htons(PORT);  //htons=change Host byte order TO Network byte order, Short data
    remoteAddress.sin_addr.s_addr = inet_addr( SERVER );  //inet_addr changes string notation
                                                              //(such as 192.168.1.1) to a long number
    memset(&(remoteAddress.sin_zero), '\0', 8);

    //try to connect to the server:
    if( connect(fd, (struct sockaddr *)&remoteAddress, sizeof(struct sockaddr)) == -1)
    {
        perror( "connect" );
        exit(2);
    }
    printf("Success!\n");

    //now we have a working connection between this client and the server;
    //we can receive and send data
    printf("please enter some message:");
    bzero(buffer,256);
    fgets(buffer,255,stdin);
    //scanf("%s",buffer);
        printf("You wrote: [%s], which is %d bytes\n",buffer,strlen(buffer));
    if(write(fd,buffer,strlen(buffer)==-1)){
    perror("ERROR writing to socket");
    }
    bzero(buffer,256);
    if(read(fd,buffer,255)==-1){
    perror("ERROR reading from socket");
    }
        printf("%s\n",buffer);


    close( fd );  //close the socket when finished
    return 0;
}
