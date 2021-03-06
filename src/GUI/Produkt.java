/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Produkt.java
 *
 * Created on 2011-01-28, 18:47:07
 */

package GUI;

import Exceptions.WrongFoodException;
import Exceptions.WrongRaportException;
import dao.EFoodCategory;
import dao.FoodDao;
import dao.NewRaportDao;
import entities.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 *
 * @author Agata
 */
public class Produkt extends javax.swing.JFrame {

    private Jedzenie food;
    private SimulationPanel simPanel;
    int suma = 0;
    String name;
    int sumaB = 0;
    int sumaT = 0;
    int sumaW = 0;


    /** Creates new form Produkt */
    public Produkt(Jedzenie food, SimulationPanel simPanel) {
        initComponents();
        this.food = food;
        this.setVisible(true);
        this.simPanel = simPanel;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void setCategory(EFoodCategory category) {
        this.category = category;
        try {
            productList = FoodDao.getAllByCategory(category);
            for(Product p : productList)
            {
                jComboBox1.addItem(p);
            }
            
        } catch (WrongFoodException ex) {
            Logger.getLogger(Produkt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public JTextField getKcalField(){
        return kcalTextField;
    }
     public JTextField getBField(){
        return bialkoTextField;
    }
    public JTextField getTField(){
        return tluszczeTextField;
    }
    public JTextField getWField(){
        return cukryTextField;
    }
     public JTextField getIGField(){
        return igTextField;
    }
    public void setSumaField(){
        //nie wiem jak to zsumować
        jTextField1 = getKcalField();
    }
 
    public JComboBox getNameCombo() {
        return jComboBox1;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cukryTextField = new javax.swing.JTextField();
        bialkoTextField = new javax.swing.JTextField();
        tluszczeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kcalTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        igTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dodajButton = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Dodaj produkt");

        cukryTextField.setText("Cukry");
        cukryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cukryTextFieldActionPerformed(evt);
            }
        });

        bialkoTextField.setText("Bialko");
        bialkoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bialkoTextFieldActionPerformed(evt);
            }
        });

        tluszczeTextField.setText("tl.");
        tluszczeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tluszczeTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Wartość energetyczna:");

        kcalTextField.setText("kcal");
        kcalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kcalTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Indeks glikemiczny");

        igTextField.setText("IG");
        igTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Tłuszcze:");

        jLabel5.setText("Węglowodany:");

        jLabel4.setText("Białko:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Wartość energetyczna Twojego posiłku:");

        jLabel8.setText("Wybrane produkty:");

        dodajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        dodajButton.setText("Dodaj");
        dodajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajButtonActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-left-icon.png"))); // NOI18N
        jButton2.setText("Powrót");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(dodajButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(igTextField, 0, 0, Short.MAX_VALUE)
                                    .addComponent(cukryTextField)
                                    .addComponent(kcalTextField)
                                    .addComponent(bialkoTextField)
                                    .addComponent(tluszczeTextField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kcalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bialkoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tluszczeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cukryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(igTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(dodajButton)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        food.setSuma(suma);
        food.setSumaB(sumaB);
        food.setSumaT(sumaT);
        food.setSumaW(sumaW);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kcalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kcalTextFieldActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_kcalTextFieldActionPerformed

    private void bialkoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bialkoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bialkoTextFieldActionPerformed

    private void tluszczeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tluszczeTextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tluszczeTextFieldActionPerformed

    private void cukryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cukryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cukryTextFieldActionPerformed

    private void igTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_igTextFieldActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        Product p = (Product)cb.getSelectedItem();
        kcalTextField.setText(""+p.getKcal());
        bialkoTextField.setText(""+p.getProtein());
        tluszczeTextField.setText(""+p.getFat());
        cukryTextField.setText(""+p.getCarbo());
        igTextField.setText(""+p.getIg());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void dodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajButtonActionPerformed
        Product p = (Product) jComboBox1.getSelectedItem();
        jComboBox2.addItem(p);
        simPanel.jList1.addItem(p);

        suma = 0;
        for(int i = 0 ; i < jComboBox2.getItemCount() ; i++)
        {
            suma+=((Product)jComboBox2.getItemAt(i)).getKcal();
        }
        jTextField1.setText(""+suma);

        sumaB = 0;
        for(int i = 0 ; i < jComboBox2.getItemCount() ; i++)
        {
            sumaB+=((Product)jComboBox2.getItemAt(i)).getProtein();
        }

        sumaT = 0;
        for(int i = 0 ; i < jComboBox2.getItemCount() ; i++)
        {
            sumaT+=((Product)jComboBox2.getItemAt(i)).getFat();
        }

        sumaW = 0;
        for(int i = 0 ; i < jComboBox2.getItemCount() ; i++)
        {
            sumaW+=((Product)jComboBox2.getItemAt(i)).getCarbo();
        }
    }//GEN-LAST:event_dodajButtonActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bialkoTextField;
    private javax.swing.JTextField cukryTextField;
    private javax.swing.JButton dodajButton;
    private javax.swing.JTextField igTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField kcalTextField;
    private javax.swing.JTextField tluszczeTextField;
    // End of variables declaration//GEN-END:variables

    private List<Product> productList;
    private EFoodCategory category;


}
