/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import gestores.GestorAsignarEvaluadores;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import tpidsi.investigador.Sesion;

/**
 *
 * @author gimena
 */
public class PantallaGestionTIChair extends JFrame {
    private Sesion sesion;
    private Login login;

    /**
     * Creates new form PantallaGestionTIChair
     */
    public PantallaGestionTIChair() {
        initComponents();
    }

    void setSesion(Sesion s, Login l){
        this.sesion = s;
        this.login = l;
    }
    
    Sesion getSesion(){
        return this.sesion;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rbt_AsignarEvaluadoresTI = new javax.swing.JRadioButton();
        rbt_ModificarAsignacion = new javax.swing.JRadioButton();
        rbt_RegistrarResultados = new javax.swing.JRadioButton();
        rbt_RegistrarPubliacion = new javax.swing.JRadioButton();
        rtb_AnularTI = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Trabajos");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Gestión de Trabajos de Investigación para Chair");

        rbt_AsignarEvaluadoresTI.setText("Asignar Evaluadores a Trabajos de Investigación ");
        rbt_AsignarEvaluadoresTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_AsignarEvaluadoresTIActionPerformed(evt);
            }
        });

        rbt_ModificarAsignacion.setText("Modificar Asignación de Evaluadores a Trabajo de Investigación");
        rbt_ModificarAsignacion.setEnabled(false);

        rbt_RegistrarResultados.setText("Registrar Resultados de Evaluación de Trabajos de Investigación");
        rbt_RegistrarResultados.setEnabled(false);

        rbt_RegistrarPubliacion.setText("Registrar Publicación de Trabajos de Investigación ");
        rbt_RegistrarPubliacion.setEnabled(false);

        rtb_AnularTI.setText("Anular Trabajo de Investigación");
        rtb_AnularTI.setEnabled(false);

        jLabel2.setText("Seleccione un opción:");

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbt_RegistrarResultados)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rbt_ModificarAsignacion)
                                .addComponent(rbt_AsignarEvaluadoresTI, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbt_RegistrarPubliacion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rtb_AnularTI, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancelar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbt_AsignarEvaluadoresTI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbt_ModificarAsignacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbt_RegistrarResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbt_RegistrarPubliacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtb_AnularTI)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
       
        this.setVisible(false);
        login.setVisible(true);
        dispose(); //Cierra Ventana 
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        if (rbt_AsignarEvaluadoresTI.isSelected()) 
        { 
            // Si el radio boton esta selecionado y cliclea el boton aceptar carga la pantalla 
            PantallaAsignarEvaluadoresTI pantalla= new PantallaAsignarEvaluadoresTI();
            pantalla.setVisible(true);
            this.setVisible(false);
            pantalla.setGestorTI(this);
        }
        else 
        {
            //Si el radio boton no esta seleccionado y cliclea el boton aceptar muestra mensaje de advertencia
            JOptionPane.showMessageDialog(null, "Seleccione una opción");       
        }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void rbt_AsignarEvaluadoresTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_AsignarEvaluadoresTIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbt_AsignarEvaluadoresTIActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaGestionTIChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaGestionTIChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaGestionTIChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaGestionTIChair.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaGestionTIChair().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rbt_AsignarEvaluadoresTI;
    private javax.swing.JRadioButton rbt_ModificarAsignacion;
    private javax.swing.JRadioButton rbt_RegistrarPubliacion;
    private javax.swing.JRadioButton rbt_RegistrarResultados;
    private javax.swing.JRadioButton rtb_AnularTI;
    // End of variables declaration//GEN-END:variables
}
