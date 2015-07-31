/*
 @authores : Eli y Dina
 */

package presentacion.components;

import java.util.List;
//import components.ComboItem;

/**
 *
 * @author User
 */
public class AdminCBO {
       private javax.swing.JComboBox combo;
    
    public void setCombo(javax.swing.JComboBox combo){
       this.combo = combo;
    }
    public void setSelectedComboItem(int value){
        setSelectedComboItem(combo,value);
    }
    public int getSelectedComboID(){
      return this.getSelectedComboID(this.combo); 
    }
    public int getSelectedComboID(javax.swing.JComboBox combo){
      int x=0;
        ComboItem item=(ComboItem)combo.getSelectedItem();
        if (item != null) { x=item.getId();}
      return x; 
    }
    public void setSelectedComboItem(javax.swing.JComboBox combo,int ID){
         int i=0;
         ComboItem item;
         while (i < combo.getItemCount()){
             item=(ComboItem)combo.getItemAt(i);
             if (item.getId()==ID)
                 { combo.setSelectedIndex(i);
                   i = combo.getItemCount();
                 }
             i = i + 1;
         }
     }
    public void LoadComboOfItems(List items){
        LoadComboOfItems(this.combo,items);
    }
     public void LoadComboOfItems(javax.swing.JComboBox combo,List items){
         int i;
         ComboItem item;
         entity.BaseEntity registro;
         combo.removeAllItems();         
         for (i=0; i<items.size();i++)
             {   registro = (entity.BaseEntity) items.get(i);
                 item = new ComboItem(registro.getId(),registro.getNombre());
                 combo.addItem(item);
             }
     }
}
