package neverfate_bot;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Vector;

/**
 * Created by sild on 6/20/14.
 */
public class Gui {
    private JButton startBtn;
    private JComboBox users;
    private JComboBox actions;

    //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    private JFrame frame;
    public Gui()
    {
        this.createForm();
        this.addUsersPanel();
        this.addActionsPanel();
        this.addStartButton();





        this.frame.setVisible(true);
    }

    private void addStartButton() {
        JButton startBtn = new JButton( "Start");

        startBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)//печальные хаки из-за отсутствия указателей на функцию. надо бы разобраться при случае.
            {
                String user = (String)Gui.this.users.getSelectedItem();
                String action = (String)Gui.this.actions.getSelectedItem();
                System.out.println(user);
                if( "lvlup" == action) {
                    String password = UserManager.getInstance().users().get(user).password();
                    Nogame.auth(user, password);
                    Lvlup.start();
                } else if ("catacomb" == action) {
                    String password = UserManager.getInstance().users().get(user).password();
                    Nogame.auth(user, password);
                    new Catacomb().run();
//                    while(true) {
//                        Fight.begin();
//                    }
                }else if ("pack_of_wolves" == action) {
                    String password = UserManager.getInstance().users().get(user).password();
                    Nogame.auth(user, password);
                    while(true) {
                        new PackOfWolves().run();
                    }

                } else if ("calendar" == action) {
                    Calendar.check(UserManager.getInstance().users());

                } else if ( "Pray" == action) {
                    String password = UserManager.getInstance().users().get(user).password();
                    Nogame.auth(user, password);
                    while(true)
                    {
                        try {
                            Chrine.start_pray();
                        } catch (Exception a) {

                        }
                    }


                } else{
                    System.out.println("method " + action + " unrecognize");
                }
            }
        });
        this.frame.add(startBtn,BorderLayout.SOUTH);
    }

    private void addUsersPanel() {
        JLabel usersLbl = new JLabel("user:");
        Vector<String> userLogins = new Vector<String>();
        for(Map.Entry<String, UserManager.User> user : UserManager.getInstance().users().entrySet() ) {
            userLogins.add(user.getKey());
        }
        this.users = new JComboBox(userLogins.toArray());
        this.users.setSelectedIndex(3);
        final JPanel usersPanel = new JPanel();
        usersPanel.add(usersLbl);
        usersPanel.add(this.users);
        this.frame.add(usersPanel, BorderLayout.NORTH);

    }

    private void addActionsPanel() {
        JLabel actionLbl = new JLabel("action:");
        Vector<String> actionsOpt = new Vector<String>(Arrays.asList("lvlup", "catacomb", "pack_of_wolves", "calendar", "Pray"));
        this.actions = new JComboBox(actionsOpt.toArray());
        this.actions.setSelectedIndex(1);
        final JPanel actionsPanel = new JPanel();
        actionsPanel.add(actionLbl);
        actionsPanel.add(this.actions);
        this.frame.add( actionsPanel, BorderLayout.WEST);

    }

    private void createForm() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("neverfate");
        this.frame.setSize(500,250);
        this.frame.setLocationRelativeTo(null);

    }
}
