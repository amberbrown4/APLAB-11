import javax.swing.*;
import java.awt.*;

public class MessageArea extends JPanel {
    JButton button;
    JTextField textField;
    public MessageArea(){
        this.setLayout(new BorderLayout());
        button = new JButton("Send Message");
        this.add(button,BorderLayout.EAST);
        textField = new JTextField();
        this.add(textField,BorderLayout.CENTER);
    }
    public JButton getButton(){
        return button;
    }
    public JTextField getTextField(){
        return textField;
    }
}
