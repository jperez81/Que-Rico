/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

import Metodos.ConexionBD;
import Metodos.GenerarCodigos;
import Metodos.MetodosSql;
import Metodos.ViajeCerrado;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Pérez
 */
public class Panel_Produccion extends javax.swing.JPanel {

//    Panel_Produccion produccion = new Panel_Produccion();
    NuevaOrden NuevaOrden = new NuevaOrden();
    PFaena parada = new PFaena();
    PlanillaControl planilla = new PlanillaControl();
    CardLayout vistac;

    /**
     * Creates new form Panel_Produccion
     */
    public Panel_Produccion() {
        initComponents();
//        mostrarDatos();
//        TxtFecha.setText(fechaact());
//        mostrarDatos1();
//        block();
//        TrabajoCerrado1();
        vistac = (CardLayout) pnl_vista_principal1.getLayout();
    }
    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

//    public void TrabajoCerrado1() {
//        
//        JTOtt.getColumnModel().getColumn(11).setCellRenderer(new ViajeCerrado());
//        
//    }
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatofecha.format(fecha);

    }

//    public void block() {
//        TxtOt.setEnabled(false);
//        LblNombreP.setEnabled(false);
//        
//    }
//    public void etiqueta() {
//        //Este metodo sirve para capturar etiquetas de otro frame y mostrarla
//        String x;
//        x = Portal.LblNombreP.getText();
//        LblNombreP.setText(x);
//    }
//    
//    public void mostrarDatos1() {
//        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
//        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Observaciones", "Inicio", "Tipo Trabajo", "Materiales", "Obs Responsable", "Estado", "Cierre"};
//        String[] registros = new String[13];
//        
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        
//        String SQL = "SELECT * FROM querico.ordenesp";
//        
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            
//            while (rs.next()) {
//                
//                registros[0] = rs.getString("ot");
//                registros[1] = rs.getString("solicitante");
//                registros[2] = rs.getString("fecha");
//                registros[3] = rs.getString("sector");
//                registros[4] = rs.getString("detalle");
//                registros[5] = rs.getString("prioridad");
//                registros[6] = rs.getString("observaciones");
//                registros[7] = rs.getString("f_inicio");
//                registros[8] = rs.getString("sector_def");
//                registros[9] = rs.getString("materiales");
//                registros[10] = rs.getString("obs_resp");
//                registros[11] = rs.getString("estado");
//                registros[12] = rs.getString("f_cierre");
//                
//                modelo.addRow(registros);
//                
//            }
//            JTOtt.setModel(modelo);
//            TrabajoCerrado1();
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
//        }
//    }
//    public void mostrarDatos() {
//        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
//        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Observaciones"};
//        String[] registros = new String[7];
//        
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        
//        String SQL = "SELECT * FROM querico.ordenes";
//        
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            
//            while (rs.next()) {
//                
//                registros[0] = rs.getString("ot");
//                registros[1] = rs.getString("solicitante");
//                registros[2] = rs.getString("fecha");
//                registros[3] = rs.getString("sector");
//                registros[4] = rs.getString("detalle");
//                registros[5] = rs.getString("prioridad");
//                registros[6] = rs.getString("observaciones");
//                
//                modelo.addRow(registros);
//                
//            }
//            JTOt.setModel(modelo);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
//        }
//    }
//    public void FiltrarDatos(String valor) {
//        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
//        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Observaciones"};
//        String[] registros = new String[7];
//        
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//
////        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
//        String SQL = "SELECT * FROM querico.ordenes WHERE CONCAT(ot,solicitante,fecha,detalle,prioridad) LIKE '%" + valor + "%'";
//        
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            
//            while (rs.next()) {
//                
//                registros[0] = rs.getString("ot");
//                registros[1] = rs.getString("solicitante");
//                registros[2] = rs.getString("fecha");
//                registros[3] = rs.getString("sector");
//                registros[4] = rs.getString("detalle");
//                registros[5] = rs.getString("prioridad");
//                registros[6] = rs.getString("observaciones");
//                
//                modelo.addRow(registros);
//                
//            }
//            JTOt.setModel(modelo);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
//        }
//        
//    }
//    public void insertarDatos() {
//        
//        try {
//            String SQL = "INSERT INTO querico.ordenes (ot,solicitante,fecha,sector,detalle,prioridad,observaciones)VALUES (?,?,?,?,?,?,?)";
//            PreparedStatement pst = con.prepareStatement(SQL);
//            
//            pst.setString(1, TxtOt.getText());
//            pst.setString(2, LblNombreP.getText());
//            pst.setString(3, TxtFecha.getText());
//            int seleccionado1 = JCSector.getSelectedIndex();            
//            pst.setString(4, JCSector.getItemAt(seleccionado1));
//            pst.setString(5, TxtDetalle.getText());
//            int seleccionado = JCPrioridad.getSelectedIndex();
//            pst.setString(6, JCPrioridad.getItemAt(seleccionado));
//            pst.setString(7, jTextField1.getText());
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());
//            
//        }
//    }
//    public void EditarDatos() {
//        
//        try {
//            String SQL = "UPDATE querico.ordenes SET solicitante=?, fecha=?, sector=?, detalle=?, prioridad=?, observaciones=? WHERE ot=?";
//            
//            PreparedStatement pst = con.prepareStatement(SQL);
//            
//            pst.setString(1, LblNombreP.getText());
//            pst.setString(2, TxtFecha.getText());
//            int seleccionado1 = JCSector.getSelectedIndex();            
//            pst.setString(3, JCSector.getItemAt(seleccionado1));
//            pst.setString(4, TxtDetalle.getText());
//            int seleccionado = JCPrioridad.getSelectedIndex();
//            pst.setString(5, JCPrioridad.getItemAt(seleccionado));
//            pst.setString(6, jTextField1.getText());
//            pst.setString(7, TxtOt.getText());
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Registro editado con exito. ");
//            limpiarCajas();
//            mostrarDatos();
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());
//            
//        }
//        
//    }
//    public void codigos() {
//        // Metodo para generar codigos automanticamente desde la clase GenerarCodigos     
//        int j;
//        int cont = 1;
//        String num = "";
////        String c="";
//        String SQL = "select max(ot) from querico.ordenes";
//        // String SQL="select count(*) from factura";
//        //String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
//        //String SQL="SELECT @@identity AS ID";
//        try {
//            PreparedStatement pst = con.prepareStatement(SQL);
//            ResultSet rs = pst.executeQuery(SQL);
//            if (rs.next()) {
//                num = rs.getString(1);
//            }
//            
//            if (num == null) {
//                TxtOt.setText("00001");
//            }
//            
//            j = Integer.parseInt(num);
//            GenerarCodigos gen = new GenerarCodigos();
//            gen.generar(j);
//            TxtOt.setText(0000 + gen.serie());
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Panel_Produccion.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jSeparator1 = new javax.swing.JSeparator();
        pnl_vista_principal1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BtnOrdenes = new javax.swing.JToggleButton();
        BtnFaena = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        BtnBalanza = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion general de produccion"));
        setPreferredSize(new java.awt.Dimension(1010, 491));

        pnl_vista_principal1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));

        BtnOrdenes.setText("NUEVAS ORDENES");
        BtnOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOrdenesActionPerformed(evt);
            }
        });

        BtnFaena.setText("PARADA DE FAENA");
        BtnFaena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFaenaActionPerformed(evt);
            }
        });

        jToggleButton3.setText("EMPAQUE");

        BtnBalanza.setText("BALANZA");
        BtnBalanza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBalanzaActionPerformed(evt);
            }
        });

        jToggleButton5.setText("?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnFaena, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnBalanza, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnFaena, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBalanza, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_vista_principal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_vista_principal1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOrdenesActionPerformed
        if (BtnOrdenes.isSelected()) {

            pnl_vista_principal1.add(NuevaOrden, "Nueva Orden");
            vistac.show(pnl_vista_principal1, "Nueva Orden");
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            //ACTIVAMOS EL BOTON QUE PRESIONAMOS Y BLOQUEAMOS LOS DEMAS
            BtnFaena.setEnabled(false);
            BtnBalanza.setEnabled(false);

            //            BtnReportes.setEnabled(false);
            //            BtnMantenimiento.setEnabled(false);
            BtnOrdenes.setBackground(Color.WHITE);

        } else {
            //LIMPIAMOS LAS CAJAS DE LO CONTRARIO
            pnl_vista_principal1.removeAll();
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            //Y ACTIVAMOS NUEVAMENTES LOS BOTONES Y DEVOLVEMOS EL COLOR AL BOTON
            BtnOrdenes.setEnabled(true);
            BtnFaena.setEnabled(true);
            BtnBalanza.setEnabled(true);

            //            BtnMantenimiento.setEnabled(true);
            BtnFaena.setBackground(new Color(204, 204, 204));

        }
    }//GEN-LAST:event_BtnOrdenesActionPerformed

    private void BtnFaenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFaenaActionPerformed
        if (BtnFaena.isSelected()) {

            pnl_vista_principal1.add(parada, "Parada de faena");
            vistac.show(pnl_vista_principal1, "Parada de faena");
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            //ACTIVAMOS EL BOTON QUE PRESIONAMOS Y BLOQUEAMOS LOS DEMAS
            //BtnFaena.setEnabled(false);

            BtnOrdenes.setEnabled(false);
            BtnBalanza.setEnabled(false);
            //            BtnMantenimiento.setEnabled(false);

            BtnFaena.setBackground(Color.WHITE);

        } else {
            //LIMPIAMOS LAS CAJAS DE LO CONTRARIO
            pnl_vista_principal1.removeAll();
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            //Y ACTIVAMOS NUEVAMENTES LOS BOTONES Y DEVOLVEMOS EL COLOR AL BOTON
            BtnFaena.setEnabled(true);
            BtnOrdenes.setEnabled(true);
            BtnBalanza.setEnabled(true);

            //            BtnMantenimiento.setEnabled(true);
            BtnFaena.setBackground(new Color(204, 204, 204));

        }
    }//GEN-LAST:event_BtnFaenaActionPerformed

    private void BtnBalanzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBalanzaActionPerformed
       if (BtnBalanza.isSelected()) {

            pnl_vista_principal1.add(planilla, "Planilla");
            vistac.show(pnl_vista_principal1, "Planilla");
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            //ACTIVAMOS EL BOTON QUE PRESIONAMOS Y BLOQUEAMOS LOS DEMAS
            //BtnFaena.setEnabled(false);

            BtnOrdenes.setEnabled(false);
            BtnFaena.setEnabled(false);
            //            BtnMantenimiento.setEnabled(false);

            BtnBalanza.setBackground(Color.WHITE);

        } else {
            //LIMPIAMOS LAS CAJAS DE LO CONTRARIO
            pnl_vista_principal1.removeAll();
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            //Y ACTIVAMOS NUEVAMENTES LOS BOTONES Y DEVOLVEMOS EL COLOR AL BOTON
            BtnFaena.setEnabled(true);
            BtnOrdenes.setEnabled(true);

            //            BtnMantenimiento.setEnabled(true);
            BtnBalanza.setBackground(new Color(204, 204, 204));

        }
    }//GEN-LAST:event_BtnBalanzaActionPerformed

//    public void Filtro1(String valor) {
//        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
//        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Observacione", "Inicio", "Tipo Trabajo", "Materiales", "Obs Responsable", "Estado", "Cierre"};
//        String[] registros = new String[13];
//        
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//
////        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
//        String SQL = "SELECT * FROM querico.ordenesp WHERE CONCAT(ot,solicitante,fecha,detalle,prioridad,f_inicio,materiales,estado,f_cierre) LIKE '%" + valor + "%'";
//        
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            
//            while (rs.next()) {
//                
//                registros[0] = rs.getString("ot");
//                registros[1] = rs.getString("solicitante");
//                registros[2] = rs.getString("fecha");
//                registros[3] = rs.getString("sector");
//                registros[4] = rs.getString("detalle");
//                registros[5] = rs.getString("prioridad");
//                registros[6] = rs.getString("observaciones");
//                registros[7] = rs.getString("f_inicio");
//                registros[8] = rs.getString("sector_def");
//                registros[9] = rs.getString("materiales");
//                registros[10] = rs.getString("obs_resp");
//                registros[11] = rs.getString("estado");
//                registros[12] = rs.getString("f_cierre");
//                
//                modelo.addRow(registros);
//                
//            }
//            JTOtt.setModel(modelo);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
//        }
//        
//    }
    //    public void EliminarRegistros1() { //metodo corto para eliminar y funciona
//        try {
//            
//            String SQL = " delete from querico.ordenesp where ot= ?";
//            PreparedStatement pst = con.prepareStatement(SQL);
//            
//            pst.setString(1, TxtOt.getText());
//            
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Registro eliminado con exito. ");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());
//            
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnBalanza;
    private javax.swing.JToggleButton BtnFaena;
    private javax.swing.JToggleButton BtnOrdenes;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JPanel pnl_vista_principal1;
    // End of variables declaration//GEN-END:variables
}
