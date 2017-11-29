/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.Cliente;
import com.sun.glass.events.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteAlta extends javax.swing.JFrame implements SujetoObservable{
    public ClienteAlta() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true); 
        observadores = new ArrayList<Observador>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_fondo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        tbNombre = new javax.swing.JTextField();
        tbDireccion = new javax.swing.JTextField();
        tbTelefono = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Cliente");
        setMaximumSize(new java.awt.Dimension(820, 460));
        setResizable(false);
        setSize(new java.awt.Dimension(820, 460));

        jPanel_fondo.setBackground(new java.awt.Color(225, 178, 86));
        jPanel_fondo.setForeground(new java.awt.Color(225, 178, 86));
        jPanel_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setForeground(new java.awt.Color(51, 0, 0));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Nombre: ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 110, 20));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Dirección:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Telefono:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel4.setText("Zona:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 60, 30));

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        jComboBox1.setOpaque(false);
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 77, -1));

        jCheckBox1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jCheckBox1.setText("Fijo");
        jCheckBox1.setOpaque(false);
        jPanel3.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, 40));

        tbNombre.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbNombre.setToolTipText("");
        tbNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbNombreKeyTyped(evt);
            }
        });
        jPanel3.add(tbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 188, -1));

        tbDireccion.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbDireccionKeyTyped(evt);
            }
        });
        jPanel3.add(tbDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 450, -1));

        tbTelefono.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbTelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(tbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 190, -1));

        btnAgregar.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnAgregarKeyTyped(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 150, 50));

        btnLimpiar.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 150, 50));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(124, 56, 14));
        jLabel5.setText("Agregar un Cliente");
        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 570, -1));

        jPanel_fondo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 740, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(!this.tbNombre.getText().isEmpty()){
                Cliente cliente= new Cliente();    

                cliente.setC_nom(tbNombre.getText());
                cliente.setDir(tbDireccion.getText());
                if(jCheckBox1.isSelected()) {
                    cliente.setTipo('F');
                } else {
                    cliente.setTipo('N');
                }
                cliente.setTel(tbTelefono.getText());
                if(jComboBox1.getSelectedIndex()==0)
                    cliente.setZona('A');
                if(jComboBox1.getSelectedIndex()==1)
                    cliente.setZona('B');
                if(jComboBox1.getSelectedIndex()==2)
                    cliente.setZona('C');
                if(jComboBox1.getSelectedIndex()==3)
                    cliente.setZona('D');
                try {
                    int control= cliente.AgregarCliente();
                    if(control== 1) {
                        JOptionPane.showMessageDialog(this, tbNombre.getText()+" agregado correctamente");
                        notificar(); // Notifica a los observadores para que actualizen su estado, es decir, se agrego un nuevo cliente
                        dispose();
                    }
                    if(control== 0)JOptionPane.showMessageDialog(this, tbNombre.getText()+" ya existe en la base de datos ");
                    if(control== 2) {
                        JOptionPane.showMessageDialog(this, tbNombre.getText()+" se dio alta, precaucion este cliente a sido dado de baja anteriormente");
                        notificar(); 
                        dispose();
                    }
                    LimpiarFormulario();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
        } else {
            JOptionPane.showMessageDialog(this, "Agregue Cliente");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        LimpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNombreKeyTyped
        char caracter = evt.getKeyChar();             
        if((int)caracter==KeyEvent.VK_ENTER)this.tbDireccion.requestFocus();
        if(!Character.isSpaceChar(caracter)) if(!Character.isLetterOrDigit(caracter))evt.consume();
    }//GEN-LAST:event_tbNombreKeyTyped

    private void tbDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDireccionKeyTyped
        char caracter = evt.getKeyChar();             
        if((int)caracter==KeyEvent.VK_ENTER)this.tbTelefono.requestFocus();
    }//GEN-LAST:event_tbDireccionKeyTyped

    private void tbTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTelefonoKeyTyped
        char caracter = evt.getKeyChar();             
        if((int)caracter==KeyEvent.VK_ENTER)this.btnAgregar.requestFocus();
        if(!Character.isDigit(caracter))evt.consume();
    }//GEN-LAST:event_tbTelefonoKeyTyped

    private void btnAgregarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyTyped
        Cliente cliente= new Cliente();    

        cliente.setC_nom(this.tbNombre.getText());
        cliente.setDir(this.tbDireccion.getText());
        if(this.jCheckBox1.isSelected())cliente.setTipo('F');
        else cliente.setTipo('N');
        cliente.setTel(this.tbTelefono.getText());
      
        if(this.jComboBox1.getSelectedIndex()==0)cliente.setZona('A');
        if(this.jComboBox1.getSelectedIndex()==1)cliente.setZona('B');
        if(this.jComboBox1.getSelectedIndex()==2)cliente.setZona('C');
        if(this.jComboBox1.getSelectedIndex()==3)cliente.setZona('D');
       
        try {
           int control= cliente.AgregarCliente();
                    if(control== 1) {
                        JOptionPane.showMessageDialog(this, this.tbNombre.getText()+" agregado correctamente");
                        notificar();
                        dispose();
                    }
                    if(control== 0)JOptionPane.showMessageDialog(this, this.tbNombre.getText()+" ya existe en la base de datos ");
                    if(control== 2) {
                        JOptionPane.showMessageDialog(this, this.tbNombre.getText()+" se dio alta, precaucion este cliente a sido dado de baja anteriormente");
                        notificar(); 
                        dispose();
                    }
            this.LimpiarFormulario();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarKeyTyped

    private void LimpiarFormulario() {
       this.tbNombre.setText("");
       this.tbDireccion.setText("");
       this.jCheckBox1.setSelected(false);
       this.tbTelefono.setText("");
       this.jComboBox1.setSelectedIndex(0);
       this.tbNombre.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_fondo;
    private javax.swing.JTextField tbDireccion;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTextField tbTelefono;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Observador> observadores;
    
    @Override
    public void notificar() {
        for(Observador o:observadores) {
            o.update();
        }
    }

    @Override
    public void añadir(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminar(Observador o) {
        observadores.remove(o);
    }
}
