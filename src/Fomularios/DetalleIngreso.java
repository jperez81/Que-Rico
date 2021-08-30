
package Fomularios;

import Metodos.ConexionBD;
import Metodos.MetodosSql;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.*;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author José Pérez
 */
public class DetalleIngreso extends javax.swing.JFrame {

    /**
     * Creates new form DetalleIngreso
     */
    public DetalleIngreso() {
        initComponents();
        mostrarDatos();
        setLocationRelativeTo(null);


    }

//    public void icon_Formulario() {
//        //aca debemos importar la imagen de nuestra libreria 
//
//        URL url = getClass().getResource("/imagenes/logoico.png");
//        //Instanciamos ... 
//        ImageIcon icon_Formulario = new ImageIcon(url);
//        setIconImage(icon_Formulario.getImage());
//    }
    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"Hoja de Ing.", "Cod Mat", "Recibido por", "fecha ingreso", "Producto", "Medida", "Marca", "cantidad"};
        String[] registros = new String[8];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.detalleing";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("hoja");
                registros[1] = rs.getString("cod");
                registros[2] = rs.getString("recibido");
                registros[3] = rs.getString("fecha");
                registros[4] = rs.getString("producto");
                registros[5] = rs.getString("medida");
                registros[6] = rs.getString("marca");
                registros[7] = rs.getString("cantidad");

                modelo.addRow(registros);

            }
            JTDetalleIng.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }

    public void FiltrarDatos(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"Hoja de Ing.", "Cod Mat", "Recibido por", "fecha ingreso", "Producto", "Medida", "Marca", "cantidad"};
        String[] registros = new String[8];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.detalleing WHERE CONCAT(hoja,cod, recibido,fecha,producto,marca,cantidad) LIKE '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("hoja");
                registros[1] = rs.getString("cod");
                registros[2] = rs.getString("recibido");
                registros[3] = rs.getString("fecha");
                registros[4] = rs.getString("producto");
                registros[5] = rs.getString("medida");
                registros[6] = rs.getString("marca");
                registros[7] = rs.getString("cantidad");

                modelo.addRow(registros);

            }
            JTDetalleIng.setModel(modelo);

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTDetalleIng = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        RDHoja = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        TxtHoja = new javax.swing.JTextField();
        BtnBuscar1 = new javax.swing.JButton();
        BtnLimpiar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        RDFechas = new javax.swing.JRadioButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        BtnBuscar2 = new javax.swing.JButton();
        BtnLimpiar2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Materiales entrantes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JTDetalleIng.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTDetalleIng.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(JTDetalleIng);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DETALLE DE INGRESO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RDHoja.setText("Mostrar por Hoja:");
        RDHoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDHojaActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        TxtHoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtHojaActionPerformed(evt);
            }
        });

        BtnBuscar1.setText("Buscar");
        BtnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar1ActionPerformed(evt);
            }
        });

        BtnLimpiar1.setText("Limpiar");
        BtnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RDHoja)
                .addGap(47, 47, 47)
                .addComponent(TxtHoja, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RDHoja)
                        .addComponent(TxtHoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscar1)
                    .addComponent(BtnLimpiar1))
                .addGap(17, 17, 17))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RDFechas.setText("Mostrar por fechas: ");
        RDFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDFechasActionPerformed(evt);
            }
        });

        jLabel2.setText("DESDE:");

        jLabel3.setText("HASTA:");

        BtnBuscar2.setText("Buscar");
        BtnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar2ActionPerformed(evt);
            }
        });

        BtnLimpiar2.setText("Limpiar");
        BtnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiar2ActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(RDFechas)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RDFechas)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscar2)
                    .addComponent(BtnLimpiar2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton3.setText("Reporte Hoja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Reporte Fechas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiar1ActionPerformed
    TxtHoja.setText("");
    mostrarDatos();
    }//GEN-LAST:event_BtnLimpiar1ActionPerformed


    private void RDHojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDHojaActionPerformed
        if (RDHoja.isSelected() == true) {
            TxtHoja.setEnabled(true);
            TxtHoja.requestFocus();
            BtnBuscar1.setEnabled(true);
            BtnLimpiar1.setEnabled(true);

            jDateChooser2.setEnabled(false);
            jDateChooser2.setDate(null);
            jDateChooser1.setEnabled(false);
            jDateChooser1.setDate(null);
            RDFechas.setEnabled(false);
            BtnBuscar2.setEnabled(false);
            BtnLimpiar2.setEnabled(false);

        } else {
            jDateChooser2.setEnabled(true);
            jDateChooser2.setDate(null);
            jDateChooser1.setEnabled(true);
            jDateChooser1.setDate(null);
            RDFechas.setEnabled(true);
            BtnBuscar2.setEnabled(true);
            BtnLimpiar2.setEnabled(true);

        }
    }//GEN-LAST:event_RDHojaActionPerformed

    private void BtnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscar1ActionPerformed
        String hoja = TxtHoja.getText();

        String consulta = "";
        if (RDHoja.isSelected() == true) {

            consulta = "SELECT * FROM querico.detalleing WHERE hoja='" + hoja + "'";

            String[] titulos = {"Hoja de Ing.", "Cod Mat", "Recibido por", "fecha ingreso", "Producto", "Medida", "Marca", "cantidad"};
            String[] registros = new String[8];
            DefaultTableModel tabla = new DefaultTableModel(null, titulos);

            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(consulta);

                while (rs.next()) {

                    registros[0] = rs.getString("hoja");
                    registros[1] = rs.getString("cod");
                    registros[2] = rs.getString("recibido");
                    registros[3] = rs.getString("fecha");
                    registros[4] = rs.getString("producto");
                    registros[5] = rs.getString("medida");
                    registros[6] = rs.getString("marca");
                    registros[7] = rs.getString("cantidad");

                    tabla.addRow(registros);

                }
                JTDetalleIng.setModel(tabla);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Error!... llene todos los campos.");
        }


    }//GEN-LAST:event_BtnBuscar1ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            String path = "C:\\NetBeansProjects\\QueRico\\src\\Reportes\\R_EntradaHoja.jasper";

            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map parametro = new HashMap();

            parametro.put("hoja", TxtHoja.getText());

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, con);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DetalleIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            String path = "C:\\NetBeansProjects\\QueRico\\src\\Reportes\\R_EntradaFecha.jasper";

            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map parametros = new HashMap();

            Date fecha1 = jDateChooser1.getDate();
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");

            String fec1 = "" + formatofecha.format(fecha1);

            Date fecha2 = jDateChooser2.getDate();
            SimpleDateFormat formatofecha2 = new SimpleDateFormat("dd/MM/yyyy");
            String fec2 = "" + formatofecha2.format(fecha2);

            parametros.put("f_ini", fec1);
            parametros.put("f_fin", fec2);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DetalleIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void RDFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDFechasActionPerformed
        if (RDFechas.isSelected() == true) {
            jDateChooser1.setEnabled(true);
            jDateChooser2.setEnabled(true);
            BtnBuscar2.setEnabled(true);
            BtnLimpiar2.setEnabled(true);

            TxtHoja.setEnabled(false);
            TxtHoja.setText("");
            BtnBuscar1.setEnabled(false);
            BtnLimpiar1.setEnabled(false);
            RDHoja.setEnabled(false);

        } else {

            TxtHoja.setEnabled(true);
            TxtHoja.setText("");
            BtnBuscar1.setEnabled(true);
            BtnLimpiar1.setEnabled(true);
            RDHoja.setEnabled(true);

        }
    }//GEN-LAST:event_RDFechasActionPerformed

    private void BtnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscar2ActionPerformed
        String consulta = "";
        if (RDFechas.isSelected() == true) {

            Date fecha1 = jDateChooser1.getDate();
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
            String fec1 = "" + formatofecha.format(fecha1);

            Date fecha2 = jDateChooser2.getDate();
            SimpleDateFormat formatofecha2 = new SimpleDateFormat("dd/MM/yyyy");
            String fec2 = "" + formatofecha2.format(fecha2);

            consulta = "SELECT * FROM querico.detalleing WHERE fecha BETWEEN '" + fec1 + "' AND '" + fec2 + "'";

            String[] titulos = {"Hoja de Ing.", "Cod Mat", "Recibido por", "fecha ingreso", "Producto", "Medida", "Marca", "cantidad"};
            String[] registros = new String[8];
            DefaultTableModel tabla = new DefaultTableModel(null, titulos);

            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(consulta);

                while (rs.next()) {

                    registros[0] = rs.getString("hoja");
                    registros[1] = rs.getString("cod");
                    registros[2] = rs.getString("recibido");
                    registros[3] = rs.getString("fecha");
                    registros[4] = rs.getString("producto");
                    registros[5] = rs.getString("medida");
                    registros[6] = rs.getString("marca");
                    registros[7] = rs.getString("cantidad");

                    tabla.addRow(registros);

                }
                JTDetalleIng.setModel(tabla);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error!... llene todos los campos");

        }
    }//GEN-LAST:event_BtnBuscar2ActionPerformed

    private void BtnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiar2ActionPerformed
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        mostrarDatos();
    }//GEN-LAST:event_BtnLimpiar2ActionPerformed

    private void TxtHojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtHojaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtHojaActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar1;
    private javax.swing.JButton BtnBuscar2;
    private javax.swing.JButton BtnLimpiar1;
    private javax.swing.JButton BtnLimpiar2;
    private javax.swing.JTable JTDetalleIng;
    private javax.swing.JRadioButton RDFechas;
    private javax.swing.JRadioButton RDHoja;
    private javax.swing.JTextField TxtHoja;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
