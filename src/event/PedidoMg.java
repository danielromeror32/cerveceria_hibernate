
package event;

import entity.*;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.Date;
import java.util.List;
import static javax.print.attribute.Size2DSyntax.MM;
import org.hibernate.Query;

public class PedidoMg {
    
    
    public void guardarPedido (Integer exp, Integer fab, Integer cer,
            Integer can, String ped, String ent,Float pre){
       Expendio aEx;
       Fabricante aFa;
       Cerveza aCe;
       Pedido aPe;
       try{
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Cerveza por clave
            aEx = (Expendio) session.get(Expendio.class, exp);
            aFa = (Fabricante) session.get(Fabricante.class, fab);
            aCe = (Cerveza) session.get(Cerveza.class, cer);
            aPe = new Pedido (aEx, aFa, aCe,can, ped, ent, pre);
            session.save(aPe);
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Pedido almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Pedido");
            exc.printStackTrace();
        }
       
    }
    
    
    public List listPedido(){
        List result = null;
        
        try{
        //Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de pacientes
         result = session.createQuery("from Pedido").list();
         //Confirmar transacción
            session.getTransaction().commit();
            session.close();
        }catch(Exception exc){
        System.out.print("Error en lectura objetos Pedido");
            exc.printStackTrace();

        }
        return result;
    }
    
     public Pedido findPedidoid(int ide){
    Pedido ped =new Pedido();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Pedido p where p.idpedido=:idex");
       result.setParameter("idex",ide);
       ped=(Pedido)result.uniqueResult();
       session.close();
       System.out.println("ID de Pedido leído");
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Pedido");
            exc.printStackTrace();
        } 
    return ped;
    
    }
     
     public Pedido findPedidoNom(int nom){
    Pedido ped =new Pedido();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
        Query result=session.createQuery("from Pedido p where p.cantidad=:nam");
       result.setParameter("nam",nom);
       ped=(Pedido)result.uniqueResult();
       session.close();
        System.out.println("Nombre de Pedido leído" );
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Pedido");
            exc.printStackTrace();
        } 
     return ped;
    }
    
    
    public int countPedido(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idpedido) FROM  Pedido e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Pedidos");
        return count;
    }
    
    public void deletePedido(int ide){
    Pedido ped = new Pedido();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Pedido p where p.idpedido=:idex");
       result.setParameter("idex",ide);
       ped=(Pedido)result.uniqueResult();
       session.delete(ped);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto Pedido eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto Pedido");
            exc.printStackTrace();
        } 
}
    
    public void updatePedido (int idp ,Expendio ex,Fabricante fa,
             Cerveza ce, int can, String fPed, String fEnt, float pre){
    Pedido ped =new Pedido();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Pedido p where p.idPedido=:idped");
       result.setParameter("idped",idp);
       ped=(Pedido)result.uniqueResult();
       ped.setExpendio(ex);
       ped.setFabricante(fa);
       ped.setCerveza(ce);
       ped.setCantidad(can);
       ped.setFechaPedido(fPed);
       ped.setFechaEntrega(fEnt);
       ped.setPrecioUni(pre);

       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto pedido actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto pedido");
            exc.printStackTrace();
        } 
}

    
    
    
}
