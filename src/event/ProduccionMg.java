
package event;

import entity.*;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.Date;
import java.util.List;
import static javax.print.attribute.Size2DSyntax.MM;
import org.hibernate.Query;


public class ProduccionMg {
    
    public void guardarProduccion(Integer cer, Integer cant, String fech ){
    
        Cerveza aCe;
        Produccion aPr;
        try{
         Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Cerveza por clave
            aCe = (Cerveza) session.get(Cerveza.class, cer);
            aPr= new Produccion (aCe, cant, fech);
            session.save(aCe);
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Produccion almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Produccion");
            exc.printStackTrace();
        }

    }
    
    public int countProduccion(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idproduccion) FROM  Produccion e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Produccion");
        return count;
    }
    
    public Produccion findProduccionid(int id){
    Produccion pro=new Produccion();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Produccion p where p.id=:ida");
       result.setParameter("ida",id);
       pro=(Produccion)result.uniqueResult();
       session.close();
       System.out.println("ID de Produccion leído: " + pro.getIdproduccion());
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Produccion");
            exc.printStackTrace();
        } 
    return pro;
    
    }
    
     public void deleteProduccion(int idp){
    Produccion pro=new Produccion();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Produccion p where p.idproduccion=:idpro");
       result.setParameter("idpro",idp);
       pro=(Produccion)result.uniqueResult();
       session.delete(pro);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Produccion eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Produccion");
            exc.printStackTrace();
        } 
}
    
     public void updateProduccion(int idp, Cerveza cer, Integer cant,
                 String fecha){
    Produccion pro=new Produccion();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Produccion p where p.idproduccion=:idpro");
       result.setParameter("idpro",idp);
       pro=(Produccion)result.uniqueResult();
       pro.setCerveza(cer);
       pro.setCantidad(cant);
       pro.setFecha(fecha);
       
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Produccion actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Produccion");
            exc.printStackTrace();
        } 
}
      
     public List listidpro(){
        List result = null;
        try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.idproduccion from Produccion a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Produccion");
            exc.printStackTrace();
        }        
        return result;
        
    
    }
    
}
