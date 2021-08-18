/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

import static Fomularios.NuevaOrden.fechaact;
import static Fomularios.NuevoIngreso.LblNombreP;
import Metodos.ConexionBD;
import Metodos.GenerarCodigos;
import Metodos.MetodosSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Pérez
 */
public class PFaena extends javax.swing.JPanel {

        
    public PFaena() {
        initComponents();
        mostrarDatos();
        TxtFecha.setText(fechaact());
        TxtId.setEnabled(false);
        LblNombreF.setEnabled(false);
        

    }

    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatofecha.format(fecha);

    }

    public void etiqueta1() {
        //Este metodo sirve para capturar etiquetas de otro frame y mostrarla
        String x;
        x = Portal.LblNombreP.getText();
        LblNombreF.setText(x);
    }

    public void FiltrarDatos(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"ID", "Fecha", "Sector", "Horario", "Motivo", "Reinicio", "Responsable", "Estado"};
        String[] registros = new String[8];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.pfaena WHERE CONCAT(id,fecha,sector,estado) LIKE '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("sector");
                registros[3] = rs.getString("horario");
                registros[4] = rs.getString("motivo");
                registros[5] = rs.getString("reinicio");
                registros[6] = rs.getString("responsable");
                registros[7] = rs.getString("estado");

                modelo.addRow(registros);

            }
            JTPFaena.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }

    public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"ID", "Fecha", "Sector", "Horario", "Motivo", "Reinicio", "Responsable", "Estado"};
        String[] registros = new String[8];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.pfaena";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("sector");
                registros[3] = rs.getString("horario");
                registros[4] = rs.getString("motivo");
                registros[5] = rs.getString("reinicio");
                registros[6] = rs.getString("responsable");
                registros[7] = rs.getString("estado");

                modelo.addRow(registros);

            }
            JTPFaena.setModel(modelo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }

    public void EditarDatos() {

        try {
            String SQL = "UPDATE querico.pfaena SET fecha=?, sector=?, horario=?, motivo=?, reinicio=?, responsable=?, estado=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtFecha.getText());
            int seleccionado1 = JCSector.getSelectedIndex();
            pst.setString(2, JCSector.getItemAt(seleccionado1));
            pst.setString(3, TxtHoraInicio.getText());
            pst.setString(4, TxtMotivo.getText());
            pst.setString(5, TxtHoraFin.getText());
            pst.setString(6, LblNombreF.getText());
            int seleccionado = JCEstado.getSelectedIndex();
            pst.setString(7, JCEstado.getItemAt(seleccionado));

            pst.setString(8, TxtId.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado con exito. ");
            Limpiar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }

    public void EliminarRegistros() { //metodo corto para eliminar y funciona
        try {

            String SQL = " delete from querico.pfaena where id= ?";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtId.getText());

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
        String SQL = "select max(id) from querico.pfaena";
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
                TxtId.setText("00001");
            }

            j = Integer.parseInt(num);
            GenerarCodigos gen = new GenerarCodigos();
            gen.generar(j);
            TxtId.setText(0000 + gen.serie());

        } catch (SQLException ex) {
            Logger.getLogger(PFaena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarDatos() {

        try {
            String SQL = "INSERT INTO querico.pfaena (id,fecha,sector,horario,motivo,reinicio,responsable,estado)VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
             String x;
        x = Portal.LblNombreP.getText();
      LblNombreF.setText(x);
            
            pst.setString(1, TxtId.getText());
            pst.setString(2, TxtFecha.getText());
            int seleccionado1 = JCSector.getSelectedIndex();
            pst.setString(3, JCSector.getItemAt(seleccionado1));
            pst.setString(4, TxtHoraInicio.getText());
            pst.setString(5, TxtMotivo.getText());
            pst.setString(6, TxtHoraFin.getText());
            pst.setString(7, LblNombreF.getText());
            int seleccionado = JCEstado.getSelectedIndex();
            pst.setString(8, JCEstado.getItemAt(seleccionado));

            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtMotivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        LblNombreF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JCEstado = new javax.swing.JComboBox<>();
        JCSector = new javax.swing.JComboBox<>();
        TxtHoraInicio = new javax.swing.JFormattedTextField();
        TxtHoraFin = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        TxtBuscar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTPFaena = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("ID :");

        TxtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdActionPerformed(evt);
            }
        });

        jLabel3.setText("Sector: ");

        jLabel4.setText("Horario:");

        jLabel5.setText("Motivos: ");

        jLabel6.setText("Horario de reinicio:");

        TxtMotivo.setColumns(20);
        TxtMotivo.setRows(5);
        jScrollPane1.setViewportView(TxtMotivo);

        jLabel7.setText("Responsable:");

        LblNombreF.setEditable(false);
        LblNombreF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LblNombreFActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado:");

        JCEstado.setEditable(true);
        JCEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio", "Fuera de servicio" }));

        JCSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Playa", "Desplume", "Evicerado", "Chiller", "Empaque", "Tunel Paletizado", "Trozado", "Otros" }));

        try {
            TxtHoraInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TxtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtHoraInicioActionPerformed(evt);
            }
        });

        try {
            TxtHoraFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha:");

        TxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaActionPerformed(evt);
            }
        });

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

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Limpiar / Actualizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Imprimir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtHoraInicio)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCSector, 0, 146, Short.MAX_VALUE)
                                .addGap(132, 132, 132)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LblNombreF, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(TxtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(LblNombreF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(JCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DETENCION FAENA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        JTPFaena.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTPFaena.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTPFaena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPFaenaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTPFaena);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TxtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdActionPerformed

    private void TxtHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtHoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtHoraInicioActionPerformed

    private void LblNombreFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LblNombreFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LblNombreFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        codigos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        insertarDatos();

        mostrarDatos();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void TxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscarActionPerformed

    }//GEN-LAST:event_TxtBuscarActionPerformed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        FiltrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void JTPFaenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPFaenaMouseClicked
        int filaSeleccionada = JTPFaena.rowAtPoint(evt.getPoint());
        TxtId.setText(JTPFaena.getValueAt(filaSeleccionada, 0).toString());
        TxtFecha.setText(JTPFaena.getValueAt(filaSeleccionada, 1).toString());
        JCSector.setSelectedItem(JTPFaena.getValueAt(filaSeleccionada, 2).toString());
        TxtHoraInicio.setText(JTPFaena.getValueAt(filaSeleccionada, 3).toString());
        TxtMotivo.setText(JTPFaena.getValueAt(filaSeleccionada, 4).toString());
        TxtHoraFin.setText(JTPFaena.getValueAt(filaSeleccionada, 5).toString());
        LblNombreF.setText(JTPFaena.getValueAt(filaSeleccionada, 6).toString());
        JCEstado.setSelectedItem(JTPFaena.getValueAt(filaSeleccionada, 7).toString());

    }//GEN-LAST:event_JTPFaenaMouseClicked

    public void Limpiar() {

        TxtBuscar.setText("");
        TxtFecha.setText(fechaact());
        TxtHoraFin.setText("");
        TxtHoraInicio.setText("");
        TxtId.setText("");
        TxtMotivo.setText("");
        LblNombreF.setText("");
        JCSector.setSelectedItem(null);
        JCSector.setSelectedItem(null);

        mostrarDatos();
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        TxtBuscar.setText("");
        TxtFecha.setText(fechaact());
        TxtHoraFin.setText("");
        TxtHoraInicio.setText("");
        TxtId.setText("");
        TxtMotivo.setText("");
        LblNombreF.setText("");
        JCSector.setSelectedItem(null);
        JCEstado.setSelectedItem(null);

        mostrarDatos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EditarDatos();
        mostrarDatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (TxtId.getText().equals("")) {
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
            Limpiar();

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        RangoFechaFaena ven = new RangoFechaFaena();
        ven.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCEstado;
    private javax.swing.JComboBox<String> JCSector;
    private javax.swing.JTable JTPFaena;
    private javax.swing.JTextField LblNombreF;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JFormattedTextField TxtHoraFin;
    private javax.swing.JFormattedTextField TxtHoraInicio;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextArea TxtMotivo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
