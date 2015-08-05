/*
 @authores : Eli y Dina
 */
package database.jdbc;

import entity.BaseEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryServicio extends QuerySQL{
    //implementar todos los metodos abstractos....
    @Override
     public BaseEntity getNewEntity(){
         return new entity.Servicio();
     }
     @Override
     public String getQuerySQL(TipoJdbc opcion){
          String s="";
          switch(opcion)
            { case readBASE_Entity  : s = "SELECT id_servicio,cod_servicio,nombre_servicio, preciounidad_servicio FROM servicio";
                                          break;
              case readLIST_ALL  : s = "SELECT id_servicio,cod_servicio,nombre_servicio, preciounidad_servicio FROM servicio"; break;
              case readListCOUNT : s = "SELECT Count(id_servicio) AS cant FROM servicio";break; 
              case writeINSERT   : s = "INSERT INTO servicio(id_servicio, cod_servicio,nombre_servicio, preciounidad_servicio) VALUES(?, ?, ?, ?)"; break;
              case writeUPDATE   : s = "UPDATE servicio SET cod_servicio = ?, nombre_servicio = ?, , preciounidad_servicio=? WHERE id_servicio = ? "; break;
              case writeDELETE   : s = "DELETE FROM servicio WHERE id_servicio = ?"; break;
              case readNewID     : s = "SELECT MAX(id_servicio)AS ID FROM servicio"; break;
            }
          return s;
     }
     @Override 
     public void copyDataToEntity(ResultSet rs, BaseEntity ent,
                                           TipoJdbc opcion){
        entity.Servicio en=null;
        if (ent instanceof entity.Servicio) {en= (entity.Servicio)ent;}    
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
                                    en.setA(rs.getString(3));
                                    en.setB(rs.getString(4));
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
         entity.Servicio en = (entity.Servicio)ent;    
         try {
               switch(opcion)
                  { case writeINSERT: 
                        { ps.setInt(1,    en.getId()); //Primer parametro
                          ps.setString(2, en.getNombre());  // Segundo parametro
                          ps.setString(3, en.getA()); 
                           ps.setString(4, en.getB()); 
                          break;
                        }
                   case writeUPDATE:
                        { ps.setString(1, en.getNombre()); // Primer parametro
                          ps.setString(2, en.getA());
                          ps.setString(3, en.getB());   
                          
                          ps.setInt(4,en.getId());// parametro
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
