/*

 */
package database.manager;

import database.jdbc.QueryUsuario;
/**
 *
 *@authores : Eli y Dina
 */
public class daoUsuario  extends BaseManager{
   
     public daoUsuario(){
      super();
      //-------------------------
      FieldID =    "id_usuario";
      FieldNombre= "login_usuario";
      FieldA= "password_usuario";

      
      
      entidad=new entity.Usuario();
      querySQL = new QueryUsuario();
      querySQL.setEntity(entidad);
     }
  
}
