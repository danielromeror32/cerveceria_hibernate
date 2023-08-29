/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.*;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.Date;
import java.util.List;
import static javax.print.attribute.Size2DSyntax.MM;
import org.hibernate.Query;


public class InventarioMg {
    
    public void guardarInventario(Integer exp, Integer cer, Integer cant){
        
        Expendio aEx;
        Cerveza aCe;
        Inventario aIn;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Cargar Fabricante por clave
            aEx = (Expendio) session.get(Expendio.class, exp);
            aCe = (Cerveza) session.get(Cerveza.class, cer);
//Crear obj marca
            aIn = new Inventario(cant,aEx,aCe);
            session.save(aIn);
            //Confirmar transacción
            session.getTransaction().commit();
            session.close();
            System.out.print("objeto Inventario almacenado");
        } catch (Exception exc) {
            System.out.print("Error en almacenamiento objeto Inventario");
            exc.printStackTrace();
        }
    }
    
    
    public int countInventario(){
        Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
        session.beginTransaction();
//Obtener valor max idexpendio
        Query result = session.createQuery("SELECT MAX(e.idinventario) FROM  Inventario e");
        int count = (int) result.uniqueResult();
        session.close();
        System.out.println("Existen " + count + " Inventario");
        return count;
    }
    
     public List listidinv(){
        List result = null;
        try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
//Obtener la lista de ids
            result = session.createQuery("select a.ininventario from Inventario a").list();
//Confirmar transacción
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception exc) {
            System.out.print("Error en lectura objetos Inventario");
            exc.printStackTrace();
        }        
        return result;
        
    }
     
      public Inventario findInventarioid(int id){
    Inventario inv=new Inventario();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Inventario p where p.id=:ida");
       result.setParameter("ida",id);
       inv=(Inventario)result.uniqueResult();
       session.close();
       System.out.println("ID de Inventario leído " );
     } catch (Exception exc) {
            System.out.print("Error en lectura de objeto Inventario");
            exc.printStackTrace();
        } 
    return inv;
    
    }
      
   public void deleteInventario(int idi){
    Inventario inv=new Inventario();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Inventario p where p.idinventario=:idinv");
       result.setParameter("idinv",idi);
       inv=(Inventario)result.uniqueResult();
       session.delete(inv);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print(" Objeto inventario eliminado ");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en eliminación de objeto inventario");
            exc.printStackTrace();
        } 
}
   
   public void updateInventario(int idi, Integer cant, Expendio ex, Cerveza ce){
    Inventario inv = new Inventario();
    try {
//Obtener la sesión actual
            Session session = HibernateUtil.getSessionFactory().openSession();
//Comenzar la transacción
            session.beginTransaction();
    Query result=session.createQuery("from Inventario p where p.idinventario=:idinv");
       result.setParameter("idinv",idi);
       inv=(Inventario)result.uniqueResult();
       inv.setCantidad(cant);
       inv.setExpendio(ex);
       inv.setCerveza(ce);
       //Confirmar transacción
            session.getTransaction().commit();
            System.out.print("Objeto Inventario actualizado");
            session.close();
     } catch (Exception exc) {
            System.out.print("Error en actualización de objeto Inventario");
            exc.printStackTrace();
        } 
}
   
    
}
