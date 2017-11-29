/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Control.LoginControl;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends javax.swing.JFrame 
{
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        AgregarUsuariosRecordados(); // Para que en el jComboBox de usuario aparezcan los nombres recordados
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLpassword = new javax.swing.JLabel();
        jLusuario = new javax.swing.JLabel();
        jTFusuario = new javax.swing.JTextField();
        jBEntrar = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jLiconlog = new javax.swing.JLabel();
        jRrecordarme = new javax.swing.JRadioButton();
        jCuserselecBox = new javax.swing.JComboBox<>();
        jLincUC = new javax.swing.JLabel();
        jLsalir = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLpassword.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLpassword.setForeground(new java.awt.Color(255, 255, 255));
        jLpassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenesForm/password.png"))); // NOI18N
        jLpassword.setText("Contraseña:");
        getContentPane().add(jLpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        jLusuario.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLusuario.setForeground(new java.awt.Color(255, 255, 255));
        jLusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenesForm/usuarioA.png"))); // NOI18N
        jLusuario.setText("Usuario:");
        getContentPane().add(jLusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 110, -1));

        jTFusuario.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jTFusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTFusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 160, -1));

        jBEntrar.setBackground(new java.awt.Color(1, 1, 38));
        jBEntrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jBEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jBEntrar.setText("Entrar");
        jBEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEntrarMouseClicked(evt);
            }
        });
        getContentPane().add(jBEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, -1, -1));

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 160, -1));

        jLiconlog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondos/personal.png"))); // NOI18N
        getContentPane().add(jLiconlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jRrecordarme.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jRrecordarme.setForeground(new java.awt.Color(255, 255, 255));
        jRrecordarme.setText("Recordarme");
        jRrecordarme.setOpaque(false);
        jRrecordarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRrecordarmeActionPerformed(evt);
            }
        });
        getContentPane().add(jRrecordarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jCuserselecBox.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jCuserselecBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCuserselecBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jCuserselecBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 175, 29));

        jLincUC.setVisible(false);
        jLincUC.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLincUC.setForeground(new java.awt.Color(255, 0, 0));
        jLincUC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImanegesMenuBar/icono_aviso.png"))); // NOI18N
        jLincUC.setText("Usuario/Contraseña incorrecto");
        getContentPane().add(jLincUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 210, -1));

        jLsalir.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLsalir.setForeground(new java.awt.Color(255, 0, 0));
        jLsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImanegesMenuBar/close_pop.png"))); // NOI18N
        jLsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLsalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLsalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLsalirMouseExited(evt);
            }
        });
        getContentPane().add(jLsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondos/simple_blue__black_wallpaper-wallpaper-2560x1440.jpg"))); // NOI18N
        Fondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFusuarioActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jRrecordarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRrecordarmeActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jRrecordarmeActionPerformed

    private void jBEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEntrarMouseClicked
        if( LoginControl.ValidarUsuarioYContraseña( jTFusuario.getText(),jPasswordField.getText() ) )
        {
            if(jRrecordarme.isSelected()) 
                LoginControl.Recordarme(jTFusuario.getText());
            if(jTFusuario.getText().equals("administrador"))
            {
                new CrearPlanillaYRemitos();
                dispose();
            }
            else
            {
                //new MenuPrincipal_Usuario();
                dispose();
            }
        }
        else jLincUC.setVisible(true);
    }//GEN-LAST:event_jBEntrarMouseClicked

    private void jCuserselecBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCuserselecBoxActionPerformed
        jTFusuario.setText(jCuserselecBox.getSelectedItem().toString()); // Setea el nombre del usuario seleccionado en el jComboBox
    }//GEN-LAST:event_jCuserselecBoxActionPerformed

    private void jLsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLsalirMouseClicked
        System.exit(0); // Sale del programa
    }//GEN-LAST:event_jLsalirMouseClicked

    private void jLsalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLsalirMouseEntered
        jLsalir.setText("Salir"); // Si el cursor entra en el incono del label salir, muestra el texto Salir
    }//GEN-LAST:event_jLsalirMouseEntered

    private void jLsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLsalirMouseExited
        jLsalir.setText(""); // Si el cursor sale del incono del label salir, no muestra el texto Salir
    }//GEN-LAST:event_jLsalirMouseExited

   // public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }*/

    private void AgregarUsuariosRecordados(){
        ArrayList <String> usuarios = LoginControl.GetRecordados(); // Obtengo en el arraylist de string usuarios, un arraylist de string con todos los usuarios recordados
        while(!usuarios.isEmpty()) // mientras el arrylist no este vacio
            jCuserselecBox.addItem(usuarios.remove(0)); // agrego al jComboBox el string de usuario en la posicion 0 y lo borra
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jBEntrar;
    private javax.swing.JComboBox<String> jCuserselecBox;
    private javax.swing.JLabel jLiconlog;
    private javax.swing.JLabel jLincUC;
    private javax.swing.JLabel jLpassword;
    private javax.swing.JLabel jLsalir;
    private javax.swing.JLabel jLusuario;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButton jRrecordarme;
    private javax.swing.JTextField jTFusuario;
    // End of variables declaration//GEN-END:variables
}
