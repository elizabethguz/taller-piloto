/*
@authores : Eli y Dina
 */
package database.jdbc;

import entity.BaseEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryTipoCliente extends QuerySQL{
    //implementar todos los metodos abstractos....
    @Override
     public BaseEntity getNewEntity(){
         return new entity.TipoCliente();
     }
     @Override
     public String getQuerySQL(TipoJdbc opcion){
          String s="";
          switch(opcion)
            { case readBASE_Entity  : s = "SELECT id_tipocliente, ruc_tipocliente, nombre_tipocliente,descripcion_tipocliente FROM tipo_cliente";
                                          break;
              case readLIST_ALL  : s = "SELECT id_tipocliente, ruc_tipocliente, nombre_tipocliente,descripcion_tipocliente FROM tipo_cliente"; break;
              case readListCOUNT : s = "SELECT Count(id_tipocliente) AS cant FROM tipo_cliente";break; 
              case writeINSERT   : s = "INSERT INTO tipo_cliente(id_tipocliente, ruc_tipocliente, nombre_tipocliente,descripcion_tipocliente) VALUES(?, ?,?,?)"; break;
              case writeUPDATE   : s = "UPDATE tipo_cliente SET ruc_tipocliente= ?,nombre_tipocliente=  ?, descripcion_tipocliente= ? WHERE id_tipocliente= ? "; break;
              case writeDELETE   : s = "DELETE FROM tipo_cliente WHERE id_tipocliente= ?"; break;
              case readNewID     : s = "SELECT MAX(id_tipocliente)AS ID FROM tipo_cliente"; break;
            }
          return s;
     }
     @Override 
     public void copyDataToEntity(ResultSet rs, BaseEntity ent,
                                           TipoJdbc opcion){
        entity.TipoCliente en=null;
        if (ent instanceof entity.TipoCliente) {en= (entity.TipoCliente)ent;}    
        try{
         switch(opcion)
            { case readBASE_Entity: { ent.setId(rs.getInt(1));
                                      ent.setNombre(rs.getString(2));
                                      ent.setA(rs.getString(3));
                                      ent.setB(rs.getString(4));
                                      
                                      
                                      break;
                                   }
              case readLIST_ALL: {  en.setId(rs.getInt(1));
                                    en.setNombre(rs.getString(2));
                                    ent.setA(rs.getString(3));
                                    ent.setB(rs.getString(4));
                                    
                                    break;
                               }
              case   readNewID: {  en.setId(rs.getInt(1));
                                   break;
                                }
            }
        }
        catch(Exception e){
        }
     }
     @Override 
     public void copyToPreparedStatement(BaseEntity ent,
                            PreparedStatement ps,  TipoJdbc opcion){
         entity.TipoCliente en = (entity.TipoCliente)ent;    
         try {
               switch(opcion)
                  { case writeINSERT: 
                        { ps.setInt(1,    en.getId()); //Primer parametro
                          ps.setString(2, en.getNombre());  // Segundo parametro
                          ps.setString(3, en.getA());  // Tercer parametro
                          ps.setString(4, en.getB());  // Cuarto parametro
                          
                          
                          break;
                        }
                   case writeUPDATE:
                        { ps.setString(1, en.getNombre()); // Primer parametro
                          ps.setString(2, en.getA());
                          ps.setString(3, en.getB());
                          
                                                    
                          ps.setInt(4,    en.getId());// parametro
                          break;
                        }
                   case writeDELETE: 
                        { ps.setInt(1, en.getId()); // Primer parametro
                          break;
                        }
                 }
             }
       catch(Exception e){
          
          }
     }
}
