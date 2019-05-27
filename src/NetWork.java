import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import static java.net.InetAddress.getLocalHost;
public class NetWork {
    InetAddress host = InetAddress.getLocalHost();
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    public NetWork() throws IOException{
        // socket = new Socket("localhost", 1234);
        socket = new Socket(host.getHostAddress(),4321);
        dataInputStream = new DataInputStream(System.in);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("salam chetoori googool?");
        System.out.println(dataInputStream.readUTF());
        dataOutputStream.close();
        dataInputStream.close();

    }
//    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//    String userInput;
//while ((userInput = stdIn.readLine) != null) {
       // out.println("hi");
   //     System.out.println("echo: " + in.readLine());
    //}

}
