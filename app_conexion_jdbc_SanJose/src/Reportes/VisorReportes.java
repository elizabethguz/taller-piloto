/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes; 

/**
 *
 * @author User
 */
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class VisorReportes extends database.jdbc.JdbcBase{
    //REPORTE USUARIO
        public void showReportUSUARIO() {                                                   
        // TODO add your handling code here:
        try {
            ConexionOpen();
            Connection conn= Conexion();
            String rutaInforme  = "C:\\Users\\Daniel\\Desktop\\SistemaSanJose\\app_conexion_jdbc_SanJose\\src\\Reportes\\rptUsuario.jasper";
            //C:\Users\Daniel\Desktop\SistemaSanJose\app_conexion_jdbc_SanJose\src\Reportes
             
            
            
            //   
            //            D:\Proyectos 2013\Java\app_conexion_jdbc_swing_report\reportes
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme,null,conn);
            JasperViewer ventanaVisor = new JasperViewer(informe, false) ;
            ventanaVisor.setTitle("LISTADO DE USUARIO");
            ventanaVisor.setVisible(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR INFORME. " + e.getMessage());
        }   // try {
    }
  //REPORTE USUARIO      
      
        //---------------------
         public void showReportSERVICIO() {                                                   
        // TODO add your handling code here:
        try {
            ConexionOpen();
            Connection conn= Conexion();
            String rutaInforme  = "C:\\Users\\Daniel\\Desktop\\SistemaSanJose\\app_conexion_jdbc_SanJose\\src\\Reportes\\rptServicio.jasper";
            //C:\Users\Daniel\Desktop\SistemaSanJose\app_conexion_jdbc_SanJose\src\Reportes
             
            
            
            //   
            //            D:\Proyectos 2013\Java\app_conexion_jdbc_swing_report\reportes
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme,null,conn);
            JasperViewer ventanaVisor = new JasperViewer(informe, false) ;
            ventanaVisor.setTitle("LISTADO DE USUARIO");
            ventanaVisor.setVisible(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR INFORME. " + e.getMessage());
        }  
        }// tr
      //----------------------------
        public void showReportTIPOCLIENTE() {  {                                                   
        // TODO add your handling code here:
        try {
            ConexionOpen();
            Connection conn= Conexion();
            String rutaInforme  = "C:\\Users\\Daniel\\Desktop\\SistemaSanJose\\app_conexion_jdbc_SanJose\\src\\Reportes\\rptTipoCliente.jasper";
            //C:\Users\Daniel\Desktop\SistemaSanJose\app_conexion_jdbc_SanJose\src\Reportes
             
            
            
            //   
            //            D:\Proyectos 2013\Java\app_conexion_jdbc_swing_report\reportes
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme,null,conn);
            JasperViewer ventanaVisor = new JasperViewer(informe, false) ;
            ventanaVisor.setTitle("LISTADO DE USUARIO");
            ventanaVisor.setVisible(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR INFORME. " + e.getMessage());
        }   // tr
        //---------------------------
       
         
}}}