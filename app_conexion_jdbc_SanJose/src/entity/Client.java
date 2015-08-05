/*
@authores : Eli y Dina
 */
package entity;

public class Client  extends BaseEntity{

    public TipoCliente TipoCliente;
    
    public Client(){
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
          if (obj instanceof Client)
             {    Client p = (Client) obj;
                  TipoCliente.copyTo(p.TipoCliente);
             }
    } 

}
