import javax.swing.*;

public class ChatArea extends JTextArea {
    private static final int ROWS = 10, COLUMNS = 30;

    public ChatArea() {
        super(ROWS, COLUMNS);
        this.setEditable(false);
        this.setLineWrap(true);
    }
    public void addMessage(String name , String message){
        append("   ");
        append(name);
        append(" : ");
        append(message);
        append(" . \n");
    }
}
