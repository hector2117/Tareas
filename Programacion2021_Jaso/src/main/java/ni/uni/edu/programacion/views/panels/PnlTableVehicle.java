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


    public PnlTableVehicle() {
        initComponents();
         cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Make", "Model", "Year" , "Style", "VIN" , "Status" }));
    }

    public JTextField getjTextField1() {
        return txtBusqueda;
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
        cmbBuscar = new javax.swing.JComboBox<>();
        txtBusqueda = new javax.swing.JTextField();
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

        cmbBuscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pnlSearch.add(cmbBuscar);

        txtBusqueda.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(0, 51, 204));
        txtBusqueda.setText("Busqueda");
        txtBusqueda.setSelectionColor(new java.awt.Color(204, 51, 0));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });
        pnlSearch.add(txtBusqueda);

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

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
       txtBusqueda.addKeyListener(new KeyAdapter() {
           
        public void keyReleased(final KeyEvent e) {
            int a=0;
        String cadena = (txtBusqueda.getText());
        txtBusqueda.setText(cadena);
        repaint();
        filtro(a);
        }
    });
        trsfiltro = new TableRowSorter(tblTableVehicle.getModel());
        tblTableVehicle.setRowSorter(trsfiltro);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void filtro (int a)
    {
         String opcion = cmbBuscar.getSelectedItem().toString();
             if(opcion.equals("ID")){
                a=0;
                }else if(opcion.equals("Make")){
                a=3;
            }else if(opcion.equals("Model")){
            a=4;
        }else if(opcion.equals("Year")){
            a=2;
         }else if(opcion.equals("Style")){
             a =5;
           }else if(opcion.equals("VIN")){
                a=6;
         }else if(opcion.equals("Status")){
                a=14;
            }else{
            System.out.println("Seleccionar");
                }
          trsfiltro.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText(), a));
       }
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JScrollPane scrollContentTable;
    private javax.swing.JTable tblTableVehicle;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
