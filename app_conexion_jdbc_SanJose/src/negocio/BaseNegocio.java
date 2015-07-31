/*
@authores : Eli y Dina
 */

package negocio;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class BaseNegocio {
       protected database.manager.BaseManager manager;
     public List getItems(){
        List list = manager.getItems();
        return list;  
    }
    public List getItemsCBO(){
        List list = manager.getItemsCBO();
        return list;  
    }
    public void setEntity(entity.BaseEntity entidad) {
        manager.setEntity(entidad);
    }
    public int getItemsCount(){
         int x = manager.getItemsCount();
         return x;  
    }
    public Object getItem(int ID){
        return manager.getItem(manager.getFieldIDName(), ID);
    }
    public Object getItem(String nombre){
        return manager.getItem(manager.getFieldNombre(), nombre);
    }
    public boolean db_insert(){
        int ID = 1;
        entity.BaseEntity row = (entity.BaseEntity)manager.getItemLastByID();
        if (row != null){ID = row.getId()+1;} 
        manager.getEntidad().setId(ID);
        return manager.insert();
    }
    public boolean db_update(){
        return manager.update();
    }
    public boolean db_delete(){
        return manager.insert();
    }    
}
