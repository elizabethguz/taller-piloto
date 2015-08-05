/*
@authores : Eli y Dina
 */
package database.manager;

import database.jdbc.QueryClient;

/**
 *
 * @authores : Eli y Dina
 */
public class daoClient extends BaseManager{
    
    public daoClient(){
      
      super();  
      FieldID = "id_cliente";
      FieldNombre=   "dni_cliente"; //Para Poder hcer La busqueda Mediaant el DNI
      FieldA=        "nombre_cliente";
      FieldB=   "sexo_cliente";
      FieldC=   "correo_cliente";
      FieldD=  "celular_cliente";
      FieldE=   "cargo_cliente";
      FieldF=   "descripcion_cliente";
      
      
      
      //-----------------------------
      entidad = new entity.Client();
      querySQL = new QueryClient();
      querySQL.setEntity(entidad);
    }
}
