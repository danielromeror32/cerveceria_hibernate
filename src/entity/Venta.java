
package entity;
import entity.Expendio;
import java.util.Date;

public class Venta implements java.io.Serializable{
    
    private Integer idventa;
    private Expendio expendio;
    private Cerveza cerveza;
    private Integer cantidad;
    private String fecha;
    private Float precioUni;

   
    public Venta (){
        
    }
    
    
    public Venta (Expendio expendio, Cerveza cerveza, Integer cantidad,
            String fecha, Float precioUni){
        this.expendio = expendio;
        this.cerveza = cerveza;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.precioUni = precioUni;
        
    }
    
    public void printVenta(){
    
        System.out.println("----\n"
                + "\nID: " + this.idventa
                +"\nCantidad; " + this.cantidad
                +"\nFecha: " + this.fecha
                +"\nPrecio unidad: " + this.precioUni);
    }
    
    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
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

    public Float getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(Float precioUni) {
        this.precioUni = precioUni;
    }
    
    
    
}
