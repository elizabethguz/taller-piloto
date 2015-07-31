/*
@authores : Eli y Dina
 */
package negocio;

/**
 *
 * @author Administrador
 */
public class Usuario  extends BaseNegocio{
     public Usuario() {
      super();
      manager = new database.manager.daoUsuario();
    }   
}
