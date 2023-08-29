/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;


import entity.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class ExpendioMg {
    
    public void createAndStoreExp(String nom, String rfc, String respon,String est, String mun, String dir){
    
        try{
            //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Crear obj paciente
            Expendio exc = new Expendio(nom, rfc, respon, est, mun, dir);
            session.save(exc);
            //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Expendio almacenado");
            
        }catch(Exception exc){
            System.out.print("Error en almacenamiento objeto Expendio");
            exc.printStackTrace();
        }
    }
    
    public List listExpendio(){
        List result = null;
        
        try{
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de pacientes
         result = session.createQuery("from Expendio").list();
         //Confirmar transacción
            session.getTransaction().commit();
            session.close();
        }catch(Exception exc){
        System.out.print("Error en lectura objetos Expendio");
            exc.printStackTrace();

        }
        return result;
    }
    
     public List listidex(){
        List result = null;
        try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.idexpendio from Expendio a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Expendio");
            exc.printStackTrace();
        }        
        return result;
        
    
    }
    
    public int countExpendio(){
        System.out.println("listo ");
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idexpendio) FROM  Expendio e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Expendio");
        return count;
    
    }
    
    public List listidexp(){
        List result = null;
        try {
            //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.idexpendio from Expendio a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
        }catch(Exception exc){
        System.out.print("Error en lectura objetos Expendio");
            exc.printStackTrace();
        }    
        return result;
    }
    
     public Expendio findExpendioid(int ide){
    Expendio exp=new Expendio();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Expendio p where p.idexpendio=:idex");
       result.setParameter("idex",ide);
       exp=(Expendio)result.uniqueResult();
       session.close();
       System.out.println("ID de Expendio leído");
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Expendio");
            exc.printStackTrace();
        } 
    return exp;
    
    }
    
      public Expendio findExpendioNom(String nom){
    Expendio exp=new Expendio();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
        Query result=session.createQuery("from Expendio p where p.nombre=:nam");
       result.setParameter("nam",nom);
       exp=(Expendio)result.uniqueResult();
       session.close();
        System.out.println("Nombre de Expendio leído" );
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Expendio");
            exc.printStackTrace();
        } 
     return exp;
    }
    
      public void deleteExpendio(int ide){
    Expendio exp=new Expendio();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Expendio p where p.idexpendio=:idex");
       result.setParameter("idex",ide);
       exp=(Expendio)result.uniqueResult();
       session.delete(exp);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Expendio eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Expendio");
            exc.printStackTrace();
        } 
}
      
      public void updateExpendio(int ide, String nomEx, String rfc, String resp, String esta, String mun, String ubi){
    Expendio exp=new Expendio();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Expendio p where p.idexpendio=:idex");
       result.setParameter("idex",ide);
       exp=(Expendio)result.uniqueResult();
       exp.setNombre(nomEx);
       exp.setRfc(rfc);
       exp.setResponsable(resp);
       exp.setEstado(esta);
       exp.setMunicipio(mun);
       exp.setUbicacion(ubi);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Expendio actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Expendio");
            exc.printStackTrace();
        } 
}
      
}
