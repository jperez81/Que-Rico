/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author José Pérez
 */
public class MetodosSql {

    //Esta clase contiene todos los metodos de ( busqueda y guardado de Datos )
    // debemos instanciar la clase ConexionBD para establecer conexion con nuestra base de datos
    public static ConexionBD conexion = new ConexionBD();//instanciamos la clase para conectarnos a la base de datos
    public static PreparedStatement sentencia_preparada; //creamos una sentencia preparada 
    public static ResultSet resultado;//esto va a ser el resultado de las consulta que realicemos
    public static String sql;//
    public static int resultado_numero = 0;

 

    public int guardar(int cod, String nombre, String apellido, String usuario, String contraseña, String JCSector) { //METODO PARA GUARDAR DATOS DE LA TABLA USUARIOS
        int resultado = 0;
        Connection conexion = null;
        String sentencia_guardar = ("INSERT INTO querico.usuario (cod,nombre,apellido,usuario,contraseña,sector)VALUES (?,?,?,?,?,?)");//creamos las sentencias SQL para guardar datos

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setInt(1, cod);
            sentencia_preparada.setString(2, nombre);
            sentencia_preparada.setString(3, apellido);
            sentencia_preparada.setString(4, usuario);
            sentencia_preparada.setString(5, contraseña);
            sentencia_preparada.setString(6, JCSector);
            resultado = sentencia_preparada.executeUpdate(); //EJECUTA LA SENTENCIA PREPARADA PARA GUARDAR DATOS
            sentencia_preparada.close();
            conexion.close(); //CERRAR CONEXION

        } catch (Exception e) {
            System.out.println("Error al cargar datos" + e);

        }
        return resultado; //RETORNO DE VALORES DE LA SENTENCIA GUARDAR

    }

//    public int guardarPañol(int cod, String producto, String marca, String modelo, String serial, String un, String estado, int stock) { //METODO PARA GUARDAR DATOS DE LA TABLA USUARIOS
//        int resultado = 0;
//        Connection conexion = null;
//        String sentencia_guardar = ("INSERT INTO querico.pañol (cod,producto,marca,modelo,serial,un,estado,stock)VALUES (?,?,?,?,?,?,?,?)");//creamos las sentencias SQL para guardar datos
//
//        try {
//            conexion = ConexionBD.conectar();
//            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
//            sentencia_preparada.setInt(1, cod);
//            sentencia_preparada.setString(2, producto);
//            sentencia_preparada.setString(3, marca);
//            sentencia_preparada.setString(4, modelo);
//            sentencia_preparada.setString(5, serial);
//            sentencia_preparada.setString(6, un);
//            sentencia_preparada.setString(7, estado);
//            sentencia_preparada.setInt(8, stock);
//           
//
//            resultado = sentencia_preparada.executeUpdate(); //EJECUTA LA SENTENCIA PREPARADA PARA GUARDAR DATOS
//            sentencia_preparada.close();
//            conexion.close(); //CERRAR CONEXION
//
//        } catch (Exception e) {
//            System.out.println("Error al cargar datos" + e);
//
//        }
//        return resultado; //RETORNO DE VALORES DE LA SENTENCIA GUARDAR
//
//    }

//    public int guardarChofer(int cod, String nombre, String apellido, String dni, String direccion, String telcel, String dominio, String marca, String modelo, String combustible, String dueño, String observacion, String estado) { //METODO PARA GUARDAR DATOS DE LA TABLA USUARIOS
//        int resultado = 0;
//        Connection conexion = null;
//        String sentencia_guardar = ("INSERT INTO labarrera.chofer (cod,nombre,apellido,dni,direccion,telcel,dominio,marca,modelo,combustible,dueño,observacion,estado)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");//creamos las sentencias SQL para guardar datos
//
//        try {
//            conexion = ConexionBD.conectar();
//            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
//            sentencia_preparada.setInt(1, cod);
//            sentencia_preparada.setString(2, nombre);
//            sentencia_preparada.setString(3, apellido);
//            sentencia_preparada.setString(4, dni);
//            sentencia_preparada.setString(5, direccion);
//            sentencia_preparada.setString(6, telcel);
//            sentencia_preparada.setString(7, dominio);
//            sentencia_preparada.setString(8, marca);
//            sentencia_preparada.setString(9, modelo);
//            sentencia_preparada.setString(10, combustible);
//            sentencia_preparada.setString(11, dueño);
//            sentencia_preparada.setString(12, observacion);
//            sentencia_preparada.setString(13, estado);
//            resultado = sentencia_preparada.executeUpdate(); //EJECUTA LA SENTENCIA PREPARADA PARA GUARDAR DATOS
//            sentencia_preparada.close();
//            conexion.close(); //CERRAR CONEXION
//
//        } catch (Exception e) {
//            System.out.println("Error al cargar datos" + e);
//
//        }
//        return resultado; //RETORNO DE VALORES DE LA SENTENCIA GUARDAR
//
//    }

//    public int guardarClientes(int cod, String nombre, String apellido, String dni, String direccion, String ecalle, String telefono, String celular, String observaciones) { //METODO PARA GUARDAR DATOS DE LA TABLA CLientes
//        int resultado = 0;
//        Connection conexion = null;
//        String sentencia_guardar = ("INSERT INTO labarrera.clientes (cod,nombre,apellido,dni,direccion,ecalle,telefono,celular,observaciones)VALUES (?,?,?,?,?,?,?,?,?)");//creamos las sentencias SQL para guardar datos
//
//        try {
//            conexion = ConexionBD.conectar();
//            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
//            sentencia_preparada.setInt(1, cod);
//            sentencia_preparada.setString(2, nombre);
//            sentencia_preparada.setString(3, apellido);
//            sentencia_preparada.setString(4, dni);
//            sentencia_preparada.setString(5, direccion);
////            sentencia_preparada.setString(6, ncalle);
//            sentencia_preparada.setString(6, ecalle);
//            sentencia_preparada.setString(7, telefono);
//            sentencia_preparada.setString(8, celular);
//            sentencia_preparada.setString(9, observaciones);
//
//            resultado = sentencia_preparada.executeUpdate(); //EJECUTA LA SENTENCIA PREPARADA PARA GUARDAR DATOS
//            sentencia_preparada.close();
//            conexion.close(); //CERRAR CONEXION
//
//        } catch (Exception e) {
//            System.out.println("Error al cargar datos" + e);
//
//        }
//        return resultado; //RETORNO DE VALORES DE LA SENTENCIA GUARDAR
//
//    }

    public String buscarNombre(String usuario) { //METODO PARA BUSCAR NOMBRE EN LA BASE DE DATOS POR MEDIO DE SU CORREO
        String busqueda_nombre = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT nombre,apellido FROM querico.usuario WHERE usuario = '" + usuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery(); //EJECUTA LA SENTANCIA PREPARADA DE BUSCAR Y VALIDAR 
            if (resultado.next()) { //SI RESULTADO ES EL SIGUIENTE: TRAEME ESE NOMBRE Y APELLIDO
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                busqueda_nombre = (nombre + " " + apellido);

            }
            conexion.close(); //CERRAMOS CONEXION

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return busqueda_nombre;
    }

    public String BuscarUsuarioRegistrado(String usuario, String contraseña) { //METODO PARA USUARIO REGISTRADO

        String busqueda_usuario = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar(); //INSTANCIAR CONEXION DE "CONEXIONBD
            String sentencia_buscar_usuario = ("SELECT nombre,usuario, contraseña FROM querico.usuario WHERE usuario = '" + usuario + "'&& contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);

            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "Usuario Registrado!";
            } else {
                busqueda_usuario = " USUARIO INVALIDO!\n"
                        + "Contacte al Administrador";

            }
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error no se encuentra usuario" + e);
        }
        return busqueda_usuario;

    }

    //CREO ESTE METODO PARA QUE BUSQUE CONTRASEÑA EN BASE DE DATOS PARA VALIDAR USUARIOS
    public String ValidarModulo(String contraseña) { //METODO PARA USUARIO REGISTRADO

        String busqueda_usuario = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar(); //INSTANCIAR CONEXION DE "CONEXIONBD
            String validar = ("SELECT nombre,usuario, contraseña FROM querico.usuario WHERE contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(validar);

            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "Usuario Registrado!";
            } else {
                busqueda_usuario = " USUARIO INVALIDO!\n"
                        + "Contacte al Administrador";

            }
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error no se encuentra usuario" + e);
        }
        return busqueda_usuario;

    }

}
