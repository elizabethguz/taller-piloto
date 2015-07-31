/*
 @authores : Eli y Dina
 */
package negocio;

/**
 *
 * @author Administrador
 */
public class TipoCliente  extends BaseNegocio{
     public TipoCliente() {
      super();
      manager = new database.manager.daoTipoCliente();
    }   
}
