/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

/**
 *
 * @author Guilherme
 */
public class BusquedaPanel extends javax.swing.JPanel {

    /**
     * Creates new form BusquedaPanel
     */
    public BusquedaPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkboxFiltrar = new javax.swing.JCheckBox();
        textFieldFiltrar = new javax.swing.JTextField();
        checkboxAmigos = new javax.swing.JCheckBox();
        buttonModificarPerfil = new javax.swing.JButton();
        buttonVerPerfil = new javax.swing.JButton();

        checkboxFiltrar.setText("Filtrar por nombre:");
        checkboxFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxFiltrarActionPerformed(evt);
            }
        });

        textFieldFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFiltrarActionPerformed(evt);
            }
        });

        checkboxAmigos.setText("Mostrar sólo amigos");

        buttonModificarPerfil.setText("Modificar mi perfil");

        buttonVerPerfil.setText("Ver perfil seleccionado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkboxFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldFiltrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkboxAmigos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(buttonModificarPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonVerPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxFiltrar)
                    .addComponent(textFieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkboxAmigos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificarPerfil)
                    .addComponent(buttonVerPerfil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxFiltrarActionPerformed

    private void textFieldFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonModificarPerfil;
    private javax.swing.JButton buttonVerPerfil;
    private javax.swing.JCheckBox checkboxAmigos;
    private javax.swing.JCheckBox checkboxFiltrar;
    private javax.swing.JTextField textFieldFiltrar;
    // End of variables declaration//GEN-END:variables
}
