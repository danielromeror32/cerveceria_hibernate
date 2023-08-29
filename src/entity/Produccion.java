
package entity;

import java.util.HashSet;
import java.util.Set;

public class Produccion  implements java.io.Serializable {
    
    
    private Integer idproduccion;
    private Cerveza cerveza;
    private Integer cantidad;
    private String fecha;

    public Produccion(){
    }
    
    public Produccion( Cerveza cerveza, Integer cantidad, String fecha) {
      
        this.cerveza = cerveza;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    
    
   
    
    
    
    public Integer getIdproduccion() {
        return idproduccion;
    }

    public void setIdproduccion(Integer idproduccion) {
        this.idproduccion = idproduccion;
    }

    public Cerveza getCerveza() {
        return cerveza;
    }

    public void setCerveza(Cerveza cerveza) {
        this.cerveza = cerveza;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
