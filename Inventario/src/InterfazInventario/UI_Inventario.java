/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfazInventario;

import InterFazMenu.UI_Menu;
import BDPostgreSQL.ConexionBD;
import Clases.BdOption;
import Clases.DatosUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Byron Canaca
 */
public class UI_Inventario extends javax.swing.JFrame {

    ConexionBD enlace = new ConexionBD();
    public UI_Inventario() {
        initComponents();
        mostrarTabla();
    }
    
    
    
    public void mostrarTabla(){
        
        Connection conex = enlace.conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Statement st = conex.createStatement();
            String orden = "SELECT * \n" +
                           "FROM public.producto;";
            
            ResultSet rs = st.executeQuery(orden);
            
            modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Categoria", "Proveedor", "Precio", "Cantidad"});
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("id_producto"), rs.getString("nombre"), rs.getString("categoria"), rs.getString("proveedor"), rs.getString("precio"), rs.getString("cantidad")});
            }
            table.setModel(modelo);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UI_Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public String seleccion(){
       
        String idSelec = table.getValueAt(table.getSelectedRow(),0).toString();
   
        
        return idSelec;
    }
     
     public void productoInfo(){
        Connection conex = enlace.conexion();
        try {
            Statement st = conex.createStatement();
            String orden = "SELECT * \n" +
                           "FROM public.producto where id_producto='"+seleccion()+"';";
            
            ResultSet rs = st.executeQuery(orden);
            rs.next();
            

           UI_InventarioMod.txt_id.setText(rs.getString("id_producto"));
           UI_InventarioMod.txt_nombre.setText(rs.getString("nombre"));
           UI_InventarioMod.txt_categoria.setText(rs.getString("categoria"));
           UI_InventarioMod.txt_precio.setText(rs.getString("precio"));
           UI_InventarioMod.txt_cantidad.setText(rs.getString("cantidad"));
           
            DatosUsuario.setIdProducto(rs.getString("id_producto"));
            
               // rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("contra")});
            
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblgestion_inventario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnregistrar_frmp = new javax.swing.JButton();
        btnmodificar_frmp = new javax.swing.JButton();
        btneliminar_frmp = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnregresar_frmp = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblgestion_inventario.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblgestion_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblgestion_inventario.setText("Gestion - Inventario");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnregistrar_frmp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnregistrar_frmp.setText("Registrar");
        btnregistrar_frmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrar_frmpActionPerformed(evt);
            }
        });

        btnmodificar_frmp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnmodificar_frmp.setText("Modificar");
        btnmodificar_frmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificar_frmpActionPerformed(evt);
            }
        });

        btneliminar_frmp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btneliminar_frmp.setText("Eliminar");
        btneliminar_frmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_frmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnregistrar_frmp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar_frmp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar_frmp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnregistrar_frmp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnmodificar_frmp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar_frmp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("ARTICULOS EN BODEGA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnregresar_frmp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnregresar_frmp.setText("Regresar al menu");
        btnregresar_frmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar_frmpActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblgestion_inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnregresar_frmp)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblgestion_inventario)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnregresar_frmp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrar_frmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrar_frmpActionPerformed
        UI_InventarioReg fram = new UI_InventarioReg();
        fram.setVisible(true);
        fram.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnregistrar_frmpActionPerformed

    private void btnmodificar_frmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificar_frmpActionPerformed
        
        UI_InventarioMod fram = new UI_InventarioMod();
        
        if(table.getSelectedRow()!= -1){
        
            productoInfo();
            fram.setVisible(true);
            fram.setLocationRelativeTo(null);
            
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione Producto a Modificar");
        }
        
        
        
    }//GEN-LAST:event_btnmodificar_frmpActionPerformed

    private void btnregresar_frmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar_frmpActionPerformed
        UI_Menu fram = new UI_Menu();
        
        fram.setVisible(true);
        fram.setLocationRelativeTo(null);
        
        dispose();
    }//GEN-LAST:event_btnregresar_frmpActionPerformed

    private void btneliminar_frmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_frmpActionPerformed
        BdOption enlace = new BdOption();
         
        if(table.getSelectedRow()!= -1){
            enlace.eliminar_producto(seleccion());
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione articulo a eliminar");
        }
        
        mostrarTabla();
    }//GEN-LAST:event_btneliminar_frmpActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(UI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar_frmp;
    private javax.swing.JButton btnmodificar_frmp;
    private javax.swing.JButton btnregistrar_frmp;
    private javax.swing.JButton btnregresar_frmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblgestion_inventario;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables


}
