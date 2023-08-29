
package entity;

import entity.Expendio;


public class Pedido implements java.io.Serializable {
    
    private Integer idpedido;
    private Expendio expendio;
    private Fabricante fabricante;
    private Cerveza cerveza;
    private Integer cantidad;
    private String fechaPedido;
    private String fechaEntrega;
    private Float precioUni;
    //private Integer noFactura;
    
    
    public Pedido (){
       
    }
    
    
    public Pedido (Expendio expendio, Fabricante fabricante, Cerveza cerveza,
            Integer cantidad, String fechaPedido, String fechaEntrega,
            Float precioUni){
        
        this.expendio = expendio;
        this.fabricante = fabricante;
        this.cerveza = cerveza;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.precioUni = precioUni;
}

    public void printPedido(){
        System.out.println("----\n"
                +"\nID: " +this.idpedido
                +"\nCantidad: " + this.cantidad
                +"\nFecha pedido: " + this.fechaPedido
                +"\nFecha entrega: " + this.fechaEntrega
                +"\nPrecio unidad: " + this.precioUni);
    }
    
    

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }
  

    public Expendio getExpendio() {
        return expendio;
    }

    public void setExpendio(Expendio expendio) {
        this.expendio = expendio;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
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

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Float getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(Float precioUni) {
        this.precioUni = precioUni;
    }

   /* public Integer getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(Integer noFactura) {
        this.noFactura = noFactura;
    }
    */
    
    
    
    
    
}
