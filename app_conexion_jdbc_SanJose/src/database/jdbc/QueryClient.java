/*
 @authores : Eli y Dina
 */
package database.jdbc;

import entity.BaseEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryClient extends QuerySQL {
    //implementar todos los metodos abstractos....
     public QueryClient(){
        setEntity(new entity.Client());
     }
     @Override
     public BaseEntity getNewEntity(){
         return new entity.Client();
     }
     @Override
     public String getQuerySQL(TipoJdbc opcion){
          String s="";
          switch(opcion)
            {  case readBASE_Entity: s = "SELECT id_cliente, dni_cliente, nombre_cliente, sexo_cliente "
                                         + ",correo_cliente, celular_cliente, cargo_cliente, descripcion_cliente "
                                         + "FROM cliente";
                                       break;
                
              case readLIST_ALL  :  s = "SELECT E.id_cliente, E.dni_cliente, E.nombre_cliente, E.sexo_cliente"
                                         + ",E.correo_cliente, E.celular_cliente, E.cargo_cliente, E.descripcion_cliente"
                                         + ", E.id_tipocliente, ruc_tipocliente FROM BaseSanjose.tipo_cliente AS V"
                                         + "INNER JOIN BaseSanjose.cliente AS E ON (V.id_tipocliente = E.id_tipocliente)";break;
                  
              case readListCOUNT : s = "SELECT COUNT(*)AS ID FROM cliente"; break; 
              case writeINSERT   : s = "INSERT INTO cliente (id_cliente, dni_cliente, nombre_cliente, sexo_cliente "
                                         + ",correo_cliente, celular_cliente, cargo_cliente, descripcion_cliente, id_tipocliente ) "
                                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"; 
                                            break;
              case writeUPDATE   : s = "UPDATE dni_cliente=?, nombre_cliente=?, sexo_cliente=? "
                                         + ",correo_cliente=?, celular_cliente=?, cargo_cliente=?, descripcion_cliente=?, id_tipocliente=? WHERE id_cliente=? "; break;
              case writeDELETE   : s = "DELETE FROM cliente WHERE id_cliente = ?"; break;
              case readNewID     : s = "SELECT MAX(id_cliente)AS ID FROM cliente"; break;
            }
          return s;
     }
     @Override
     public void copyDataToEntity(ResultSet rs, BaseEntity ent, TipoJdbc opcion){
        entity.Client en=null;
        if (ent instanceof entity.Client) {en= (entity.Client)ent;} 
        try{
         switch(opcion)
            { case readBASE_Entity: { ent.setId(rs.getInt(1));
                                      ent.setNombre(rs.getString(2));
                                      ent.setA(rs.getString(3));
                                      ent.setB(rs.getString(4));
                                      ent.setC(rs.getString(5));
                                      ent.setD(rs.getString(6));
                                      ent.setE(rs.getString(7));
                                      ent.setF(rs.getString(8));
                                      
                                      break;
                                     }
              case readLIST_ALL: {  en.setId(rs.getInt(1));
                                    en.setNombre(rs.getString(2));//DNI
                                    en.setA(rs.getString(3));//NOMBRE
                                    en.setB(rs.getString(4));//SEXO
                                    en.setC(rs.getString(5));//CORREO
                                    en.setD(rs.getString(6));//CELULRR
                                    en.setE(rs.getString(7));//CARGO
                                    en.setF(rs.getString(8));//DESCRIPCION
                                    en.TipoCliente.setId(rs.getInt(9));//ID_TIPO_CLIENTE
                                    en.TipoCliente.setNombre(rs.getString(10));//NOMBRE TIPO_CLIENTE
                                    
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
     public void copyToPreparedStatement(BaseEntity ent, PreparedStatement ps,  TipoJdbc opcion){
         entity.Client en = (entity.Client)ent;    
         try {switch(opcion)
            { case writeINSERT: {
                                 ps.setInt(1,    en.getId()); //Primer parametro
                                 ps.setString(2, en.getNombre());  // Segundo parametro
                                 ps.setString(3, en.getA()); // Tercer parametro
                                 ps.setString(4, en.getB());//Caurto Parametro
                                 ps.setString(5, en.getC()); // Quinto parametro
                                 ps.setString(6, en.getD());//Sexto Parametro
                                 ps.setString(7, en.getE()); // Setimo parametro
                                 ps.setString(8, en.getF());// Octavo parametro
                                 ps.setInt(9,    en.TipoCliente.getId());// Noveno parametro
                                 break;
                                 }

              case writeUPDATE: { ps.setString(1, en.getNombre()); // Primer parametro
                                  ps.setString(2, en.getA());//Segundo parametro
                                  ps.setString(3, en.getB());//Tercer Parametro
                                  ps.setString(4, en.getC());//Cuarto parametro
                                  ps.setString(5, en.getD());//Quinto Paramatro
                                  ps.setString(6, en.getE());//Sexto parametro
                                  ps.setString(7, en.getF());//Setimo parametro
                                  ps.setInt(8,    en.TipoCliente.getId()); //Octavo parametro
                                  ps.setInt(9,    en.getId());//Noveno parametro
                                  break;
                                 }
              case writeDELETE: { ps.setInt(1, en.getId()); // Primer parametro
                                  break;
                                 }
            }
          }
       catch(Exception e){
          
          }
     }          
}
