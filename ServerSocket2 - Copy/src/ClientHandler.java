import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket socket ;
    private DataOutputStream dataOutputStream;
    private static ArrayList<DataOutputStream> dataOutputStreams = new ArrayList<>();
    private DataInputStream dataInputStream;
    public ClientHandler(Socket client) throws Exception {
        if (client == null)
            throw new Exception("client can't be null");
        this.socket = client;
        dataOutputStream = new DataOutputStream(client.getOutputStream());
        dataOutputStreams.add(dataOutputStream);
        dataInputStream = new DataInputStream(client.getInputStream());
    }
    private void handleIncomingMessages(String message) throws IOException {
        for (DataOutputStream x: dataOutputStreams){
            x.writeUTF(message);
        }
        System.out.println(message);
    }
    @Override
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