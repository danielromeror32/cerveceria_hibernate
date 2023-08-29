
package event;

import entity.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class IngredienteMg {
    
    
    
    public void guardarIngrediente (String nom,String des){
      
       Ingrediente aIn;
       try{
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Cerveza por clave
            
            aIn = new Ingrediente (nom, des);
            session.save(aIn);
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Ingrediente almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Ingrediente");
            exc.printStackTrace();
        }
       
    }
    
    
    public List listidIngrediente(){
        List result = null;
        try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.idingrediente from Ingrediente a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Ingrediente");
            exc.printStackTrace();
        }        
        return result;
    }
    
    
    public int countIngrediente(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idingrediente) FROM  Ingrediente e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Ingredientes");
        return count;
    }
    
    public void deleteIngrediente(int ide){
    Ingrediente ing = new Ingrediente();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Ingrediente p where p.idingrediente:idex");
       result.setParameter("idex",ide);
       ing=(Ingrediente)result.uniqueResult();
       session.delete(ing);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Ingrediente eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Ingrediente");
            exc.printStackTrace();
        } 
}
    
    public void updateIngrediente (int idi ,String nom,String des ){
    Ingrediente ing =new Ingrediente();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Ingrediente p where p.idingrediente=:iding");
       result.setParameter("iding",idi);
       ing=(Ingrediente)result.uniqueResult();
       ing.setNombre(nom);
       ing.setDescripcion(des);


       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Ingrediente actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Ingrediente");
            exc.printStackTrace();
        } 
}

    
     public Ingrediente findIngredienteid(int ide){
    Ingrediente ing =new Ingrediente();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Ingrediente p where p.idingrediente=:idex");
       result.setParameter("idex",ide);
       ing=(Ingrediente)result.uniqueResult();
       session.close();
       System.out.println("ID de Ingrediente leído");
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Ingrediente");
            exc.printStackTrace();
        } 
    return ing;
    
    }
    
      public Ingrediente findIngredienteNom(String nom){
    Ingrediente ing =new Ingrediente();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
        Query result=session.createQuery("from Ingrediente p where p.nombre=:nam");
       result.setParameter("nam",nom);
       ing=(Ingrediente)result.uniqueResult();
       session.close();
        System.out.println("Nombre de Ingrediente leído" );
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Ingrediente");
            exc.printStackTrace();
        } 
     return ing;
    }
    
}
