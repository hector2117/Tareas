/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.views;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ni.uni.edu.programacion.Controllers.PnlVehicleController;
import ni.uni.edu.programacion.Controllers.PnlVehicleShowController;
import ni.uni.edu.programacion.views.panels.PnlVehicle;
import ni.uni.edu.programacion.views.panels.PnlVehicleShowInfo;
import org.rwshop.swing.animation.*;
/**
 *
 * @author Héctor Fuentes
 */
public class FrmVehicle extends javax.swing.JFrame {
    private PnlVehicle pnlVehicle;
    private PnlVehicleController pnlVehicleController;
    private PnlVehicleShowController pnlVShowInfo;// controller para el panel PnlVehicleShowInfo;
    private PnlVehicleShowInfo pnlVSInfo; // objeto tipo 
    /**
     * Creates new form FrmVehicle
     */
    public FrmVehicle() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.btnNew.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnMenu = new rsbuttom.RSButtonMetro();
        pnlMenu = new javax.swing.JPanel();
        btnNew = new rsbuttom.RSButtonMetro();
        btnDelete = new rsbuttom.RSButtonMetro();
        btnVisual = new rsbuttom.RSButtonMetro();
        btnUpdate = new rsbuttom.RSButtonMetro();
        PnlCont = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(1, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(750, 742));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(915, 34));

        btnMenu.setBackground(new java.awt.Color(153, 153, 153));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/options.png"))); // NOI18N
        btnMenu.setColorHover(new java.awt.Color(102, 102, 102));
        btnMenu.setColorNormal(new java.awt.Color(102, 102, 102));
        btnMenu.setColorPressed(new java.awt.Color(102, 102, 102));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        jPanel4.add(jPanel1, gridBagConstraints);

        pnlMenu.setBackground(new java.awt.Color(255, 153, 51));
        pnlMenu.setLayout(new java.awt.GridBagLayout());

        btnNew.setBackground(new java.awt.Color(255, 153, 51));
        btnNew.setText("New");
        btnNew.setColorHover(new java.awt.Color(255, 153, 51));
        btnNew.setColorNormal(new java.awt.Color(255, 153, 51));
        btnNew.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNew.setIconTextGap(20);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 55;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 0, 0, 0);
        pnlMenu.add(btnNew, gridBagConstraints);

        btnDelete.setBackground(new java.awt.Color(255, 153, 51));
        btnDelete.setText("Remove");
        btnDelete.setColorHover(new java.awt.Color(255, 153, 51));
        btnDelete.setColorNormal(new java.awt.Color(255, 153, 51));
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDelete.setIconTextGap(29);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        pnlMenu.add(btnDelete, gridBagConstraints);

        btnVisual.setBackground(new java.awt.Color(255, 153, 51));
        btnVisual.setText("View");
        btnVisual.setColorHover(new java.awt.Color(255, 153, 51));
        btnVisual.setColorNormal(new java.awt.Color(255, 153, 51));
        btnVisual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisual.setIconTextGap(34);
        btnVisual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 92;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        pnlMenu.add(btnVisual, gridBagConstraints);

        btnUpdate.setBackground(new java.awt.Color(255, 153, 51));
        btnUpdate.setText("Update");
        btnUpdate.setColorHover(new java.awt.Color(255, 153, 51));
        btnUpdate.setColorNormal(new java.awt.Color(255, 153, 51));
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdate.setIconTextGap(33);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 252, 0);
        pnlMenu.add(btnUpdate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 246;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        jPanel4.add(pnlMenu, gridBagConstraints);

        PnlCont.setBackground(new java.awt.Color(255, 255, 255));
        PnlCont.setPreferredSize(new java.awt.Dimension(696, 598));
        PnlCont.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(PnlCont, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        /*int position = this.pnlMenu.getX();
        
        if (position > -1)
        {
            
        }*/
        
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        if(pnlVehicle == null){
            pnlVehicle = new PnlVehicle();
            try {
                pnlVehicleController = new PnlVehicleController(pnlVehicle);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        addComponent(pnlVehicle);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnVisualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualActionPerformed
        // TODO add your handling code here:
        if (pnlVSInfo == null)
        {
            pnlVSInfo = new PnlVehicleShowInfo();
            //try
            {
            pnlVShowInfo = new PnlVehicleShowController(pnlVSInfo);
            }
            /*catch (FileNotFoundException ex) {
                Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
        
        addComponent(pnlVSInfo);
    }//GEN-LAST:event_btnVisualActionPerformed
    private void addComponent(JComponent component) {
        PnlCont.removeAll();        
        PnlCont.add(component, BorderLayout.CENTER);
        validate();
        repaint();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVehicle().setVisible(true);
            }
        });
    }
    private javax.swing.JPanel pnlContent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlCont;
    private rsbuttom.RSButtonMetro btnDelete;
    private rsbuttom.RSButtonMetro btnMenu;
    private rsbuttom.RSButtonMetro btnNew;
    private rsbuttom.RSButtonMetro btnUpdate;
    private rsbuttom.RSButtonMetro btnVisual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}