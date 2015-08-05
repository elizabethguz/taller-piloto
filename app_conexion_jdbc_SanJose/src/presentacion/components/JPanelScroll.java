/*
@authores : Eli y Dina
 */

package presentacion.components;

import java.util.List;

/**
 *
 * @author User
 */
public class JPanelScroll extends javax.swing.JPanel {
    private IEventsCursor cliente;
    private List list;
    private int index;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
        reset();
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if (index>=0 && index<getCount())
            { this.index = index;}
    }
    
    public int getCount(){
        return list.size();
    }
    public JPanelScroll() {
        initComponents();
    }

    public IEventsCursor getCliente() {
        return cliente;
    }

    public void setCliente(IEventsCursor cliente) {
        this.cliente = cliente;
    }
    public void reset(){
      index = -1;
      if (getCount()>0){index = 0;}
    }
    public Object getItem(int index){
        return list.get(index);
    }
    public Object getItem(){
         return getItem(index);
    }
    public boolean next(){
       if (index<getCount()-1)
          { index = index+1;
            return true;
          }
       else {return false;}
    }
    public boolean last(){
       if (index<getCount()-1)
          { index = getCount()-1;
            return true;
          }
       else {return false;}
    }
    public boolean ExistsRow(){
       if (getCount()<1) return false;
       if (index<0 || index>getCount()-1) return false;
       return getItem(index)!=null;
    }
    public boolean previous(){
       if (index>0 && getCount()>0)
          { index = index-1;
            return true;
          }
       else {return false;}
    }
    public boolean first(){
       if (index>0 && getCount()>0)
          { index = 0;
            return true;
          }
       else {return false;}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnPrimero = new javax.swing.JButton();
        jbtnUltimo = new javax.swing.JButton();
        jbtnSiguiente = new javax.swing.JButton();
        jbtnAntes = new javax.swing.JButton();
        jbtnUltimaso = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        jbtnPrimero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnPrimero.setText("jbtnPrimero");
        jbtnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrimeroActionPerformed(evt);
            }
        });

        jbtnUltimo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenesSanJose/Iconos/BUSCAR.png"))); // NOI18N
        jbtnUltimo.setText(" Buscar");
        jbtnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUltimoActionPerformed(evt);
            }
        });

        jbtnSiguiente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnSiguiente.setText("->");
        jbtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSiguienteActionPerformed(evt);
            }
        });

        jbtnAntes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnAntes.setText("<-");
        jbtnAntes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAntesActionPerformed(evt);
            }
        });

        jbtnUltimaso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnUltimaso.setText("jbtnUltimo");
        jbtnUltimaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUltimasoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jbtnPrimero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnAntes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnSiguiente)
                .addGap(2, 2, 2)
                .addComponent(jbtnUltimaso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnUltimo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbtnPrimero)
                .addComponent(jbtnUltimo)
                .addComponent(jbtnSiguiente)
                .addComponent(jbtnAntes)
                .addComponent(jbtnUltimaso))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        jbtnPrimero.setEnabled(enabled);
        jbtnSiguiente.setEnabled(enabled);
        jbtnUltimo.setEnabled(enabled);
    
    }
    private void jbtnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrimeroActionPerformed
       cliente.OnChange_Cursor(enumCursor.primero);
    }//GEN-LAST:event_jbtnPrimeroActionPerformed

    private void jbtnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUltimoActionPerformed
        cliente.OnChange_Cursor(enumCursor.buscar);
    }//GEN-LAST:event_jbtnUltimoActionPerformed

    private void jbtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSiguienteActionPerformed
        cliente.OnChange_Cursor(enumCursor.siguiente);
    }//GEN-LAST:event_jbtnSiguienteActionPerformed

    private void jbtnAntesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAntesActionPerformed
        // TODO add your handling code here:
        cliente.OnChange_Cursor(enumCursor.anterior);
    }//GEN-LAST:event_jbtnAntesActionPerformed

    private void jbtnUltimasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUltimasoActionPerformed
        // TODO add your handling code here:
         cliente.OnChange_Cursor(enumCursor.ultimo);
    }//GEN-LAST:event_jbtnUltimasoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnAntes;
    private javax.swing.JButton jbtnPrimero;
    private javax.swing.JButton jbtnSiguiente;
    private javax.swing.JButton jbtnUltimaso;
    private javax.swing.JButton jbtnUltimo;
    // End of variables declaration//GEN-END:variables
}
