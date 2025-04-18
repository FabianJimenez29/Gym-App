/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.app.gymapp.frames;

import java.awt.Color;

/**
 *
 * @author Administrator
 */
public class AdminV1 extends javax.swing.JFrame {

    int xMouse, yMouse;

    public AdminV1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        btnVolver = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("Ingrese el nombre");
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 230, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 20));

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 60, 30));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 60, 30));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(204, 204, 204));
        txtApellido.setText("Ingrese el apellido");
        txtApellido.setBorder(null);
        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoMousePressed(evt);
            }
        });
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 230, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 230, 20));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Edad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 40, 30));

        txtEdad.setBackground(new java.awt.Color(255, 255, 255));
        txtEdad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(204, 204, 204));
        txtEdad.setText("Ingrese la edad");
        txtEdad.setBorder(null);
        txtEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEdadMousePressed(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 230, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 230, 20));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 60, 30));

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(204, 204, 204));
        txtTelefono.setText("Ingrese el telefono");
        txtTelefono.setBorder(null);
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 230, 30));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 230, 20));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Correo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 50, 30));

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(204, 204, 204));
        txtCorreo.setText("Ingrese el correo");
        txtCorreo.setBorder(null);
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoMousePressed(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 230, 30));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 230, 20));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 20, 30));

        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtID.setForeground(new java.awt.Color(204, 204, 204));
        txtID.setText("Ingrese el ID");
        txtID.setBorder(null);
        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDMousePressed(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 230, 30));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 20));

        jLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Contraseña");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 80, 30));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 230, 20));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("****************");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 230, 30));

        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, -1, -1));

        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 540, 470));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\Gym-App\\src\\main\\resources\\volverr.png")); // NOI18N
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverMouseExited(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir.png"))); // NOI18N
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 804, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(15, 15, 15))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addComponent(btnVolver))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(Color.red);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(Color.white);
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        Principal p = new Principal();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseEntered
        btnVolver.setBackground(Color.red);
    }//GEN-LAST:event_btnVolverMouseEntered

    private void btnVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseExited
        btnVolver.setBackground(Color.white);
    }//GEN-LAST:event_btnVolverMouseExited

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMousePressed
        if (txtID.getText().equals("Ingrese el ID")) {
            txtID.setText("");
            txtID.setForeground(Color.black);
        }

        // Resetea los otros campos solo si no tienen datos personalizados
        if (txtNombre.getText().isEmpty() || txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("Ingrese el nombre");
            txtNombre.setForeground(Color.gray);
        }

        if (txtApellido.getText().isEmpty() || txtApellido.getText().equals("Ingrese el apellido")) {
            txtApellido.setText("Ingrese el apellido");
            txtApellido.setForeground(Color.gray);
        }

        if (txtEdad.getText().isEmpty() || txtEdad.getText().equals("Ingrese la edad")) {
            txtEdad.setText("Ingrese la edad");
            txtEdad.setForeground(Color.gray);
        }

        if (txtTelefono.getText().isEmpty() || txtTelefono.getText().equals("Ingrese el telefono")) {
            txtTelefono.setText("Ingrese el telefono");
            txtTelefono.setForeground(Color.gray);
        }

        if (txtCorreo.getText().isEmpty() || txtCorreo.getText().equals("Ingrese el correo")) {
            txtCorreo.setText("Ingrese el correo");
            txtCorreo.setForeground(Color.gray);
        }

        if (txtPassword.getText().isEmpty() || txtPassword.getText().equals("****************")) {
            txtPassword.setText("****************");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtIDMousePressed

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        if (txtID.getText().isEmpty() || txtID.getText().equals("Ingrese el ID")) {
            txtID.setText("Ingrese el ID");
            txtID.setForeground(Color.gray);
        }

        if (txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.BLACK);
        }

        if (txtApellido.getText().isEmpty() || txtApellido.getText().equals("Ingrese el apellido")) {
            txtApellido.setText("Ingrese el apellido");
            txtApellido.setForeground(Color.gray);
        }

        if (txtEdad.getText().isEmpty() || txtEdad.getText().equals("Ingrese la edad")) {
            txtEdad.setText("Ingrese la edad");
            txtEdad.setForeground(Color.gray);
        }

        if (txtTelefono.getText().isEmpty() || txtTelefono.getText().equals("Ingrese el telefono")) {
            txtTelefono.setText("Ingrese el telefono");
            txtTelefono.setForeground(Color.gray);
        }

        if (txtCorreo.getText().isEmpty() || txtCorreo.getText().equals("Ingrese el correo")) {
            txtCorreo.setText("Ingrese el correo");
            txtCorreo.setForeground(Color.gray);
        }

        if (txtPassword.getText().isEmpty() || txtPassword.getText().equals("****************")) {
            txtPassword.setText("****************");
            txtPassword.setForeground(Color.gray);
        }

    }//GEN-LAST:event_txtNombreMousePressed

    private void txtApellidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMousePressed
        if (txtID.getText().isEmpty() || txtID.getText().equals("Ingrese el ID")) {
            txtID.setText("Ingrese el ID");
            txtID.setForeground(Color.gray);
        }

        if (txtNombre.getText().isEmpty() || txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("Ingrese el nombre");
            txtNombre.setForeground(Color.gray);
        }

        if (txtApellido.getText().equals("Ingrese el apellido")) {
            txtApellido.setText("");
            txtApellido.setForeground(Color.BLACK);
        }

        if (txtEdad.getText().isEmpty() || txtEdad.getText().equals("Ingrese la edad")) {
            txtEdad.setText("Ingrese la edad");
            txtEdad.setForeground(Color.gray);
        }

        if (txtTelefono.getText().isEmpty() || txtTelefono.getText().equals("Ingrese el telefono")) {
            txtTelefono.setText("Ingrese el telefono");
            txtTelefono.setForeground(Color.gray);
        }

        if (txtCorreo.getText().isEmpty() || txtCorreo.getText().equals("Ingrese el correo")) {
            txtCorreo.setText("Ingrese el correo");
            txtCorreo.setForeground(Color.gray);
        }

        if (txtPassword.getText().isEmpty() || txtPassword.getText().equals("****************")) {
            txtPassword.setText("****************");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtApellidoMousePressed

    private void txtEdadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadMousePressed
        if (txtID.getText().isEmpty() || txtID.getText().equals("Ingrese el ID")) {
            txtID.setText("Ingrese el ID");
            txtID.setForeground(Color.gray);
        }

        if (txtNombre.getText().isEmpty() || txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("Ingrese el nombre");
            txtNombre.setForeground(Color.gray);
        }

        if (txtApellido.getText().isEmpty() || txtApellido.getText().equals("Ingrese el apellido")) {
            txtApellido.setText("Ingrese el apellido");
            txtApellido.setForeground(Color.gray);
        }

        if (txtEdad.getText().equals("Ingrese la edad")) {
            txtEdad.setText("");
            txtEdad.setForeground(Color.BLACK);
        }

        if (txtTelefono.getText().isEmpty() || txtTelefono.getText().equals("Ingrese el telefono")) {
            txtTelefono.setText("Ingrese el telefono");
            txtTelefono.setForeground(Color.gray);
        }

        if (txtCorreo.getText().isEmpty() || txtCorreo.getText().equals("Ingrese el correo")) {
            txtCorreo.setText("Ingrese el correo");
            txtCorreo.setForeground(Color.gray);
        }

        if (txtPassword.getText().isEmpty() || txtPassword.getText().equals("****************")) {
            txtPassword.setText("****************");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtEdadMousePressed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        if (txtID.getText().isEmpty() || txtID.getText().equals("Ingrese el ID")) {
            txtID.setText("Ingrese el ID");
            txtID.setForeground(Color.gray);
        }

        if (txtNombre.getText().isEmpty() || txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("Ingrese el nombre");
            txtNombre.setForeground(Color.gray);
        }

        if (txtApellido.getText().isEmpty() || txtApellido.getText().equals("Ingrese el apellido")) {
            txtApellido.setText("Ingrese el apellido");
            txtApellido.setForeground(Color.gray);
        }

        if (txtEdad.getText().isEmpty() || txtEdad.getText().equals("Ingrese la edad")) {
            txtEdad.setText("Ingrese la edad");
            txtEdad.setForeground(Color.gray);
        }

        if (txtTelefono.getText().equals("Ingrese el telefono")) {
            txtTelefono.setText("");
            txtTelefono.setForeground(Color.BLACK);
        }

        if (txtCorreo.getText().isEmpty() || txtCorreo.getText().equals("Ingrese el correo")) {
            txtCorreo.setText("Ingrese el correo");
            txtCorreo.setForeground(Color.gray);
        }

        if (txtPassword.getText().isEmpty() || txtPassword.getText().equals("****************")) {
            txtPassword.setText("****************");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtTelefonoMousePressed

    private void txtCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMousePressed
        if (txtID.getText().isEmpty() || txtID.getText().equals("Ingrese el ID")) {
            txtID.setText("Ingrese el ID");
            txtID.setForeground(Color.gray);
        }

        if (txtNombre.getText().isEmpty() || txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("Ingrese el nombre");
            txtNombre.setForeground(Color.gray);
        }

        if (txtApellido.getText().isEmpty() || txtApellido.getText().equals("Ingrese el apellido")) {
            txtApellido.setText("Ingrese el apellido");
            txtApellido.setForeground(Color.gray);
        }

        if (txtEdad.getText().isEmpty() || txtEdad.getText().equals("Ingrese la edad")) {
            txtEdad.setText("Ingrese la edad");
            txtEdad.setForeground(Color.gray);
        }

        if (txtTelefono.getText().isEmpty() || txtTelefono.getText().equals("Ingrese el telefono")) {
            txtTelefono.setText("Ingrese el telefono");
            txtTelefono.setForeground(Color.gray);
        }

        if (txtCorreo.getText().equals("Ingrese el correo")) {
            txtCorreo.setText("");
            txtCorreo.setForeground(Color.BLACK);
        }

        if (txtPassword.getText().isEmpty() || txtPassword.getText().equals("****************")) {
            txtPassword.setText("****************");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtCorreoMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (txtID.getText().isEmpty() || txtID.getText().equals("Ingrese el ID")) {
            txtID.setText("Ingrese el ID");
            txtID.setForeground(Color.gray);
        }

        if (txtNombre.getText().isEmpty() || txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("Ingrese el nombre");
            txtNombre.setForeground(Color.gray);
        }

        if (txtApellido.getText().isEmpty() || txtApellido.getText().equals("Ingrese el apellido")) {
            txtApellido.setText("Ingrese el apellido");
            txtApellido.setForeground(Color.gray);
        }

        if (txtEdad.getText().isEmpty() || txtEdad.getText().equals("Ingrese la edad")) {
            txtEdad.setText("Ingrese la edad");
            txtEdad.setForeground(Color.gray);
        }

        if (txtTelefono.getText().isEmpty() || txtTelefono.getText().equals("Ingrese el telefono")) {
            txtTelefono.setText("Ingrese el telefono");
            txtTelefono.setForeground(Color.gray);
        }

        if (txtCorreo.getText().isEmpty() || txtCorreo.getText().equals("Ingrese el correo")) {
            txtCorreo.setText("Ingrese el correo");
            txtCorreo.setForeground(Color.gray);
        }

        if (txtPassword.getText().equals("****************")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

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
            java.util.logging.Logger.getLogger(AdminV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminV1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
