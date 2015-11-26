/*
@authores : Eli y Dina
 */

package presentacion.forms;

import java.awt.Dimension;
import presentacion.components.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
// coment
public class JInternalFrameClient extends javax.swing.JInternalFrame
     implements IEventsCursor, IEventsDatabase{
      JPanelScroll Scroll=null;
      JPanelUpdate ScrollDB=null;
      private entity.Client registro;
      private negocio.Client BaseDeDatos;
      private negocio.TipoCliente TipoCliente;
      private presentacion.components.AdminCBO cbo=new presentacion.components.AdminCBO();
      DefaultTableModel objModTab;
      
      /**
     * Creates new form JInternalFrameCiudad
     */
    public JInternalFrameClient() {
          super("",
          false, //resizable
          true, //closable
          false, //maximizable
          true);//iconificable
        initComponents();
        LoadJPanelScroll();
        registro = new entity.Client();
        BaseDeDatos = new negocio.Client();
        Scroll.setList(BaseDeDatos.getItems());
        TipoCliente = new negocio.TipoCliente();
        cbo.LoadComboOfItems(jcboTipoCliente,TipoCliente.getItemsCBO());
        
        mostarTablaCliente();
        ConfiguraInterfaz(ScrollDB.getStatus());
                this.setSize(new Dimension(1354, 640));


    }
    //-------------------------------------------------------
                 public void   mostarTablaCliente(){
        String[] nomColumna = new String[9];
        String[] registro = new String[9];        
        nomColumna[0]="ID";
        nomColumna[1]="DNI"; 
        nomColumna[2]="NOMBRE"; 
        nomColumna[3]="SEXO"; 
        nomColumna[4]="CORREO"; 
        nomColumna[5]="CELULAR"; 
        nomColumna[6]="CARGO";
        nomColumna[7]="DESCRIPCION";
        nomColumna[8]="ID_TURISTA"; 
       
       
        objModTab = new DefaultTableModel(null,nomColumna);               
            int numRow=Scroll.getCount();   
            
            for(int i=0;i<=numRow-1;i++){   
                entity.Client objE = (entity.Client)Scroll.getItem();
                
                registro[0]=String.valueOf(objE.getId()).trim();
                               
                registro[1]=objE.getNombre().trim();
                registro[2]=objE.getA().trim();
                registro[3]=objE.getB().trim();
                registro[4]=objE.getC().trim();
                registro[5]=objE.getD().trim();
                registro[6]=objE.getE().trim();
                registro[7]=objE.getF().trim();
                registro[8]=String.valueOf(objE.TipoCliente.getId()).trim(); 
           
                
                
                objModTab.addRow(registro); 
                Scroll.next();
             }            
            tbMantCliente.setModel(objModTab);
    }
     //-----------------------------------------
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
          { entity.Client row = (entity.Client)Scroll.getItem();
            this.jtxtCodigo.setText(String.valueOf(row.getId()));
            this.jtxtNombre.setText(row.getNombre());
            this.jtxtNombre1.setText(row.getA());
            this.jtxtSexo.setText(row.getB());
            this.jtxtCorreo.setText(row.getC());
            this.jtxtCelular.setText(row.getD());
            this.jtxtCargo.setText(row.getE());
            this.jtxtDescripcion.setText(row.getF());
           
                       
            cbo.setSelectedComboItem(this.jcboTipoCliente, row.getTipoCliente().getId());
            String s = String.valueOf(Scroll.getIndex()+1) + " de " + String.valueOf(Scroll.getCount());
            this.jlblInfoRegistros.setText(s + " registros");
            row.copyTo(registro);
          }
      else{
           this.jtxtCodigo.setText("");
           this.jtxtNombre.setText("");
           this.jtxtNombre1 .setText("");
           this.jtxtSexo.setText("");
           this.jtxtCorreo.setText("");
           this.jtxtCelular.setText("");
           this.jtxtCargo.setText("");
           this.jtxtDescripcion.setText("");
           
           
//++++++++++++++++++++++++++++++++++++++++++++
           this.jlblInfoRegistros.setText("No hay registro activo");
           registro.clear();
          }
    }

    private boolean puedeGrabar(){
        int id_tipocliente = cbo.getSelectedComboID(this.jcboTipoCliente);
        registro.setNombre(jtxtNombre.getText().trim());
        registro.setA(jtxtNombre1.getText().trim());
        registro.setB(jtxtSexo.getText().trim());
        registro.setC(jtxtCorreo.getText().trim());
        registro.setD(jtxtCelular.getText().trim());
        registro.setE(jtxtCargo.getText().trim());
        registro.setF(jtxtDescripcion.getText().trim());
        //--------------------------------------
        registro.TipoCliente.setId(id_tipocliente);
        return true;
    }
    private void ConfiguraInterfaz(enumStatus status){
        this.jtxtCodigo.setEnabled(false);
        this.jtxtNombre.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtNombre1.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtSexo.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtCorreo.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtCelular.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtCargo.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.jtxtDescripcion.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        
        this.jcboTipoCliente.setEnabled(status == enumStatus.insertando ||status == enumStatus.modificando);
        this.Scroll.setEnabled(status == enumStatus.explorando);
        switch(status){
            case insertando:{  this.jtxtCodigo.setText("<Auto>");
                               this.jtxtNombre.setText("");
                               this.jtxtNombre1.setText("");
                               this.jtxtSexo.setText("");
                               this.jtxtCorreo.setText("");
                               this.jtxtCelular.setText("");
                               this.jtxtCargo.setText("");
                               this.jtxtDescripcion.setText("");
                               
                               //---------------------------------------------
                               this.jlblInfoTitle.setText("Cliente: Nuevo Registro");
                               break;
                            }    
            case modificando:{ this.jlblInfoTitle.setText("Cliente: Modificando");
                               break;
                            }
            case explorando:{  this.jlblInfoTitle.setText("Cliente: Explorando");
                               break;
                            }                    
        }
    
    }
    private void buscarRegistro(){
        String buscar = JOptionPane.showInputDialog(null, "Escriba DNI del Cliente", "BUSQUEDA POR DNI - CLIENTE", 3).trim();
        if (buscar.length()<1) {return; }
        
        entity.Client row = new entity.Client();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcboTipoCliente = new javax.swing.JComboBox();
        jlblInfoRegistros = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jlblInfoTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNombre1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtSexo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMantCliente = new javax.swing.JTable();
        textBuscarNombre = new javax.swing.JTextField();
        jbtnBuscar5 = new javax.swing.JButton();
        jtxtCorreo = new javax.swing.JTextField();
        jtxtCelular = new javax.swing.JTextField();
        jtxtCargo = new javax.swing.JTextField();
        jtxtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 255));
        setPreferredSize(new java.awt.Dimension(890, 650));

        jtxtCodigo.setBackground(new java.awt.Color(0, 0, 0));
        jtxtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtCodigo.setForeground(new java.awt.Color(255, 0, 0));
        jtxtCodigo.setText("jTextField1");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DNI");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TIPO DE CLIENTE");

        jcboTipoCliente.setBackground(new java.awt.Color(0, 0, 0));
        jcboTipoCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcboTipoCliente.setForeground(new java.awt.Color(255, 0, 0));
        jcboTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlblInfoRegistros.setBackground(new java.awt.Color(255, 255, 255));
        jlblInfoRegistros.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jlblInfoRegistros.setForeground(new java.awt.Color(255, 255, 255));
        jlblInfoRegistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblInfoRegistros.setText("jLabel3");

        jtxtNombre.setBackground(new java.awt.Color(0, 0, 0));
        jtxtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(255, 0, 0));
        jtxtNombre.setText("jTextField2");

        jlblInfoTitle.setBackground(new java.awt.Color(255, 255, 255));
        jlblInfoTitle.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jlblInfoTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblInfoTitle.setText("jLabel3");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");

        jtxtNombre1.setBackground(new java.awt.Color(0, 0, 0));
        jtxtNombre1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtNombre1.setForeground(new java.awt.Color(255, 0, 0));
        jtxtNombre1.setText("TextField3");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SEXO");

        jtxtSexo.setBackground(new java.awt.Color(0, 0, 0));
        jtxtSexo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtSexo.setForeground(new java.awt.Color(255, 0, 0));
        jtxtSexo.setText("jTextField4");

        tbMantCliente.setBackground(new java.awt.Color(0, 0, 0));
        tbMantCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbMantCliente.setForeground(new java.awt.Color(255, 255, 255));
        tbMantCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        tbMantCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMantClienteMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbMantClienteMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbMantCliente);

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

        jbtnBuscar5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnBuscar5.setText("BUSCAR");
        jbtnBuscar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscar5ActionPerformed(evt);
            }
        });

        jtxtCorreo.setBackground(new java.awt.Color(0, 0, 0));
        jtxtCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtCorreo.setForeground(new java.awt.Color(255, 0, 0));
        jtxtCorreo.setText("jTextField5");

        jtxtCelular.setBackground(new java.awt.Color(0, 0, 0));
        jtxtCelular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtCelular.setForeground(new java.awt.Color(255, 0, 0));
        jtxtCelular.setText("JTextField6");

        jtxtCargo.setBackground(new java.awt.Color(0, 0, 0));
        jtxtCargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtCargo.setForeground(new java.awt.Color(255, 0, 0));
        jtxtCargo.setText("TextField7");

        jtxtDescripcion.setBackground(new java.awt.Color(0, 0, 0));
        jtxtDescripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtDescripcion.setForeground(new java.awt.Color(255, 0, 0));
        jtxtDescripcion.setText("jTextField8");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CORREO");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TELEFONO");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CARGO");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DESCRIPCION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblInfoTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcboTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jlblInfoRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jtxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jtxtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jtxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 685, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jlblInfoTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcboTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblInfoRegistros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMantClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbMantClienteMouseClicked

    private void tbMantClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantClienteMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbMantClienteMouseReleased

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

    private void jbtnBuscar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscar5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnBuscar5;
    private javax.swing.JComboBox jcboTipoCliente;
    private javax.swing.JLabel jlblInfoRegistros;
    private javax.swing.JLabel jlblInfoTitle;
    private javax.swing.JTextField jtxtCargo;
    private javax.swing.JTextField jtxtCelular;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtCorreo;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNombre1;
    private javax.swing.JTextField jtxtSexo;
    private javax.swing.JTable tbMantCliente;
    public javax.swing.JTextField textBuscarNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void OnChange_Cursor(enumCursor cursor) {
        switch(cursor){
            case primero: { Scroll.first();
                            ActualizarDatosMostrados();
                            break;
                           }
            case anterior:{ Scroll.previous();
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
            case editar: {  ScrollDB.setStatus(enumStatus.modificando); 
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
