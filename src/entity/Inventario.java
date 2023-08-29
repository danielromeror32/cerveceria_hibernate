
package entity;

import entity.Expendio;
import java.util.HashSet;
import java.util.Set;

public class Inventario implements java.io.Serializable {
    
    private Integer idinventario;
    private Expendio expendio;
    private Cerveza cerveza;
    private Integer cantidad;

    
    public Inventario (){
    
    }
    
    public Inventario (Integer cantidad, Expendio expendio, Cerveza cerveza){
    
        this.cantidad = cantidad;
        this.expendio = expendio;
        this.cerveza = cerveza;
    }
            
  

    public Integer getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(Integer idinventario) {
        this.idinventario = idinventario;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Expendio getExpendio() {
        return expendio;
    }

    public void setExpendio(Expendio expendio) {
        this.expendio = expendio;
    }

    public Cerveza getCerveza() {
        return cerveza;
    }

    public void setCerveza(Cerveza cerveza) {
        this.cerveza = cerveza;
    }


            
}
