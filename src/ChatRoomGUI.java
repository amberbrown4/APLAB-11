import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatRoomGUI extends JFrame {
    private NetWork netWork = new NetWork();
    private String myName;
    private final String WINDOWS_TITLE = "AUT Chat Room";
    private final int WIDTH = 500, HEIGHT = 500;
    private final int X = 100, Y = 100;
    MessageArea messageArea;
    ParticipantsArea participantsaArea;
    ChatArea chatArea;

    public ChatRoomGUI(String myName) throws IOException {
        super();
        this.myName = myName;
        //ActionListener listener = new MessageListener();

        this.setTitle(WINDOWS_TITLE);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);
        //this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        messageArea = new MessageArea();
        messageArea.getButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String message = messageArea.getTextField().getText();
                System.out.println(message);
//                chatArea.addMessage(myName,message);
                messageArea.getTextField().setText("");
                try {
                    netWork.work(myName + " : `" +message);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        participantsaArea = new ParticipantsArea();
        chatArea = new ChatArea();
        panel.add(messageArea, BorderLayout.SOUTH);
        panel.add(participantsaArea, BorderLayout.WEST);
        panel.add(chatArea, BorderLayout.CENTER);
        this.setContentPane(panel);
        this.setVisible(true);
        netWork.setListener(new MessageListener() {
            @Override
            public void handle(String s) {
                chatArea.addMessage("", s);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    netWork.getMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void addMessage(String name , String message){
        chatArea.addMessage(name,message);
    }
    public void addNewParticipants(String participant) {
        participantsaArea.addUser(participant);
    }

    public void removeParticipants(String participant) {
        participantsaArea.removeUser(participant);
    }

}
