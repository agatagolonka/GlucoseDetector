package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterDialog extends JDialog implements ActionListener{

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton cancelButton;

    private MainApplication mainApplication;

    public RegisterDialog(MainApplication mainApplication)
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
        confirmPasswordLabel = new JLabel("potwierdź hasło:");

        usernameTextField = new JTextField(10);
        passwordField = new JPasswordField(10);
        confirmPasswordField = new JPasswordField(10);
        registerButton = new JButton("Zarejestruj", new ImageIcon("src/images/register.png"));
        registerButton.setActionCommand("register");
        registerButton.addActionListener(this);
        cancelButton = new JButton("Cancel", new ImageIcon("src/images/delete.png"));
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);

        addJPanel(usernameLabel, usernameTextField);
        addJPanel(passwordLabel, passwordField);
        addJPanel(confirmPasswordLabel, confirmPasswordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        this.setTitle("Rejestracja");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.getContentPane().add(buttonPanel);

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

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if(command.equals("register"))
        {
            boolean equalPass = true;
            char[] pass1 = passwordField.getPassword();
            char[] pass2 = confirmPasswordField.getPassword();
            String pass = "";
            for(int i = 0; i < pass1.length; i++)
            {
                if(pass1[i] != pass2[i])
                    equalPass = false;
                pass+=pass1[i];
            }
            
            if( (equalPass == true) && (pass1.length == pass2.length))
            {
                mainApplication.register(usernameTextField.getText(),pass);
                this.dispose();
            }

        }
        else if(command.equals("cancel"))
        {
            this.dispose();
        }
    }

}
