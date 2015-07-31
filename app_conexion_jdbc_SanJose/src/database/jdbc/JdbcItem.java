/*
@authores : Eli y Dina
 */

package database.jdbc;

import entity.BaseEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public class JdbcItem extends JdbcBase{

      /**
     * getItem: Metodo que retorna el item buscado (un registro)
     * <ul>
     *  <li>@param PropertyName: Nombre de la propiedad de busqueda
     *  <li>@param PropertyValue: Valor que tiene la propiedad del registro solicitado
     *  <li>       
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public Object getItem(String PropertyName,int PropertyValue){
         entity.BaseEntity result =null;
        error="";
        try {
             ConexionOpen();
             Connection conn= Conexion();
             String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
             
             PreparedStatement ps;
             sql = sql + " WHERE " +  PropertyName + " = ?";
             ps = conn.prepareStatement(sql);
             ps.setInt(1, PropertyValue);
             try (ResultSet rs = ps.executeQuery()) {
                 if (rs.next())
                     {   result = query.getNewEntity();
                         query.copyDataToEntity(rs, result, TipoJdbc.readLIST_ALL);
                     }
             }
             ps.close();
             ConexionClose();
            }
         catch (Exception e) {
            System.out.println(e.getMessage());
            }
       return result;
        }
     /**
     * getItem: Metodo que retorna el item buscado (un registro)
     * <ul>
     *  <li>@param PropertyName: Nombre de la propiedad de busqueda
     *  <li>@param PropertyValue: Valor que tiene la propiedad del registro solicitado
     *  <li>       
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */ 
    public Object getItem(String PropertyName,String PropertyValue){
        error=""; 
        entity.BaseEntity result =null;
        try {
             ConexionOpen();
             Connection conn= Conexion();
             String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
             
             PreparedStatement ps;
             sql = sql + " WHERE " +  PropertyName + " = ?";
             ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
             ps.setString(1, PropertyValue);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    {   result = query.getNewEntity();
                        query.copyDataToEntity(rs, result, TipoJdbc.readLIST_ALL);
                    }
            }
             ps.close();
             ConexionClose();
            }
         catch (Exception e) {
            System.out.println(e.getMessage());
            }
       return result;
        }
   /**
     * getItemLast: Metodo que retorna el ultimo item de la lista(un registro)
     * se supone que todos los items estan ordenados ascendentemente,
     * segun la propiedad "id" de los registros almacenados en la BD
     * @author Ing. Edwin Octavio Ramos Velasquez
     */     
      public Object getItemLast(String OrderBy){
        error=""; 
          entity.BaseEntity result =null;
        try {
             ConexionOpen();
             Connection conn= Conexion();
             PreparedStatement ps;
             if (OrderBy.length()>2) {
                ps = conn.prepareStatement(query.getQuerySQL(TipoJdbc.readLIST_ALL) + " ORDER BY " + OrderBy,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              }
             else {
                ps = conn.prepareStatement(query.getQuerySQL(TipoJdbc.readLIST_ALL),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             } 
              try (ResultSet rs = ps.executeQuery()) {
                  if (rs.last())
                      {   result = query.getNewEntity();
                          query.copyDataToEntity(rs, result, TipoJdbc.readLIST_ALL);
                      }
              }
             ps.close();
             ConexionClose();
            }
         catch (Exception e) {
            System.out.println(e.getMessage());
            }
       return result;
        }
    
}
