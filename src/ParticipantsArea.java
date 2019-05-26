import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ParticipantsArea extends JPanel {
    private JList<String> usersList;
    private ArrayList<String> usersName;
    JLabel label;
    public ParticipantsArea(){
        this.setLayout(new BorderLayout());
        label = new JLabel("Online People");
        this.add(label,BorderLayout.NORTH);
        usersList = new JList<String>();
        usersName = new ArrayList<String>();
        this.add(usersList,BorderLayout.CENTER);
    }
    public void addUser(String user){
        usersName.add(user);
        usersList.setListData(usersName.toArray(new String[usersName.size()]));
    }
    public void removeUser(String user){
        usersName.remove(user);
        usersList.setListData(usersName.toArray(new String[usersName.size()]));
    }
    public JLabel getLabel(){
        return label;
    }
    public JList<String> getList(){
        return usersList;
    }
}

