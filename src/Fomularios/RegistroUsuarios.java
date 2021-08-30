package Fomularios;

import Metodos.ConexionBD;
import Metodos.GenerarCodigos;
import Metodos.MetodosSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class RegistroUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form RegistroUsuarios
     */
    public RegistroUsuarios() {
        initComponents();
        mostrarDatos();
        setLocationRelativeTo(null);
//        icon_Formulario();
        etiqueta();

    }
    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtApellido = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtContraseña = new javax.swing.JTextField();
        JCSector = new javax.swing.JComboBox<>();
        TxtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LblEtiqueta = new javax.swing.JLabel();
        LblNombre = new javax.swing.JLabel();
        BtnEditar = new javax.swing.JButton();
        BtnBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTUsuario = new javax.swing.JTable();
        TxtCod = new javax.swing.JTextField();
        BtnRegistro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de usuarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Usuario: ");

        jLabel5.setText("Sector:");

        TxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidoActionPerformed(evt);
            }
        });

        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });

        TxtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtContraseñaActionPerformed(evt);
            }
        });

        JCSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operador", "Administrador", "Mantenimiento", "Sistemas", " " }));

        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 51, 0));
        jLabel6.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText(" Sistema de registro de usuarios");

        LblEtiqueta.setText("Bienvenido :");

        LblNombre.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N

        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnBorrar.setText("Borrar");
        BtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorrarActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        JTUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTUsuario.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JTUsuario.setShowHorizontalLines(false);
        JTUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTUsuario);

        TxtCod.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodActionPerformed(evt);
            }
        });

        BtnRegistro.setText("Nuevo Regisro: ");
        BtnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(LblEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(184, 184, 184)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(214, 214, 214)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(TxtUsuario))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCSector, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JCSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSalir)
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 640));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f_2.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 818, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        int i = Met.guardar(Integer.parseInt(TxtCod.getText()), TxtNombre.getText(), TxtApellido.getText(), TxtUsuario.getText(), TxtContraseña.getText(), JCSector.getItemAt(0)); //EJECUTAMOS EL METODO GUARDAR DE LOS METODOS SQL
        if (i > 0) {
            JOptionPane.showMessageDialog(this, "Datos guardados con exito");
            limpiarCajas();
            mostrarDatos();
            codigos();

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo guardar los datos");

        }


    }//GEN-LAST:event_BtnGuardarActionPerformed

//    public void icon_Formulario() {
//        //aca debemos importar la imagen de nuestra libreria 
//
//        URL url = getClass().getResource("/imagenes/logoico.png");
//        //Instanciamos ... 
//        ImageIcon icon_Formulario = new ImageIcon(url);
//        setIconImage(icon_Formulario.getImage());
//    }
    public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"Cod.", "Nombre", "Apellido", "Usuario", "Contraseña", "Sector"};
        String[] registros = new String[6];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.usuario";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido");
                registros[3] = rs.getString("usuario");
                registros[4] = rs.getString("contraseña");
                registros[5] = rs.getString("sector");

                modelo.addRow(registros);

            }
            JTUsuario.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }

    public void EliminarRegistros() { //metodo corto para eliminar y funciona
        try {
            String SQL = " delete from querico.usuario where cod= ?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtCod.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());

        }
    }

    public void EditarDatos() {

        try {
            String SQL = "UPDATE querico.usuario SET nombre=?, apellido=?, usuario=?, contraseña=?, sector=? WHERE cod=?";

            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, TxtNombre.getText());
            pst.setString(2, TxtApellido.getText());
            pst.setString(3, TxtUsuario.getText());
            pst.setString(4, TxtContraseña.getText());
            int seleccionado = JCSector.getSelectedIndex();
            pst.setString(5, JCSector.getItemAt(seleccionado));
            pst.setString(6, TxtCod.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado con exito. ");
            limpiarCajas();
            mostrarDatos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }

    public void limpiarCajas() {
        TxtCod.setText("");
        TxtNombre.setText("");
        TxtUsuario.setText("");
        TxtContraseña.setText("");
        TxtApellido.setText("");
        JCSector.setSelectedItem(null);

    }

    public void etiqueta() {
        //Este metodo sirve para capturar etiquetas de otro frame y mostrarla
        String x;
        x = Portal.LblNombreP.getText();
        LblNombre.setText(x);

        if (x.equals("AdminSoft") || x.equals("Fernando Sosa") || x.equals("Administrador")) {

            TxtCod.setEnabled(false);
            TxtNombre.setEnabled(true);
            TxtApellido.setEnabled(true);
            TxtUsuario.setEnabled(true);
            TxtContraseña.setEnabled(true);

        } else {
            TxtCod.setEnabled(false);
            TxtNombre.setEnabled(false);
            TxtApellido.setEnabled(false);
            TxtUsuario.setEnabled(false);
            TxtContraseña.setEnabled(false);

            BtnGuardar.setEnabled(false);
            BtnBorrar.setEnabled(false);
            BtnEditar.setEnabled(false);
            JTUsuario.setVisible(false);
            JCSector.setEnabled(false);
            BtnRegistro.setEnabled(false);

            LblNombre.setText("No tiene permisos de Administrador.");

        }

    }

    public void codigos() {
        // Metodo para generar codigos automanticamente desde la clase GenerarCodigos     
        int j;
        int cont = 1;
        String num = "";
//        String c="";
        String SQL = "select max(cod) from querico.usuario";
        // String SQL="select count(*) from factura";
        //String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
        //String SQL="SELECT @@identity AS ID";
        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery(SQL);
            if (rs.next()) {
                num = rs.getString(1);
            }

            if (num == null) {
                TxtCod.setText("0001");
            }

            j = Integer.parseInt(num);
            GenerarCodigos gen = new GenerarCodigos();
            gen.generar(j);
            TxtCod.setText(gen.serie());

        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

    private void TxtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtContraseñaActionPerformed

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    private void TxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidoActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        if (TxtCod.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Seleccione un campo para poder editar.");

        } else {

            EditarDatos();
            mostrarDatos();
        }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorrarActionPerformed
        if (TxtCod.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un campo a eliminar.");

        } else {
            String opcion[] = {"Eliminar", "Cancelar"};

            int eleccion = JOptionPane.showOptionDialog(this, "Esta seguro de eliminar el registro para siempre?. ", "ATENCION!!!", 0, 0, null, opcion, evt);
            if (eleccion == JOptionPane.YES_OPTION) {
                EliminarRegistros();

            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.out.println("Eliminacion cancelada!");

            }
            mostrarDatos();
            limpiarCajas();

        }

    }//GEN-LAST:event_BtnBorrarActionPerformed

    private void JTUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTUsuarioMouseClicked
        int filaSeleccionada = JTUsuario.rowAtPoint(evt.getPoint());
        TxtCod.setText(JTUsuario.getValueAt(filaSeleccionada, 0).toString());
        TxtNombre.setText(JTUsuario.getValueAt(filaSeleccionada, 1).toString());
        TxtApellido.setText(JTUsuario.getValueAt(filaSeleccionada, 2).toString());
        TxtUsuario.setText(JTUsuario.getValueAt(filaSeleccionada, 3).toString());
        TxtContraseña.setText(JTUsuario.getValueAt(filaSeleccionada, 4).toString());
        JCSector.setSelectedItem(JTUsuario.getValueAt(filaSeleccionada, 5));


    }//GEN-LAST:event_JTUsuarioMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        int filaSeleccionada = JTUsuario.rowAtPoint(evt.getPoint());
        TxtCod.setText(JTUsuario.getValueAt(filaSeleccionada, 0).toString());
        TxtNombre.setText(JTUsuario.getValueAt(filaSeleccionada, 1).toString());
        TxtApellido.setText(JTUsuario.getValueAt(filaSeleccionada, 2).toString());
        TxtUsuario.setText(JTUsuario.getValueAt(filaSeleccionada, 3).toString());
        TxtContraseña.setText(JTUsuario.getValueAt(filaSeleccionada, 4).toString());
        JCSector.setSelectedItem(JTUsuario.getValueAt(filaSeleccionada, 5));
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void BtnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistroActionPerformed

        codigos();

    }//GEN-LAST:event_BtnRegistroActionPerformed

    private void TxtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCodActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBorrar;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnRegistro;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JComboBox<String> JCSector;
    private javax.swing.JTable JTUsuario;
    private javax.swing.JLabel LblEtiqueta;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtCod;
    private javax.swing.JTextField TxtContraseña;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
