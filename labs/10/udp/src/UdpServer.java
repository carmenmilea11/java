import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class UdpServer {
    public static void main() throws IOException {

        DatagramSocket serverSocket = new DatagramSocket(7777);
        System.out.println("UDP Server is running on port 7777");

        while(true){
            byte[] requestMessage = new byte[100];
            DatagramPacket requestPacket = new DatagramPacket(
                    requestMessage, requestMessage.length
            );

            serverSocket.receive(requestPacket);
            String request = new String(requestMessage);

            System.out.println("Received request" + request +
                    "from " + requestPacket.getAddress() + " " +
                    requestPacket.getPort());

            String response = null;
            if("What date is it?".equals(
                    new String(requestPacket.getData()).trim())){
                response = new Date().toString();
            }else{
                response = "Invalid request";
            }

            byte[] responseMessage = response.getBytes();

            DatagramPacket responsePacket = new DatagramPacket(
                    responseMessage, responseMessage.length,
                    requestPacket.getAddress(),
                    requestPacket.getPort()
            );

            serverSocket.send(responsePacket);
            System.out.println("Sent response" + response);

        }

    }
}
