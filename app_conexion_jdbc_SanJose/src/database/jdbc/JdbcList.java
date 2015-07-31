/*
@authores : Eli y Dina
 */
package database.jdbc;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * HibernateList es una clase que retorna un conjunto de registros
 * (listas) obtenidos de la Base de Datos
 * 
 *
 * @author Ing. Edwin Octavio Ramos Velasquez
 */
public class JdbcList extends JdbcBase{


    /**
        * Obtener la lista de registros para una query
        * @return
    */
     public List getList(String[] OrderBy){
           List result = new ArrayList();
           String _OrderBy = ArrayToString(OrderBy);
           try {
                 ConexionOpen();
                 Connection conn= Conexion();
                 String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
                 if (_OrderBy.length()>1) {sql = sql + " ORDER BY " + _OrderBy;}
                 PreparedStatement ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                 //-----------------------------------
                 try {ResultSet rs = ps.executeQuery();
                   while (rs.next())
                       {   entity.BaseEntity p = query.getNewEntity();
                           query.copyDataToEntity(rs, p, TipoJdbc.readLIST_ALL);
                           result.add(p);
                       }
                    }
                 catch(Exception e){}
               //------------------------------------
                 ConexionClose();
                }
             catch (Exception e) {
                System.out.println(e.getMessage());
                }
           return result;
       }
         /**
        * Obtener la lista de registros para una query
        * @return
    */
     public List getList(String[] OrderBy, String FilterSQL){
           List result = new ArrayList();
           String _OrderBy = ArrayToString(OrderBy);
           try {
                 ConexionOpen();
                 Connection conn= Conexion();
                 String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
                 if (FilterSQL.length()>1) {sql = sql + " WHERE " + FilterSQL;}
                 if (_OrderBy.length()>1) {sql = sql + " ORDER BY " + _OrderBy;}
                 PreparedStatement ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
              //----------------------------------------------
                 try 
                   { ResultSet rs = ps.executeQuery();
                       while (rs.next())
                       {   entity.BaseEntity p = query.getNewEntity();
                           query.copyDataToEntity(rs, p, TipoJdbc.readLIST_ALL);
                           result.add(p);
                       }
                    }
                  catch(Exception e){}
               //----------------------------------------------
                 ConexionClose();
                }
             catch (Exception e) {
                System.out.println(e.getMessage());
                }
           return result;
       }
         /**
        * Obtener la lista de registros para una query
        * @return
    */
     public List getListCBO(String[] OrderBy){
           List result = new ArrayList();
           String _OrderBy = ArrayToString(OrderBy);
           try {
                 ConexionOpen();
                 Connection conn= Conexion();
                 String sql =query.getQuerySQL(TipoJdbc.readBASE_Entity);
                 if (_OrderBy.length()>1) {sql = sql + " ORDER BY " + _OrderBy;}
                 PreparedStatement ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                 //-----------------------------------
                 try {ResultSet rs = ps.executeQuery();
                   while (rs.next())
                       {   entity.BaseEntity p = new entity.BaseEntity();
//                           p.setId(rs.getInt(1));
//                           p.setNombre(rs.getString(2));
                           query.copyDataToEntity(rs, p, TipoJdbc.readBASE_Entity);
                           result.add(p);
                       }
                    }
                 catch(Exception e){}
               //------------------------------------
                 ConexionClose();
                }
             catch (Exception e) {
                System.out.println(e.getMessage());
                }
           return result;
       }
        /**
        * Retorna un numero escalar que indica la Cantidad
        * de registros existentes en la Base de datos
        * @return
        */
       public int getListCount() {
         int result = 0;
         try {
              ConexionOpen();
              Connection conn= Conexion();
              try {
                   PreparedStatement ps = conn.prepareStatement(query.getQuerySQL(TipoJdbc.readListCOUNT)); 
                   ResultSet rs = ps.executeQuery();
                   if (rs.next())
                         {   result= rs.getInt(1);  }
                  }
              catch(Exception e){}
              ConexionClose();
            }
         catch (Exception e) {
            System.out.println(e.getMessage());
            }
       return result;
        }

     /**
     * El metoso getList retorna un conjunto de registros ajustados a los filtro seleccionados
     * el nùmero total de elementos que se ajustan al patron requerido
     * <ul>
     *  <li>@param PropertyName: Nombre del campo utilizado en el filtrado
     *  <li>@param PropertyValue: Valor que debe tener el campo mencionado de los registros solicitados
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public List getList(String PropertyName, int PropertyValue){
          return getList(new String[0], PropertyName, PropertyValue);
     }
     /**
     * El metoso getList retorna un conjunto de registros ajustados a los filtro seleccionados
     * el nùmero total de elementos que se ajustan al patron requerido
     * <ul>
     *  <li>@param OrderBy[]: Campos utilizados para ordenar los registros requeridos
     *  <li>@param PropertyName: Nombre del campo utilizado en el filtrado
     *  <li>@param PropertyValue: Valor que debe tener el campo mencionado de los registros solicitados
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public List getList(String[] OrderBy, String FilterPropertyName, int FilterPropertyValue){
     List result = new ArrayList();
       try {
             ConexionOpen();
             Connection conn= Conexion();
             String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
             
             String _OrderBy = ArrayToString(OrderBy);
             
             PreparedStatement ps;
             // Opciones de filtrado
             if (FilterPropertyName.length()>0)
                { sql = sql + " WHERE " +  FilterPropertyName + " = ?";
                  if (_OrderBy.trim().length()>0)
                      { sql = sql + " ORDER BY " + _OrderBy;
                      }
                  ps = conn.prepareStatement(sql);
                  ps.setInt(1, FilterPropertyValue);
                }
             else 
                { 
                    if (_OrderBy.trim().length() > 0)
                      { sql = sql + " ORDER BY " + _OrderBy;
                      }
                    ps = conn.prepareStatement(sql);
                }
             // Campos por los cuales ordenar los resultados
             try (ResultSet rs = ps.executeQuery()) {
                 while (rs.next())
                     {   entity.BaseEntity p = query.getNewEntity();
                         query.copyDataToEntity(rs, p, TipoJdbc.readLIST_ALL);
                         result.add(p);
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
     * El metoso getList retorna un conjunto de registros ajustados a los filtro seleccionados
     * el nùmero total de elementos que se ajustan al patron requerido
     * <ul>
     *  <li>@param OrderBy[]: Campos utilizados para ordenar los registros requeridos
     *  <li>@param PropertyName[]: Nombre de los campos de enteros utilizados en el filtrado
     *  <li>@param PropertyValue[]: Valor que deben tener los campos de los registros solicitados
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public List getList(String[] OrderBy, String[] FilterPropertyName, int []FilterPropertyValue){
     List result = new ArrayList();
       try {
             ConexionOpen();
             Connection conn= Conexion();
             String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
             // Campos por los cuales ordenar los resultados

             String _OrderBy = ArrayToString(OrderBy);
             
             PreparedStatement ps;
             // Opciones de filtrado
             if (FilterPropertyName.length>0)
                { sql = sql + " WHERE " ;
                  for (int i=0;i<FilterPropertyName.length;i++)
                     {  if (i>0) {sql = sql + " AND ";}
                        sql = sql +  FilterPropertyName[i] + " = ?";
                     }
                  if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                  for (int i=0;i<FilterPropertyName.length;i++)
                     { ps.setInt(i+1, FilterPropertyValue[i] );
                     }
                }
             else 
                { if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                }
             try (ResultSet rs = ps.executeQuery()) {
                 while (rs.next())
                     {   entity.BaseEntity p = query.getNewEntity();
                         query.copyDataToEntity(rs, p, TipoJdbc.readLIST_ALL);
                         result.add(p);
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
     
     //------------------------------------------------------
     /**
     * El metoso getList retorna un conjunto de registros ajustados a los filtro seleccionados
     * el nùmero total de elementos que se ajustan al patron requerido
     * <ul>
     *  <li>@param OrderBy[]: Campos utilizados para ordenar los registros requeridos
     *  <li>@param PropertyName[]: Nombre de los campos de enteros utilizados en el filtrado
     *  <li>@param PropertyValue[]: Valor que deben tener los campos de los registros solicitados
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public List getList(String[] OrderBy, String[] PropertyName, String[] PropertyValue){
       List result = new ArrayList();
       try {
             ConexionOpen();
             Connection conn= Conexion();
             String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
             String _OrderBy = ArrayToString(OrderBy);
             
             PreparedStatement ps;
             // Opciones de filtrado
             if (PropertyName.length>0)
                { sql = sql + " WHERE " ;
                  for (int i=0;i<PropertyName.length;i++)
                     {  if (i>0) {sql = sql + " AND ";}
                        sql = sql +  PropertyName[i] + " = ?";
                     }
                  if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                  for (int i=0;i<PropertyName.length;i++)
                     { ps.setString(i+1, PropertyValue[i] );
                     }
                }
             else 
                { if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                }
            
             // Campos por los cuales ordenar los resultados
             try (ResultSet rs = ps.executeQuery()) {
                 while (rs.next())
                     {   entity.BaseEntity p = query.getNewEntity();
                         query.copyDataToEntity(rs, p, TipoJdbc.readLIST_ALL);
                         result.add(p);
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
     * El metoso getList retorna un conjunto de registros ajustados a los filtro seleccionados
     * el nùmero total de elementos que se ajustan al patron requerido
     * <ul>
     *  <li>@param OrderBy[]: Campos utilizados para ordenar los registros requeridos
     *  <li>@param PropertyName: Nombre del campo utilizado en el filtrado
     *  <li>@param PropertyValue: Valor que debe tener el campo mencionado de los registros solicitados
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public List getList(String[] OrderBy, String PropertyName, String PropertyValue){
          List result = new ArrayList();
          try {
             ConexionOpen();
             Connection conn= Conexion();
             String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
             // Campos por los cuales ordenar los resultados
             String _OrderBy = ArrayToString(OrderBy);
             
             PreparedStatement ps;
             // Opciones de filtrado
             if (PropertyName.length()>0)
                { sql = sql + " WHERE " + PropertyName + " = ?";
                  if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                  ps.setString(1, PropertyValue);
                }
             else 
                { if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                }
             try (ResultSet rs = ps.executeQuery()) {
                 while (rs.next())
                     {   entity.BaseEntity p = query.getNewEntity();
                         query.copyDataToEntity(rs, p, TipoJdbc.readLIST_ALL);
                         result.add(p);
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
     * El metoso getListLIKE retorna un conjunto de registros ajustados a los filtros seleccionados
     * usando la funcion LIKE el nùmero total de elementos que se ajustan al patron requerido
     * <ul>
     *  <li>@param OrderBy[]: Campos utilizados para ordenar los registros requeridos
     *  <li>@param PropertyName[]: Nombre de los campos de enteros utilizados en el filtrado
     *  <li>@param PropertyValue[]: Valor que deben tener los campos de los registros solicitados
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public List getListLIKE(String[] OrderBy, String[] PropertyName, String[] PropertyValue){
       List result = new ArrayList();
       try {
             ConexionOpen();
             Connection conn= Conexion();
             String sql =query.getQuerySQL(TipoJdbc.readLIST_ALL);
             String _OrderBy = ArrayToString(OrderBy);
             
             PreparedStatement ps;
             // Opciones de filtrado
             if (PropertyName.length>0)
                { sql = sql + " WHERE " ;
                  for (int i=0;i<PropertyName.length;i++)
                     {  if (i>0) {sql = sql + " AND ";}
                        sql = sql +  PropertyName[i] + " = '"+ PropertyValue[i]+ "%'";
                     }
                  if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                }
             else 
                { if (_OrderBy.trim().length()>0){sql = sql + " ORDER BY " + _OrderBy;}
                  ps = conn.prepareStatement(sql,ResultSet.FETCH_FORWARD, ResultSet.CONCUR_READ_ONLY);
                }
            
             // Campos por los cuales ordenar los resultados
             try (ResultSet rs = ps.executeQuery()) {
                 while (rs.next())
                     {   entity.BaseEntity p = query.getNewEntity();
                         query.copyDataToEntity(rs, p, TipoJdbc.readLIST_ALL);
                         result.add(p);
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
     * El metoso getList retorna un conjunto de registros ajustados a los filtro seleccionados
     * el nùmero total de elementos que se ajustan al patron requerido
     * <ul>
     *  <li>@param PropertyName: Nombre del campo utilizado en el filtrado
     *  <li>@param PropertyValue: Valor que debe tener el campo mencionado de los registros solicitados
     * </ul>
     * @author Ing. Edwin Octavio Ramos Velasquez
     */
     public List getList(String PropertyName, String PropertyValue){
         return getList(new String[0], PropertyName, PropertyValue);
     }
}
