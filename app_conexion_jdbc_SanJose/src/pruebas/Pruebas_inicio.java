/*
 * PLANTILLA DE UNA APLICACION DE ACCESO A DATOS EN 
 *       JAVA - USANDO JDBC
 *    UNIVERSIDAD NACIONAL JOSE MARIA ARGUEDAS
 *       PROGRAMACION AVANZADA EN JAVA
 *   Carrera Profesional de Ingenieria de Sistemas
 *   PREPARADO POR : Ing. Edwin Octavio Ramos Velásquez
 *     Andahuaylas, 2013
 */
package pruebas;

public class Pruebas_inicio {
  public  void PruebaConexion(){
       database.conexion.Conexion cn;
       cn = new database.conexion.Conexion();
       cn.Open();
       if (cn.opened()) {
            System.out.print("Logro conectarse con la BD");
        }
       else {
            System.out.print("NO pudo conectarse con la BD");
        }
       cn.Close();
    }
}
