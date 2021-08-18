/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

import Metodos.ColorRemio2;
import Metodos.ConexionBD;
import Metodos.GenerarCodigos;
import Metodos.MetodosSql;
import java.awt.PageAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author José Pérez
 */
public class PlanillaControl extends javax.swing.JPanel {

    /**
     * Creates new form PlanillaControl
     */
    public PlanillaControl() {
        initComponents();
        mostrarDatos();
        mostrarDatos2();
        mostrarDatos3();
        mostrarDatos4();
        TxtFecha3.setText(fechaact());
        TxtFecha.setText(fechaact());
        TxtFecha1.setText(fechaact());
        TxtFechas3.setText(fechaact());

        TxtPromedio.setEnabled(false);
        TxtPNeto.setEnabled(false);
        TxtPNeto1.setEnabled(false);
        TxtPIngreso1.setEnabled(false);
        TxtPromedio1.setEnabled(false);
        TxtID.setEnabled(false);
        TxtId1.setEnabled(false);
        TxtPNSalida.setEnabled(false);
        TxtPNEntrada.setEnabled(false);
        TxtId3.setEnabled(false);
        TxtTKilos.setVisible(true);
        TxtTPollos.setVisible(true);
        TxtTMuertos.setVisible(true);
        TxtTPromedio.setVisible(true);
        TxtBuscarF.setText(fechaact());
        TxtBuscarF1.setText(fechaact());
        LblNombreX.setEnabled(false);

        FiltrarDatos1(TxtBuscarF1.getText());
        FiltrarDatos(TxtBuscarF.getText());

        Orden();
        OrdenReporte();

    }

    public void Orden() {

        JTRemito2.getColumnModel().getColumn(19).setCellRenderer(new ColorRemio2());

    }

    public void OrdenReporte() {

        JTReporte.getColumnModel().getColumn(11).setCellRenderer(new ColorRemio2());

    }
    MetodosSql Met = new MetodosSql();
    ConexionBD cc = new ConexionBD();
    Connection con = ConexionBD.conectar();

    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatofecha.format(fecha);

    }

    public void mostrarDatos() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"ID", "Numero", "Fecha", "Remito", "Patente", "Pollos", "Peso Bruto", "Pesto Tara", "Peso Neto", "Promedio", "Transporte"};
        String[] registros = new String[11];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.remito1";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("remito");
                registros[4] = rs.getString("patentes");
                registros[5] = rs.getString("pollos");
                registros[6] = rs.getString("pesobruto");
                registros[7] = rs.getString("pesotara");
                registros[8] = rs.getString("pesoneto");
                registros[9] = rs.getString("promedio");
                registros[10] = rs.getString("transporte");

                modelo.addRow(registros);

            }
            JTRemito1.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }

    public void mostrarDatos2() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"ID", "Numero", "Remito", "Patente", "Pollos", "P.Bruto", "Tara", "P. Neto", "P. Ingreso", "Fecha", "H. Entrada", "Tipo", "Chofer", "Granja", "Cargador", "Promedio", "Muertos", "Galpon", "Pollos x cajon", "Orden"};
        String[] registros = new String[20];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.remito2";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("remito");
                registros[3] = rs.getString("patente");
                registros[4] = rs.getString("pollos");
                registros[5] = rs.getString("pesobruto");
                registros[6] = rs.getString("tara");
                registros[7] = rs.getString("pesoneto");
                registros[8] = rs.getString("pingreso");
                registros[9] = rs.getString("fecha");
                registros[10] = rs.getString("hentrada");
                registros[11] = rs.getString("tipo");
                registros[12] = rs.getString("chofer");
                registros[13] = rs.getString("granja");
                registros[14] = rs.getString("cargador");
                registros[15] = rs.getString("promedio");
                registros[16] = rs.getString("muertos");
                registros[17] = rs.getString("galpon");
                registros[18] = rs.getString("pcajon");
                registros[19] = rs.getString("orden");

                modelo.addRow(registros);

            }
            JTRemito2.setModel(modelo);
            Orden();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }

    public void mostrarDatos3() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"ID", "Numero", "Fecha", "Remito", "Chofer", "Granja", "Cargador", "Pollos", "Kilos", "Promedio", "Muertos", "Orden"};
        String[] registros = new String[12];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.reporte";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("remito");
                registros[4] = rs.getString("chofer");
                registros[5] = rs.getString("granja");
                registros[6] = rs.getString("cargador");
                registros[7] = rs.getString("pollos");
                registros[8] = rs.getString("kilos");
                registros[9] = rs.getString("promedio");
                registros[10] = rs.getString("muertos");
                registros[11] = rs.getString("Orden");

                modelo.addRow(registros);

            }
            JTReporte.setModel(modelo);
            OrdenReporte();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }

    public void mostrarDatos4() {
        //CON ESTE METODO MOSTRAMOS EL CONTENIDO DE LA TABLA
        String[] titulos = {"ID", "Fecha", "Hora", "Carga", "Patente", "Empresa", "Operador", "Chofer", "Remito", "Tara", "P.B Entrada", "P.N Entrada", "P.B Salida", "P.N Salida"};
        String[] registros = new String[14];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "SELECT * FROM querico.remito3";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("hora");
                registros[3] = rs.getString("carga");
                registros[4] = rs.getString("patente");
                registros[5] = rs.getString("empresa");
                registros[6] = rs.getString("operador");
                registros[7] = rs.getString("chofer");
                registros[8] = rs.getString("remito");
                registros[9] = rs.getString("tara");
                registros[10] = rs.getString("pesobrutoe");
                registros[11] = rs.getString("pesonetoe");
                registros[12] = rs.getString("pesobrutos");
                registros[13] = rs.getString("pesonetos");

                modelo.addRow(registros);

            }
            JTRemito3.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }
    }

    public void insertarDatos4() {

        try {
            String SQL = "INSERT INTO querico.remito3 (id,fecha,hora,carga,patente,empresa,operador,chofer,remito,tara,pesobrutoe,pesonetoe,pesobrutos,pesonetos)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);

            String x;
            x = Portal.LblNombreP.getText();
            LblNombreX.setText(x);

            pst.setString(1, TxtId3.getText());
            pst.setString(2, TxtFechas3.getText());
            pst.setString(3, TxtHora3.getText());
            pst.setString(4, TxtCarga3.getText());
            pst.setString(5, TxtPatente3.getText());
            pst.setString(6, TxtEmpresa3.getText());
            pst.setString(7, LblNombreX.getText());
            pst.setString(8, TxtChofer3.getText());
            pst.setString(9, TxtRemito3.getText());
            pst.setString(10, TxtTara3.getText());
            pst.setString(11, TxtPBEntrada.getText());
            pst.setString(12, TxtPNEntrada.getText());
            pst.setString(13, TxtPBSalida.getText());
            pst.setString(14, TxtPNSalida.getText());

//            int sele = JCOrden.getSelectedIndex();
//            pst.setString(20, JCOrden.getItemAt(sele));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());

        }
    }

//    public void insertarDatos2() {
//
//        try {
//            String SQL = "INSERT INTO querico.remito2 (id,numero,fecha,hentrada,tipo,chofer,remito,patente,granja,cargador,pollos,pesobruto,tara,pesoneto,promedio,muertos,galpon,pingreso,pcajon,orden)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            PreparedStatement pst = con.prepareStatement(SQL);
//
//            pst.setString(1, TxtId1.getText());
//            pst.setString(2, TxtNumero1.getText());
//            pst.setString(3, TxtFecha1.getText());
//            pst.setString(4, TxtHentrada1.getText());
//            int seleccionado1 = JCTipo2.getSelectedIndex();
//            pst.setString(5, JCTipo2.getItemAt(seleccionado1));
//            pst.setString(6, TxtChofer1.getText());
//            pst.setString(7, TxtRemito1.getText());
//            pst.setString(8, TxtPatentes1.getText());
//            pst.setString(9, TxtGranja1.getText());
//            pst.setString(10, TxtCargador1.getText());
//            pst.setString(11, TxtPollos1.getText());
//            pst.setString(12, TxtPBruto1.getText());
//            pst.setString(13, TxtTara1.getText());
//            pst.setString(14, TxtPNeto1.getText());
//            pst.setDouble(15, Double.valueOf(TxtPromedio1.getText()));
//            pst.setString(16, TxtMuertos1.getText());
//            pst.setString(17, TxtGalpon1.getText());
//            pst.setDouble(18, Double.valueOf(TxtPIngreso1.getText()));
//            pst.setString(19, TxtPCajon1.getText());
//            int sele = JCOrden.getSelectedIndex();
//            pst.setString(20, JCOrden.getItemAt(sele));
//
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());
//
//        }
//    }
    public void insertarDatos() {

        try {
            String SQL = "INSERT INTO querico.remito1 (id,numero,fecha,remito,patentes,pollos,pesobruto,pesotara,pesoneto,promedio,transporte)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtID.getText());
            pst.setString(2, TxtNumero.getText());
            pst.setString(3, TxtFecha.getText());
//            int seleccionado1 = JCSector.getSelectedIndex();            
//            pst.setString(3, JCSector.getItemAt(seleccionado1));
            pst.setString(4, TxtRemito.getText());
            pst.setString(5, TxtPatentes.getText());
            pst.setString(6, TxtPollos.getText());
            pst.setString(7, TxtPBruto.getText());
            pst.setString(8, TxtTara.getText());
            pst.setString(9, TxtPNeto.getText());
            pst.setDouble(10, Double.valueOf(TxtPromedio.getText()));
            pst.setString(11, TxtTransporte.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());

        }
    }

    public void codigos() {
        // Metodo para generar codigos automanticamente desde la clase GenerarCodigos     
        int j;
        int cont = 1;
        String num = "";
//        String c="";
        String SQL = "select max(id) from querico.remito1";
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
                TxtID.setText("00001");
            }

            j = Integer.parseInt(num);
            GenerarCodigos gen = new GenerarCodigos();
            gen.generar(j);
            TxtID.setText(0000 + gen.serie());
            FiltrarDatos1(TxtBuscarF1.getText());
        

        } catch (SQLException ex) {
            Logger.getLogger(PFaena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void codigos1() {
        // Metodo para generar codigos automanticamente desde la clase GenerarCodigos     
        int j;
        int cont = 1;
        String num = "";
//        String c="";
        String SQL = "select max(id) from querico.remito2";
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
                TxtId1.setText("00001");
            }

            j = Integer.parseInt(num);
            GenerarCodigos gen = new GenerarCodigos();
            gen.generar(j);
            TxtId1.setText(0000 + gen.serie());

        } catch (SQLException ex) {
            Logger.getLogger(PlanillaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void codigos4() {
        // Metodo para generar codigos automanticamente desde la clase GenerarCodigos     
        int j;
        int cont = 1;
        String num = "";
//        String c="";
        String SQL = "select max(id) from querico.remito3";
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
                TxtId3.setText("00001");
            }

            j = Integer.parseInt(num);
            GenerarCodigos gen = new GenerarCodigos();
            gen.generar(j);
            TxtId3.setText(0000 + gen.serie());

        } catch (SQLException ex) {
            Logger.getLogger(PlanillaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarDatos() {

        try {
            String SQL = "UPDATE querico.remito1 SET numero=?,fecha=?, remito=?, patentes=?, pollos=?, pesobruto=?, pesotara=?, pesoneto=?,promedio=?,transporte=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtNumero.getText());
            pst.setString(2, TxtFecha.getText());
//            int seleccionado1 = JCSector.getSelectedIndex();            
//            pst.setString(3, JCSector.getItemAt(seleccionado1));
            pst.setString(3, TxtRemito.getText());
            pst.setString(4, TxtPatentes.getText());
            pst.setString(5, TxtPollos.getText());
            pst.setString(6, TxtPBruto.getText());
            pst.setString(7, TxtTara.getText());
            pst.setString(8, TxtPNeto.getText());
            pst.setString(9, TxtPromedio.getText());
            pst.setString(10, TxtTransporte.getText());
            pst.setString(11, TxtID.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado en Remito 1. ");
            Limpiar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }

    public void EditarDatos2() {

        try {
            String SQL = "UPDATE querico.remito2 SET numero=?,remito=?, patente=?, pollos=?, pesobruto=?, tara=?,  pesoneto=?,pingreso=?,fecha=?,hentrada=?,tipo=?,chofer=?,granja=?,cargador=?,promedio=?,muertos=?,galpon=?,pcajon=?,orden=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtNumero1.getText());
            pst.setString(2, TxtRemito1.getText());
            pst.setString(3, TxtPatentes1.getText());
            pst.setString(4, TxtPollos1.getText());
            pst.setString(5, TxtPBruto1.getText());
            pst.setString(6, TxtTara1.getText());
            pst.setString(7, TxtPNeto1.getText());
            pst.setString(8, TxtPIngreso1.getText());
            pst.setString(9, TxtFecha1.getText());
            pst.setString(10, TxtHentrada1.getText());
            int seleccionado1 = JCTipo2.getSelectedIndex();
            pst.setString(11, JCTipo2.getItemAt(seleccionado1));
            pst.setString(12, TxtChofer1.getText());
            pst.setString(13, TxtGranja1.getText());
            pst.setString(14, TxtCargador1.getText());
            pst.setString(15, TxtPromedio1.getText());
            pst.setString(16, TxtMuertos1.getText());
            pst.setString(17, TxtGalpon1.getText());
            pst.setString(18, TxtPCajon1.getText());
            int selecciona = JCOrden.getSelectedIndex();
            pst.setString(19, JCOrden.getItemAt(selecciona));
            pst.setString(20, TxtId1.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado en Remito 2. ");
            Orden();
            OrdenReporte();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }

    public void Editar4() {

        try {
            String SQL = "UPDATE querico.remito3 SET fecha=?,hora=?, carga=?,patente=?, empresa=?, operador=?, chofer=?, remito=?,tara=?,pesobrutoe=?, pesonetoe=?, pesobrutos=?, pesonetos=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtFechas3.getText());
            pst.setString(2, TxtHora3.getText());
            pst.setString(3, TxtCarga3.getText());
            pst.setString(4, TxtPatente3.getText());
            pst.setString(5, TxtEmpresa3.getText());
            pst.setString(6, LblNombreX.getText());
            pst.setString(7, TxtChofer3.getText());
            pst.setString(8, TxtRemito3.getText());
            pst.setString(9, TxtTara3.getText());
            pst.setString(10, TxtPBEntrada.getText());
            pst.setString(11, TxtPNEntrada.getText());
            pst.setString(12, TxtPBSalida.getText());
            pst.setString(13, TxtPNSalida.getText());
            pst.setString(14, TxtId3.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado en Remito 3. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }

    public void EditarReporte() {

        try {
            String SQL = "UPDATE querico.reporte SET numero=?,fecha=?, remito=?,chofer=?, granja=?, cargador=?, pollos=?, kilos=?,promedio=?,muertos=?, orden=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtNumero1.getText());
            pst.setString(2, TxtFecha1.getText());
            pst.setString(3, TxtRemito1.getText());
            pst.setString(4, TxtChofer1.getText());
            pst.setString(5, TxtGranja1.getText());
            pst.setString(6, TxtCargador1.getText());
            pst.setString(7, TxtPollos1.getText());
            pst.setString(8, TxtPNeto1.getText());
            pst.setDouble(9, Double.valueOf(TxtPromedio1.getText()));
            pst.setString(10, TxtMuertos1.getText());
            int Sel = JCOrden.getSelectedIndex();
            pst.setString(11, JCOrden.getItemAt(Sel));
            pst.setString(12, TxtId1.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado en Reporte. ");
            Limpiar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar los datos.  " + e.getMessage());

        }

    }

    public void Limpiar2() {
//        TxtId1.setText("");
        TxtFecha1.setText(fechaact());
        TxtHentrada1.setText("");
        JCTipo2.setSelectedItem(null);
        TxtChofer1.setText("");
        TxtRemito1.setText("");
        TxtPatentes1.setText("");
        TxtGranja1.setText("");
        TxtCargador1.setText("");
        TxtPollos1.setText("");
        TxtPBruto1.setText("");
        TxtTara1.setText("");
        TxtPNeto1.setText("");
        TxtPromedio1.setText("");
        TxtMuertos1.setText("");
        TxtGalpon1.setText("");
        TxtPIngreso1.setText("");
        TxtPCajon1.setText("");
        TxtNumero1.setText("");

    }

    public void Limpiar() {
        TxtNumero.setText("");
        TxtFecha.setText(fechaact());
        TxtRemito.setText("");
        TxtPatentes.setText("");
//        TxtID.setText("");
        TxtPollos.setText("");
        TxtPBruto.setText("");
        TxtTara.setText("");
        TxtPNeto.setText("");
        TxtPromedio.setText("");
        TxtTransporte.setText("");
//       JCSector.setSelectedItem(null);

       
    }

    public void Limpiar4() {
        TxtFechas3.setText("");
        TxtHora3.setText("");
        TxtCarga3.setText("");
        TxtPatente3.setText("");
        TxtEmpresa3.setText("");
        LblNombreX.setText("");
        TxtChofer3.setText("");
        TxtRemito3.setText("");
        TxtTara3.setText("");
        TxtPBEntrada.setText("");
        TxtPBSalida.setText("");
        TxtPNEntrada.setText("");
        TxtPNSalida.setText("");

        mostrarDatos4();
    }

    public void EliminarRegistros() { //metodo corto para eliminar y funciona
        try {

            String SQL = " delete from querico.remito1 where id= ? ";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtId1.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado de Remito 1. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());

        }
    }

    public void EliminarRegistros1() { //metodo corto para eliminar y funciona
        try {

            String SQL = " delete from querico.remito2 where id= ?";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtId1.getText());

            pst.execute();
            EliminarRegistros();
            JOptionPane.showMessageDialog(null, "Registro eliminado de Remito 2. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());

        }
    }

    public void EliminarRegistrosReporte() { //metodo corto para eliminar y funciona
        try {

            String SQL = " delete from querico.reporte where id= ?";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtId1.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado de reporte. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());

        }
    }

    public void EliminarRegistros4() { //metodo corto para eliminar y funciona
        try {

            String SQL = " delete from querico.remito3 where id= ? ";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtId3.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado de Remito 3. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar Borrar los datos.  " + e.getMessage());

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
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTRemito1 = new javax.swing.JTable();
        TxtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtRemito = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtPatentes = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtPollos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtPBruto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtTara = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtPNeto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtPromedio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TxtTransporte = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        BtnGuardar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        TxtBuscarF = new javax.swing.JFormattedTextField();
        jLabel48 = new javax.swing.JLabel();
        BtnActualizar5 = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        TxtNumero = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTRemito2 = new javax.swing.JTable();
        TxtId1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        TxtFecha1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        TxtChofer1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        TxtRemito1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TxtPatentes1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        TxtGranja1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        TxtCargador1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        TxtPollos1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        TxtPBruto1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        TxtTara1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        TxtPNeto1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        TxtPromedio1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        TxtMuertos1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        TxtGalpon1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        TxtPIngreso1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        TxtPCajon1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        BtnGuardar1 = new javax.swing.JButton();
        BtnEditar1 = new javax.swing.JButton();
        BtnEliminar1 = new javax.swing.JButton();
        BtnActualizar1 = new javax.swing.JButton();
        BtnCalculos1 = new javax.swing.JButton();
        BtnImprimir = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        TxtBuscarF1 = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        BtnActualizar4 = new javax.swing.JButton();
        JCTipo2 = new javax.swing.JComboBox<>();
        TxtHentrada1 = new javax.swing.JFormattedTextField();
        JCOrden = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        TxtNumero1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTReporte = new javax.swing.JTable();
        TxtFecha3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        TxtTPollos = new javax.swing.JTextField();
        TxtTKilos = new javax.swing.JTextField();
        TxtTPromedio = new javax.swing.JTextField();
        TxtTMuertos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        A = new javax.swing.JCheckBox();
        B = new javax.swing.JCheckBox();
        C = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTRemito3 = new javax.swing.JTable();
        TxtId3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        TxtFechas3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        TxtRemito3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        TxtPatente3 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        TxtCarga3 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        TxtTara3 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        LblNombreX = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        BtnGuardar2 = new javax.swing.JButton();
        BtnEditar2 = new javax.swing.JButton();
        BtnEliminar2 = new javax.swing.JButton();
        BtnActualizar2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        BtnActualizar3 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        TxtPNEntrada = new javax.swing.JTextField();
        TxtPNSalida = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        BtnNuevo1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel53 = new javax.swing.JLabel();
        TxtEmpresa3 = new javax.swing.JTextField();
        TxtHora3 = new javax.swing.JFormattedTextField();
        jLabel54 = new javax.swing.JLabel();
        TxtChofer3 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        TxtPBEntrada = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        TxtPBSalida = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control general", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        JTRemito1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTRemito1.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTRemito1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTRemito1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTRemito1);

        jLabel1.setText("ID :");

        jLabel3.setText("Fecha :");

        jLabel6.setText("Remito :");

        jLabel7.setText("Patentes :");

        jLabel10.setText("Pollos :");

        jLabel11.setText("Peso Bruto :");

        jLabel12.setText("TARA :");

        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Peso Neto :");

        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Promedio :");

        jLabel15.setText("Transporte:");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        jButton2.setText("Calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        try {
            TxtBuscarF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TxtBuscarF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarFKeyReleased(evt);
            }
        });

        jLabel48.setText("Filtrar por fechas :");

        BtnActualizar5.setText("Mostrar todo");
        BtnActualizar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(TxtBuscarF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BtnActualizar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(BtnGuardar))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel48)
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBuscarF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(BtnActualizar5)
                .addContainerGap())
        );

        BtnNuevo.setText("Nuevo:");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        jLabel16.setText("Numero :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtTara, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPatentes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtPNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtPollos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtPBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(TxtPatentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtRemito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(TxtPollos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtPNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtPBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(TxtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtTara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Remitos 1", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        JTRemito2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTRemito2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JTRemito2.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTRemito2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTRemito2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTRemito2);

        TxtId1.setText("00001");
        TxtId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtId1ActionPerformed(evt);
            }
        });

        jLabel26.setText("ID :");

        jLabel27.setText("Tipo :");

        jLabel28.setText("Fecha :");

        jLabel29.setText("Chofer :");

        jLabel30.setText("H. Entrada");

        jLabel31.setText("Remito :");

        jLabel32.setText("Patentes :");

        jLabel33.setText("Granja :");

        jLabel34.setText("Cargador :");

        jLabel35.setText("Pollos :");

        jLabel36.setText("Peso Bruto :");

        jLabel37.setText("TARA :");

        jLabel38.setForeground(new java.awt.Color(204, 0, 0));
        jLabel38.setText("Peso Neto :");

        jLabel39.setForeground(new java.awt.Color(204, 0, 0));
        jLabel39.setText("Promedio :");

        jLabel40.setText("Muertos :");

        TxtMuertos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMuertos1ActionPerformed(evt);
            }
        });

        jLabel41.setText("Galpon :");

        jLabel42.setForeground(new java.awt.Color(204, 0, 0));
        jLabel42.setText("P. Ingreso :");

        jLabel43.setText("P. por cajon:");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnGuardar1.setText("Guardar");
        BtnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardar1ActionPerformed(evt);
            }
        });

        BtnEditar1.setText("Editar");
        BtnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditar1ActionPerformed(evt);
            }
        });

        BtnEliminar1.setText("Eliminar");
        BtnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar1ActionPerformed(evt);
            }
        });

        BtnActualizar1.setText("Actualizar");
        BtnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar1ActionPerformed(evt);
            }
        });

        BtnCalculos1.setText("Ralizar calculos ");
        BtnCalculos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalculos1ActionPerformed(evt);
            }
        });

        BtnImprimir.setText("Imprimir");
        BtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImprimirActionPerformed(evt);
            }
        });

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        try {
            TxtBuscarF1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TxtBuscarF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscarF1ActionPerformed(evt);
            }
        });
        TxtBuscarF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarF1KeyReleased(evt);
            }
        });

        jLabel60.setText("Filtrar por fechas :");

        BtnActualizar4.setText("Mostrar todo");
        BtnActualizar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCalculos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(BtnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(BtnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(BtnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(TxtBuscarF1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel60)))
                .addGap(60, 60, 60))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnActualizar4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(BtnCalculos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar1)
                    .addComponent(BtnEditar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar1)
                    .addComponent(BtnImprimir))
                .addGap(18, 18, 18)
                .addComponent(jLabel60)
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBuscarF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnActualizar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnActualizar4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JCTipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chasis", "Acoplado", "Completo" }));

        try {
            TxtHentrada1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        JCOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F" }));

        jLabel51.setText("Orden :");

        jLabel52.setText("Numero: ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPollos1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPBruto1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtTara1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPNeto1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPromedio1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtMuertos1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtGalpon1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPCajon1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtChofer1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtRemito1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPatentes1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtGranja1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtCargador1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtId1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(JCOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtHentrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(82, 82, 82)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel51)
                                .addComponent(JCOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel52))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)
                                .addComponent(jLabel30)
                                .addComponent(TxtHentrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(TxtChofer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(TxtRemito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(JCTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPatentes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(TxtGranja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(TxtCargador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPollos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(TxtPBruto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(TxtTara1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPNeto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(TxtPromedio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(TxtMuertos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtGalpon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)
                            .addComponent(TxtPIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)
                            .addComponent(TxtPCajon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Remitos 2", jPanel3);

        JTReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTReporte.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane4.setViewportView(JTReporte);

        TxtFecha3.setEditable(false);
        TxtFecha3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TxtFecha3.setForeground(new java.awt.Color(204, 0, 0));
        TxtFecha3.setBorder(null);
        TxtFecha3.setCaretColor(new java.awt.Color(60, 63, 65));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("REPORTES ");

        jButton1.setText("Ver / Calcular");
        jButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jButton1StateChanged(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Mostrar desde :");

        jLabel4.setText("Hasta: ");

        A.setText("A");
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });

        B.setText("B");

        C.setText("C");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setText("Vista previa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel19.setText("Imprimir por fechas y orden");

        jLabel20.setText("Desde :");

        jLabel21.setText("Hasta :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));

        jLabel22.setText("Orden :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jButton5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setText("Vista previa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Imprimir por fechas");

        jLabel17.setText("Desde :");

        jLabel18.setText("Hasta :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(111, 111, 111))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(76, 76, 76))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Imprimir todo");

        jButton3.setText("Vista previa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(111, 111, 111))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(204, 0, 0));
        jLabel61.setText("POLLOS:");

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(204, 0, 0));
        jLabel62.setText("KILOS:");

        jLabel63.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(204, 0, 0));
        jLabel63.setText("PROMEDIO:");

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(204, 0, 0));
        jLabel64.setText("MUERTOS:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(TxtFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(A)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(B)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtTPollos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtTKilos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtTPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtTMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(A)
                        .addComponent(B)
                        .addComponent(C)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTPollos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTKilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Reporte", jPanel5);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        JTRemito3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTRemito3.setSelectionBackground(new java.awt.Color(0, 102, 102));
        JTRemito3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTRemito3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTRemito3);

        jLabel23.setText("ID :");

        jLabel24.setText("Fecha :");

        jLabel25.setText("Remito :");

        jLabel44.setText("Patente :");

        jLabel45.setText("Carga:");

        jLabel47.setText("TARA :");

        jLabel49.setText("Operador :");

        jLabel50.setText("Hora :");

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnGuardar2.setText("Guardar");
        BtnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardar2ActionPerformed(evt);
            }
        });

        BtnEditar2.setText("Editar");
        BtnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditar2ActionPerformed(evt);
            }
        });

        BtnEliminar2.setText("Eliminar");
        BtnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar2ActionPerformed(evt);
            }
        });

        BtnActualizar2.setText("Actualizar");
        BtnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar2ActionPerformed(evt);
            }
        });

        jButton6.setText("Calcular");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        BtnActualizar3.setText("Imprimir");
        BtnActualizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar3ActionPerformed(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel56.setForeground(new java.awt.Color(204, 0, 0));
        jLabel56.setText("Peso Neto Entrada:");

        jLabel57.setForeground(new java.awt.Color(204, 0, 0));
        jLabel57.setText("Peso Neto Salida :");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtPNSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtPNEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPNEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPNSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(BtnEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnActualizar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEditar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(BtnGuardar2)
                    .addComponent(BtnEditar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar2)
                    .addComponent(BtnActualizar2)
                    .addComponent(BtnActualizar3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnNuevo1.setText("Nuevo:");
        BtnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevo1ActionPerformed(evt);
            }
        });

        jLabel53.setText("Empresa :");

        TxtEmpresa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEmpresa3ActionPerformed(evt);
            }
        });

        try {
            TxtHora3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel54.setText("Chofer :");

        jLabel55.setText("Peso Bruto Entrada:");

        jLabel58.setText("Peso Bruto Salida :");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TxtId3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TxtFechas3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TxtHora3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TxtPBEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TxtPBSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                                        .addComponent(TxtRemito3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(TxtChofer3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(TxtTara3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(BtnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LblNombreX, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtCarga3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtPatente3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtEmpresa3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnNuevo1)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LblNombreX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel49)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtId3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(TxtFechas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel50)
                                    .addComponent(TxtHora3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCarga3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45)))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtEmpresa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53))
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(TxtPatente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtRemito3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(TxtChofer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(TxtTara3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPBEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55)
                            .addComponent(TxtPBSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Remitos 3", jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //REPORTES SIN PARAMETROS
        try {

            String path = "C:\\NetBeansProjects\\QueRico\\src\\Reportes\\B_Reporte.jasper";

            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map parametros = new HashMap();

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(PlanillaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {

            String path = "C:\\NetBeansProjects\\QueRico\\src\\Reportes\\B_ReporteF.jasper";

            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map parametros = new HashMap();

            Date fecha1 = jDateChooser3.getDate();
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");

            String fec1 = "" + formatofecha.format(fecha1);

            Date fecha2 = jDateChooser4.getDate();
            SimpleDateFormat formatofecha2 = new SimpleDateFormat("dd/MM/yyyy");
            String fec2 = "" + formatofecha2.format(fecha2);

            parametros.put("f_ini", fec1);
            parametros.put("f_fin", fec2);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(PlanillaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String path = "C:\\NetBeansProjects\\QueRico\\src\\Reportes\\B_ReporteFO.jasper";

            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map parametros = new HashMap();

            //            if( A1.isSelected()){
            parametros.put("orden", jComboBox1.getSelectedItem().toString());
            //            }
            //            parametros.put("orden", B1.isSelected());
            //
            //            parametros.put("orden", C1.isSelected());

            Date fecha1 = jDateChooser6.getDate();
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
            String fec1 = "" + formatofecha.format(fecha1);
            Date fecha2 = jDateChooser5.getDate();
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

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String consulta = "";

        Date fecha1 = jDateChooser1.getDate();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");

        String fec1 = "" + formatofecha.format(fecha1);

        Date fecha2 = jDateChooser2.getDate();
        SimpleDateFormat formatofecha2 = new SimpleDateFormat("dd/MM/yyyy");
        String fec2 = "" + formatofecha2.format(fecha2);

        consulta = "SELECT * FROM querico.reporte WHERE fecha  BETWEEN '" + fec1 + "' AND '" + fec2 + "' ";

        if (A.isSelected()) {

            consulta = "SELECT * FROM querico.reporte WHERE orden='A' AND fecha  BETWEEN '" + fec1 + "' AND '" + fec2 + "' ";
        }
        if (B.isSelected()) {

            //            TxtTPollos.setText("");
            consulta = "SELECT * FROM querico.reporte WHERE orden='B' AND fecha  BETWEEN '" + fec1 + "' AND '" + fec2 + "'";

            ////            DefaultTableModel dtm1;
            ////
            ////            for(int i=0;i<JTReporte.getRowCount();i++){
            ////                sub = Integer.parseInt(JTReporte.getValueAt(i, 6).toString());
            ////                total = total +sub;
            ////
            ////
            //              TxtTPollos.setText(String.valueOf(total));
            //            }
        }

        if (C.isSelected()) {

            consulta = "SELECT * FROM querico.reporte WHERE orden='C' AND fecha  BETWEEN '" + fec1 + "' AND '" + fec2 + "' ";
        }

        String[] titulos = {"ID", "Numero", "Fecha", "Remito", "Chofer", "Granja", "Cargador", "Pollos", "Kilos", "Promedio", "Muertos", "Orden"};
        String[] registros = new String[12];
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("remito");
                registros[4] = rs.getString("chofer");
                registros[5] = rs.getString("granja");
                registros[6] = rs.getString("cargador");
                registros[7] = rs.getString("pollos");
                registros[8] = rs.getString("kilos");
                registros[9] = rs.getString("promedio");
                registros[10] = rs.getString("muertos");
                registros[11] = rs.getString("Orden");

                tabla.addRow(registros);

            }
            JTReporte.setModel(tabla);
            //SUMA POLLOS
            int total = 0;
            int sub;

            DefaultTableModel dtm;

            for (int i = 0; i < JTReporte.getRowCount(); i++) {
                sub = Integer.parseInt(JTReporte.getValueAt(i, 7).toString());
                total = total + sub;
            }
            //SUMA kilos
            int total1 = 0;

            for (int i = 0; i < JTReporte.getRowCount(); i++) {
                sub = Integer.parseInt(JTReporte.getValueAt(i, 8).toString());
                total1 = total1 + sub;
            }
            //PROMEDIO
            double total2 = 0;

//            double sbb;
//            for (int i = 0; i < JTReporte.getRowCount(); i++) {
//                sbb = Double.parseDouble(JTReporte.getValueAt(i, 9).toString());
            total2 = (total1 / total);
//            }
            //SUMA MUERTOS
            int total3 = 0;
            for (int i = 0; i < JTReporte.getRowCount(); i++) {
                sub = Integer.parseInt(JTReporte.getValueAt(i, 10).toString());
                total3 = total3 + sub;
            }
            //

            TxtTPollos.setText(String.valueOf(total));
            TxtTKilos.setText(String.valueOf(total1));
            DecimalFormat df = new DecimalFormat("#.000");
            TxtTPromedio.setText(String.valueOf(df.format(total2)));

            TxtTMuertos.setText(String.valueOf(total3));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje, rellene todos los campos codigo :" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void FiltrarDatos(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"ID", "Numero", "Fecha", "Remito", "Patente", "Pollos", "Peso Bruto", "Pesto Tara", "Peso Neto", "Promedio", "Transporte"};
        String[] registros = new String[11];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.remito1 WHERE CONCAT(fecha) LIKE '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("remito");
                registros[4] = rs.getString("patentes");
                registros[5] = rs.getString("pollos");
                registros[6] = rs.getString("pesobruto");
                registros[7] = rs.getString("pesotara");
                registros[8] = rs.getString("pesoneto");
                registros[9] = rs.getString("promedio");
                registros[10] = rs.getString("transporte");

                modelo.addRow(registros);

            }
            JTRemito1.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }

    public void FiltrarDatos1(String valor) {
        //CON ESTE METODO PODEMOS FLITRAR BUSQUEDAS ESPECIFICAS
        String[] titulos = {"ID", "Numero", "Remito", "Patente", "Pollos", "P.Bruto", "Tara", "P. Neto", "P. Ingreso", "Fecha", "H. Entrada", "Tipo", "Chofer", "Granja", "Cargador", "Promedio", "Muertos", "Galpon", "Pollos x cajon", "Orden"};
        String[] registros = new String[20];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

//        String SQL = "SELECT * FROM labarrera.clientes WHERE CONCAT(cod,nombre,apellido,dni,direccion,ncalle,ecalle,telefono,celular,observaciones) LIKE '%" + valor + "%'";
        String SQL = "SELECT * FROM querico.remito2 WHERE CONCAT(fecha) LIKE '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                registros[0] = rs.getString("id");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("remito");
                registros[3] = rs.getString("patente");
                registros[4] = rs.getString("pollos");
                registros[5] = rs.getString("pesobruto");
                registros[6] = rs.getString("tara");
                registros[7] = rs.getString("pesoneto");
                registros[8] = rs.getString("pingreso");
                registros[9] = rs.getString("fecha");
                registros[10] = rs.getString("hentrada");
                registros[11] = rs.getString("tipo");
                registros[12] = rs.getString("chofer");
                registros[13] = rs.getString("granja");
                registros[14] = rs.getString("cargador");
                registros[15] = rs.getString("promedio");
                registros[16] = rs.getString("muertos");
                registros[17] = rs.getString("galpon");
                registros[18] = rs.getString("pcajon");
                registros[19] = rs.getString("orden");

                modelo.addRow(registros);

            }
            JTRemito2.setModel(modelo);
            Orden();
            OrdenReporte();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al monstrar el mensaje" + e);
        }

    }

    private void jButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jButton1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1StateChanged

    private void BtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImprimirActionPerformed
        RangoFechaImprimir ven = new RangoFechaImprimir();
        ven.setVisible(true);
    }//GEN-LAST:event_BtnImprimirActionPerformed

    private void BtnCalculos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalculos1ActionPerformed
        int num1 = Integer.parseInt(TxtTara1.getText());
        int num2 = Integer.parseInt(TxtPBruto1.getText());
        TxtPNeto1.setText(String.valueOf(num2 - num1));
        //
        double num9 = Double.parseDouble(TxtPNeto1.getText());
        double num8 = Double.parseDouble(TxtPollos1.getText());

        DecimalFormat df = new DecimalFormat("#.0000");
        TxtPromedio1.setText(String.valueOf(((num9 / num8))));
    }//GEN-LAST:event_BtnCalculos1ActionPerformed

    private void BtnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar1ActionPerformed
        Limpiar2();
        Orden();
        OrdenReporte();

//        mostrarDatos2();
    }//GEN-LAST:event_BtnActualizar1ActionPerformed

    private void BtnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar1ActionPerformed
        if (TxtId1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un campo a eliminar.");

        } else {
            String opcion[] = {"Eliminar", "Cancelar"};

            int eleccion = JOptionPane.showOptionDialog(this, "Esta seguro de eliminar el registro para siempre?. ", "ATENCION!!!", 0, 0, null, opcion, evt);
            if (eleccion == JOptionPane.YES_OPTION) {
                
//                EliminarRegistros();
                EliminarRegistros1();
                EliminarRegistrosReporte();

            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.out.println("Eliminacion cancelada!");

            }
          
          mostrarDatos2();
            mostrarDatos3();
            mostrarDatos();
            Limpiar();

        }
    }//GEN-LAST:event_BtnEliminar1ActionPerformed

    private void BtnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditar1ActionPerformed
        EditarDatos2();
//        EditarDatos();

        EditarReporte();

        FiltrarDatos1(TxtBuscarF1.getText());
        Orden();
        OrdenReporte();
        mostrarDatos3();
    }//GEN-LAST:event_BtnEditar1ActionPerformed

    private void BtnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardar1ActionPerformed
        try {
            String SQL = "INSERT INTO querico.reporte (id,numero,fecha,remito,chofer,granja,cargador,pollos,kilos,promedio,muertos,orden)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtId1.getText());
            pst.setString(2, TxtNumero1.getText());
            pst.setString(3, TxtFecha1.getText());
            pst.setString(4, TxtRemito1.getText());
            pst.setString(5, TxtChofer1.getText());
            pst.setString(6, TxtGranja1.getText());
            pst.setString(7, TxtCargador1.getText());
            pst.setString(8, TxtPollos1.getText());
            pst.setString(9, TxtPNeto1.getText());
            pst.setDouble(10, Double.valueOf(TxtPromedio1.getText()));
            pst.setString(11, TxtMuertos1.getText());
            int Sel = JCOrden.getSelectedIndex();
            pst.setString(12, JCOrden.getItemAt(Sel));

            //            pst.setString(3, TxtHentrada1.getText());
            //            int seleccionado1 = JCTipo2.getSelectedIndex();
            //            pst.setString(4, JCTipo2.getItemAt(seleccionado1));
            //            pst.setString(7, TxtPatentes1.getText());
            //            pst.setString(11, TxtPBruto1.getText());
            //            pst.setString(12, TxtTara1.getText());
            //            pst.setString(16, TxtGalpon1.getText());
            //            pst.setString(17, TxtPIngreso1.getText());
            //            pst.setString(18, TxtPCajon1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos enviados para su proceso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());

        }
//        insertarDatos2();
        EditarDatos2();
//        mostrarDatos2();
        FiltrarDatos1(TxtBuscarF1.getText());
        Orden();
        OrdenReporte();
        mostrarDatos3();
    }//GEN-LAST:event_BtnGuardar1ActionPerformed

    private void TxtId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtId1ActionPerformed

    private void JTRemito2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTRemito2MouseClicked

        Limpiar2();
        int filaSeleccionada = JTRemito2.rowAtPoint(evt.getPoint());
        TxtId1.setText(JTRemito2.getValueAt(filaSeleccionada, 0).toString());
        TxtNumero1.setText(JTRemito2.getValueAt(filaSeleccionada, 1).toString());
        TxtRemito1.setText(JTRemito2.getValueAt(filaSeleccionada, 2).toString());
        TxtPatentes1.setText(JTRemito2.getValueAt(filaSeleccionada, 3).toString());
        TxtPollos1.setText(JTRemito2.getValueAt(filaSeleccionada, 4).toString());
        TxtPBruto1.setText(JTRemito2.getValueAt(filaSeleccionada, 5).toString());
        TxtTara1.setText(JTRemito2.getValueAt(filaSeleccionada, 6).toString());
        TxtPNeto1.setText(JTRemito2.getValueAt(filaSeleccionada, 7).toString());
        TxtPIngreso1.setText(JTRemito2.getValueAt(filaSeleccionada, 8).toString());
        TxtFecha1.setText(JTRemito2.getValueAt(filaSeleccionada, 9).toString());
        TxtHentrada1.setText(JTRemito2.getValueAt(filaSeleccionada, 10).toString());
        JCTipo2.setSelectedItem(JTRemito2.getValueAt(filaSeleccionada, 11).toString());
        TxtChofer1.setText(JTRemito2.getValueAt(filaSeleccionada, 12).toString());
        TxtGranja1.setText(JTRemito2.getValueAt(filaSeleccionada, 13).toString());
        TxtCargador1.setText(JTRemito2.getValueAt(filaSeleccionada, 14).toString());
        TxtPromedio1.setText(JTRemito2.getValueAt(filaSeleccionada, 15).toString());
        TxtMuertos1.setText(JTRemito2.getValueAt(filaSeleccionada, 16).toString());
        TxtGalpon1.setText(JTRemito2.getValueAt(filaSeleccionada, 17).toString());
        TxtPCajon1.setText(JTRemito2.getValueAt(filaSeleccionada, 18).toString());
        JCOrden.setSelectedItem(JTRemito2.getValueAt(filaSeleccionada, 19).toString());


    }//GEN-LAST:event_JTRemito2MouseClicked

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed

        Limpiar();

        
        codigos();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int num1 = Integer.parseInt(TxtTara.getText());
        int num2 = Integer.parseInt(TxtPBruto.getText());
        TxtPNeto.setText(String.valueOf(num2 - num1));

        //
        double num4 = Double.parseDouble(TxtPNeto.getText());
        double num5 = Double.parseDouble(TxtPollos.getText());

        DecimalFormat df = new DecimalFormat("#.0000");
        TxtPromedio.setText(String.valueOf((num4 / num5)));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
//        mostrarDatos();
//        Limpiar();
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if (TxtID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un campo a eliminar.");

        } else {
            String opcion[] = {"Entiendo", "Cancelar"};

            int eleccion = JOptionPane.showOptionDialog(this, "ELIMINE DESDE REMITO 2!!!. ", "ATENCION!!!", 0, 0, null, opcion, evt);
            if (eleccion == JOptionPane.YES_OPTION) {

//                EliminarRegistros();
//                EliminarRegistros1();
//                EliminarRegistrosReporte();
            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.out.println("Eliminacion cancelada!");

            }
           

            Limpiar();
            FiltrarDatos(TxtBuscarF.getText());
       

        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        EditarDatos();
       FiltrarDatos(TxtBuscarF.getText());
        Orden();
        OrdenReporte();
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        try {
            String SQL = "INSERT INTO querico.remito2 (id,numero,remito,patente,pollos,pesobruto,tara,pesoneto,pingreso,fecha)VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setString(1, TxtID.getText());
            pst.setString(2, TxtNumero.getText());
            pst.setString(3, TxtRemito.getText());
            pst.setString(4, TxtPatentes.getText());
            pst.setString(5, TxtPollos.getText());
            pst.setString(6, TxtPBruto.getText());
            pst.setString(7, TxtTara.getText());
            pst.setString(8, TxtPNeto.getText());
            pst.setDouble(9, Double.valueOf(TxtPromedio.getText()));

            pst.setString(10, TxtFecha.getText());
//            pst.setString(4, TxtHentrada1.getText());
//            int seleccionado1 = JCTipo2.getSelectedIndex();
//            pst.setString(5, JCTipo2.getItemAt(seleccionado1));
//            pst.setString(6, TxtChofer1.getText());
//           
//           
//            pst.setString(9, TxtGranja1.getText());
//            pst.setString(10, TxtCargador1.getText());
//           
//            
//          
//           
//           
//            pst.setString(16, TxtMuertos1.getText());
//            pst.setString(17, TxtGalpon1.getText());
//            pst.setDouble(18, Double.valueOf(TxtPIngreso1.getText()));
//            pst.setString(19, TxtPCajon1.getText());
//            int sele = JCOrden.getSelectedIndex();
//            pst.setString(20, JCOrden.getItemAt(sele));
            pst.execute();
//            JOptionPane.showMessageDialog(null, "Pre. Cargando Remito 2");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en CONEXION " + e.getMessage());

        }
//        String info = TxtPromedio.getText();
//        TxtPIngreso1.setText(info);

        JOptionPane.showMessageDialog(null, "Atencion! se autocompletaran campos en otras pestañas.");

        insertarDatos();
        FiltrarDatos(TxtBuscarF.getText());
        FiltrarDatos1(TxtBuscarF1.getText());
        Orden();
        OrdenReporte();
//        mostrarDatos();
//        mostrarDatos2();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void JTRemito1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTRemito1MouseClicked
        int filaSeleccionada = JTRemito1.rowAtPoint(evt.getPoint());
        TxtID.setText(JTRemito1.getValueAt(filaSeleccionada, 0).toString());
        TxtNumero.setText(JTRemito1.getValueAt(filaSeleccionada, 1).toString());
        TxtFecha.setText(JTRemito1.getValueAt(filaSeleccionada, 2).toString());
        TxtRemito.setText(JTRemito1.getValueAt(filaSeleccionada, 3).toString());
        TxtPatentes.setText(JTRemito1.getValueAt(filaSeleccionada, 4).toString());
        TxtPollos.setText(JTRemito1.getValueAt(filaSeleccionada, 5).toString());
        TxtPBruto.setText(JTRemito1.getValueAt(filaSeleccionada, 6).toString());
        TxtTara.setText(JTRemito1.getValueAt(filaSeleccionada, 7).toString());
        TxtPNeto.setText(JTRemito1.getValueAt(filaSeleccionada, 8).toString());
        TxtPromedio.setText(JTRemito1.getValueAt(filaSeleccionada, 9).toString());
        TxtTransporte.setText(JTRemito1.getValueAt(filaSeleccionada, 10).toString());

        //        JCEstado.setSelectedItem(JTRemito1.getValueAt(filaSeleccionada, 7).toString());
    }//GEN-LAST:event_JTRemito1MouseClicked

    private void JTRemito3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTRemito3MouseClicked
        int filaSeleccionada = JTRemito3.rowAtPoint(evt.getPoint());
        TxtId3.setText(JTRemito3.getValueAt(filaSeleccionada, 0).toString());
        TxtFechas3.setText(JTRemito3.getValueAt(filaSeleccionada, 1).toString());
        TxtHora3.setText(JTRemito3.getValueAt(filaSeleccionada, 2).toString());
        TxtCarga3.setText(JTRemito3.getValueAt(filaSeleccionada, 3).toString());
        TxtPatente3.setText(JTRemito3.getValueAt(filaSeleccionada, 4).toString());
        TxtEmpresa3.setText(JTRemito3.getValueAt(filaSeleccionada, 5).toString());
        LblNombreX.setText(JTRemito3.getValueAt(filaSeleccionada, 6).toString());
        TxtChofer3.setText(JTRemito3.getValueAt(filaSeleccionada, 7).toString());
        TxtRemito3.setText(JTRemito3.getValueAt(filaSeleccionada, 8).toString());
        TxtTara3.setText(JTRemito3.getValueAt(filaSeleccionada, 9).toString());
        TxtPBEntrada.setText(JTRemito3.getValueAt(filaSeleccionada, 10).toString());
        TxtPNEntrada.setText(JTRemito3.getValueAt(filaSeleccionada, 11).toString());
        TxtPBSalida.setText(JTRemito3.getValueAt(filaSeleccionada, 12).toString());
        TxtPNSalida.setText(JTRemito3.getValueAt(filaSeleccionada, 13).toString());
    }//GEN-LAST:event_JTRemito3MouseClicked

    private void BtnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardar2ActionPerformed
        insertarDatos4();
        Limpiar4();
        mostrarDatos4();
    }//GEN-LAST:event_BtnGuardar2ActionPerformed

    private void BtnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditar2ActionPerformed
        Editar4();
        Limpiar4();
        mostrarDatos4();
    }//GEN-LAST:event_BtnEditar2ActionPerformed

    private void BtnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar2ActionPerformed
        if (TxtId3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un campo a eliminar.");

        } else {
            String opcion[] = {"Eliminar", "Cancelar"};

            int eleccion = JOptionPane.showOptionDialog(this, "Esta seguro de eliminar el registro para siempre?. ", "ATENCION!!!", 0, 0, null, opcion, evt);
            if (eleccion == JOptionPane.YES_OPTION) {
                EliminarRegistros4();
                mostrarDatos4();

            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.out.println("Eliminacion cancelada!");

            }

        }
    }//GEN-LAST:event_BtnEliminar2ActionPerformed

    private void BtnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar2ActionPerformed
        Limpiar4();
        mostrarDatos4();
    }//GEN-LAST:event_BtnActualizar2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int num10 = Integer.parseInt(TxtTara3.getText());
        int num11 = Integer.parseInt(TxtPBSalida.getText());
        TxtPNSalida.setText(String.valueOf(num11 - num10));

        int num12 = Integer.parseInt(TxtTara3.getText());
        int num13 = Integer.parseInt(TxtPBEntrada.getText());
        TxtPNEntrada.setText(String.valueOf(num13 - num12));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BtnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevo1ActionPerformed
        codigos4();
        Limpiar4();
    }//GEN-LAST:event_BtnNuevo1ActionPerformed

    private void BtnActualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar3ActionPerformed
        RANGOIDREMITO3 ven = new RANGOIDREMITO3();
        ven.setVisible(true);
    }//GEN-LAST:event_BtnActualizar3ActionPerformed

    private void TxtEmpresa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEmpresa3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEmpresa3ActionPerformed

    private void TxtBuscarFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarFKeyReleased
        FiltrarDatos(TxtBuscarF.getText());
     
        Orden();
        OrdenReporte();
    }//GEN-LAST:event_TxtBuscarFKeyReleased

    private void TxtBuscarF1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarF1KeyReleased
        FiltrarDatos1(TxtBuscarF1.getText());
        Orden();
        OrdenReporte();
    }//GEN-LAST:event_TxtBuscarF1KeyReleased

    private void TxtBuscarF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscarF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarF1ActionPerformed

    private void BtnActualizar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar4ActionPerformed
        Limpiar2();
        mostrarDatos2();
    }//GEN-LAST:event_BtnActualizar4ActionPerformed

    private void BtnActualizar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar5ActionPerformed
        mostrarDatos();
    }//GEN-LAST:event_BtnActualizar5ActionPerformed

    private void TxtMuertos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMuertos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMuertos1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox A;
    private javax.swing.JCheckBox B;
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnActualizar1;
    private javax.swing.JButton BtnActualizar2;
    private javax.swing.JButton BtnActualizar3;
    private javax.swing.JButton BtnActualizar4;
    private javax.swing.JButton BtnActualizar5;
    private javax.swing.JButton BtnCalculos1;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEditar1;
    private javax.swing.JButton BtnEditar2;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnEliminar1;
    private javax.swing.JButton BtnEliminar2;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnGuardar1;
    private javax.swing.JButton BtnGuardar2;
    private javax.swing.JButton BtnImprimir;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnNuevo1;
    private javax.swing.JCheckBox C;
    private javax.swing.JComboBox<String> JCOrden;
    private javax.swing.JComboBox<String> JCTipo2;
    private javax.swing.JTable JTRemito1;
    private javax.swing.JTable JTRemito2;
    private javax.swing.JTable JTRemito3;
    private javax.swing.JTable JTReporte;
    private javax.swing.JTextField LblNombreX;
    private javax.swing.JFormattedTextField TxtBuscarF;
    private javax.swing.JFormattedTextField TxtBuscarF1;
    private javax.swing.JTextField TxtCarga3;
    private javax.swing.JTextField TxtCargador1;
    private javax.swing.JTextField TxtChofer1;
    private javax.swing.JTextField TxtChofer3;
    private javax.swing.JTextField TxtEmpresa3;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtFecha1;
    private javax.swing.JTextField TxtFecha3;
    private javax.swing.JTextField TxtFechas3;
    private javax.swing.JTextField TxtGalpon1;
    private javax.swing.JTextField TxtGranja1;
    private javax.swing.JFormattedTextField TxtHentrada1;
    private javax.swing.JFormattedTextField TxtHora3;
    private javax.swing.JTextField TxtID;
    public static javax.swing.JTextField TxtId1;
    private javax.swing.JTextField TxtId3;
    private javax.swing.JTextField TxtMuertos1;
    private javax.swing.JTextField TxtNumero;
    private javax.swing.JTextField TxtNumero1;
    private javax.swing.JTextField TxtPBEntrada;
    private javax.swing.JTextField TxtPBSalida;
    private javax.swing.JTextField TxtPBruto;
    private javax.swing.JTextField TxtPBruto1;
    private javax.swing.JTextField TxtPCajon1;
    public static javax.swing.JTextField TxtPIngreso1;
    private javax.swing.JTextField TxtPNEntrada;
    private javax.swing.JTextField TxtPNSalida;
    private javax.swing.JTextField TxtPNeto;
    private javax.swing.JTextField TxtPNeto1;
    private javax.swing.JTextField TxtPatente3;
    private javax.swing.JTextField TxtPatentes;
    private javax.swing.JTextField TxtPatentes1;
    private javax.swing.JTextField TxtPollos;
    private javax.swing.JTextField TxtPollos1;
    private javax.swing.JTextField TxtPromedio;
    private javax.swing.JTextField TxtPromedio1;
    private javax.swing.JTextField TxtRemito;
    private javax.swing.JTextField TxtRemito1;
    private javax.swing.JTextField TxtRemito3;
    private javax.swing.JTextField TxtTKilos;
    private javax.swing.JTextField TxtTMuertos;
    private javax.swing.JTextField TxtTPollos;
    public static javax.swing.JTextField TxtTPromedio;
    private javax.swing.JTextField TxtTara;
    private javax.swing.JTextField TxtTara1;
    private javax.swing.JTextField TxtTara3;
    private javax.swing.JTextField TxtTransporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane4;
    // End of variables declaration//GEN-END:variables
}
