/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasDatos;

import estructurasDatos.Enumerados.Categoria;

/**
 *
 * @author pedrovalero
 */
public class ParaFarmacia extends Producto {
    private Categoria categoria;
    private int dosisUnidades;
    private float descuento;

    public ParaFarmacia(String codigo, String nombre, String descripcion, float precio, int unidades,Categoria categoria, int dosisUnidades, float descuento) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.categoria = categoria;
        this.descuento = descuento;
        this.dosisUnidades = dosisUnidades;
    }

    public ParaFarmacia (ParaFarmacia paraFarmacia){
        super(paraFarmacia.getCodigo(), paraFarmacia.getNombre(), paraFarmacia.getDescripcion(),paraFarmacia.getPrecio(), paraFarmacia.getUnidades());
        this.categoria = paraFarmacia.categoria;
        this.descuento = paraFarmacia.descuento;
        this.dosisUnidades = paraFarmacia.dosisUnidades;
    }
    

    public Categoria categoria(){
        return categoria;
    }
    
    public void setModificarCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public int getDosisUnidades(){
        return dosisUnidades;
    }
    
    public void setDosisUnidades(int dosisUnidades){
        this.dosisUnidades = dosisUnidades;
    }
    
    public float getDescuento(){
        return descuento;
    }
    
    public void setDescuento(float descuento){
        this.descuento = descuento;
    }
    
    @Override
        public String toString() {
        return String.format(" codigo: %s,\n nombre: %s,\n Descripcion: %s,\n Precio: %.2f,\n Unidades: %s,\n baja: %s, \n Categoria: %s, \n Dosis o unidades: %s, \n Efectos adversos: %f \n",
                getCodigo(),
                getNombre(),
                getDescripcion(),
                getPrecio(),
                getUnidades(),
                getBaja(),
                this.categoria,
                this.dosisUnidades,
                this.descuento);
    }
    
}
