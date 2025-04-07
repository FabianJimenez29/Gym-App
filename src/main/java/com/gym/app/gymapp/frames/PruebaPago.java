/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.app.gymapp.frames;

import com.gym.app.gymapp.TipoDePago;
import com.gym.app.gymapp.classes.Membresias;
import com.gym.app.gymapp.classes.Pagos;
import com.gym.app.gymapp.classes.Usuario;
import com.gym.app.gymapp.features.MembresiaDAO;
import com.gym.app.gymapp.features.PagosDAO;
import com.gym.app.gymapp.features.UsuarioDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabi
 */
public class PruebaPago extends javax.swing.JFrame {

    /**
     * Creates new form PruebaPago
     */
    public PruebaPago() {
        initComponents();
        cargarTiposDePago();
        cargarClientes();
        cargarPagos();
        cargarMembresias();
        txtIdPago.setEnabled(false);
        txtFecha.setEnabled(false);
        txtIdPago.setVisible(false);
        txtFecha.setVisible(false);
        lbl1.setVisible(false);
        lbl2.setVisible(false);

    }

    public void limpiar() {
        txtId.setText("");
        txtIdAdmin.setText("");
        cmbMembresia.setSelectedItem("Seleccione Un Tipo");
        cmbTipoPago.setSelectedItem("Seleccione Una Opcion");
    }

    private void cargarTiposDePago() {

        cmbTipoPago.removeAllItems();
        cmbTipoPago.addItem("Seleccione Una Opcion");// Limpiar ComboBox
        for (TipoDePago tipo : TipoDePago.values()) {
            cmbTipoPago.addItem(tipo.name()); // Agregar opciones del enum
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtIdAdmin = new javax.swing.JTextField();
        cmbMembresia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtIdPago = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);

        jLabel1.setText("Id Cliente");

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Tipo De Pago");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPagosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPagos);

        jLabel3.setText("Clientes");

        jLabel4.setText("Pagos");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cmbMembresia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Tipo De Membresia");

        jLabel6.setText("IdAdmin");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl1.setText("Fecha");

        lbl2.setText("Id Pago");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(156, 156, 156))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbMembresia, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(btnGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl1)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtIdPago, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                                .addComponent(txtFecha))
                                            .addComponent(lbl2))))))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(249, 249, 249))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbl1))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl2))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(txtIdAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            int idCliente = Integer.parseInt(txtId.getText());
            TipoDePago tipoPago = TipoDePago.valueOf(cmbTipoPago.getSelectedItem().toString());
            int idAdmin = Integer.parseInt(txtIdAdmin.getText());
            String membresia = cmbMembresia.getSelectedItem().toString();

            // Crear un objeto de pago con la fecha actual y sin ID de pago
            Pagos pago = new Pagos(0, idAdmin, idCliente, tipoPago, new java.sql.Date(System.currentTimeMillis()), membresia);

            // Insertar el pago
            PagosDAO pagosDAO = new PagosDAO();
            boolean exito = pagosDAO.insertarPago(pago);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Pago registrado correctamente");
                cargarTiposDePago();
                cargarClientes();
                cargarPagos();
                cargarMembresias();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el pago", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            // Obtener el ID de pago de los campos
            int idPago = Integer.parseInt(txtIdPago.getText());
            int idCliente = Integer.parseInt(txtId.getText());
            TipoDePago tipoPago = TipoDePago.valueOf(cmbTipoPago.getSelectedItem().toString());
            int idAdmin = Integer.parseInt(txtIdAdmin.getText());
            String membresia = cmbMembresia.getSelectedItem().toString();

            // Crear un objeto de pago con los datos editados
            Pagos pago = new Pagos(idPago, idAdmin, idCliente, tipoPago, new java.sql.Date(System.currentTimeMillis()), membresia);

            // Actualizar el pago en la base de datos
            PagosDAO pagosDAO = new PagosDAO();
            boolean exito = pagosDAO.editarPago(pago); // Este método debería actualizar el pago según su ID

            if (exito) {
                JOptionPane.showMessageDialog(this, "Pago actualizado correctamente");
                cargarPagos();
                limpiar();
                btnGuardar.setEnabled(true);
                txtIdAdmin.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el pago", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = tblPagos.getSelectedRow();
        if (selectedRow >= 0) {
            int idPago = Integer.parseInt(tblPagos.getValueAt(selectedRow, 0).toString());  // Obtener el ID del pago

            // Confirmar la eliminación
            int response = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este pago?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                // Eliminar el pago
                PagosDAO pagosDAO = new PagosDAO();
                boolean exito = pagosDAO.eliminarPago(idPago);  // Este método debería eliminar el pago por ID

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Pago eliminado correctamente");
                    cargarPagos();
                    limpiar();
                    btnGuardar.setEnabled(true);
                    txtIdAdmin.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el pago", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un pago para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPagosMouseClicked
        int row = tblPagos.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            btnGuardar.setEnabled(false);
            txtIdAdmin.setEnabled(false);

            String idPago = tblPagos.getValueAt(row, 0).toString();
            String idAdmin = tblPagos.getValueAt(row, 1).toString();
            String idCliente = tblPagos.getValueAt(row, 2).toString();
            String tipoPago = tblPagos.getValueAt(row, 3).toString();
            String fechaPago = tblPagos.getValueAt(row, 4).toString();
            String membresia = tblPagos.getValueAt(row, 5).toString();

            // Cargar los datos de la fila seleccionada en los campos de texto
            txtId.setText(idCliente);  // O el campo que corresponda con el ID del cliente
            txtIdAdmin.setText(idAdmin);
            cmbTipoPago.setSelectedItem(tipoPago);
            cmbMembresia.setSelectedItem(membresia);
            txtIdPago.setText(idPago);
            txtFecha.setText(fechaPago);
        }
    }//GEN-LAST:event_tblPagosMouseClicked

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
            java.util.logging.Logger.getLogger(PruebaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaPago().setVisible(true);
            }
        });
    }

    private void cargarClientes() {
        try {
            UsuarioDAO usuariosDao = new UsuarioDAO();
            List<Usuario> listaClientes = usuariosDao.obtenerClientes();

            if (listaClientes == null || listaClientes.isEmpty()) {
                
                return;
            }

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");

            for (Usuario usuario : listaClientes) {
                modelo.addRow(new Object[]{usuario.getId_Cliente(), usuario.getNombre_Cliente(), usuario.getApellido_Cliente()});
            }
            tblClientes.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }

    private void cargarPagos() {
        try {
            // Obtener lista de pagos desde la base de datos
            PagosDAO pagosDAO = new PagosDAO();
            List<Pagos> listaPagos = pagosDAO.obtenerPagos();

            // Crear modelo de tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Pago");
            modelo.addColumn("ID Admin");
            modelo.addColumn("ID Cliente");
            modelo.addColumn("Tipo de Pago");
            modelo.addColumn("Fecha");
            modelo.addColumn("Membresia");

            // Agregar datos al modelo
            for (Pagos pago : listaPagos) {
                modelo.addRow(new Object[]{
                    pago.getId_Pago(),
                    pago.getId_Administrador(),
                    pago.getId_Cliente(),
                    pago.getTipo_Pago().name(),
                    pago.getFecha_Pago(),
                    pago.getTipo_Membresia()
                });
            }

            // Asignar modelo a la tabla
            tblPagos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar pagos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarMembresias() {
        try {
            // Obtener lista de membresías desde la base de datos
            MembresiaDAO membresiasDAO = new MembresiaDAO();
            List<Membresias> listaMembresias = membresiasDAO.obtenerMembresia(); // Método que obtiene todas las membresías

            // Limpiar el comboBox
            cmbMembresia.removeAllItems();

            // Verificar si la lista tiene datos
            if (listaMembresias == null || listaMembresias.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron membresías.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Agregar nombres de membresías al comboBox
            cmbMembresia.removeAllItems();
            cmbMembresia.addItem("Seleccione Un Tipo");
            for (Membresias membresia : listaMembresias) {
                cmbMembresia.addItem(membresia.getNombre_Membresia()); // Suponiendo que tienes un método getNombre()
            }

            // Verificar que la carga fue correcta
            System.out.println("Membresías cargadas correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar membresías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbMembresia;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdAdmin;
    private javax.swing.JTextField txtIdPago;
    // End of variables declaration//GEN-END:variables
}
