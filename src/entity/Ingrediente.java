
package entity;

import java.util.HashSet;
import java.util.Set;


public class Ingrediente implements java.io.Serializable {
    
    private Integer idingrediente;
    private String nombre;
    private String descripcion;
    private Set recetas = new HashSet(0);
    
    public Ingrediente(){
    }
    
    public Ingrediente(String nombre, String descripcion ){
    
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
     public Ingrediente(String nombre, String descripcion, Set recetas ){
    
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.recetas = recetas;
    }
    
     public void printIngrediente(){
         System.out.println("----\n"
                 + "\nID: "+ this.idingrediente
                 + "\nNombre: " + this.nombre
                 + "\nDescripcion: "+ this.descripcion);
     
     }

    public Integer getIdingrediente() {
        return idingrediente;
    }

    public void setIdingrediente(Integer idingrediente) {
        this.idingrediente = idingrediente;
    }

     
    public Integer getIdIngrediente() {
        return idingrediente;
    }

    public void setIdIngrediente(Integer idingrediente) {
        this.idingrediente = idingrediente;
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

    public Set getRecetas() {
        return recetas;
    }

    public void setRecetas(Set recetas) {
        this.recetas = recetas;
    }

   
     
}
