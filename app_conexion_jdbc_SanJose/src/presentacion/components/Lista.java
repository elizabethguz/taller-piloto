package presentacion.components;

import java.util.List;

/**
 *
@authores : Eli y Dina
 */
    public class Lista {
    
    private List list;
    private int index;
    private IEventsCursor cliente;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
        reset();
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if (index>=0 && index<getCount())
            { this.index = index;}
    }
    
    public int getCount(){
        return list.size();
    }
    
    public IEventsCursor getCliente() {
        return cliente;
    }

    public void setCliente(IEventsCursor cliente) {
        this.cliente = cliente;
    }
//==============================================================================
    public void reset(){
      index = -1;
      if (getCount()>0){index = 0;}
    }
    public Object getItem(int index){
        return list.get(index);
    }
    public Object getItem(){
         return getItem(index);
    }
    public boolean next(){
       if (index<getCount()-1)
          { index = index+1;
            return true;
          }
       else {return false;}
    }
    public boolean last(){
       if (index<getCount()-1)
          { index = getCount()-1;
            return true;
          }
       else {return false;}
    }
    public boolean ExistsRow(){
       if (getCount()<1) return false;
       if (index<0 || index>getCount()-1) return false;
       return getItem(index)!=null;
    }
    public boolean previous(){
       if (index>0 && getCount()>0)
          { index = index-1;
            return true;
          }
       else {return false;}
    }
    public boolean first(){
       if (index>0 && getCount()>0)
          { index = 0;
            return true;
          }
       else {return false;}
    }
    
}








