/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 */
package estructurasDatos;

import utilidades.IO_ES;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pedro Toshiba
 */
public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private float precio;
    private int unidades;
    private boolean baja;

    public Producto(String codigo, String nombre, String descripcion, float precio, int unidades, boolean baja) throws IllegalArgumentException {
        if (comprobarCodigo(codigo)) {
            this.codigo = codigo;
        } else {
            this.codigo = "X";
        }

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
        this.baja = baja;
/// aqui no se puede visualizar ni tampoco  hacer else ni tampoco if


    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public static boolean comprobarCodigo(String comprobarCodigo) {
        boolean comprobar = false;
        Pattern patron = Pattern.compile("^[0-9]{13}");
        Matcher mat = patron.matcher(comprobarCodigo);
        if (mat.find()) {
            comprobar = true;
        }
        return comprobar;
    }

    public static boolean validarPrecio(float precio) {
        boolean comprobar = false;

        if (precio > 0) {
            comprobar = true;
        }

        return comprobar;
    }
    
    public  boolean validarSumarProductos(int producto){
        
        boolean comprobar = false;
        
        if(producto >= 0){
            unidades += producto;
            comprobar = true;
        }
        
        return comprobar;
    }
    
    public boolean validarRestarProductos(int producto){
        boolean comprobar = false;
        if(producto >= 0){
            
            if(unidades < producto){
                comprobar = false;
            }else{
                unidades = unidades - producto;
                comprobar = true;
            }
            
        }
        return comprobar;
    }

    @Override
    public String toString() {
        return String.format(" codigo: %s,\n nombre: %s,\n Descripcion: %s,\n Precio: %.2f,\n Unidades: %s,\n baja: %s \n",
                this.codigo,
                this.nombre,
                this.descripcion,
                this.precio,
                this.unidades,
                this.baja);
    }
}
