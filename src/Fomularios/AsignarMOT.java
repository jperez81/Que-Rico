
package Fomularios;

import Metodos.ConexionBD;
import Metodos.MetodosSql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Pérez
 */
public class AsignarMOT extends javax.swing.JFrame {

    /**
     * Creates new form AsignarMOT
     */
    public AsignarMOT() {
        initComponents();
        setLocationRelativeTo(null);

    }
    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"Num OT", "Sector", "Detalle", "Materiales", "Estado"};
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.ordenesp";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("ot");
//                registros[1] = rs.getString("solicitante");
//                registros[2] = rs.getString("fecha");
                registros[1] = rs.getString("sector");
                registros[2] = rs.getString("detalle");
//                registros[5] = rs.getString("prioridad");
//                registros[3] = rs.getString("observaciones");
//                registros[7] = rs.getString("f_inicio");
//                registros[8] = rs.getString("sector_def");
                registros[3] = rs.getString("materiales");
//                registros[10] = rs.getString("obs_resp");
                registros[4] = rs.getString("estado");
//                registros[12] = rs.getString("f_cierre");

                modelo.addRow(registros);

            }
            JTOtt.setModel(modelo);
//            TrabajoCerrado1();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }

    public void Filtro(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"Num OT", "Sector", "Detalle", "Materiales", "Estado"};
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.ordenesp WHERE CONCAT(ot,detalle,materiales,estado) LIKE '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("ot");
//                registros[1] = rs.getString("solicitante");
//                registros[2] = rs.getString("fecha");
                registros[1] = rs.getString("sector");
                registros[2] = rs.getString("detalle");
//                registros[5] = rs.getString("prioridad");
//                registros[3] = rs.getString("observaciones");
//                registros[7] = rs.getString("f_inicio");
//                registros[8] = rs.getString("sector_def");
                registros[3] = rs.getString("materiales");
//                registros[10] = rs.getString("obs_resp");
                registros[4] = rs.getString("estado");
//                registros[12] = rs.getString("f_cierre");

                modelo.addRow(registros);
            }
            JTOtt.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }

    //DESCA ACA MUSTRA TABLA DINAMICA
//        public void mostrarDatosd() {
//        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
//        String[] titulos = {"Num OT", "Sector", "Detalle", "Materiales","Dinamica"};
//        String[] registros = new String[5];
//
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//
//        String SQL = "SELECT * FROM querico.ordenesd";
//
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//
//            while (rs.next()) {
//
//                registros[0] = rs.getString("ot");
////                registros[1] = rs.getString("tipo");
////                registros[2] = rs.getString("solicita");
////                registros[3] = rs.getString("fecha");
//                registros[1] = rs.getString("sector");
//                registros[2] = rs.getString("detalle");
////                registros[6] = rs.getString("observacion");
//                registros[3] = rs.getString("materiales");
//                registros[4] = rs.getString("estado");
////                registros[9] = rs.getString("fechac");
//
//                modelo.addRow(registros);
//
//            }
//            JTDinamica.setModel(modelo);
//           
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        EnviarDatosSeleccionados = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        EnviarDatos2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TxtBuscar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTOtt = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        EnviarDatosSeleccionados.setText("Enviar datos seleccionados");
        EnviarDatosSeleccionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarDatosSeleccionadosActionPerformed(evt);
            }
        });
        jPopupMenu1.add(EnviarDatosSeleccionados);
        EnviarDatosSeleccionados.getAccessibleContext().setAccessibleName("Enviar Datos Seleccionados");

        EnviarDatos2.setText("Enviar datos seleccionados");
        EnviarDatos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarDatos2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(EnviarDatos2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccione donde asinara materiales");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        jButton1.setText("Actualizar lista");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla Produccion"));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        JTOtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTOtt.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(JTOtt);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked


    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void EnviarDatosSeleccionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarDatosSeleccionadosActionPerformed
        String ot = "", sector = "", detalle = "", materiales = "", estado = "";

        int filaseleccionada = JTOtt.getSelectedRow();

        if (filaseleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

        } else {
            ot = (String) JTOtt.getValueAt(filaseleccionada, 0);
            sector = (String) JTOtt.getValueAt(filaseleccionada, 1);
            detalle = (String) JTOtt.getValueAt(filaseleccionada, 2);
            materiales = (String) JTOtt.getValueAt(filaseleccionada, 3);
            estado = (String) JTOtt.getValueAt(filaseleccionada, 4);

            NuevoEgreso.TxtOt.setText(ot);
            NuevoEgreso.TxtSector.setText(sector);
            NuevoEgreso.TxtSector1.setText(sector);

            NuevoEgreso.TxtDetalle.setText(detalle);
            NuevoEgreso.TxtMateriales.setText(materiales);
            NuevoEgreso.TxtEstado.setText(estado);
            NuevoEgreso.TxtRef.setText(ot);

            this.dispose();

        }
    }//GEN-LAST:event_EnviarDatosSeleccionadosActionPerformed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        Filtro(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void EnviarDatos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarDatos2ActionPerformed
//       String ot= "",sector="", detalle ="", materiales="", estado ="";
//        
//        int filaseleccionada = JTDinamica.getSelectedRow();
//        
//        if (filaseleccionada == -1){
//            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");
//        
//        }else{
//        ot = (String) JTDinamica.getValueAt(filaseleccionada, 0);
//        sector= (String) JTDinamica.getValueAt(filaseleccionada, 1);
//        detalle = (String) JTDinamica.getValueAt(filaseleccionada, 2);
//        materiales = (String) JTDinamica.getValueAt(filaseleccionada, 3);
//        estado = (String)JTDinamica.getValueAt(filaseleccionada, 4);
//        
//        NuevoEgreso.TxtOt.setText(ot);
//        NuevoEgreso.TxtSector.setText(sector);            
//        NuevoEgreso.TxtDetalle.setText(detalle);
//        NuevoEgreso.TxtMateriales.setText(materiales);
//        NuevoEgreso.TxtEstado.setText(estado);
//        NuevoEgreso.TxtRef.setText(ot);
//        
//        this.dispose();
//        
//        }
    }//GEN-LAST:event_EnviarDatos2ActionPerformed

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
            java.util.logging.Logger.getLogger(AsignarMOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarMOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarMOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarMOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarMOT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EnviarDatos2;
    private javax.swing.JMenuItem EnviarDatosSeleccionados;
    private javax.swing.JTable JTOtt;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
