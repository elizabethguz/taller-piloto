/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.forms;

import app_conexion_jdbc_sanjose.App_conexion_jdbc_Contraseña;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
//import org.jfree.chart.title.Title;

/**
 *
 * @authores : Eli y Dina
 */
public class JPanelFondoBotones extends javax.swing.JPanel {
JDesktopPane theDesktop = new JDesktopPane();
    /**
     * Creates new form JPanelFondo
     */
    public JPanelFondoBotones() {
        initComponents();
        initComponents();
        this.setSize(300,300); //ANCHO Y ALTO
        
    }
    @Override
    public void paintComponent(Graphics g){
    
       
    }
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Entretenimiento = new javax.swing.JButton();
        NuevoUsuario = new javax.swing.JButton();
        Imagenes = new javax.swing.JButton();

        Entretenimiento.setBackground(new java.awt.Color(0, 0, 255));
        Entretenimiento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Entretenimiento.setForeground(new java.awt.Color(255, 255, 255));
        Entretenimiento.setText("Entretenimiento");
        Entretenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntretenimientoActionPerformed(evt);
            }
        });

        NuevoUsuario.setBackground(new java.awt.Color(0, 0, 255));
        NuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        NuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        NuevoUsuario.setText("Nuevo Usuario");
        NuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoUsuarioActionPerformed(evt);
            }
        });

        Imagenes.setBackground(new java.awt.Color(0, 0, 255));
        Imagenes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Imagenes.setForeground(new java.awt.Color(255, 255, 255));
        Imagenes.setText("Publicidad");
        Imagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Entretenimiento)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(NuevoUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Imagenes)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(NuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Entretenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Imagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoUsuarioActionPerformed
        
          JInternalFrameUsuario  f= new JInternalFrameUsuario();
          f.setVisible(true);
          theDesktop.add(f);
    }//GEN-LAST:event_NuevoUsuarioActionPerformed

    private void EntretenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntretenimientoActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
           new triqui.Triqui().setVisible(true);  
    }//GEN-LAST:event_EntretenimientoActionPerformed

    private void ImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenesActionPerformed
        // TODO add your handling code here:
         this.setVisible(true);
         new Publicidad().setVisible(true);  
    }//GEN-LAST:event_ImagenesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Entretenimiento;
    private javax.swing.JButton Imagenes;
    private javax.swing.JButton NuevoUsuario;
    // End of variables declaration//GEN-END:variables
}
