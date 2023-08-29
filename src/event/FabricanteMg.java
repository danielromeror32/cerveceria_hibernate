

package event;


import entity.*;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.Query;

public class FabricanteMg {
    
    public void guardarFabricante( String nom, String esta, String mun,
            String ubi){
  
    try{
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();

//Crear obj marca
            Fabricante aFa = new Fabricante(nom,esta, mun, ubi);
            session.save(aFa);
            //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Fabricante almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Fabricante");
            exc.printStackTrace();
        }
    
    }
    
    public List listidfa(){
        List result = null;
        try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.idfabricante from Fabricante a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Fabricante");
            exc.printStackTrace();
        }        
        return result;
        
    
    }
    
    public int countFabricante(){
        System.out.println("listo ");
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idfabricante) FROM  Fabricante e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Fabricante");
        return count;
    
    }
    
    public Fabricante findFabricanteNom(String nom){
    Fabricante fab=new Fabricante();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Fabricante p where p.nombre=:nam");
       result.setParameter("nam",nom);
       fab=(Fabricante)result.uniqueResult();
       session.close();
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Fabricante");
            exc.printStackTrace();
        } 
    return fab;
    
    }
    
    public Fabricante findFabricanteid(int id){
    Fabricante fab=new Fabricante();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Fabricante p where p.id=:ida");
       result.setParameter("ida",id);
       fab=(Fabricante)result.uniqueResult();
       session.close();
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Fabricante");
            exc.printStackTrace();
        } 
    return fab;
    
    }
    
    public void deleteFabricante(int idfab){
    Fabricante fa=new Fabricante();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Fabricante p where p.idfabricante=:idfa");
       result.setParameter("idfa",idfab);
       fa=(Fabricante)result.uniqueResult();
       session.delete(fa);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Fabricante eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Fabricante");
            exc.printStackTrace();
        } 
}
    
     public void updateFabricante(int idf, String nom, String esta, String mun, String ubi){
    Fabricante fab=new Fabricante();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Fabricante p where p.idfabricante=:idfa");
       result.setParameter("idfa",idf);
       fab=(Fabricante)result.uniqueResult();
       fab.setNombre(nom);
       fab.setEstado(esta);
       fab.setMunicipio(mun);
       fab.setUbicacion(ubi);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Fabricante actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Fabricante");
            exc.printStackTrace();
        } 
}
    
    public void addFabricantetoMarca(Integer fab, Integer mar){
        
        try{
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar fabricante por clave
            Fabricante aFa = (Fabricante) session.load(Fabricante.class, fab);
            Marca aMa = (Marca) session.load(Marca.class, mar);
            
            aFa.getMarcas().add(aMa);
            
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
        }catch(Exception exc){
            System.out.print("Error Paciente");
            exc.printStackTrace();
        }
    }
    
    
    
    
}
