
package entity;

import java.util.HashSet;
import java.util.Set;

public class Marca  implements java.io.Serializable{
    
    private Integer idmarca;
    private Fabricante fabricante;
    private String nombre;
    private Set cevezas = new HashSet(0);
   
    
    public Marca(){
        
    }
    
    public Marca (Fabricante fabricante, String nombre){
        //this.idmarca = idmarca;
        this.fabricante = fabricante;
        this.nombre = nombre;
        
    }
    
    public Marca (Fabricante fabricante, String nombre, Set cervezas){
        //this.idmarca = idmarca;
        this.fabricante = fabricante;
        this.nombre = nombre;
        this.cevezas = cervezas;
        
    }

    public Integer getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set getCevezas() {
        return cevezas;
    }

    public void setCevezas(Set cevezas) {
        this.cevezas = cevezas;
    }

 


}
