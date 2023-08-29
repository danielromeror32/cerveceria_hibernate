
package entity;

import java.util.HashSet;
import java.util.Set;

public class Receta implements java.io.Serializable {

     private Integer idreceta;
     private Integer cantidad;
     private Ingrediente ingrediente;
     private Cerveza cerveza;
     
     
     public Receta(){
     
     }        
     
     public Receta(Integer cantidad, Ingrediente ingrediente, Cerveza cerveza){
     
         this.cantidad = cantidad;  
         this.ingrediente = ingrediente;
         this.cerveza = cerveza;
     
     }
     
     

    public Integer getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(Integer idreceta) {
        this.idreceta = idreceta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Cerveza getCerveza() {
        return cerveza;
    }

    public void setCerveza(Cerveza cerveza) {
        this.cerveza = cerveza;
    }
     
     
             
}
