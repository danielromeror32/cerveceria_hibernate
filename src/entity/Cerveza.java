
package entity;

import java.util.HashSet;
import java.util.Set;

public class Cerveza implements java.io.Serializable {
    
    private Integer idcerveza;
    private Marca marca;
    private String nombre;
    private String presentacion;
    private String gradacion;
    private String tipo;
    private String aspecto;
    private String procedimientos;
    private Set produccciones = new HashSet(0);
    private Set pedidos = new HashSet(0);
    private Set ventas = new HashSet(0);
    private Set recetas = new HashSet(0);
    private Set inventarios = new HashSet(0);

 

  public Cerveza (){
        
    }
  
    public Cerveza(Marca marca, String nombre, 
            String presentacion, String gradacion, String tipo, String aspecto, 
            String procedimientos) {
        
        this.marca = marca;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.gradacion = gradacion;
        this.tipo = tipo;
        this.aspecto = aspecto;
        this.procedimientos = procedimientos;
    }
    
    public Cerveza(Marca marca, String nombre, 
            String presentacion, String gradacion, String tipo, String aspecto, 
            String procedimientos,Set pedidos,
            Set ventas, Set recetas, Set inventarios) {
        
        this.marca = marca;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.gradacion = gradacion;
        this.tipo = tipo;
        this.aspecto = aspecto;
        this.procedimientos = procedimientos;
        this.pedidos=pedidos;
        this.ventas = ventas;
        this.recetas = recetas;
        this.inventarios = inventarios;
    }
    
    
   /* public void printCerveza(){
        System.out.println("----\n"
                +"\nID: " + this.idcerveza
                +"\nNombre"+ this.nombre
                +"\nPresentacion: "+ this.presentacion
                +"\nGraduacion: "+ this.graduacion
                +"\nTipo: " + this.tipo
                +"\nAspecto: " + this.aspecto
                +"\nProcedimiento: " + this.procedimientos);
    }
    
  */
    public Integer getIdcerveza() {
     return idcerveza;
    }
 
    public void setIdcerveza(Integer idcerveza) {
        this.idcerveza = idcerveza;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getGradacion() {
        return gradacion;
    }

    public void setGradacion(String gradacion) {
        this.gradacion = gradacion;
    }

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAspecto() {
        return aspecto;
    }

    public void setAspecto(String aspecto) {
        this.aspecto = aspecto;
    }

    public String getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(String procedimientos) {
        this.procedimientos = procedimientos;
    }

    public Set getProduccciones() {
        return produccciones;
    }

    public void setProduccciones(Set produccciones) {
        this.produccciones = produccciones;
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

    public Set getRecetas() {
        return recetas;
    }

    public void setRecetas(Set recetas) {
        this.recetas = recetas;
    }

    public Set getInventarios() {
        return inventarios;
    }

    public void setInventarios(Set inventarios) {
        this.inventarios = inventarios;
    }
    
    
}
