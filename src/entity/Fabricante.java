

package entity;

import java.util.HashSet;
import java.util.Set;

public class Fabricante implements java.io.Serializable {
    
    private Integer idfabricante;
    private String nombre;
    private String estado;
    private String municipio;
    private String ubicacion;
    private Set pedidos = new HashSet(0);
    private Set marcas = new HashSet(0);
    
    public Fabricante(){
    }

    public Fabricante(String nombre, String estado, String municipio, String ubicacion) {
        this.nombre = nombre;
        this.estado = estado;
        this.municipio = municipio;
        this.ubicacion = ubicacion;
    }
    
     public Fabricante(String nombre, String estado, String municipio,
             String ubicacion, Set pedidos, Set marcas) {
        this.nombre = nombre;
        this.estado = estado;
        this.municipio = municipio;
        this.ubicacion = ubicacion;
        this.pedidos = pedidos;
        this.marcas = marcas;
    }
    
    
    
   /* public void printFabricante(){
        System.out.println("----\n"
                + "\nNombre: " + this.nombre
                +"\nDireccion: " + this.direccion);
    }
    */

   

    public Integer getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(Integer idfabricante) {
        this.idfabricante = idfabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Set getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }

    public Set getMarcas() {
        return marcas;
    }

    public void setMarcas(Set marcas) {
        this.marcas = marcas;
    }

            
    
}
