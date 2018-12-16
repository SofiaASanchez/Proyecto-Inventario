/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfazUsuario;

import InterfazInventario.UI_Inventario;
import InterFazMenu.UI_Menu;
import BDPostgreSQL.ConexionBD;
import Clases.BdOption;
import Clases.DatosUsuario;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UI_Usuario extends javax.swing.JFrame {


    ConexionBD enlace = new ConexionBD();
    
    public UI_Usuario() {
        initComponents();
        mostrarTabla();
    }

    public String seleccion(){
       
        String idSelec = tblusuario.getValueAt(tblusuario.getSelectedRow(),0).toString();
   
        
        return idSelec;
    }
    public void usuarioInfo(){
       
        Connection conex = enlace.conexion();
        try {
            Statement st = conex.createStatement();
            String orden = "SELECT * \n" +
                           "FROM public.usuarios where id='"+seleccion()+"';";
            
            ResultSet rs = st.executeQuery(orden);
            rs.next();
            //DatosUsuario.id(seleccion());
           
           UI_UsuarioMod.txt_idp.setText(rs.getString("id"));
           
           UI_UsuarioMod.txt_apellido.setText(rs.getString("apellido"));
           UI_UsuarioMod.txt_nombre.setText(rs.getString("nombre"));
           UI_UsuarioMod.txt_fechaN.setText(rs.getString("fecha_naci"));
           UI_UsuarioMod.txt_contra.setText(rs.getString("contra"));
           UI_UsuarioMod.txt_repitcontra.setText(rs.getString("contra"));
           UI_UsuarioMod.txt_telefono.setText(rs.getString("telefono"));
           UI_UsuarioMod.txt_permiso.setText(rs.getString("tipopermiso"));
           UI_UsuarioMod.txt_direccion.setText(rs.getString("direccion"));
           if(rs.getString("tipoPermiso")=="1"){
               UI_UsuarioMod.txt_nameP.setText("Gerente");
           }else{
               UI_UsuarioMod.txt_nameP.setText("Vendedor");
           }
           
               // rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("contra")});
            
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
   public void mostrarTabla(){
        Connection conex = enlace.conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Statement st = conex.createStatement();
            String orden = "SELECT * \n" +
                           "FROM public.usuarios;";
            
            ResultSet rs = st.executeQuery(orden);
            
            modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido", "Direccion", "Telefono", "Contraseña"});
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("contra")});
            }
            tblusuario.setModel(modelo);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UI_Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblgestion_usuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnregistrar_frmu = new javax.swing.JButton();
        btnmodificar_frmu = new javax.swing.JButton();
        btneliminar_frmu = new javax.swing.JButton();
        btnregresar_frmu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblgestion_usuario.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblgestion_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblgestion_usuario.setText("Gestion - Usuario");

        tblusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Fecha  Nacimiento", "Telefono", "Permisos", "Contraseña"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblusuario);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnregistrar_frmu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnregistrar_frmu.setText("Registrar");
        btnregistrar_frmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrar_frmuActionPerformed(evt);
            }
        });

        btnmodificar_frmu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnmodificar_frmu.setText("Modificar");
        btnmodificar_frmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificar_frmuActionPerformed(evt);
            }
        });

        btneliminar_frmu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btneliminar_frmu.setText("Eliminar");
        btneliminar_frmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_frmuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnregistrar_frmu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificar_frmu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar_frmu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnregistrar_frmu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnmodificar_frmu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar_frmu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnregresar_frmu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnregresar_frmu.setText("Regresar al menu");
        btnregresar_frmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar_frmuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnregresar_frmu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblgestion_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblgestion_usuario)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnregresar_frmu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneliminar_frmuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_frmuActionPerformed
       BdOption elim = new BdOption();
            if(tblusuario.getSelectedRow()!= -1){
            elim.eliminar_usuario(seleccion());
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione Usuario a Eliminar");
        }
        
        mostrarTabla();
    }//GEN-LAST:event_btneliminar_frmuActionPerformed

    private void btnregresar_frmuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar_frmuActionPerformed
        UI_Menu fram = new UI_Menu();
        //fram.setVisible(true);
        //fram.setLocationRelativeTo(null);
        fram.setVisible(true);
        fram.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnregresar_frmuActionPerformed

    private void btnmodificar_frmuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificar_frmuActionPerformed
        UI_UsuarioMod fram = new UI_UsuarioMod();
       if(tblusuario.getSelectedRow()!= -1){
            usuarioInfo();
        
        fram.setVisible(true);
        fram.setLocationRelativeTo(null);
        dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione Usuario para modificar sus datos");
        }
        
    }//GEN-LAST:event_btnmodificar_frmuActionPerformed

    private void btnregistrar_frmuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrar_frmuActionPerformed
        UI_UsuarioReg fram = new UI_UsuarioReg();
        fram.setVisible(true);
        fram.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnregistrar_frmuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar_frmu;
    private javax.swing.JButton btnmodificar_frmu;
    private javax.swing.JButton btnregistrar_frmu;
    private javax.swing.JButton btnregresar_frmu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblgestion_usuario;
    private javax.swing.JTable tblusuario;
    // End of variables declaration//GEN-END:variables

}
