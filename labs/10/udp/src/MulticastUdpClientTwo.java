import java.io.IOException;
import java.net.*;

public class MulticastUdpClientTwo {
    public static void main() throws IOException {

        MulticastSocket clientSocket = new MulticastSocket(5000);
        InetAddress address = InetAddress.getByName("230.0.0.1");
        clientSocket.joinGroup(address);

        for(int i = 0; i < 20; i++){
            byte[] message = new byte[100];
            DatagramPacket packet = new DatagramPacket(message, message.length);
            clientSocket.receive(packet);
            System.out.println("Received message " + new String(message).trim());
        }
    }
}
