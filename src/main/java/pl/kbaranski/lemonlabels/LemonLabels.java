/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LemonLabels.java
 *
 * Created on 2011-08-08, 21:13:28
 */
package pl.kbaranski.lemonlabels;

import com.lowagie.text.PageSize;
import java.io.IOException;
import javax.swing.DefaultListModel;

/**
 *
 * @author krzysiek
 */
public class LemonLabels extends javax.swing.JFrame {

    /** Creates new form LemonLabels */
    public LemonLabels() {
        listModel = new DefaultListModel();
        initComponents();
    }

    DefaultListModel listModel;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productCodeLabel = new javax.swing.JLabel();
        productCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        choosedProductCodes = new javax.swing.JList();
        addProductButton = new javax.swing.JButton();
        generatePdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productCodeLabel.setText("Kod produktu");

        choosedProductCodes.setModel(listModel);
        jScrollPane1.setViewportView(choosedProductCodes);

        addProductButton.setActionCommand("addProduct");
        addProductButton.setLabel("Dodaj produkt");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        generatePdf.setText("Drukuj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(productCodeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productCode, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addProductButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(generatePdf)
                .addContainerGap(133, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCodeLabel)
                    .addComponent(productCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProductButton))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generatePdf))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductToList(String productCode) {
        listModel.addElement(productCode);
    }
    
private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
    String txt = productCode.getText();
    if (txt != null && !"".equals(txt))
        addProductToList(txt);
    productCode.setText(null);
}//GEN-LAST:event_addProductButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LemonLabels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LemonLabels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LemonLabels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LemonLabels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
Printer.main(args);System.exit(0);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LemonLabels().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JList choosedProductCodes;
    private javax.swing.JButton generatePdf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productCode;
    private javax.swing.JLabel productCodeLabel;
    // End of variables declaration//GEN-END:variables
}