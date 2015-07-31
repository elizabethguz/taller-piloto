/*
 @authores : Eli y Dina
 */

package database.jdbc;

import entity.BaseEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class JdbcDatabase extends JdbcBase{

    /**
    * Inserta un objeto en la base de datos
    * @param entity
    */
     public int insert(BaseEntity entidad){
       setError("");
      int result=0;
       try {
             ConexionOpen();
//             System.out.println(entity.getQuerySQL(ActionJdbc.writeINSERT));
             Connection conn= Conexion();
             int affectedRows;
             try (PreparedStatement ps = conn.prepareStatement(query.getQuerySQL(TipoJdbc.writeINSERT))) {
                 query.copyToPreparedStatement(entidad, ps, TipoJdbc.writeINSERT);

                 affectedRows = ps.executeUpdate();
             }
             ConexionClose();
             if(affectedRows>0) {result=entidad.getId();}
            }
         catch (Exception e) {
             setError(e.getMessage());
             System.out.println(e.getMessage());
            }
       return result;
     }
    /**
    * Actualiza un objeto en la base de datos
    * @param entity
    */
     public int update(BaseEntity entidad){
       setError("");
      int result=0;
       try {
             ConexionOpen();
             Connection conn= Conexion();
             int affectedRows;
             try (PreparedStatement ps = conn.prepareStatement(query.getQuerySQL(TipoJdbc.writeUPDATE))) {
                 query.copyToPreparedStatement(entidad, ps, TipoJdbc.writeUPDATE);
                 affectedRows = ps.executeUpdate();
             }
             ConexionClose();
             if(affectedRows>0) {result=entidad.getId();}
            }
         catch (Exception e) {
             setError(e.getMessage());
             System.out.println(e.getMessage());
            }
       return result;
     }
         /**
    * Elimina un objeto en la base de datos
    * @param entity
    */
     public int delete(BaseEntity entidad){
       setError("");
      int result=0;
       try {
             ConexionOpen();
//             System.out.println(entity.getQuerySQL(ActionJdbc.writeINSERT));
             Connection conn= Conexion();
             int affectedRows;
             try (PreparedStatement ps = conn.prepareStatement(query.getQuerySQL(TipoJdbc.writeDELETE))) {
                 query.copyToPreparedStatement(entidad, ps, TipoJdbc.writeDELETE);
                 System.out.print(String.valueOf(entidad.getId()));
                 System.out.print(entidad.getNombre());
                 
                 affectedRows = ps.executeUpdate();
             }
             ConexionClose();
             if(affectedRows>0) {result=entidad.getId();}
            }
         catch (Exception e) {
             setError(e.getMessage());
             System.out.println(e.getMessage());
            }
       return result;
     }    
}
