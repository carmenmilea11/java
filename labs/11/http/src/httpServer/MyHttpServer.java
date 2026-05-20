package httpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer {

    public static void main() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(10001)){
            System.out.println("Server running on port 10001");

            while(true){
                Socket clientSocket = serverSocket.accept();
                MyHttpServerThread thread = new MyHttpServerThread(clientSocket);
                thread.start();
            }
        }
    }
}
