package GUI;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class LoginDialog extends JDialog implements ActionListener {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    private MainApplication mainApplication;

    public LoginDialog(MainApplication mainApplication)
    {
        super(mainApplication);
        this.mainApplication = mainApplication;
        createGUI();
        setLocationRelativeTo(null);
    }

    private void createGUI()
    {
        usernameLabel = new JLabel("login:");
        passwordLabel = new JLabel("hasło:");
        usernameTextField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Zaloguj", new ImageIcon("src/images/lock.png"));
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);
        cancelButton = new JButton("Cancel", new ImageIcon("src/images/delete.png"));
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);

        addJPanel(usernameLabel, usernameTextField);
        addJPanel(passwordLabel, passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        this.getContentPane().add(buttonPanel);

        this.setTitle("Logowanie");
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        this.pack();
        this.setVisible(true);

    }

    private JPanel addJPanel(JLabel label, JTextField textField)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        panel.add(label,BorderLayout.WEST);
        panel.add(textField,BorderLayout.EAST);
        panel.setBorder(BorderFactory.createEmptyBorder(5,6,0,6));
        this.getContentPane().add(panel);
        return panel;
    }

    public void actionPerformed(ActionEvent e)
    {
         String command = e.getActionCommand();

         if(command.equals("login"))
         {
            String pass = "";
            char charPass[] = passwordField.getPassword();
            for(int i = 0; i < charPass.length; i++)
            {
                pass+=charPass[i];
            }

           mainApplication.login(usernameTextField.getText(),pass);
         }
         else if(command.equals("cancel"))
         {
             this.dispose();
         }
    }

}
