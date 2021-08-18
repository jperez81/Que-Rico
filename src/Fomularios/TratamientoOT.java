/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

import Metodos.ConexionBD;
import Metodos.MetodosSql;
import Metodos.ViajeCerrado;
import com.lowagie.text.pdf.PdfName;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Pérez
 */
public class TratamientoOT extends javax.swing.JFrame {

    /**
     * Creates new form TratamientoOT
     */
    public TratamientoOT() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarDatos();
        TrabajoCerrado1();
       

    }

    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    public void TrabajoCerrado1() {

        JTOt.getColumnModel().getColumn(6).setCellRenderer(new ViajeCerrado());
      
    }

    public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado Solicitud"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.ordenes";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("ot");
                registros[1] = rs.getString("solicitante");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("sector");
                registros[4] = rs.getString("detalle");
                registros[5] = rs.getString("prioridad");
                registros[6] = rs.getString("estado");

                modelo.addRow(registros);

            }
            JTOt.setModel(modelo);
            TrabajoCerrado1();
         
            {
            
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        TxtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTOt = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();

        jMenuItem1.setText("Enviar Datos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tratamiento de OT");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        TxtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaActionPerformed(evt);
            }
        });
        TxtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBusquedaKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busqueda: ");

        jButton1.setText("Limpiar busqueda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        JTOt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTOt.setComponentPopupMenu(jPopupMenu1);
        JTOt.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTOt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTOtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTOt);

        jCheckBox1.setText("Mostrar ordenes solicitadas");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBusquedaKeyReleased
        FiltrarDatos(TxtBusqueda.getText());
    }//GEN-LAST:event_TxtBusquedaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        LimpiarCaja();
        mostrarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTOtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTOtMouseClicked


    }//GEN-LAST:event_JTOtMouseClicked

    public void FiltrarDatos(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado Solicitud"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.ordenes WHERE CONCAT(ot,solicitante,fecha,detalle,prioridad) LIKE '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("ot");
                registros[1] = rs.getString("solicitante");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("sector");
                registros[4] = rs.getString("detalle");
                registros[5] = rs.getString("prioridad");
                registros[6] = rs.getString("solicitud");

                modelo.addRow(registros);

            }
            JTOt.setModel(modelo);
            TrabajoCerrado1();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DefaultTableModel tm = (DefaultTableModel) JTOt.getModel();
        String dato = String.valueOf(tm.getValueAt(JTOt.getSelectedRow(), 6));
        if (dato.equals("Tratamiento")) {

            JOptionPane.showMessageDialog(null, "El trabajo ya esta en tratamiento.");

        } else {

            String ot = "", solicitante = "", fecha = "", sector = "", detalle = "", prioridad = "";

            int filaseleccionada = JTOt.getSelectedRow();

            try {

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
                } else {
                    ot = (String) JTOt.getValueAt(filaseleccionada, 0);
                    solicitante = (String) JTOt.getValueAt(filaseleccionada, 1);
                    fecha = (String) JTOt.getValueAt(filaseleccionada, 2);
                    sector = (String) JTOt.getValueAt(filaseleccionada, 3);
                    detalle = (String) JTOt.getValueAt(filaseleccionada, 4);
                    prioridad = (String) JTOt.getValueAt(filaseleccionada, 5);
//                    estado = (String) JTOt.getValueAt(filaseleccionada, 6);

                    Panel_Manteniento.TxtOt.setText(ot);
                    Panel_Manteniento.LblNombreP.setText(solicitante);
                    Panel_Manteniento.TxtFecha.setText(fecha);
                    Panel_Manteniento.TxtSector.setText(sector);
                    Panel_Manteniento.TxtDetalle.setText(detalle);
//            int sel = Panel_Manteniento.JCPrioridad.getSelectedIndex();
                    Panel_Manteniento.TxtPrioridad.setText(prioridad);
//                    int sel = Panel_Manteniento.JCEstados.getSelectedIndex();
//                    Panel_Manteniento.JCEstados.setSelectedItem(estado);

                }

            } catch (Exception e) {
            }
        }
        this.dispose();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void TxtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBusquedaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrarDatos();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
     
        if(jCheckBox1.isSelected()){
        
             String consulta = "";
             
             consulta = "SELECT * FROM querico.ordenes WHERE estado='Solicitada'";
             String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Solicitud"};
            String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);


        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {

                registros[0] = rs.getString("ot");
                registros[1] = rs.getString("solicitante");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("sector");
                registros[4] = rs.getString("detalle");
                registros[5] = rs.getString("prioridad");
                registros[6] = rs.getString("estado");

                modelo.addRow(registros);

            }
            JTOt.setModel(modelo);
            TrabajoCerrado1();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
        
        }else{
        mostrarDatos();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(TratamientoOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TratamientoOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TratamientoOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TratamientoOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TratamientoOT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JTOt;
    private javax.swing.JTextField TxtBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
