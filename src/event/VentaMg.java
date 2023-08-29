
package event;
import entity.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class VentaMg {

    public void guardarVenta (Integer exp, Integer cer,Integer can, 
            String fech, Float pre){
       Expendio aEx;
       Cerveza aCe;
       Venta aVe;
       try{
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Cerveza por clave
            aEx = (Expendio) session.get(Expendio.class, exp);
            aCe = (Cerveza) session.get(Cerveza.class, cer);
            aVe = new Venta (aEx,aCe, can, fech, pre);
            session.save(aVe);
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Venta almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Venta");
            exc.printStackTrace();
        }
       
    }
    
    
    public List listVenta(){
        List result = null;
        
        try{
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de pacientes
         result = session.createQuery("from Venta").list();
         //Confirmar transacción
            session.getTransaction().commit();
            session.close();
        }catch(Exception exc){
        System.out.print("Error en lectura objetos Venta");
            exc.printStackTrace();

        }
        return result;
    }
    
    
    public int countVenta(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idventa) FROM  Venta e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Ventas");
        return count;
    }
    
    public void deleteVenta(int ide){
    Venta ven = new Venta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Venta p where p.idventa=:idex");
       result.setParameter("idex",ide);
       ven=(Venta)result.uniqueResult();
       session.delete(ven);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Venta eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Venta");
            exc.printStackTrace();
        } 
}
    
    public void updateVenta (int idv ,Expendio ex,Cerveza ce, int can, 
            String fecha,float pre){
    Venta ven =new Venta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Venta p where p.idventa=:idped");
       result.setParameter("idven",idv);
       ven=(Venta)result.uniqueResult();
       ven.setExpendio(ex);
       ven.setCerveza(ce);
       ven.setCantidad(can);
       ven.setFecha(fecha);
       ven.setPrecioUni(pre);

       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Venta actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Venta");
            exc.printStackTrace();
        } 
}

    
     public Venta findVentaid(int ide){
    Venta ven =new Venta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Venta p where p.idventa=:idex");
       result.setParameter("idex",ide);
       ven=(Venta)result.uniqueResult();
       session.close();
       System.out.println("ID de Venta leído");
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Venta");
            exc.printStackTrace();
        } 
    return ven;
    
    }
    
      public Venta findVentaNom(int nom){
    Venta ven =new Venta();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
        Query result=session.createQuery("from Venta p where p.cantidad=:nam");
       result.setParameter("nam",nom);
       ven=(Venta)result.uniqueResult();
       session.close();
        System.out.println("Nombre de Venta leído" );
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Venta");
            exc.printStackTrace();
        } 
     return ven;
    }
    
      
}
