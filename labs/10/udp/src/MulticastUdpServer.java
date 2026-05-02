import java.io.IOException;
import java.net.*;
import java.util.Date;

public class MulticastUdpServer {

    public static void main() throws IOException, InterruptedException {
        DatagramSocket serverSocket = new DatagramSocket(7777);
        System.out.println("UDP Server is running on port 7777");

        while(true){
            String message = new Date().toString();
            byte[] messageBytes = message.getBytes();

            InetAddress multicastAddress = InetAddress.getByName("230.0.0.1");
            int port = 5000;

            DatagramPacket messagePacket = new DatagramPacket(
                    messageBytes, messageBytes.length,
                    multicastAddress,
                    port
            );

            serverSocket.send(messagePacket);
            System.out.println("Send message: " + message);
            Thread.currentThread().sleep(5000);
        }

    }
}
