/*
@authores : Eli y Dina
 */
package negocio;

/**
 *
 * @author Daniel
 */
public class Client extends BaseNegocio{
    public Client(){
        super();
        manager = new database.manager.daoClient();
    }
}
