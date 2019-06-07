import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
    private static final int PORT = 4321;
    private ServerSocket serverSocket;
    public MyServer() throws Exception {
        serverSocket = new ServerSocket(PORT);
        while(true){
            Socket client = serverSocket.accept();
            new Thread(new ClientHandler(client)).start();
            System.out.println("fdskhdfg");
        }
    }
}