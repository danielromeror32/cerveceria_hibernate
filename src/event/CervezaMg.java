
package event;

import entity.*;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.Date;
import java.util.List;
import static javax.print.attribute.Size2DSyntax.MM;
import org.hibernate.Query;

public class CervezaMg {
    
    public void guardarCerveza(Integer mar, String nom, String pres, String grad,
                String tip, String aspe, String proce){
        Marca aMa;
        Cerveza aCe;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Cerveza por clave
            aMa = (Marca) session.get(Marca.class, mar);
            aCe= new Cerveza (aMa, nom, pres, grad, tip, aspe, proce);
            session.save(aCe);
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Cerveza almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Cerveza");
            exc.printStackTrace();
        }
    }
    
    public int countCerveza(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idcerveza) FROM  Cerveza e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Cerveza");
        return count;
    }
    
    public List listidce(){
        List result = null;
        try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.idcerveza from Cerveza a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Cerveza");
            exc.printStackTrace();
        }        
        return result;
        
    
    }
    
     public Cerveza findCervezaNom(String nom){
    Cerveza cer=new Cerveza();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
        Query result=session.createQuery("from Cerveza p where p.nombre=:nam");
       result.setParameter("nam",nom);
       cer=(Cerveza)result.uniqueResult();
       session.close();
        System.out.println("Nombre de Cerveza leído" + cer.getNombre());
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Cerveza");
            exc.printStackTrace();
        } 
     return cer;
    }
    
      public Cerveza findCervezaid(int id){
    Cerveza cer=new Cerveza();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Cerveza p where p.id=:ida");
       result.setParameter("ida",id);
       cer=(Cerveza)result.uniqueResult();
       session.close();
       System.out.println("ID de Cerveza leído: " + cer.getIdcerveza());
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Cerveza");
            exc.printStackTrace();
        } 
    return cer;
    
    }
     
       public void deleteCerveza(int idc){
    Cerveza cer=new Cerveza();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Cerveza p where p.idcerveza=:idcer");
       result.setParameter("idcer",idc);
       cer=(Cerveza)result.uniqueResult();
       session.delete(cer);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Cerveza eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Cerveza");
            exc.printStackTrace();
        } 
}
      public void updateCerveza(int idc, Marca mar,String nom, String pres, String grad, String tip,
                String asp, String proce){
    Cerveza cer=new Cerveza();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Cerveza p where p.idcerveza=:idcer");
       result.setParameter("idcer",idc);
       cer=(Cerveza)result.uniqueResult();
       cer.setNombre(nom);
       cer.setMarca(mar);
       cer.setPresentacion(pres);
       cer.setGradacion(grad);
       cer.setTipo(tip);
       cer.setAspecto(asp);
       cer.setProcedimientos(proce);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Cerveza actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Cerveza");
            exc.printStackTrace();
        } 
}
      
      
      
}
