/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.views.panels;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import ni.uni.edu.programacion.Controllers.PnlVehicleController;

/**
 *
 * @author FAMILIASOZAORTIZ
 */
public class PnlTableVehicle extends javax.swing.JPanel {
    private PnlVehicleController pnlVehicleController;
private TableRowSorter trsfiltro;
private JComboBox combo ;



    public PnlTableVehicle() {
        initComponents();
         jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Make", "Model", "Year" , "Style", "VIN" , "Status" }));
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public JPanel getjPanel1() {
        return pnlSearch;
    }

    public JPanel getPnlContent() {
        return pnlContent;
    }

    public JScrollPane getScrollContentTable() {
        return scrollContentTable;
    }

    public JTable getTblTableVehicle() {
        return tblTableVehicle;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSearch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        pnlContent = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollContentTable = new javax.swing.JScrollPane();
        tblTableVehicle = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnlSearch.setBackground(new java.awt.Color(184, 237, 232));
        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Buscar por :");
        pnlSearch.add(jLabel1);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pnlSearch.add(jComboBox1);

        jTextField1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 51, 204));
        jTextField1.setText("Busqueda");
        jTextField1.setSelectionColor(new java.awt.Color(204, 51, 0));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        pnlSearch.add(jTextField1);

        add(pnlSearch, java.awt.BorderLayout.PAGE_START);

        pnlContent.setLayout(new java.awt.BorderLayout());
        pnlContent.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        tblTableVehicle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        tblTableVehicle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, "", null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Stock numer", "Year", "Make", "Model", "Style", "VIN", "Exterior color", "Interior color", "Miles", "Price", "Transmission", "Engine", "Image", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTableVehicle.setToolTipText("");
        scrollContentTable.setViewportView(tblTableVehicle);

        pnlContent.add(scrollContentTable, java.awt.BorderLayout.CENTER);

        add(pnlContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
       jTextField1.addKeyListener(new KeyAdapter() {
           
        public void keyReleased(final KeyEvent e) {
            int a=0;
        String cadena = (jTextField1.getText());
        jTextField1.setText(cadena);
        repaint();
        filtro(a);
        }
    });
        trsfiltro = new TableRowSorter(tblTableVehicle.getModel());
        tblTableVehicle.setRowSorter(trsfiltro);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void filtro (int a)
    {
         String opcion = jComboBox1.getSelectedItem().toString();
 if(opcion.equals("ID")){
  a=0;
 }else if(opcion.equals("Make")){
 a=3;
 }else if(opcion.equals("Model")){
 a=4;
 }else if(opcion.equals("Year")){
 a=2;
 }else if(opcion.equals("Style")){
 a=5;
 }else if(opcion.equals("VIN")){
 a=6;
 }else if(opcion.equals("Status")){
 a=14;
 }else{
 System.out.println("Seleccionar");
 }
   trsfiltro.setRowFilter(RowFilter.regexFilter(jTextField1.getText(), a));
    }
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JScrollPane scrollContentTable;
    private javax.swing.JTable tblTableVehicle;
    // End of variables declaration//GEN-END:variables
}
