
package entity;

import java.util.HashSet;
import java.util.Set;


public class Expendio implements java.io.Serializable {
    
private Integer idexpendio;
private String nombre;
private String rfc;
private String responsable;
private String estado;
private String municipio;
private String ubicacion;

private Set pedidos = new HashSet(0);
private Set ventas = new HashSet (0);
private Set inventarios = new HashSet(0);

public Expendio(){
    
}

    public Expendio(String nombre, String rfc, String responsable, 
            String estado, String municipio, String ubicacion) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.responsable = responsable;
        this.estado = estado;
        this.municipio = municipio;
        this.ubicacion = ubicacion;
    }

public Expendio(String nombre, String rfc, String responsable,
        String estado, String municipio, String ubicacion,
        Set pedidos, Set ventas, Set inventarios) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.responsable = responsable;
        this.estado = estado;
        this.municipio = municipio;
        this.ubicacion = ubicacion;
        this.pedidos = pedidos;
        this.ventas = ventas;
        this.inventarios = inventarios;
    }



    public Integer getIdexpendio() {
        return idexpendio;
    }

    public void setIdexpendio(Integer idexpendio) {
        this.idexpendio = idexpendio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
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

    public Set getVentas() {
        return ventas;
    }

    public void setVentas(Set ventas) {
        this.ventas = ventas;
    }

    public Set getInventarios() {
        return inventarios;
    }

    public void setInventarios(Set inventarios) {
        this.inventarios = inventarios;
    }



}
