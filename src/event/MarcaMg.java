

package event;

import entity.*;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.Date;
import java.util.List;
import static javax.print.attribute.Size2DSyntax.MM;
import org.hibernate.Query;


public class MarcaMg {
    
    public void guarfarMarca(Integer fab, String nom){
        Fabricante aFa;
        Marca aMa;
        try{
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Fabricante por clave
            aFa = (Fabricante) session.get(Fabricante.class, fab);
//Crear obj marca
            aMa = new Marca(aFa, nom);
            session.save(aMa);
            //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Marca almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Marca");
            exc.printStackTrace();
        }
    
    }
    
    public int countMarca(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idmarca) FROM  Marca e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Marca");
        return count;
    }
    
    public List listMarca(){
        List result = null;
        
        try{
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de pacientes
         result = session.createQuery("from Marca").list();
         //Confirmar transacción
            session.getTransaction().commit();
            session.close();
        }catch(Exception exc){
        System.out.print("Error en lectura objetos Marca");
            exc.printStackTrace();

        }
        return result;
    }
    
     public List listidma(){
        List result = null;
        try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.idmarca from Marca a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Marca");
            exc.printStackTrace();
        }        
        return result;
        
    
    }
    
     public Marca findMarcaNom(String nom){
    Marca mar=new Marca();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
        Query result=session.createQuery("from Marca p where p.nombre=:nam");
       result.setParameter("nam",nom);
       mar=(Marca)result.uniqueResult();
       session.close();
        System.out.println("Nombre de Marca leído" + mar.getNombre());
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Marca");
            exc.printStackTrace();
        } 
     return mar;
    }
 
     public Marca findMarcaid(int id){
    Marca mar=new Marca();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Marca p where p.id=:ida");
       result.setParameter("ida",id);
       mar=(Marca)result.uniqueResult();
       session.close();
       System.out.println("ID de Marca leído: " + mar.getIdmarca()+ "  Nombre: " + mar.getNombre());
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Marca");
            exc.printStackTrace();
        } 
    return mar;
    
    }
     
     public void deleteMarca(int idm){
    Marca mar=new Marca();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Marca p where p.idmarca=:idmar");
       result.setParameter("idmar",idm);
       mar=(Marca)result.uniqueResult();
       session.delete(mar);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Marca eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Marca");
            exc.printStackTrace();
        } 
}
     public void updateMarca(int idm, String nomMa, Fabricante fa){
    Marca mar=new Marca();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Marca p where p.idmarca=:idmar");
       result.setParameter("idmar",idm);
       mar=(Marca)result.uniqueResult();
       mar.setNombre(nomMa);
       mar.setFabricante(fa);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Marca actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Marca");
            exc.printStackTrace();
        } 
}
     
}

