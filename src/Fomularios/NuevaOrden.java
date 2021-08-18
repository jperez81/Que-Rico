/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

import static Fomularios.TratamientoOT.JTOt;
import Metodos.ConexionBD;
import Metodos.GenerarCodigos;
import Metodos.MetodosSql;
import Metodos.ViajeCerrado;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Pérez
 */
public class NuevaOrden extends javax.swing.JPanel {

    /**
     * Creates new form NuevaOrden
     */
    public NuevaOrden() {
        initComponents();
        mostrarDatos();
        mostrarDatos1();
         TxtFecha.setText(fechaact());
                 block();
        TrabajoCerrado1();
        TrabajoCerrado3();
         
    }

   MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();
    
    public void TrabajoCerrado1() {
        
        JTOtt.getColumnModel().getColumn(11).setCellRenderer(new ViajeCerrado());
        
    }
     public void TrabajoCerrado2() {

        JTOt.getColumnModel().getColumn(6).setCellRenderer(new ViajeCerrado());

    }
     public void TrabajoCerrado3() {

        JTOt.getColumnModel().getColumn(6).setCellRenderer(new ViajeCerrado());
      
    }
        public void etiqueta() {
        //Este metodo sirve para capturar etiquetas de otro frame y mostrarla
        String x;
        x = Portal.LblNombreP.getText();
        LblNombreP.setText(x);
    }
            public void mostrarDatos1() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado Solicitud", "Inicio", "Tipo Trabajo", "Materiales", "Obs Responsable", "Estado", "Cierre"};
        String[] registros = new String[13];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "SELECT * FROM querico.ordenesp";
        
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
                registros[6] = rs.getString("estados");
                registros[7] = rs.getString("f_inicio");
                registros[8] = rs.getString("sector_def");
                registros[9] = rs.getString("materiales");
                registros[10] = rs.getString("obs_resp");
                registros[11] = rs.getString("estado");
                registros[12] = rs.getString("f_cierre");
                
                modelo.addRow(registros);
                
            }
            JTOtt.setModel(modelo);
            TrabajoCerrado1();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }
        
        
        public void block() {
        TxtOt.setEnabled(false);
        LblNombreP.setEnabled(false);
        
    }

    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatofecha.format(fecha);
        
    }
    
  
    
  
    
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
                registros[6] = rs.getString("estado");
                
                modelo.addRow(registros);
                
            }
            JTOt.setModel(modelo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
        
    }
    
        public void Filtro1(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado Solicitud", "Inicio", "Tipo Trabajo", "Materiales", "Obs Responsable", "Estado", "Cierre"};
        String[] registros = new String[13];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.ordenesp WHERE CONCAT(ot,solicitante,fecha,detalle,prioridad,f_inicio,materiales,estados,f_cierre) LIKE '%" + valor + "%'";
        
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
                registros[6] = rs.getString("estados");
                registros[7] = rs.getString("f_inicio");
                registros[8] = rs.getString("sector_def");
                registros[9] = rs.getString("materiales");
                registros[10] = rs.getString("obs_resp");
                registros[11] = rs.getString("estado");
                registros[12] = rs.getString("f_cierre");
                
                modelo.addRow(registros);
                
            }
            JTOtt.setModel(modelo);
            TrabajoCerrado1();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
        
    }
    
        public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado"};
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
            TrabajoCerrado2();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }
    
    public void insertarDatos() {
        
        try {
            String SQL = "INSERT INTO querico.ordenes (ot,solicitante,fecha,sector,detalle,prioridad,estado)VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1, TxtOt.getText());
            pst.setString(2, LblNombreP.getText());
            pst.setString(3, TxtFecha.getText());
            int seleccionado1 = JCSector.getSelectedIndex();            
            pst.setString(4, JCSector.getItemAt(seleccionado1));
            pst.setString(5, TxtDetalle.getText());
            int seleccionado = JCPrioridad.getSelectedIndex();
            pst.setString(6, JCPrioridad.getItemAt(seleccionado));
           int seleccionado2 = JCEstado.getSelectedIndex();
            pst.setString(7, JCEstado.getItemAt(seleccionado2));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());
            
        }
    }
    
    public void EditarDatos() {
        
        try {
            String SQL = "UPDATE querico.ordenes SET solicitante=?, fecha=?, sector=?, detalle=?, prioridad=?, estado=? WHERE ot=?";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1, LblNombreP.getText());
            pst.setString(2, TxtFecha.getText());
            int seleccionado1 = JCSector.getSelectedIndex();            
            pst.setString(3, JCSector.getItemAt(seleccionado1));
            pst.setString(4, TxtDetalle.getText());
            int seleccionado = JCPrioridad.getSelectedIndex();
            pst.setString(5, JCPrioridad.getItemAt(seleccionado));
            int seleccionado2 = JCEstado.getSelectedIndex();
            pst.setString(6, JCEstado.getItemAt(seleccionado2));
            pst.setString(7, TxtOt.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado con exito. ");
            limpiarCajas();
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());
            
        }
        
    }
    
          public void EliminarRegistros1() { //metodo corto para eliminar y funciona
        try {
            
            String SQL = " delete from querico.ordenesp where ot= ?";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1, TxtOt.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito. ");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());
            
        }
    }
              public void EliminarRegistros() { //metodo corto para eliminar y funciona
        try {
            
            String SQL = " delete from querico.ordenes where ot= ?";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1, TxtOt.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito. ");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());
            
        }
    }

    
    public void codigos() {
        // Metodo para generar codigos automanticamente desde la clase GenerarCodigos     
        int j;
        int cont = 1;
        String num = "";
//        String c="";
        String SQL = "select max(ot) from querico.ordenes";
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
                TxtOt.setText("00001");
            }
            
            j = Integer.parseInt(num);
            GenerarCodigos gen = new GenerarCodigos();
            gen.generar(j);
            TxtOt.setText(0000 + gen.serie());
            
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Produccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpiarCajas() {
        TxtOt.setText("");
        LblNombreP.setText("");
        JCSector.setSelectedItem(null);
        TxtDetalle.setText("");
        JCPrioridad.setSelectedItem(null);
        JCEstado.setSelectedItem(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        LblNombreP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtOt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JCPrioridad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BtnEnviar = new javax.swing.JButton();
        BtnEdicion = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtDetalle = new javax.swing.JTextArea();
        JCSector = new javax.swing.JComboBox<>();
        BtnVer = new javax.swing.JButton();
        JCEstado = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTOt = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTOtt = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TxtBuscar1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        TxtBuscar2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jCheckCerrradas = new javax.swing.JCheckBox();
        jCheckProceso = new javax.swing.JCheckBox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Solicitud de Trabajo: ");

        jButton1.setText("Nueva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Solicitante: ");

        LblNombreP.setBackground(new java.awt.Color(255, 255, 255));
        LblNombreP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LblNombreP.setForeground(new java.awt.Color(204, 0, 0));
        LblNombreP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Numero:");

        TxtOt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtOtActionPerformed(evt);
            }
        });

        jLabel3.setText("Sector :");

        TxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha :");

        jLabel7.setText("Prioridad :");

        JCPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Intermedia", "Alta" }));

        jLabel5.setText("Detalle Trabajo:");

        jLabel6.setText("Estado:");

        BtnEnviar.setText("Enviar");
        BtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarActionPerformed(evt);
            }
        });

        BtnEdicion.setText("Edicion");
        BtnEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEdicionActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        TxtDetalle.setColumns(20);
        TxtDetalle.setRows(5);
        jScrollPane5.setViewportView(TxtDetalle);

        JCSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Playa", "Desplume", "Evicerado", "Chiller", "Empaque", "Tunel Paletizado", "Trozado", "Otros" }));

        BtnVer.setText("Ver");
        BtnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerActionPerformed(evt);
            }
        });

        JCEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solicitada", "Tratamiento" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LblNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(TxtOt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(JCPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane5))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(BtnVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JCSector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JCEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(BtnEnviar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEdicion)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnLimpiar)
                            .addComponent(BtnVer)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jButton1))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(LblNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(JCSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(TxtOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JCPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(JCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        JTOt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTOt.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTOt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTOtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTOt);

        JTOtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTOtt.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTOtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTOttMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTOtt);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setForeground(new java.awt.Color(0, 102, 102));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SOLICITUD DE TRABAJOS: ");

        TxtBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscar1KeyReleased(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("MOSTRAR ORDENES SOLICITADAS");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setForeground(new java.awt.Color(0, 102, 102));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TRABAJOS EN PROCESO:");

        TxtBuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscar2KeyReleased(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        jCheckCerrradas.setForeground(new java.awt.Color(255, 255, 255));
        jCheckCerrradas.setText("MOSTRAR CERRADAS");
        jCheckCerrradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCerrradasActionPerformed(evt);
            }
        });

        jCheckProceso.setForeground(new java.awt.Color(255, 255, 255));
        jCheckProceso.setText("MOSTRAR EN PROCESO");
        jCheckProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckProcesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jCheckProceso)
                .addGap(30, 30, 30)
                .addComponent(jCheckCerrradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckCerrradas)
                        .addComponent(jCheckProceso)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        etiqueta();
        codigos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtOtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtOtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtOtActionPerformed

    private void TxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaActionPerformed

    private void BtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarActionPerformed
        insertarDatos();
        mostrarDatos();
    }//GEN-LAST:event_BtnEnviarActionPerformed

    private void BtnEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEdicionActionPerformed
        EditarDatos();
        mostrarDatos();
    }//GEN-LAST:event_BtnEdicionActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if (TxtOt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un campo a eliminar.");

        } else {
            String opcion[] = {"Eliminar", "Cancelar"};

            int eleccion = JOptionPane.showOptionDialog(this, "Esta seguro de eliminar el registro para siempre?. ", "ATENCION!!!", 0, 0, null, opcion, evt);
            if (eleccion == JOptionPane.YES_OPTION) {
                EliminarRegistros();
                EliminarRegistros1();

            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.out.println("Eliminacion cancelada!");

            }
            mostrarDatos();
            mostrarDatos1();
            limpiarCajas();

        }

    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        limpiarCajas();
        mostrarDatos();
        mostrarDatos1();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void JTOttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTOttMouseClicked
       
    }//GEN-LAST:event_JTOttMouseClicked

    private void JTOtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTOtMouseClicked
       int filaSeleccionada = JTOtt.rowAtPoint(evt.getPoint());
        TxtOt.setText(JTOtt.getValueAt(filaSeleccionada, 0).toString());
        LblNombreP.setText(JTOtt.getValueAt(filaSeleccionada, 1).toString());
        TxtFecha.setText(JTOtt.getValueAt(filaSeleccionada, 2).toString());
       JCSector.setSelectedItem(JTOtt.getValueAt(filaSeleccionada, 3).toString());        
        TxtDetalle.setText(JTOtt.getValueAt(filaSeleccionada, 4).toString());
        JCPrioridad.setSelectedItem(JTOtt.getValueAt(filaSeleccionada, 5).toString());
        JCEstado.setSelectedItem(JTOtt.getValueAt(filaSeleccionada, 6).toString());  
        
           
      
    
       
    }//GEN-LAST:event_JTOtMouseClicked

    private void TxtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscar1KeyReleased
        FiltrarDatos(TxtBuscar1.getText());
    }//GEN-LAST:event_TxtBuscar1KeyReleased

    private void TxtBuscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscar2KeyReleased
        Filtro1(TxtBuscar2.getText());

    }//GEN-LAST:event_TxtBuscar2KeyReleased

    private void BtnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerActionPerformed
         VerOt ven = new VerOt();
        ven.setVisible(true);

        String ot ="";
        String solicitante = "", fecha = "", sector = "", detalle = "", prioridad = "", estados = "", f_inicio = "", sector_def = "", materiales = "", obs_resp = "", estado = "", f_cierre = "";
        int filaseleccionada = JTOtt.getSelectedRow();

        if (filaseleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Favor de selecciona una fila de la tabla Trabajos en proceso");

        } else {
            ot = (String) JTOtt.getValueAt(filaseleccionada, 0);
            solicitante = (String) JTOtt.getValueAt(filaseleccionada, 1);
            fecha = (String) JTOtt.getValueAt(filaseleccionada, 2);
            sector = (String) JTOtt.getValueAt(filaseleccionada, 3);
            detalle = (String) JTOtt.getValueAt(filaseleccionada, 4);
            
            prioridad = (String) JTOtt.getValueAt(filaseleccionada, 5);
            estados = (String) JTOtt.getValueAt(filaseleccionada, 6);
            f_inicio = (String) JTOtt.getValueAt(filaseleccionada,7);
            sector_def = (String) JTOtt.getValueAt(filaseleccionada, 8);
            materiales = (String) JTOtt.getValueAt(filaseleccionada, 9);
            obs_resp = (String) JTOtt.getValueAt(filaseleccionada, 10);
            estado = (String) JTOtt.getValueAt(filaseleccionada, 11);
            f_cierre = (String) JTOtt.getValueAt(filaseleccionada, 12);

            
            VerOt.Txtot.setText(ot);
            VerOt.LblNombreP.setText(solicitante);
            VerOt.TxtFecha1.setText(fecha);
            VerOt.TxtSector.setText(sector);
            VerOt.TxtDetalle.setText(detalle);
            VerOt.TxtPrioridad.setText(prioridad);
            VerOt.TxtObservaciones.setText(estados);
            VerOt.TxtFecha2.setText(f_inicio);
            VerOt.TxtSectorDefinido.setText(sector_def);
            VerOt.TxtMateriales.setText(materiales);
            VerOt.TxtObservacionResp.setText(obs_resp);
            VerOt.TxtEstado.setText(estado);
            VerOt.TxtFecha3.setText(f_cierre);
            

        }
    }//GEN-LAST:event_BtnVerActionPerformed

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
            TrabajoCerrado3();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
        
        }else{
        mostrarDatos();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckProcesoActionPerformed
        if(jCheckProceso.isSelected()){
            jCheckCerrradas.setEnabled(false);
             String consulta = "";
             
             consulta = "SELECT * FROM querico.ordenesp WHERE estado='Proceso'";
             String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado Solicitud", "Inicio", "Tipo Trabajo", "Materiales", "Obs Responsable", "Estado", "Cierre"};
            String[] registros = new String[13];

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
                registros[6] = rs.getString("estados");
                registros[7] = rs.getString("f_inicio");
                registros[8] = rs.getString("sector_def");
                registros[9] = rs.getString("materiales");
                registros[10] = rs.getString("obs_resp");
                registros[11] = rs.getString("estado");
                registros[12] = rs.getString("f_cierre");
                modelo.addRow(registros);

            }
            JTOtt.setModel(modelo);
            TrabajoCerrado1();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
        
        }else{
        mostrarDatos1();
        jCheckCerrradas.setEnabled(true);
        
        }
    }//GEN-LAST:event_jCheckProcesoActionPerformed

    private void jCheckCerrradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCerrradasActionPerformed
         if(jCheckCerrradas.isSelected()){
             jCheckProceso.setEnabled(false);
        
             String consulta = "";
             
             consulta = "SELECT * FROM querico.ordenesp WHERE estado='Cerrado'";
             String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado Solicitud", "Inicio", "Tipo Trabajo", "Materiales", "Obs Responsable", "Estado", "Cierre"};
            String[] registros = new String[13];

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
                registros[6] = rs.getString("estados");
                registros[7] = rs.getString("f_inicio");
                registros[8] = rs.getString("sector_def");
                registros[9] = rs.getString("materiales");
                registros[10] = rs.getString("obs_resp");
                registros[11] = rs.getString("estado");
                registros[12] = rs.getString("f_cierre");
                modelo.addRow(registros);

            }
            JTOtt.setModel(modelo);
            TrabajoCerrado1();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
        
        }else{
        mostrarDatos1();
        jCheckProceso.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckCerrradasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEdicion;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnEnviar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnVer;
    private javax.swing.JComboBox<String> JCEstado;
    private javax.swing.JComboBox<String> JCPrioridad;
    private javax.swing.JComboBox<String> JCSector;
    private javax.swing.JTable JTOt;
    private javax.swing.JTable JTOtt;
    private javax.swing.JLabel LblNombreP;
    private javax.swing.JTextField TxtBuscar1;
    private javax.swing.JTextField TxtBuscar2;
    private javax.swing.JTextArea TxtDetalle;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtOt;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckCerrradas;
    private javax.swing.JCheckBox jCheckProceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
