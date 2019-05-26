import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.net.InetAddress.getLocalHost;

public class NetWork<userInput> {
    Socket socket = new Socket("localhost", 1234);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String userInput;
//while ((userInput = stdIn.readLine) != null) {
       // out.println("hi");
   //     System.out.println("echo: " + in.readLine());
    //}

    public NetWork() throws IOException {
    }
}
