/*
 @authores : Eli y Dina
 */
package database.jdbc;

import entity.BaseEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryUsuario extends QuerySQL{
    //implementar todos los metodos abstractos....
    @Override
     public BaseEntity getNewEntity(){
         return new entity.Usuario();
     }
     @Override
     public String getQuerySQL(TipoJdbc opcion){
          String s="";
          switch(opcion)
            { case readBASE_Entity  : s = "SELECT `id_usuario`,`login_usuario`,`password_usuario` FROM usuario";
                                          break;
              case readLIST_ALL  : s = "SELECT `id_usuario`,`login_usuario`,`password_usuario` FROM usuario"; break;
              case readListCOUNT : s = "SELECT Count(id_usuario) AS cant FROM usuario";break; 
              case writeINSERT   : s = "INSERT INTO usuario(id_usuario, login_usuario,password_usuario) VALUES(?, ?, ?)"; break;
              case writeUPDATE   : s = "UPDATE usuario SET login_usuario = ?, password_usuario = ? WHERE id_usuario = ? "; break;
              case writeDELETE   : s = "DELETE FROM usuario WHERE id_usuario = ?"; break;
              case readNewID     : s = "SELECT MAX(id_usuario)AS ID FROM usuario"; break;
            }
          return s;
     }
     @Override 
     public void copyDataToEntity(ResultSet rs, BaseEntity ent,
                                           TipoJdbc opcion){
        entity.Usuario en=null;
        if (ent instanceof entity.Usuario) {en= (entity.Usuario)ent;}    
        try{
         switch(opcion)
            { case readBASE_Entity: { ent.setId(rs.getInt(1));
                                      ent.setNombre(rs.getString(2));
                                      ent.setA(rs.getString(3));
                                      
                                      break;
                                   }
              case readLIST_ALL: {  en.setId(rs.getInt(1));
                                    en.setNombre(rs.getString(2));
                                    en.setA(rs.getString(3));
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
         entity.Usuario en = (entity.Usuario)ent;    
         try {
               switch(opcion)
                  { case writeINSERT: 
                        { ps.setInt(1,    en.getId()); //Primer parametro
                          ps.setString(2, en.getNombre());  // Segundo parametro
                          ps.setString(3, en.getA()); 
                          
                          break;
                        }
                   case writeUPDATE:
                        { ps.setString(1, en.getNombre()); // Primer parametro
                          ps.setString(2, en.getA());
                                                  
                          ps.setInt(3,en.getId());// parametro
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
