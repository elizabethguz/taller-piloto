/*

 */
package database.manager;

import database.jdbc.QueryServicio;
/**
 *
 *@authores : Eli y Dina
 */
public class daoServicio  extends BaseManager{
   
     public daoServicio(){
      super();
      //-------------------------
      FieldID =    "id_servicio";
      FieldNombre= "cod_servicio";
      FieldA= "nombre_servicio";
      FieldB= "preciounidad_servicio";
      
      
      entidad=new entity.Servicio();
      querySQL = new QueryServicio();
      querySQL.setEntity(entidad);
     }
  
}
