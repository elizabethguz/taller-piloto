/*

 */
package database.conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Conexion {
   static Connection conexion;
    //static String bd="D:/Proyectos 2013/Java/Practica 01 JDBC/Data/VENTASNET2011.FDB";
    static String bd="BaseSanjose";
    static String user="root";
    static String password="";
    static String server="jdbc:mysql://localhost/BaseSanJose";
    static String driver="org.gjt.mm.mysql.Driver";
    static int status=0;
/** Creates a new instance of BasedeDatos */

public Conexion() {
}
 
public boolean Open(){
   boolean ok=false;
   try{
       Class.forName(driver);
       conexion = DriverManager.getConnection(server,user,password);
       status = 1;
       ok = !conexion.isClosed();
       JOptionPane.showMessageDialog(null, "BIEN HECHO!!! ");
    }
   catch(Exception e){
        JOptionPane.showMessageDialog(null, "ERROR DE CONEXION");
        System.out.println("Imposible realizar conexion con la BD");
        e.printStackTrace();
        status=0;
    }
return ok;
}
public boolean Close(){
    boolean ok=false;
    if(conexion !=null)
       { try {
               conexion.close();
               status=0;
               ok = conexion.isClosed();
             }
         catch(Exception e){}
       }
    return ok;
  }
public boolean opened(){
    boolean ok;
    if(conexion ==null){return false;}
    try {
         ok = !conexion.isClosed();
        }
    catch(Exception e){
         ok = false;
        }
    return ok;
}
public boolean closed(){
    boolean ok;
    if(conexion ==null){return false;}
    try {
         ok = conexion.isClosed();
        }
    catch(Exception e){
         ok = false;
        }
    return ok;
}
public Connection getConexion(){
     return conexion;
}
//
//
//public void cerrar(ResultSet rs){
//     if(rs !=null)
//        {  try{
//               rs.close();
//              }
//           catch(Exception e){
//               System.out.print("No es posible cerrar la Conexion");
//              }
//        }
//}
// 
//public void cerrar(java.sql.Statement stmt){
//      if(stmt !=null)
//       {  try{
//               stmt.close();
//              }
//          catch(Exception e){}
//       }
//}
// 
}
