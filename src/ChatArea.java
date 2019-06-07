import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChatArea extends JTextArea {
    private static final int ROWS = 10, COLUMNS = 30;

    public ChatArea() {
        super(ROWS, COLUMNS);
        this.setEditable(false);
        this.setLineWrap(true);
        this.setBorder(new EmptyBorder(10,10,10,10));
    }
    public void addMessage(String name , String message){
//        append("   ");
//        append(name);
//        append(" : ");
        append(message);
        append("\n");
    }
}
