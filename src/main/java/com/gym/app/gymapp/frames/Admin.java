/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.app.gymapp.frames;

import com.gym.app.gymapp.classes.Administrador;
import com.gym.app.gymapp.features.AdminDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabi
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        txtContrasena.setEnabled(false);
        cargarUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdAdmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNameAdmin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLastnameAdmin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAgeAdmin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPhoneAdmin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMailAdmin = new javax.swing.JTextField();
        btnGuardarAdmin = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        txtContrasena = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("ID");

        jLabel8.setText("Nombre");

        txtNameAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameAdminActionPerformed(evt);
            }
        });

        jLabel9.setText("Apellido");

        jLabel10.setText("Edad");

        jLabel11.setText("Telefono");

        jLabel12.setText("Correo");

        btnGuardarAdmin.setText("Guardar");
        btnGuardarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAdminActionPerformed(evt);
            }
        });

        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);

        jLabel13.setText("Contraseña");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar1)
                    .addComponent(btnEditar1)
                    .addComponent(btnGuardarAdmin)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNameAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLastnameAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAgeAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMailAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastnameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAgeAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhoneAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMailAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(14, 14, 14)
                        .addComponent(btnGuardarAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameAdminActionPerformed

    private void btnGuardarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAdminActionPerformed
        // Obtener los datos desde los campos de texto del formulario
        int idAdministrador = Integer.parseInt(txtIdAdmin.getText());  // Suponiendo que el ID es un número entero
        String nombreAdministrador = txtNameAdmin.getText();
        String apellidoAdministrador = txtLastnameAdmin.getText();
        int edadAdministrador = Integer.parseInt(txtAgeAdmin.getText());  // Suponiendo que la edad es un número entero
        int telefonoAdministrador = Integer.parseInt(txtPhoneAdmin.getText()); // Suponiendo que el teléfono es un número
        String correoAdministrador = txtMailAdmin.getText();

        // Generar la contraseña automáticamente
        String contrasenaGenerada = generarContrasena(nombreAdministrador, apellidoAdministrador, edadAdministrador);

        // Crear el objeto Administrador
        Administrador administrador = new Administrador(idAdministrador, nombreAdministrador, apellidoAdministrador, edadAdministrador, telefonoAdministrador, correoAdministrador, contrasenaGenerada);

        // Llamar al método del DAO para guardar el administrador en la base de datos
        AdminDAO adminDAO = new AdminDAO();
        boolean adminGuardado = adminDAO.insertarAdministrador(administrador);
        cargarUsuario();
        limpiar();

        if (adminGuardado) {
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Administrador guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "Error al guardar el administrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarAdminActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed

        try {
            int idAdmin = Integer.parseInt(txtIdAdmin.getText());
            String nombreAdmin = txtNameAdmin.getText();
            String apellidoAdmin = txtLastnameAdmin.getText();
            int edadAdmin = Integer.parseInt(txtAgeAdmin.getText());
            int telefonoAdmin = Integer.parseInt(txtPhoneAdmin.getText());
            String correoAdmin = txtMailAdmin.getText();
            String contrasena = txtContrasena.getText();

            Administrador cliente = new Administrador(idAdmin, nombreAdmin, apellidoAdmin, edadAdmin, telefonoAdmin, correoAdmin, contrasena);

            AdminDAO adminDAO = new AdminDAO();
            boolean clienteActualizado = adminDAO.editarAdministrador(cliente);
            cargarUsuario();
            limpiar();
            btnGuardarAdmin.setEnabled(true);
            txtContrasena.setEnabled(false);

            if (clienteActualizado) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        int fila = tblAdmin.getSelectedRow();
        if (fila >= 0) {
            btnGuardarAdmin.setEnabled(false);
            txtContrasena.setEnabled(true);
            txtIdAdmin.setText(tblAdmin.getValueAt(fila, 0).toString());
            txtNameAdmin.setText(tblAdmin.getValueAt(fila, 1).toString());
            txtLastnameAdmin.setText(tblAdmin.getValueAt(fila, 2).toString());
            txtAgeAdmin.setText(tblAdmin.getValueAt(fila, 3).toString());
            txtPhoneAdmin.setText(tblAdmin.getValueAt(fila, 4).toString());
            txtMailAdmin.setText(tblAdmin.getValueAt(fila, 5).toString());
            txtContrasena.setText(tblAdmin.getValueAt(fila, 6).toString());
        }
    }//GEN-LAST:event_tblAdminMouseClicked

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        try {
            int idAdmin = Integer.parseInt(txtIdAdmin.getText());

            // Confirmar la eliminación
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este administrador?",
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                AdminDAO adminDAO = new AdminDAO();
                boolean clienteEliminado = adminDAO.eliminarAdministrador(idAdmin);
                cargarUsuario();  // Recargar la lista de usuarios
                limpiar();
                btnGuardarAdmin.setEnabled(true);
                txtContrasena.setEnabled(false);

                if (clienteEliminado) {
                    JOptionPane.showMessageDialog(this, "Administrador eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Limpiar los campos de texto
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el Administrador", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    private String generarContrasena(String nombre, String apellido, int edad) {
        return nombre.substring(0, Math.min(3, nombre.length()))
                + apellido.substring(0, Math.min(4, apellido.length()))
                + edad
                + "_gym2025";
    }

    private void cargarUsuario() {
        try {
            // Obtener lista de membresías desde la base de datos
            AdminDAO adminDAO = new AdminDAO();
            List<Administrador> listaUsuarios = adminDAO.obtenerAdministradoresTotales();

            // Crear modelo de tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Admin");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Edad");
            modelo.addColumn("Telefono");
            modelo.addColumn("Correo");
            modelo.addColumn("Contrasena");

            // Agregar datos al modelo
            for (Administrador administrador : listaUsuarios) {
                modelo.addRow(new Object[]{
                    administrador.getId_Administrador(),
                    administrador.getNombre_Administrador(),
                    administrador.getApellido_Administrador(),
                    administrador.getEdad_Administrador(),
                    administrador.getNumero_Administrador(),
                    administrador.getCorreo_Administrador(),
                    administrador.getContrasena_Administrador()

                });
            }

            // Asignar modelo a la tabla
            tblAdmin.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar membresías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiar() {
        txtAgeAdmin.setText("");
        txtIdAdmin.setText("");
        txtLastnameAdmin.setText("");
        txtMailAdmin.setText("");
        txtNameAdmin.setText("");
        txtPhoneAdmin.setText("");
        txtContrasena.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardarAdmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTextField txtAgeAdmin;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtIdAdmin;
    private javax.swing.JTextField txtLastnameAdmin;
    private javax.swing.JTextField txtMailAdmin;
    private javax.swing.JTextField txtNameAdmin;
    private javax.swing.JTextField txtPhoneAdmin;
    // End of variables declaration//GEN-END:variables
}
