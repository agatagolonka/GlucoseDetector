/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author maja
 */



public class MainPanel extends JPanel{


    private JMenuItem chartItem;

    public MainPanel()
    {
        initComponents();

        ChartFrame chartFrame;
        chartItem.setText("Zaloguj");
        chartItem.setActionCommand("login");
       // this.setLayout(new GridLayout(1, 2));

        add(new SimulationPanel());

       

    }

       private void initComponents()
    {
        chartItem = new JMenuItem();
    }


}
