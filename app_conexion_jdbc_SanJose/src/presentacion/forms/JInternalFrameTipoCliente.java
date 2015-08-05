    /*
@authores : Eli y Dina
 */
package presentacion.forms;
//---------------------------------------
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class JInternalFrameTipoCliente extends javax.swing.JInternalFrame  implements IEventsCursor, IEventsDatabase{
     JDesktopPane theDesktop = new JDesktopPane();  
     JPanelScroll Scroll=null;
     JPanelUpdate ScrollDB=null;
     String JPanelFondo4;
      private entity.TipoCliente registro;
      private negocio.TipoCliente BaseDeDatos;
      private presentacion.components.AdminCBO cbo=new presentacion.components.AdminCBO();
    DefaultTableModel objModTab;
      /**
     * 
     * Creates new form JInternalFrameClienteMnto
     */
    
    public JInternalFrameTipoCliente() {
         super("",
          false, //resizable
          true, //closable
          false, //maximizable
          true);//iconificable
        initComponents();
        getContentPane().add( theDesktop);
        //-------------------------
//         JPanelFondo4 fondo4 = new JPanelFondo4();
//        theDesktop.add(fondo4);
//        fondo4.show();
        //fondo4.setLocation(50, 400);
        //---------------------------------
        LoadJPanelScroll();
        registro = new entity.TipoCliente();
        BaseDeDatos = new negocio.TipoCliente();
        Scroll.setList(BaseDeDatos.getItems());
        ActualizarDatosMostrados();
        mostrarTablaCliente();
        ConfiguraInterfaz(ScrollDB.getStatus());
        this.setSize(new Dimension(1354, 640));
        //this.setBackground(Color.darkGray);
    }
     //-----------------------------------------------
        
      public void   mostrarTablaCliente(){
     String[] nomColumna = new String[4];
        String[] registro = new String[4];        
        nomColumna[0]="ID";
        nomColumna[1]="RUC"; 
        nomColumna[2]="NOMBRE"; 
        nomColumna[3]="DESCRIPCION"; 
        //nomColumna[4]="DIRECCION"; 
       
       
        objModTab = new DefaultTableModel(null,nomColumna);               
            int numRow=Scroll.getCount();   
            
            for(int i=0;i<=numRow-1;i++){   
                entity.TipoCliente objE = (entity.TipoCliente)Scroll.getItem();
                registro[0]=String.valueOf(objE.getId()).trim();
                registro[1]=objE.getNombre().trim();
                registro[2]=objE.getA().trim();
                registro[3]=objE.getB().trim();
                
                
                
                objModTab.addRow(registro); 
                Scroll.next();
             }            
            tbMantCliente.setModel(objModTab);
    }
 //-----------------------------------------------
   
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
        pane2.setSize(600, 31);//ANCHO Y ALTO
        pane2.setLocation(10, 250);//DERECH/ARRIBA
        pane2.setCliente(this);
        this.add(pane2);
        ScrollDB = pane2;
    }
    private void ActualizarDatosMostrados(){
      if (Scroll.ExistsRow())
          { entity.TipoCliente row = (entity.TipoCliente)Scroll.getItem();
             //--------------------------------------------
            this.jtxtCodigo.setText(String.valueOf(row.getId()));
            this.jtxtRuc.setText(row.getNombre());
            this.jtxtNombre.setText(row.getA());
            this.jtxtDescripcion.setText(row.getB());
            
            //--------------------------------------------
            String s = String.valueOf(Scroll.getIndex()+1) + " de " + String.valueOf(Scroll.getCount());
            this.jlblInfoRegistros.setText(s + " registros");
            row.copyTo(registro);
          }
      else{
           this.jtxtCodigo.setText("");
           this.jtxtRuc.setText("");
           this.jtxtNombre.setText("");
           this.jtxtDescripcion.setText("");
           
           //--------------------------
           
           this.jlblInfoRegistros.setText("No hay registro activo");
           registro.clear();
          }
    }

    private boolean puedeGrabar(){
        
      registro.setNombre(jtxtRuc.getText().trim());
      registro.setA(jtxtNombre.getText().trim());
      registro.setB(jtxtDescripcion.getText().trim());
      
      //--------------------------
      
      return true;
    }
    private void ConfiguraInterfaz(enumStatus status){
        this.jtxtCodigo.setEnabled(false);
        this.jtxtRuc.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtNombre.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtDescripcion.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        //--------------------------
        this.Scroll.setEnabled(status == enumStatus.explorando);
        switch(status){
            case insertando:{  this.jtxtCodigo.setText("<Auto>");
                               this.jtxtRuc.setText("");
                               this.jtxtNombre.setText("");
                               this.jtxtDescripcion.setText("");
                               
                               //---------------------------------------
                               this.jlblInfoTitle.setText("Tipo Cliente: Nuevo Registro");
                               break;
                              
                               //*****************************************                                                             
                            }    
            case modificando:{ this.jlblInfoTitle.setText("Tipo Cliente: Modificando");
                               break;
                            }
            case explorando:{  this.jlblInfoTitle.setText("Tipo Cliente: Explorando");
                               break;
                            }                    
        }
    
    }
    private void buscarRegistro(){
        String buscar = JOptionPane.showInputDialog(null, "Escriba el Cliente", "Nombre del Cliente", 3).trim();
        if (buscar.length()<1) { return ; }
        
        entity.TipoCliente row = new entity.TipoCliente();
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
        jtxtRuc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlblInfoRegistros = new javax.swing.JLabel();
        jlblInfoTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtDescripcion = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
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
        textBuscarNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerDateEditor1 = new com.toedter.calendar.JSpinnerDateEditor();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jbtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantCliente = new javax.swing.JTable();

<<<<<<< HEAD
        setBackground(java.awt.Color.magenta);
=======
        setBackground(java.awt.Color.blue);
>>>>>>> elizabeth/master
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(890, 650));

        jtxtCodigo.setBackground(new java.awt.Color(0, 0, 0));
        jtxtCodigo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtxtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jtxtCodigo.setText("jTextField1");
        jtxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCodigoActionPerformed(evt);
            }
        });

        jtxtRuc.setBackground(new java.awt.Color(0, 0, 0));
        jtxtRuc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtxtRuc.setForeground(new java.awt.Color(255, 255, 255));
        jtxtRuc.setText("jTextField2");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DOCUMEN");

        jlblInfoRegistros.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlblInfoRegistros.setForeground(new java.awt.Color(255, 255, 255));
        jlblInfoRegistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblInfoRegistros.setText("jLabel3");

        jlblInfoTitle.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jlblInfoTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblInfoTitle.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESCRIPCION");

        jtxtDescripcion.setBackground(new java.awt.Color(0, 0, 0));
        jtxtDescripcion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtxtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jtxtDescripcion.setText("jTextField4");

        jtxtNombre.setBackground(new java.awt.Color(0, 0, 0));
        jtxtNombre.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(255, 255, 255));
        jtxtNombre.setText("jTextField3");

<<<<<<< HEAD
        lbfoto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenesSanJose/U.jpg"))); // NOI18N
=======
        lbfoto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgenciaVuelosImagenes/FotosTurista/turista.JPG"))); // NOI18N
>>>>>>> elizabeth/master
        lbfoto4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("FOTO");

        jtxtRutaFoto.setEditable(false);
        jtxtRutaFoto.setBackground(new java.awt.Color(0, 0, 0));
        jtxtRutaFoto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtRutaFoto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Direccion de la Foto:");

        jbtnCargarFoto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnCargarFoto.setText("Cargar Foto");
        jbtnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarFotoActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenesSanJose/Gifs Animados Turistas 1.gif"))); // NOI18N
=======
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgenciaVuelosImagenes/Gifs Animados Turistas 1.gif"))); // NOI18N
>>>>>>> elizabeth/master

        jbtnGrabar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGrabar.setText("GRABAR");
        jbtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGrabarActionPerformed(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnCancelar.setText("CANCELAR");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnEliminar.setText("ELIMINAR");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnEditar.setText("EDITAR");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnNuevo.setText("NUEVO");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        textBuscarNombre.setBackground(new java.awt.Color(0, 0, 0));
        textBuscarNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textBuscarNombre.setForeground(new java.awt.Color(255, 255, 255));
        textBuscarNombre.setText("Buscar por Nombre");
        textBuscarNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textBuscarNombreMouseReleased(evt);
            }
        });
        textBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarNombreActionPerformed(evt);
            }
        });
        textBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscarNombreKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FECHA Y HORA");

        jSpinnerDateEditor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jCalendar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jbtnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnBuscar.setText("BUSCAR");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        tbMantCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbMantCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel3))
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlblInfoRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(15, 15, 15)
                                                .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlblInfoTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
=======
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtxtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(15, 15, 15)
                                            .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblInfoRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)))
                        .addGap(53, 53, 53)
>>>>>>> elizabeth/master
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
=======
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel51)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtxtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlblInfoTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(129, 129, 129))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
>>>>>>> elizabeth/master
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbtnCargarFoto))
<<<<<<< HEAD
                                    .addComponent(lbfoto4))
                                .addGap(34, 34, 34)
=======
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lbfoto4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
>>>>>>> elizabeth/master
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
<<<<<<< HEAD
                                        .addComponent(jbtnCancelar)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
=======
                                        .addComponent(jbtnCancelar)))
                                .addGap(18, 18, 18)))
>>>>>>> elizabeth/master
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                                .addComponent(jSpinnerDateEditor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(599, 599, 599))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37)
                                .addComponent(jSpinnerDateEditor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(424, 424, 424))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> elizabeth/master
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jbtnCargarFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbfoto4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel51)
                                    .addComponent(jtxtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtnGrabar)
                                    .addComponent(jbtnNuevo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtnEditar)
                                    .addComponent(jbtnEliminar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnCancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jSpinnerDateEditor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlblInfoTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
=======
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jbtnCargarFoto))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbfoto4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel51)
                                        .addComponent(jtxtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnGrabar)
                                        .addComponent(jbtnNuevo))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnEditar)
                                        .addComponent(jbtnEliminar))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbtnCancelar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerDateEditor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblInfoTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
>>>>>>> elizabeth/master
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
<<<<<<< HEAD
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlblInfoRegistros)
                        .addGap(113, 113, 113))
=======
                        .addGap(62, 62, 62)
                        .addComponent(jlblInfoRegistros)
                        .addGap(62, 62, 62))
>>>>>>> elizabeth/master
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    private void textBuscarNombreMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBuscarNombreMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarNombreMouseReleased

    private void textBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarNombreActionPerformed

    private void textBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarNombreKeyReleased

    }//GEN-LAST:event_textBuscarNombreKeyReleased

    private void textBuscarNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarNombreKeyTyped

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JSpinnerDateEditor jSpinnerDateEditor1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCargarFoto;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGrabar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JLabel jlblInfoRegistros;
    private javax.swing.JLabel jlblInfoTitle;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtRuc;
    private javax.swing.JTextField jtxtRutaFoto;
    private javax.swing.JLabel lbfoto4;
    private javax.swing.JTable tbMantCliente;
    public javax.swing.JTextField textBuscarNombre;
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
