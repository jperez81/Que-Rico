/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

import Metodos.ColorearFilas;
import Metodos.ConexionBD;
import Metodos.GenerarCodigos;
import Metodos.MetodosSql;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author José Pérez
 */
public class Panel_Pañol extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Pañol
     */
    public Panel_Pañol() {
        initComponents();
        mostrarDatos();
        bloqueoCajas();
        PocoStock1();
    }
    
    public void PocoStock1(){
    
        JTPañol.getColumnModel().getColumn(8).setCellRenderer(new ColorearFilas());
    
    }

    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    public void limpiarCajas() {
        TxtCod.setText("");
        TxtProducto.setText("");
        TxtMarca.setText("");
        TxtMedida.setText("");
        TxtSerial.setText("");
        JCUnidad.setSelectedItem(null);
        JCEstado.setSelectedItem(null);
        TxtStock.setText("");
        TxtComentario.setText("");

    }

    public void bloqueoCajas() {

        TxtCod.setEditable(false);

    }
    
     public void EliminarRegistros() { //metodo corto para eliminar y funciona
        try {
            String SQL = " delete from querico.pañol where cod= ?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtCod.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());

        }
    }

    public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"Codigo", "Producto", "Marca", "Medida", "Unidad Med.", "Serial", "Estado", "comentario", "Stock"};
        String[] registros = new String[9];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.pañol";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod");
                registros[1] = rs.getString("producto");
                registros[2] = rs.getString("marca");
                registros[3] = rs.getString("medida");
                registros[4] = rs.getString("un");
                registros[5] = rs.getString("serial");
                registros[6] = rs.getString("estado");
                registros[7] = rs.getString("comentario");
                registros[8] = rs.getString("stock");

                modelo.addRow(registros);

            }
            JTPañol.setModel(modelo);
            PocoStock1();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }

    public void codigos() {
        // Metodo para generar codigos automanticamente desde la clase GenerarCodigos     
        int j;
        int cont = 1;
        String num = "";
//        String c="";
        String SQL = "select max(cod) from querico.pañol";
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
                TxtCod.setText("00001");
            }

            j = Integer.parseInt(num);
            GenerarCodigos gen = new GenerarCodigos();
            gen.generar(j);
            TxtCod.setText(0000+gen.serie());

        } catch (SQLException ex) {
            Logger.getLogger(Panel_Pañol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarDatos() {

        try {
            String SQL = "UPDATE querico.pañol SET producto=?, marca=?, medida=?, serial=?,  un=?, estado=?,comentario=?, stock=? WHERE cod=?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtProducto.getText());
            pst.setString(2, TxtMarca.getText());
            pst.setString(3, TxtMedida.getText());//
            int seleccionado = JCUnidad.getSelectedIndex();
            pst.setString(4, JCUnidad.getItemAt(seleccionado));
            pst.setString(5, TxtSerial.getText());
            int seleccionado1 = JCEstado.getSelectedIndex();
            pst.setString(6, JCEstado.getItemAt(seleccionado1));
            pst.setString(7, TxtComentario.getText());
            pst.setString(8, TxtStock.getText());
            pst.setString(9, TxtCod.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado con exito. ");
            limpiarCajas();
            mostrarDatos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }

    public void insertarDatos() {

        try {
            String SQL = "INSERT INTO querico.pañol (cod,producto,marca,medida,un,serial,estado,comentario,stock)VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtCod.getText());
            pst.setString(2, TxtProducto.getText());
            pst.setString(3, TxtMarca.getText());
            pst.setString(4, TxtMedida.getText());
            int seleccionado = JCUnidad.getSelectedIndex();
            pst.setString(5, JCUnidad.getItemAt(seleccionado));
            pst.setString(6, TxtSerial.getText());
            int seleccionado1 = JCEstado.getSelectedIndex();
            pst.setString(7, JCEstado.getItemAt(seleccionado1));
            pst.setString(8, TxtComentario.getText());

            pst.setString(9, TxtStock.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Los datos se guardaron con exito.");

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTPañol = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtCod = new javax.swing.JTextField();
        TxtProducto = new javax.swing.JTextField();
        TxtMarca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtStock = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtComentario = new javax.swing.JTextArea();
        JCEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TxtSerial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JCUnidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        TxtMedida = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        TxtBuscar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo registro de inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Fax", 1, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)), "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane1.setToolTipText("Tabla de inventario");
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        JTPañol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTPañol.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTPañol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPañolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTPañol);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel1.setText("Cod.");

        jLabel2.setText("Producto :");

        jLabel4.setText("Marca :");

        TxtCod.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        TxtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodActionPerformed(evt);
            }
        });

        jLabel9.setText("Stock : ");

        TxtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtStockActionPerformed(evt);
            }
        });

        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Borrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Observacion:");

        TxtComentario.setColumns(20);
        TxtComentario.setRows(5);
        TxtComentario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        TxtComentario.setSelectionColor(new java.awt.Color(0, 102, 102));
        jScrollPane3.setViewportView(TxtComentario);

        JCEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado", "Reparado", "Dañado" }));

        jLabel7.setText("Estado : ");

        TxtSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSerialActionPerformed(evt);
            }
        });

        jLabel5.setText("Serial N.:");

        jLabel6.setText("Unidad Med. :");

        JCUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNIDAD", "METROS", "V", "KW", "AMP", "W", "JOULE", "EJE", "DIAMETRO", "MT", "CENTIMETRO", "PULGADA", "CALORIAS", "FRIGORIAS", "CIRCUNF.", "TORQUE", "M°3", "M°2", "CM°3", "CM°2", "MM", "MM°3", "MM°2", "VELOCIDAD", "CARGA", "KILO", "GRAMO", "LITRO", "OHMS", "KOHMS", "OTROS", " " }));

        jLabel3.setText("Medida:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TxtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE))
                            .addComponent(TxtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jButton4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)
                                .addComponent(jLabel8)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(JCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JCUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(TxtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

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

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Entrada de Material");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Actualizar Registros");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Salida de Material");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(19, 19, 19)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        codigos();
    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(TxtProducto.getText().isEmpty() || TxtStock.getText().isEmpty() || TxtMedida.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(null, "Favor de rellenar todos los campos.");
        
        }else{
        insertarDatos();
        mostrarDatos();
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (TxtCod.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Seleccione un campo para poder editar.");

        } else {

            EditarDatos();
            mostrarDatos();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public void FiltrarDatos(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"Codigo", "Producto", "Marca", "Medida", "Unidad Med.", "Serial", "Estado", "Comentario", "Stock"};
        String[] registros = new String[9];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.pañol WHERE CONCAT(cod,producto,medida,un,serial,estado) LIKE '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod");
                registros[1] = rs.getString("producto");
                registros[2] = rs.getString("marca");
                registros[3] = rs.getString("medida");
                registros[4] = rs.getString("un");
                registros[5] = rs.getString("serial");
                registros[6] = rs.getString("estado");
                registros[7] = rs.getString("comentario");
                registros[8] = rs.getString("stock");

                modelo.addRow(registros);

            }
            JTPañol.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }
    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked


    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void JTPañolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPañolMouseClicked
        int filaSeleccionada = JTPañol.rowAtPoint(evt.getPoint());
        TxtCod.setText(JTPañol.getValueAt(filaSeleccionada, 0).toString());
        TxtProducto.setText(JTPañol.getValueAt(filaSeleccionada, 1).toString());
        TxtMarca.setText(JTPañol.getValueAt(filaSeleccionada, 2).toString());
        TxtMedida.setText(JTPañol.getValueAt(filaSeleccionada, 3).toString());
        JCUnidad.setSelectedItem(JTPañol.getValueAt(filaSeleccionada, 4).toString());
        TxtSerial.setText(JTPañol.getValueAt(filaSeleccionada, 5).toString());
        JCEstado.setSelectedItem(JTPañol.getValueAt(filaSeleccionada, 6).toString());
        TxtComentario.setText(JTPañol.getValueAt(filaSeleccionada, 7).toString());
        TxtStock.setText(JTPañol.getValueAt(filaSeleccionada, 8).toString());
    }//GEN-LAST:event_JTPañolMouseClicked

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        FiltrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        mostrarDatos();
        limpiarCajas();


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        NuevoIngreso ventana = new NuevoIngreso();
        ventana.setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        NuevoEgreso ven = new NuevoEgreso();
        ven.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void TxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarActionPerformed

    private void TxtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtStockActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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


                                     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TxtSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSerialActionPerformed

    private void TxtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCodActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCEstado;
    private javax.swing.JComboBox<String> JCUnidad;
    private javax.swing.JTable JTPañol;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtCod;
    private javax.swing.JTextArea TxtComentario;
    private javax.swing.JTextField TxtMarca;
    private javax.swing.JTextField TxtMedida;
    private javax.swing.JTextField TxtProducto;
    private javax.swing.JTextField TxtSerial;
    private javax.swing.JTextField TxtStock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
