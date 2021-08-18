/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

import static Fomularios.IngresoMatTabla.JTPañol;
import static Fomularios.TratamientoOT.JTOt;
import Metodos.ColorearFilas;
import Metodos.ConexionBD;
import Metodos.MetodosSql;

import Metodos.ViajeCerrado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
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
public class Panel_Manteniento extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Manteniento
     */
    public Panel_Manteniento() {
        initComponents();
        Block();
        mostrarDatos();
       
        TxtMateriales.setEnabled(false);
        TrabajoCerrado1();
       
       
    }
    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    public void TrabajoCerrado1() {

        JTOtt.getColumnModel().getColumn(11).setCellRenderer(new ViajeCerrado());

    }
   

   

    

  
    

    public void mostrarDatos() {
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

    public void insertarDatos() {

        try {
            String SQL = "INSERT INTO querico.ordenesp (ot,solicitante,fecha,sector,detalle,prioridad,estados,f_inicio,sector_def,materiales,obs_resp,estado,f_cierre)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtOt.getText());
            pst.setString(2, LblNombreP.getText());
            pst.setString(3, TxtFecha.getText());
            pst.setString(4, TxtSector.getText());
            pst.setString(5, TxtDetalle.getText());
            pst.setString(6, TxtPrioridad.getText());
            int seleccionado2 = JCEstados.getSelectedIndex();
            pst.setString(7, JCEstados.getItemAt(seleccionado2));
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yy");
            String date = formatofecha.format(JDFinicio.getDate());
            String date1 = formatofecha.format(JDFcierre.getDate());
            pst.setString(8, date);
             int seleccionado1 = JCTipo.getSelectedIndex();
            pst.setString(9, JCTipo.getItemAt(seleccionado1));
            pst.setString(10, TxtMateriales.getText());
            pst.setString(11, TxtObservacionResp.getText());
            int seleccionado = JCEstado.getSelectedIndex();
            pst.setString(12, JCEstado.getItemAt(seleccionado));
            pst.setString(13, date1);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());

        }
    }

    public void FiltrarDatos(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"Num OT", "Solicitante", "Fecha", "Sector", "Detalle trabajo", "Prioridad", "Estado Solicitud", "Inicio", "Tipo Trabajo", "Materiales", "Obs Responsable", "Estado", "Cierre"};
        String[] registros = new String[13];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.ordenesp WHERE CONCAT(ot,solicitante,fecha,detalle,prioridad,f_inicio,materiales,estado,f_cierre) LIKE '%" + valor + "%'";

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

    public void EditarDatos() {

        try {
            String SQL = "UPDATE querico.ordenesp SET solicitante=?, fecha=?, sector=?, detalle=?,  prioridad=?, estados=?,f_inicio=?, sector_def=?,materiales=?,obs_resp=?,estado=?,f_cierre=? WHERE ot=?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, LblNombreP.getText());
            pst.setString(2, TxtFecha.getText());
            pst.setString(3, TxtSector.getText());
            pst.setString(4, TxtDetalle.getText());
            pst.setString(5, TxtPrioridad.getText());
             int seleccionado2 = JCEstados.getSelectedIndex();
            pst.setString(6, JCEstados.getItemAt(seleccionado2));
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yy");
            String date = formatofecha.format(JDFinicio.getDate());
            String date1 = formatofecha.format(JDFcierre.getDate());
            pst.setString(7, date);
             int seleccionado1 = JCTipo.getSelectedIndex();
            pst.setString(8, JCTipo.getItemAt(seleccionado1));
            
            pst.setString(9, TxtMateriales.getText());
            pst.setString(10, TxtObservacionResp.getText());
            int seleccionado = JCEstado.getSelectedIndex();
            pst.setString(11, JCEstado.getItemAt(seleccionado));
            pst.setString(12, date1);
            pst.setString(13, TxtOt.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado con exito. ");
//            limpiarCajas();
            mostrarDatos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }
    public void EditarDatos1() {
        
        try {
            String SQL = "UPDATE querico.ordenes SET  estado=? WHERE ot=?";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
//            pst.setString(1, LblNombreP.getText());
//            pst.setString(2, TxtFecha.getText());
//            int seleccionado1 = JCSector.getSelectedIndex();            
//            pst.setString(3, JCSector.getItemAt(seleccionado1));
//            pst.setString(4, TxtDetalle.getText());
//            int seleccionado = JCPrioridad.getSelectedIndex();
//            pst.setString(5, JCPrioridad.getItemAt(seleccionado));
            int seleccionado2 = JCEstados.getSelectedIndex();
            pst.setString(1, JCEstados.getItemAt(seleccionado2));
            pst.setString(2, TxtOt.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado con exito. ");
            
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());
            
        }
        
    }

    public void Block() {
        TxtOt.setEnabled(false);
        TxtFecha.setEnabled(false);
        LblNombreP.setEnabled(false);
        TxtDetalle.setEnabled(false);
       
        TxtPrioridad.setEnabled(false);
        TxtSector.setEnabled(false);

    }

    public void Limpiar() {

        LblNombreP.setText("");
        TxtFecha.setText("");
        TxtSector.setText("");
        TxtDetalle.setText("");
        TxtPrioridad.setText("");
        JCEstados.setSelectedItem(null);

//            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yy");
//            String date = formatofecha.format(JDFinicio.getDate());
//            String date1 = formatofecha.format(JDFcierre.getDate());
        JDFinicio.getDate();
        JDFcierre.getDate();
//            pst.setString(7, date);
        JCTipo.setSelectedItem(null);
        TxtMateriales.setText("");
        TxtObservacionResp.setText("");
        JCEstado.setSelectedItem(null);
//            pst.setString(12, date1);
        TxtOt.setText("");
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
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckCerradas = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTOtt = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LblNombreP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtOt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        TxtSector = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtPrioridad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JDFinicio = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TxtMateriales = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        JCEstado = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        JDFcierre = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtObservacionResp = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TxtDetalle = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        JCTipo = new javax.swing.JComboBox<>();
        BtnGenerar = new javax.swing.JButton();
        JCEstados = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tratamiento de Ordenes de Trabajo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setForeground(new java.awt.Color(0, 102, 102));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ORDEN EN PROCESO");

        TxtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscarActionPerformed(evt);
            }
        });
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("MOSTRAR EN PROCESO");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckCerradas.setForeground(new java.awt.Color(255, 255, 255));
        jCheckCerradas.setText("MOSTRAR CERRADAS");
        jCheckCerradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCerradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckCerradas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)
                        .addComponent(jCheckCerradas)))
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        JTOtt.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTOtt.setFocusable(false);
        JTOtt.setOpaque(false);
        JTOtt.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTOtt.setShowHorizontalLines(false);
        JTOtt.setShowVerticalLines(false);
        JTOtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTOttMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTOtt);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Consultar Ordenes :");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Solicita: ");

        LblNombreP.setBackground(new java.awt.Color(204, 0, 0));

        jLabel3.setText("OT Numero: ");

        TxtOt.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel4.setText("Fecha :");

        TxtFecha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaActionPerformed(evt);
            }
        });

        TxtSector.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel5.setText("Sector :");

        jLabel6.setText("Detalle trabajo :");

        TxtPrioridad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel7.setText("Prioridad :");

        jLabel8.setText("Estado de solicitud: ");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("INICIO DE TAREAS: ");

        jLabel10.setText("Fecha Inicio :");

        jLabel11.setText("Tipo de Trabajo: ");

        jLabel12.setText("Materiales :");

        jLabel14.setText("Obs Resp.");

        JCEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proceso", "Cerrado", "Suspendido", "Otros" }));

        jLabel15.setText("Fecha de cierre:");

        jButton4.setText("Actualizar / Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        TxtObservacionResp.setColumns(20);
        TxtObservacionResp.setRows(5);
        jScrollPane1.setViewportView(TxtObservacionResp);

        jButton2.setText("Editar Estado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Enviar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir Seleccion");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        TxtDetalle.setColumns(20);
        TxtDetalle.setRows(5);
        jScrollPane4.setViewportView(TxtDetalle);

        jLabel18.setText("Estado : ");

        jButton6.setText("Reporte");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        JCTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OT", "MP", "MG", "Otros" }));

        BtnGenerar.setText("Generar nueva");
        BtnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerarActionPerformed(evt);
            }
        });

        JCEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tratamiento", "Solicitada" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JDFcierre, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                        .addComponent(JDFinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnGenerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(TxtOt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(17, 17, 17))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(TxtSector, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LblNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JCEstados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addComponent(TxtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addComponent(jButton1))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addComponent(TxtOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5))
                            .addComponent(TxtSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(LblNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(TxtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(JCEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JCTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JDFinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JDFcierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(JCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BtnGenerar)
                                        .addComponent(jButton6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton3)
                                            .addComponent(jButton2)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton4)
                                            .addComponent(jButton5)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TratamientoOT ven = new TratamientoOT();
        ven.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //VALIDACION DE TRABAJO CERRADO PARA QUE NO ME DEJE MODIFICARLO

        DefaultTableModel tm = (DefaultTableModel) JTOtt.getModel();
        String dato = String.valueOf(tm.getValueAt(JTOtt.getSelectedRow(), 11));

        if (dato.equals("Cerrado")) {

            JOptionPane.showMessageDialog(null, "El trabajo esta cerrado no puede modificarlo.");

        } else if (TxtOt.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Seleccione un campo para poder editar.");

        } else {

            EditarDatos();
            EditarDatos1();
            mostrarDatos();

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void EliminarRegistros() { //metodo corto para eliminar y funciona
        try {

            String SQL = " delete from querico.ordenes where ot= ? ";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtOt.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());

        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        insertarDatos();
        EditarDatos1();
    
        
        mostrarDatos();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JTOttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTOttMouseClicked
        int filaSeleccionada = JTOtt.rowAtPoint(evt.getPoint());
        TxtOt.setText(JTOtt.getValueAt(filaSeleccionada, 0).toString());
        LblNombreP.setText(JTOtt.getValueAt(filaSeleccionada, 1).toString());
        TxtFecha.setText(JTOtt.getValueAt(filaSeleccionada, 2).toString());
        TxtSector.setText(JTOtt.getValueAt(filaSeleccionada, 3).toString());
        TxtDetalle.setText(JTOtt.getValueAt(filaSeleccionada, 4).toString());
        TxtPrioridad.setText(JTOtt.getValueAt(filaSeleccionada, 5).toString());
        JCEstados.setSelectedItem(JTOtt.getValueAt(filaSeleccionada, 6).toString());
        Date formatofecha;
        try {
            formatofecha = new SimpleDateFormat("dd/MM/yy").parse((String) JTOtt.getValueAt(filaSeleccionada, 7));
            JDFinicio.setDate(formatofecha);

        } catch (ParseException ex) {
            Logger.getLogger(Panel_Manteniento.class.getName()).log(Level.SEVERE, null, ex);
        }
            JCTipo.setSelectedItem(JTOtt.getValueAt(filaSeleccionada, 8).toString());
        TxtMateriales.setText(JTOtt.getValueAt(filaSeleccionada, 9).toString());
        TxtObservacionResp.setText(JTOtt.getValueAt(filaSeleccionada, 10).toString());
            JCEstado.setSelectedItem(JTOtt.getValueAt(filaSeleccionada, 11).toString());
        Date formatofecha1;
        try {
            formatofecha = new SimpleDateFormat("dd/MM/yy").parse((String) JTOtt.getValueAt(filaSeleccionada, 12));
            JDFcierre.setDate(formatofecha);
        } catch (ParseException ex) {
            Logger.getLogger(Panel_Manteniento.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_JTOttMouseClicked

    private void TxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarActionPerformed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        FiltrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Limpiar();
        mostrarDatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        VerOt ven = new VerOt();
        ven.setVisible(true);

        String ot ="";
        String solicitante = "", fecha = "", sector = "", detalle = "", prioridad = "", observaciones = "", f_inicio = "", sector_def = "", materiales = "", obs_resp = "", estado = "", f_cierre = "";
        int filaseleccionada = JTOtt.getSelectedRow();

        if (filaseleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Favor de selecciona una fila de la tabla");

        } else {
            ot = (String) JTOtt.getValueAt(filaseleccionada, 0);
            solicitante = (String) JTOtt.getValueAt(filaseleccionada, 1);
            fecha = (String) JTOtt.getValueAt(filaseleccionada, 2);
            sector = (String) JTOtt.getValueAt(filaseleccionada, 3);
            detalle = (String) JTOtt.getValueAt(filaseleccionada, 4);
            
            prioridad = (String) JTOtt.getValueAt(filaseleccionada, 5);
            observaciones = (String) JTOtt.getValueAt(filaseleccionada, 6);
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
            VerOt.TxtObservaciones.setText(observaciones);
            VerOt.TxtFecha2.setText(f_inicio);
            VerOt.TxtSectorDefinido.setText(sector_def);
            VerOt.TxtMateriales.setText(materiales);
            VerOt.TxtObservacionResp.setText(obs_resp);
            VerOt.TxtEstado.setText(estado);
            VerOt.TxtFecha3.setText(f_cierre);
            

        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      ReporteOt ven = new ReporteOt();
      ven.setVisible(true);
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BtnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerarActionPerformed
        GenerarOD ventana = new GenerarOD();
        ventana.setVisible(true);
        
    }//GEN-LAST:event_BtnGenerarActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
         if(jCheckBox1.isSelected()){
             jCheckCerradas.setEnabled(false);
        
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
        mostrarDatos();
        jCheckCerradas.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckCerradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCerradasActionPerformed
        if(jCheckCerradas.isSelected()){
            jCheckBox1.setEnabled(false);

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
            mostrarDatos();
            jCheckBox1.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckCerradasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGenerar;
    public static javax.swing.JComboBox<String> JCEstado;
    public static javax.swing.JComboBox<String> JCEstados;
    public static javax.swing.JComboBox<String> JCTipo;
    public static com.toedter.calendar.JDateChooser JDFcierre;
    public static com.toedter.calendar.JDateChooser JDFinicio;
    private javax.swing.JTable JTOtt;
    public static javax.swing.JLabel LblNombreP;
    private javax.swing.JTextField TxtBuscar;
    public static javax.swing.JTextArea TxtDetalle;
    public static javax.swing.JTextField TxtFecha;
    public static javax.swing.JTextField TxtMateriales;
    public static javax.swing.JTextArea TxtObservacionResp;
    public static javax.swing.JTextField TxtOt;
    public static javax.swing.JTextField TxtPrioridad;
    public static javax.swing.JTextField TxtSector;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckCerradas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
