import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserNameFrame extends JFrame{

    private static final String BTN_TXT = " Start Chatting ...";
    private static final String LABEL_TXT = " Choose Your UserName ";
    private static final int WIDTH = 300, HEIGHT = 100;
    JTextField textField;
    JButton btn;
    public UserNameFrame() throws HeadlessException {
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(LABEL_TXT);
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        add(textField, BorderLayout.CENTER);
        btn = new JButton(BTN_TXT);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myName= textField.getText();
                System.out.println(myName);
                textField.setText("");
                ChatRoomGUI chatRoomGUI = null;
                try {
                    chatRoomGUI = new ChatRoomGUI(myName);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                chatRoomGUI.addNewParticipants(myName);
                setVisible(false);
            }
        });
        add(btn, BorderLayout.PAGE_END);
        setSize(WIDTH, HEIGHT);
        setVisible(true);

    }
}
