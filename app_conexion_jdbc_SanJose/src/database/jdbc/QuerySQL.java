/*
@authores : Eli y Dina
 */
package database.jdbc;

import entity.BaseEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public abstract class QuerySQL {
     protected BaseEntity entity;
     public void setEntity(BaseEntity value){
            entity= value; 
     }
     public BaseEntity getEntity(){
         return entity;
     }
     public abstract BaseEntity getNewEntity();
     public abstract String getQuerySQL(TipoJdbc opcion);
     public abstract void copyDataToEntity(ResultSet rs, BaseEntity ent,
                                           TipoJdbc opcion);
     public abstract void copyToPreparedStatement(BaseEntity ent,
                            PreparedStatement ps,  TipoJdbc opcion);

}
