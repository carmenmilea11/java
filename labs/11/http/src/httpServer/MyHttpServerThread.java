package httpServer;

import java.io.*;
import java.net.Socket;

public class MyHttpServerThread extends Thread{

    private Socket clientSocket;

    public MyHttpServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader bufferedInputStream =
                    new BufferedReader(new InputStreamReader(inputStream));

            String readLine = "";
            StringBuilder finalInput = new StringBuilder();

            while((readLine = bufferedInputStream.readLine()) != null
            && !readLine.isEmpty()){
                finalInput.append(readLine);
            }

            String outputString = processRequest(finalInput.toString());

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream,true);

            printWriter.println(outputString);
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String processRequest(String input){
        String output = "";

        String fileName = input
                .substring(input.indexOf("/") + 1,input.indexOf(" HTTP"));

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            byte[] readLine = new byte[4096];
            int byteCount = 0;
            StringBuilder finalOutput = new StringBuilder();

            while( (byteCount = fileInputStream.read(readLine)) > 1){
                finalOutput.append(new String(readLine, 0, byteCount));
            }

            fileInputStream.close();
            output = "HTTP/1.1 200 OK\r\nContent-Type: text/html" +
            "\r\nContent-Length: " + (finalOutput.toString().length())
            +"\r\n\r\n" + finalOutput.toString();


        } catch (IOException e) {
            output = "HTTP/1.1 404\r\n";
        }


        return output;
    }
}
