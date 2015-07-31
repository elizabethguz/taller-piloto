/*
 
 */
package database.manager;

import database.jdbc.QueryTipoCliente;
/**
 *
 * @authores : Eli y Dina
 */
public class daoTipoCliente  extends BaseManager{
   
     public daoTipoCliente(){
      super();
      //-------------------------
      FieldID =    "id_tipocliente";
      FieldNombre= "ruc_tipocliente";
      FieldA=      "nombre_tipocliente";
      FieldB=      "descripcion_tipocliente";
      

      
      
      entidad=new entity.TipoCliente();
      querySQL = new QueryTipoCliente();
      querySQL.setEntity(entidad);
     }
  
}
