    /*
 @authores : Eli y Dina
 */
package presentacion.forms;
//---------------------------------------
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import presentacion.components.IEventsCursor;
import presentacion.components.IEventsDatabase;
import presentacion.components.JPanelScroll;
import presentacion.components.JPanelUpdate;
import presentacion.components.OpcionesUpdate;
import presentacion.components.enumCursor;
import presentacion.components.enumStatus;

/**
 *
 * @author User
 */
public class JInternalFrameUsuario extends javax.swing.JInternalFrame  implements IEventsCursor, IEventsDatabase{
     JDesktopPane theDesktop = new JDesktopPane();  
      JPanelScroll Scroll=null;
      JPanelUpdate ScrollDB=null;
      private entity.Usuario registro;
      private negocio.Usuario BaseDeDatos;
      private presentacion.components.AdminCBO cbo=new presentacion.components.AdminCBO();
    /**
     * Creates new form JInternalFrameTuristaMnto
     */
    public JInternalFrameUsuario() {
         super("",
          false, //resizable
          true, //closable
          false, //maximizable
          true);//iconificable
        initComponents();
        getContentPane().add( theDesktop);
        LoadJPanelScroll();
        
        registro = new entity.Usuario();
        BaseDeDatos = new negocio.Usuario();
        
        Scroll.setList(BaseDeDatos.getItems());
        
        ActualizarDatosMostrados();
        ConfiguraInterfaz(ScrollDB.getStatus());
        
        this.setSize(new Dimension(800, 640));

        //this.setBackground(Color.darkGray);
    }
 private void LoadJPanelScroll(){
        JPanelScroll pane1=new JPanelScroll();
        pane1.setVisible(true);
        pane1.setSize(440, 30);
        pane1.setLocation(30, 220);
        pane1.setCliente(this);
        this.add(pane1);
        Scroll = pane1;
        
        JPanelUpdate pane2=new JPanelUpdate();
        pane2.setVisible(true);
        pane2.setSize(600, 31);
        pane2.setLocation(10, 250);
        pane2.setCliente(this);
        this.add(pane2);
        ScrollDB = pane2;
    }
     private void ActualizarDatosMostrados(){
      if (Scroll.ExistsRow())
          { entity.Usuario row = (entity.Usuario)Scroll.getItem();
             //--------------------------------------------
            this.jtxtCodigo.setText(String.valueOf(row.getId()));
            this.jtxtNombre.setText(row.getNombre());
            this.jtxtClave.setText(row.getA());
           
            //--------------------------------------------
            String s = String.valueOf(Scroll.getIndex()+1) + " de " + String.valueOf(Scroll.getCount());
            this.jlblInfoRegistros.setText(s + " registros");
            row.copyTo(registro);
          }
      else{
           this.jtxtCodigo.setText("");
           this.jtxtNombre.setText("");
           this.jtxtClave.setText("");
        
           
           this.jlblInfoRegistros.setText("No hay registro activo");
           registro.clear();
          }
    }

    private boolean puedeGrabar(){
        
      registro.setNombre(jtxtNombre.getText().trim());
      registro.setA(jtxtClave.getText().trim());
     
      //--------------------------
      
      return true;
    }
    private void ConfiguraInterfaz(enumStatus status){
        this.jtxtCodigo.setEnabled(false);
        this.jtxtNombre.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtClave.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
       
        //--------------------------
        this.Scroll.setEnabled(status == enumStatus.explorando);
        switch(status){
            case insertando:{  this.jtxtCodigo.setText("<Auto>");
                               this.jtxtNombre.setText("");
                               this.jtxtClave.setText("");
                               
                               //---------------------------------------
                               this.jlblInfoTitle.setText("Usuario: Nuevo Registro");
                               break;
                              
                               //*****************************************                                                             
                            }    
            case modificando:{ this.jlblInfoTitle.setText("Usuario: Modificando");
                               break;
                            }
            case explorando:{  this.jlblInfoTitle.setText("Usuario: Explorando");
                               break;
                            }                    
        }
    
    }
    private void buscarRegistro(){
        String buscar = JOptionPane.showInputDialog(null, "Escriba el Usuario", "Nombre del Usuario", 3).trim();
        if (buscar.length()<1) { return ; }
        
        entity.Usuario row = new entity.Usuario();
        row.setNombre(buscar);
        row.setRowSearch(2);
        
        int index = Scroll.getList().indexOf(row);
        if (index>=0){ Scroll.setIndex(index);
                       ActualizarDatosMostrados();
                      }
        else {
              JOptionPane.showMessageDialog(null, "No se ha encontrado el registro solicitado");
             }
    }
    //---------------------------------------------------
    // Las lineas abajo no requieren modificacion alguna
    
    private boolean database_Insert(){
         if (!puedeGrabar()) {return false;}
         BaseDeDatos.setEntity(registro);
         return BaseDeDatos.db_insert();
    }
    private boolean database_Update(){
         if (!puedeGrabar()) {return false;}
         BaseDeDatos.setEntity(registro);
         return BaseDeDatos.db_update();
    }
    private boolean database_Delete(){
         int ID_a_Borrar=0;
         registro.setId(ID_a_Borrar);
         if (!puedeGrabar()) {return false;}
         BaseDeDatos.setEntity(registro);
         return BaseDeDatos.db_delete();
    }
    private void refresFromDB(boolean last){
        int id = Scroll.getIndex();
        Scroll.setList(BaseDeDatos.getItems());
        if (last) {Scroll.last();}
        else {Scroll.setIndex(id);}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtCodigo = new javax.swing.JTextField();
        jtxtClave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlblInfoRegistros = new javax.swing.JLabel();
        jlblInfoTitle = new javax.swing.JLabel();
        lbfoto4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtRutaFoto = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jbtnCargarFoto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbtnGrabar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();
        jtxtNombre = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(890, 650));

        jtxtCodigo.setBackground(new java.awt.Color(0, 0, 0));
        jtxtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jtxtCodigo.setText("jTextField1");
        jtxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCodigoActionPerformed(evt);
            }
        });

        jtxtClave.setBackground(new java.awt.Color(0, 0, 0));
        jtxtClave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtClave.setForeground(new java.awt.Color(255, 255, 255));
        jtxtClave.setText("jTextField3");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setText("Contraseña");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("Usuario");

        jlblInfoRegistros.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jlblInfoRegistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblInfoRegistros.setText("jLabel3");

        jlblInfoTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jlblInfoTitle.setText("jLabel3");

        lbfoto4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setFont(new java.awt.Font("Eras Demi ITC", 1, 18)); // NOI18N
        jLabel7.setText("FOTO");

        jtxtRutaFoto.setEditable(false);
        jtxtRutaFoto.setBackground(new java.awt.Color(0, 0, 0));
        jtxtRutaFoto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtRutaFoto.setForeground(new java.awt.Color(255, 255, 255));
        jtxtRutaFoto.setText("Ruta de la Imagen");

        jLabel51.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel51.setText("Dirección de la Foto:");

        jbtnCargarFoto.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jbtnCargarFoto.setText("Cargar Foto");
        jbtnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarFotoActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenesSanJose/Gifs Animados Turistas 1.gif"))); // NOI18N

        jbtnGrabar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGrabar.setText("Grabar");
        jbtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGrabarActionPerformed(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnCancelar.setText("CANCELAR");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnEditar.setText("Editar");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jtxtNombre.setBackground(new java.awt.Color(0, 0, 0));
        jtxtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(255, 255, 255));
        jtxtNombre.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnCargarFoto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbfoto4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbtnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(jlblInfoTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlblInfoRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jbtnCargarFoto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbfoto4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnNuevo)
                            .addComponent(jbtnEditar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnEliminar)
                            .addComponent(jbtnGrabar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblInfoTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(33, 33, 33)
                        .addComponent(jlblInfoRegistros))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCodigoActionPerformed

    private void jbtnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCargarFotoActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed

    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed

    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGrabarActionPerformed

    }//GEN-LAST:event_jbtnGrabarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed

    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed

        //TODO add your handling code here:
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCargarFoto;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGrabar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JLabel jlblInfoRegistros;
    private javax.swing.JLabel jlblInfoTitle;
    private javax.swing.JTextField jtxtClave;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtRutaFoto;
    private javax.swing.JLabel lbfoto4;
    // End of variables declaration//GEN-END:variables

  @Override
    public void OnChange_Cursor(enumCursor cursor) {
        switch(cursor){
            case primero:  {Scroll.first();
                            ActualizarDatosMostrados();
                            break;
                           }
            case anterior: {Scroll.previous();
                            ActualizarDatosMostrados();
                            break;
                           }
            case siguiente:{ Scroll.next();
                            ActualizarDatosMostrados();
                            break;
                           }
            case ultimo:   { Scroll.last();
                            ActualizarDatosMostrados();
                            break;
                           }
            case buscar:   { buscarRegistro();
                             break;
                           }
        }
    }

    @Override
    public void OnChange_Database(OpcionesUpdate evt) {
         switch(evt.accion){
            case nuevo:   {  ScrollDB.setStatus(enumStatus.insertando); 
                             ConfiguraInterfaz(ScrollDB.getStatus());
                             break;
                          } 
            case editar:  { ScrollDB.setStatus(enumStatus.modificando); 
                            ConfiguraInterfaz(ScrollDB.getStatus());
                            break;
                          } 
            case grabar:  { if (evt.status==enumStatus.insertando)
                                { if(database_Insert())
                                    { ScrollDB.setStatus(enumStatus.explorando); 
                                      refresFromDB(true);
                                      ActualizarDatosMostrados();
                                      ConfiguraInterfaz(ScrollDB.getStatus());
                                    }
                                }
                            else  { 
                                    if(database_Update())
                                    { ScrollDB.setStatus(enumStatus.explorando); 
                                      refresFromDB(false);
                                      ActualizarDatosMostrados();
                                      ConfiguraInterfaz(ScrollDB.getStatus());
                                    }
                                 }
                          } 
            case cancelar:{  ScrollDB.setStatus(enumStatus.explorando); 
                             ActualizarDatosMostrados();
                             ConfiguraInterfaz(ScrollDB.getStatus());
                             break;
                          }
            case eliminar:{ if(database_Delete())
                               { refresFromDB(false);
                                 ActualizarDatosMostrados();
                               }
                             ConfiguraInterfaz(evt.status);
                             break;
                          }
            case cerrar: {setVisible(false);
                          dispose();
                          break;
                         }      
        }
    }


}
