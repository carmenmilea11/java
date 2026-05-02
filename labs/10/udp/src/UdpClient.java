import java.io.IOException;
import java.net.*;

public class UdpClient {

    public static void main() throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        String message = "What date is it?";
        byte[] messageBytes = message.getBytes();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        int port = 7777;

        DatagramPacket packet = new DatagramPacket(messageBytes,
                messageBytes.length, serverAddress, port);

        clientSocket.send(packet);

        byte[] responseBytes = new byte[100];
        DatagramPacket responsePacket = new DatagramPacket(responseBytes,
                responseBytes.length);

        clientSocket.receive(responsePacket);

        String response = new String(responseBytes);
        System.out.println("Received message: " + response);

        clientSocket.close();

    }

}
