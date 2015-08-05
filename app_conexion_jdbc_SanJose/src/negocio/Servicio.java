/*
@authores : Eli y Dina
 */
package negocio;

/**
 *
 * @author Administrador
 */
public class Servicio  extends BaseNegocio{
     public Servicio() {
      super();
      manager = new database.manager.daoServicio();
    }   
}
