/*
@authores : Eli y Dina
 */
package entity;

public class Cliente  extends BaseEntity{

    public TipoCliente TipoCliente;
    
    public Cliente(){
        super();
        TipoCliente = new TipoCliente();
    }

    public entity.TipoCliente getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(entity.TipoCliente TipoCliente) {
        this.TipoCliente = TipoCliente;
    }
    @Override 
    public void copyTo(BaseEntity obj){
          super.copyTo(obj);
          if (obj instanceof Cliente)
             {    Cliente p = (Cliente) obj;
                  TipoCliente.copyTo(p.TipoCliente);
             }
    } 

}
