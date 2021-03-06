/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Jedzenie.java
 *
 * Created on 2011-01-28, 18:36:52
 */

package GUI;

import dao.EFoodCategory;
import javax.swing.ImageIcon;

/**
 *
 * @author Agata
 */
public class Jedzenie extends javax.swing.JFrame {

    private Produkt prod;
    private Nowy nowy;
    private int suma;
    private int sumaB;
    private int sumaT;
    private int sumaW;
    private SimulationPanel simulationPanel;
    /** Creates new form Jedzenie */
    
    public Jedzenie(SimulationPanel simulationPanel) {
        initComponents();
        this.simulationPanel = simulationPanel;

        this.setVisible(true);
        this.setResizable(false);

    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma += suma;
    }

    public int getSumaB() {
        return sumaB;
    }

    public void setSumaB(int sumaB) {
        this.sumaB += sumaB;
    }

    public int getSumaT() {
        return sumaT;
    }

    public void setSumaT(int sumaT) {
        this.sumaT += sumaT;
    }

    public int getSumaW() {
        return sumaW;
    }

    public void setSumaW(int sumaW) {
        this.sumaW += sumaW;
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
        nabialButton = new javax.swing.JButton();
        pieczywoButton = new javax.swing.JButton();
        warzywaButton = new javax.swing.JButton();
        owoceButton = new javax.swing.JButton();
        rybyButton = new javax.swing.JButton();
        miesoButton = new javax.swing.JButton();
        fastFoodButton = new javax.swing.JButton();
        maczneButton = new javax.swing.JButton();
        alkoholButton = new javax.swing.JButton();
        ciastaButton = new javax.swing.JButton();
        slodyczeButton = new javax.swing.JButton();
        napojeButton = new javax.swing.JButton();
        dodajNowyButton = new javax.swing.JButton();
        powrotButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Wybierz kategorię");

        nabialButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cheese-icon.png"))); // NOI18N
        nabialButton.setText("Nabiał");
        nabialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nabialButtonActionPerformed(evt);
            }
        });

        pieczywoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/toast-icon.png"))); // NOI18N
        pieczywoButton.setText("Pieczywo");
        pieczywoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieczywoButtonActionPerformed(evt);
            }
        });

        warzywaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Capsicum-icon.png"))); // NOI18N
        warzywaButton.setText("Warzywa");
        warzywaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warzywaButtonActionPerformed(evt);
            }
        });

        owoceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/strawberry-icon.png"))); // NOI18N
        owoceButton.setText("Owoce");
        owoceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                owoceButtonActionPerformed(evt);
            }
        });

        rybyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fish-icon.png"))); // NOI18N
        rybyButton.setText("Ryby");
        rybyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rybyButtonActionPerformed(evt);
            }
        });

        miesoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ham-icon.png"))); // NOI18N
        miesoButton.setText("Mięso");
        miesoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miesoButtonActionPerformed(evt);
            }
        });

        fastFoodButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hamburger-icon.png"))); // NOI18N
        fastFoodButton.setText("Fast food");
        fastFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastFoodButtonActionPerformed(evt);
            }
        });

        maczneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flour-icon.png"))); // NOI18N
        maczneButton.setText("Mączne");
        maczneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maczneButtonActionPerformed(evt);
            }
        });

        alkoholButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/network-icon.png"))); // NOI18N
        alkoholButton.setText("Alkohol");
        alkoholButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alkoholButtonActionPerformed(evt);
            }
        });

        ciastaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cake-005-icon.png"))); // NOI18N
        ciastaButton.setText("Ciasta");
        ciastaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciastaButtonActionPerformed(evt);
            }
        });

        slodyczeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/candy-icon.png"))); // NOI18N
        slodyczeButton.setText("Słodycze");
        slodyczeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slodyczeButtonActionPerformed(evt);
            }
        });

        napojeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coffee-icon.png"))); // NOI18N
        napojeButton.setText("Napoje");
        napojeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                napojeButtonActionPerformed(evt);
            }
        });

        dodajNowyButton.setText("Dodaj nowy");
        dodajNowyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajNowyButtonActionPerformed(evt);
            }
        });

        powrotButton.setText("Powrót");
        powrotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powrotButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alkoholButton, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(slodyczeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(nabialButton, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(owoceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(miesoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(fastFoodButton, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maczneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ciastaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(napojeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rybyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(warzywaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pieczywoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(powrotButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(dodajNowyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(powrotButton))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nabialButton)
                    .addComponent(pieczywoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(owoceButton)
                    .addComponent(warzywaButton))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miesoButton)
                    .addComponent(rybyButton))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fastFoodButton)
                    .addComponent(maczneButton))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slodyczeButton)
                    .addComponent(ciastaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alkoholButton)
                    .addComponent(napojeButton))
                .addGap(18, 18, 18)
                .addComponent(dodajNowyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nabialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nabialButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
        prod.setCategory(EFoodCategory.NABIAL);
        prod.setVisible(true);

    }//GEN-LAST:event_nabialButtonActionPerformed

    private void alkoholButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alkoholButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
        prod.setCategory(EFoodCategory.ALKOHOL);
        prod.setVisible(true);
        
    }//GEN-LAST:event_alkoholButtonActionPerformed

    private void dodajNowyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajNowyButtonActionPerformed
        // TODO add your handling code here:
        nowy = new Nowy(this);
//        nowy.setCategory();
        nowy.setVisible(true);
    }//GEN-LAST:event_dodajNowyButtonActionPerformed

    private void powrotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powrotButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        simulationPanel.setKcal(suma);
        simulationPanel.setB(sumaB);
        simulationPanel.setT(sumaT);
        simulationPanel.setW(sumaW);
    }//GEN-LAST:event_powrotButtonActionPerformed

    private void fastFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastFoodButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
          prod.setCategory(EFoodCategory.FASTFOOD);
        prod.setVisible(true);
    }//GEN-LAST:event_fastFoodButtonActionPerformed

    private void pieczywoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieczywoButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
          prod.setCategory(EFoodCategory.PIECZYWO);
        prod.setVisible(true);
    }//GEN-LAST:event_pieczywoButtonActionPerformed

    private void owoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_owoceButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
        prod.setCategory(EFoodCategory.OWOCE);
        prod.setVisible(true);
    }//GEN-LAST:event_owoceButtonActionPerformed

    private void warzywaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warzywaButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
          prod.setCategory(EFoodCategory.WARZYWA);
        prod.setVisible(true);
    }//GEN-LAST:event_warzywaButtonActionPerformed

    private void miesoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miesoButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
          prod.setCategory(EFoodCategory.MIESO);
        prod.setVisible(true);
    }//GEN-LAST:event_miesoButtonActionPerformed

    private void rybyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rybyButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
          prod.setCategory(EFoodCategory.RYBY);
        prod.setVisible(true);
    }//GEN-LAST:event_rybyButtonActionPerformed

    private void maczneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maczneButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
          prod.setCategory(EFoodCategory.MACZNE);
        prod.setVisible(true);
    }//GEN-LAST:event_maczneButtonActionPerformed

    private void slodyczeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slodyczeButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
        prod.setCategory(EFoodCategory.SLODYCZE);
        prod.setVisible(true);
    }//GEN-LAST:event_slodyczeButtonActionPerformed

    private void ciastaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciastaButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
        prod.setCategory(EFoodCategory.CIASTA);
        prod.setVisible(true);
    }//GEN-LAST:event_ciastaButtonActionPerformed

    private void napojeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_napojeButtonActionPerformed
        // TODO add your handling code here:
        prod = new Produkt(this,simulationPanel);
        prod.setCategory(EFoodCategory.NAPOJE);
        prod.setVisible(true);
    }//GEN-LAST:event_napojeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alkoholButton;
    private javax.swing.JButton ciastaButton;
    private javax.swing.JButton dodajNowyButton;
    private javax.swing.JButton fastFoodButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton maczneButton;
    private javax.swing.JButton miesoButton;
    private javax.swing.JButton nabialButton;
    private javax.swing.JButton napojeButton;
    private javax.swing.JButton owoceButton;
    private javax.swing.JButton pieczywoButton;
    private javax.swing.JButton powrotButton;
    private javax.swing.JButton rybyButton;
    private javax.swing.JButton slodyczeButton;
    private javax.swing.JButton warzywaButton;
    // End of variables declaration//GEN-END:variables

}
