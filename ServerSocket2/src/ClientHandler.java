import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class ClientHandler {
    private Socket socket ;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    public ClientHandler(Socket client) throws Exception {
        if (client == null)
            throw new Exception("client can't be null");
        this.socket = client;
        dataOutputStream = new DataOutputStream(client.getOutputStream());
        dataInputStream = new DataInputStream(client.getInputStream());
        run();
    }
    private void handleIncomingMessages(String message){
        System.out.println(message);
    }
    public void run() {
        while(true){
            try {
                String input = dataInputStream.readUTF();
                handleIncomingMessages(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}