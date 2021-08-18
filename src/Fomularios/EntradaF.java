/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fomularios;

/**
 *
 * @author José Pérez
 */
public class EntradaF {
 private String hoja;
 private String cod;
 private String recibido;

    public EntradaF(String hoja, String cod, String recibido) {
        this.hoja = hoja;
        this.cod = cod;
        this.recibido = recibido;
    }

    public String getHoja() {
        return hoja;
    }

    public void setHoja(String hoja) {
        this.hoja = hoja;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getRecibido() {
        return recibido;
    }

    public void setRecibido(String recibido) {
        this.recibido = recibido;
    }
 
 
   
    
   
    
}
