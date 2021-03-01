/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasDatos;

import utilidades.IO_ES;
import utilidades.ValidarDatos;

/**
 *
 * @author Pedro
 */
public class Cliente {

    public  int contadorCliente;
    private  String id;
    private  String nombre;
    private  String direccion;
    private  String telefono;
    private boolean baja;

    
    public Cliente(String id, String nombre, String direccion, String telefono,boolean baja) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.baja = baja;

    }

    public String getId() {
        return id;
    }

    public  String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public boolean getBaja(){
        return baja;
    }

    public void  setId(String id) {
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDirecion(String direccion){
        this.direccion = direccion;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setBaja(boolean baja){
        this.baja = baja;
    }

    @Override
    public String toString() {

        return String.format(" id: %s,\n nombre: %s,\n Direccion: %s,\n Telefono: %s,\n baja: %s\n-----------------\n",
                this.id,
                this.nombre,
                this.direccion,
                this.telefono,
                this.baja);

    }

}
