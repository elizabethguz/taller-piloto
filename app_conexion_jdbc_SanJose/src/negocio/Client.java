/*
@authores : Eli y Dina
 */
package negocio;

/**
 *
 * @author Daniel
 */
public class Cliente extends BaseNegocio{
    public Cliente(){
        super();
        manager = new database.manager.daoCliente();
    }
}
