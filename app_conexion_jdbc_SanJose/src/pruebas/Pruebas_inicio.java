/*

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
