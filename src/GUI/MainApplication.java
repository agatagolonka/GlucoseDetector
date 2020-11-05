package GUI;

import Exceptions.LoginExistsException;
import Exceptions.WrongLoginException;
import Exceptions.WrongRaportException;
import dao.LoginDao;
import dao.RegistrationDao;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class MainApplication extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu systemMenu;
    private JMenu raportsMenu;
  
    private JMenuItem loginItem;
    private JMenuItem registerItem;
    private JMenuItem raportItem;
    private Raport raporty;

    private JTabbedPane tabbedPane;
    private JPanel bottomInfoPanel;

    private LoginDialog loginDialog;
    private RegisterDialog registerDialog;



    public MainApplication()
    {
        initComponents();

        //tworzymy menu głównej aplikacji, dodajemy słuchacza zdarzeń

        systemMenu.setText("System");
        loginItem.setText("Zaloguj");
        loginItem.setActionCommand("login");
        loginItem.addActionListener(this);
        systemMenu.add(loginItem);
        registerItem.setText("Zarejestruj");
        registerItem.setActionCommand("register");
        registerItem.addActionListener(this);
        systemMenu.add(registerItem);
        menuBar.add(systemMenu);

        this.setResizable(false);

        raportsMenu.setText("Raporty");
        menuBar.add(raportsMenu);
        raportItem.setText("Mój raport");
        raportItem.setActionCommand("raport");
        raportItem.addActionListener(this);
        raportsMenu.add(raportItem);

////        chartsMenu.setText("Wykresy");
//        menuBar.add(chartsMenu);
//
//     //   wskaznikiMenu.setText("Wskaźniki");
//        menuBar.add(wskaznikiMenu);
//
//    //    caloriesMenu.setText("Kalorie");
//        menuBar.add(caloriesMenu);
//
//  //      helpMenu.setText("Pomoc");
//        menuBar.add(helpMenu);

        //zajmujemy się resztą okna

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));     
        tabbedPane.setMinimumSize(new Dimension(400,700));
        tabbedPane.setPreferredSize(new Dimension(400,600));
        this.add(tabbedPane);
        this.add(bottomInfoPanel);

        this.setJMenuBar(menuBar);
        this.setTitle("Symulator poziomu glukozy");
        this.setSize(400, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.setLoggedOutGUI();
    }

    private void initComponents()
    {
        menuBar = new JMenuBar();
        systemMenu = new JMenu();
        raportsMenu = new JMenu();
        raportItem = new JMenuItem();
//        chartsMenu = new JMenu();
//        wskaznikiMenu = new JMenu();
//        caloriesMenu = new JMenu();
//        helpMenu = new JMenu();
        loginItem = new JMenuItem();
        registerItem = new JMenuItem();
        tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        bottomInfoPanel = new JPanel();
    }

    public void setLoggedGUI()
    {
        raportsMenu.setEnabled(true);
//        chartsMenu.setEnabled(true);
//        wskaznikiMenu.setEnabled(true);
//        caloriesMenu.setEnabled(true);

        loginItem.setText("Wyloguj");
        loginItem.setActionCommand("logout");
        
        registerItem.setText("Wyrejestruj");
        registerItem.setActionCommand("unregister");

        addTab("Witaj!", new MainPanel());

    }

    public void setLoggedOutGUI()
    {
        raportsMenu.setEnabled(false);
//        chartsMenu.setEnabled(false);
//        wskaznikiMenu.setEnabled(false);
//        caloriesMenu.setEnabled(false);

        loginItem.setText("Zaloguj");
        loginItem.setActionCommand("login");

        registerItem.setText("Zarejestruj");
        registerItem.setActionCommand("register");

        tabbedPane.removeAll();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApplication().setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if(command.equals("login"))
        {
            loginDialog = new LoginDialog(this);
            loginDialog.pack();
            loginDialog.setVisible(true);
        }
        else if(command.equals("logout"))
        {
            logout();
        }
        else if(command.equals("register"))
        {
            registerDialog = new RegisterDialog(this);
            registerDialog.pack();
            registerDialog.setVisible(true);
        }
        else if(command.equals("unregister"))
        {
            try
            {
                unregister();
            }
            catch (SQLException ex) {}
        }
        else if(command.equals("closeTab"))
        {

        }
        else if(command.equals("raport")){
            try {
                raporty = new Raport();
            } catch (WrongRaportException ex) {
                Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            raporty.setVisible(true);
        }
    }

    public void register(String login, String pass)
    {
        try
        {
            RegistrationDao.register(login, pass);
            
        }
        catch (LoginExistsException ex)
        {
            JOptionPane.showMessageDialog(this, "Podany użytkownik już istnieje w bazie !", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void login(String login, String password)
    {
        try
        {
            LoginDao.logging(login, password);
            setLoggedGUI();
            loginDialog.dispose();
        }
        catch (WrongLoginException ex)
        {
            JOptionPane.showMessageDialog(this, "Podałeś błędny login lub hasło !", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void logout()
    {
        setLoggedOutGUI();
    }

    public void addTab(String title, JComponent component)
    {
        int tabCount = tabbedPane.getTabCount();
        tabbedPane.addTab(title, component);
        initTabComponent(tabCount);
        tabbedPane.setSelectedIndex(tabCount);
    }

    public void removeTab(JComponent c)
    {
        tabbedPane.remove(c);
    }

    private void unregister() throws SQLException
    {
        int answer = JOptionPane.showConfirmDialog(this,"Czy na pewno chcesz się wyrejestrować "+LoginDao.login+"?",
                                            "Wyrejestruj " + LoginDao.login ,
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.WARNING_MESSAGE);
        if(answer == JOptionPane.OK_OPTION)
            RegistrationDao.unregister(LoginDao.login);
        logout();
    }

    private void initTabComponent(int i) {
        tabbedPane.setTabComponentAt(i,
                 new CloseButtonTabComponent(tabbedPane));
    }


    private class CloseButtonTabComponent extends JPanel {
		JTabbedPane pane;

		private CloseButtonTabComponent(final JTabbedPane pane) {
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			this.pane = pane;
			setOpaque(false);

			setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));

			ImageIcon i = new ImageIcon("src/images/delete_tab.png");
			final JButton closeButton = new JButton(i);
			closeButton.setToolTipText("Close this tab");
			closeButton.setBorderPainted(false);
			closeButton.setContentAreaFilled(false);
                        closeButton.setPreferredSize(new Dimension(20,16));

			closeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int i = pane.indexOfTabComponent(CloseButtonTabComponent.this);
                                        if (i != -1) {
                                            pane.remove(i);
                                        }
				}
			});
			closeButton.addMouseListener(new MouseAdapter() {
                                @Override
				public void mouseEntered(MouseEvent e) {
					closeButton.setBorderPainted(true);
				}

                                @Override
				public void mouseExited(MouseEvent e) {
					closeButton.setBorderPainted(false);
				}

			});

			add(new JLabel() {
                                @Override
				public String getText() {
                                    int i = pane.indexOfTabComponent(CloseButtonTabComponent.this);
                                    if (i != -1) {
                                        return pane.getTitleAt(i);
                                    }
                                    return null;
                                }

			}, BorderLayout.CENTER);
			add(closeButton, BorderLayout.EAST);
		}
	}
    }


