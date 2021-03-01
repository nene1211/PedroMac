/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasDatos;
import estructurasDatos.Enumerados.TipoMedicamento;

/**
 *
 * @author pedrovalero
 */
public class Medicamento extends Producto {

    private String comoTomar;
    private String efectosAdverso;
    private TipoMedicamento tipoMedicamento;

    public Medicamento(String codigo, String nombre, String descripcion, float precio,
        int unidades, boolean baja,TipoMedicamento tipoMedicamento, String comoTomar, String efectosAdversos){
        
        super(codigo, nombre, descripcion, precio, unidades);
        this.comoTomar = comoTomar;
        this.efectosAdverso = efectosAdversos;
        this.tipoMedicamento = tipoMedicamento;
    }
    
    public Medicamento (Medicamento medicamento){
        super(medicamento.getCodigo(),medicamento.getNombre(), medicamento.getDescripcion(), medicamento.getPrecio(), medicamento.getUnidades());
        
        this.tipoMedicamento = medicamento.tipoMedicamento;
        this.comoTomar = medicamento.comoTomar;
        this.efectosAdverso = medicamento.efectosAdverso;
    }
    
    public void setTipoMedicamento(TipoMedicamento tipoMedicamento){
        this.tipoMedicamento = tipoMedicamento;
        
    }
    
    public TipoMedicamento getTipoMedicamento(){
        
        return tipoMedicamento;
    }
    
    
    public String getEfectosAdversos() {
        return efectosAdverso;
    }

    public void setEfectosAversos(String efectosAversos) {
        this.efectosAdverso = efectosAversos;
    }

    public  String getComoTomar() {
        return comoTomar;
    }

    public void setComoTomar(String comoTomar) {
        this.comoTomar = comoTomar;
    }

    @Override
    public String toString() {
        return (super.toString() + " Tipo de Medicamento: " + tipoMedicamento + ", \nComo tomar: "+ comoTomar + ", \n Efectos adversos: "+ efectosAdverso+ "\n");
    }
}
