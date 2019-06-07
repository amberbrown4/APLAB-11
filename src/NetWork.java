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
    private MessageListener listener;

    public NetWork() throws IOException {
        // socket = new Socket("localhost", 1234);
        socket = new Socket(host.getHostAddress(), 4321);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void work(String s) throws IOException {
        // user:message
        dataOutputStream.writeUTF(s);
//        System.out.println(dataInputStream.readUTF());
       // dataOutputStream.close();
       // dataInputStream.close();
    }
    public String getMessages() throws IOException {
        while(true){
            String message = dataInputStream.readUTF();
            listener.handle(message);
        }
    }
    public void setListener(MessageListener listener){
        this.listener = listener;
    }
}
