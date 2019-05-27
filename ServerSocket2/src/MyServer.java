import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    private static final int PORT = 4321;
    private ServerSocket serverSocket;

    public MyServer() throws Exception {
        serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket client = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(client);
        }
    }
}