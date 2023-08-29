
package event;

import entity.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class RecetaMg {
    
     public void guardarReceta(Integer can, Integer ing,Integer cer){
       Ingrediente aIng;
       Cerveza aCe;
       Receta aRe;
       try{
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Cerveza por clave
            aIng = (Ingrediente) session.get(Ingrediente.class, ing);
            aCe = (Cerveza) session.get(Cerveza.class, cer);
            aRe = new Receta (can,aIng,aCe);
            session.save(aRe);
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Receta almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Receta");
            exc.printStackTrace();
        }
       
    }
    
    
    public List listReceta(){
        List result = null;
        
        try{
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de pacientes
         result = session.createQuery("from Receta").list();
         //Confirmar transacción
            session.getTransaction().commit();
            session.close();
        }catch(Exception exc){
        System.out.print("Error en lectura objetos Receta");
            exc.printStackTrace();

        }
        return result;
    }
    
    
    public int countReceta(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idreceta) FROM  Receta e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Receta");
        return count;
    }
    
    public void deleteReceta(int ide){
    Receta rec = new Receta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Receta p where p.idreceta=:idex");
       result.setParameter("idex",ide);
       rec=(Receta)result.uniqueResult();
       session.delete(rec);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Receta eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Receta");
            exc.printStackTrace();
        } 
}
    
    public void updateReceta (int idr ,Ingrediente in,Cerveza ce, int can){
    Receta rec =new Receta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Receta p where p.idrecetaa=:idrec");
       result.setParameter("idrec",idr);
       rec=(Receta)result.uniqueResult();
       rec.setCerveza(ce);
       rec.setIngrediente(in);
       rec.setCantidad(can);

       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Receta actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Receta");
            exc.printStackTrace();
        } 
}

    
     public Receta findRecetaid(int ide){
    Receta rec =new Receta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Receta p where p.idreceta=:idex");
       result.setParameter("idex",ide);
       rec=(Receta)result.uniqueResult();
       session.close();
       System.out.println("ID de Receta leído");
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Receta");
            exc.printStackTrace();
        } 
    return rec;
    
    }
    
      public Receta findRecetaNom(int nom){
    Receta rec =new Receta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
        Query result=session.createQuery("from Receta p where p.cantidad=:nam");
       result.setParameter("nam",nom);
       rec=(Receta)result.uniqueResult();
       session.close();
        System.out.println("Nombre de Receta leído" );
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Receta");
            exc.printStackTrace();
        } 
     return rec;
    }
    
      
    
}
