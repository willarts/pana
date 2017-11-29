package Vista;

import Control.Cliente;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.SQLException;
import java.util.ArrayList;
;
import javax.swing.JOptionPane;

public class ClienteModificar extends javax.swing.JFrame implements SujetoObservable{
    private TextAutoCompleter textautocompleter;
    Cliente clienteAux;

    public ClienteModificar() {
        initComponents();   
        setLocationRelativeTo(null);
        setVisible(true); 
        
        textautocompleter=new TextAutoCompleter(tbCliente);
        clienteAux = new Cliente();
        AddItemsAutocompleterCliente();
        jCheckBox1.setOpaque(true);
       
        observadores = new ArrayList<Observador>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        tbNombre = new javax.swing.JTextField();
        tbDireccion = new javax.swing.JTextField();
        tbTelefono = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tbDeuda = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tbCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Cliente");
        setMaximumSize(new java.awt.Dimension(820, 460));
        setMinimumSize(new java.awt.Dimension(820, 460));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(225, 178, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Dirección:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Telefono:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jCheckBox1.setText("Fijo");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("Zona:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, 50));

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "F" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 77, 30));

        tbNombre.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbNombre.setEnabled(false);
        tbNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbNombreKeyTyped(evt);
            }
        });
        jPanel1.add(tbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 210, -1));

        tbDireccion.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(tbDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 310, -1));

        tbTelefono.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(tbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 210, -1));

        btnModificar.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 140, 40));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setText("Deuda:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, 30));

        tbDeuda.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbDeuda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbDeudaKeyTyped(evt);
            }
        });
        jPanel1.add(tbDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 210, -1));

        btnLimpiar.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 140, 40));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setText("Cliente:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, 20));

        tbCliente.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbClienteActionPerformed(evt);
            }
        });
        tbCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbClienteKeyTyped(evt);
            }
        });
        jPanel1.add(tbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 130, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(124, 56, 14));
        jLabel5.setText("Modificar Cliente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 530, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbClienteActionPerformed
       
    }//GEN-LAST:event_tbClienteActionPerformed

    private void LimpiarFormulario()
    {
       this.tbNombre.setText("");
       this.tbDireccion.setText("");
       this.jCheckBox1.setSelected(false);
       this.tbTelefono.setText("");
       this.jComboBox1.setSelectedIndex(0);
       this.tbCliente.setText("");
       this.tbCliente.setEnabled(true);
       this.tbDeuda.setText("");
       this.tbCliente.requestFocus();
      
    
    
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       Cliente cliente= new Cliente();    
       if(!this.tbNombre.getText().isEmpty())
       {
            cliente.setC_nom(this.tbNombre.getText());
            cliente.setDir(this.tbDireccion.getText());
            if(this.jCheckBox1.isSelected())cliente.setTipo('F');
            else cliente.setTipo('N');
            cliente.setTel(this.tbTelefono.getText());
            if(this.jComboBox1.getSelectedIndex()==0 )cliente.setZona('A');
            if(this.jComboBox1.getSelectedIndex()==1 )cliente.setZona('B');
            if(this.jComboBox1.getSelectedIndex()==2 )cliente.setZona('C');
            if(this.jComboBox1.getSelectedIndex()==3)cliente.setZona('D');
            cliente.setDeuda(Float.parseFloat(this.tbDeuda.getText()));
            this.tbCliente.setEnabled(true);
              try {
                   cliente.Modificar();
                   JOptionPane.showMessageDialog(this, this.tbCliente.getText()+" Fue modificado correctamente");
                   this.LimpiarFormulario();
                   notificar();
              } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex.getMessage());
              }
       }
       else{ JOptionPane.showMessageDialog(this, "Ingrese Cliente");this.tbCliente.requestFocus();}
       
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.LimpiarFormulario();// TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTelefonoKeyTyped
        char caracter = evt.getKeyChar();             
        if((int)caracter==com.sun.glass.events.KeyEvent.VK_ENTER)this.tbDeuda.requestFocus();
        if(!Character.isDigit(caracter))evt.consume(); // TODO add your handling code here:
    }//GEN-LAST:event_tbTelefonoKeyTyped

    private void tbClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbClienteKeyTyped
         char caracter = evt.getKeyChar();             
        if((int)caracter==com.sun.glass.events.KeyEvent.VK_ENTER){
            Cliente cliente= new Cliente();
                
            cliente.setC_nom(this.tbCliente.getText());
            try {
               if(cliente.BuscarCliente())
               {
                   this.jPanel1.setEnabled(true);
                   this.tbNombre.setText(cliente.getC_nom());
                   this.tbDireccion.setText(cliente.getDir());
                   this.tbTelefono.setText(cliente.getTel());
                  
                   if(cliente.getTipo()=='F') this.jCheckBox1.setSelected(true);
                   else this.jCheckBox1.setSelected(false);
                   if(cliente.getZona()=='A')this.jComboBox1.setSelectedIndex(0);
                   if(cliente.getZona()=='B')this.jComboBox1.setSelectedIndex(1);
                   if(cliente.getZona()=='C')this.jComboBox1.setSelectedIndex(2);
                   if(cliente.getZona()=='D')this.jComboBox1.setSelectedIndex(3);
                   this.tbDeuda.setText(String.valueOf(cliente.getDeuda()));
                   this.tbCliente.setEnabled(false);
                   this.tbDireccion.requestFocus();
               
               }else{ JOptionPane.showMessageDialog(this, this.tbCliente.getText()+" No se encontro registrado");
                      this.LimpiarFormulario();
               }    
               } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        }
        if(!Character.isSpaceChar(caracter)) if(!Character.isLetterOrDigit(caracter))evt.consume();
        
        // TODO add your handling code here: // TODO add your handling code here:
    }//GEN-LAST:event_tbClienteKeyTyped

    private void tbNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNombreKeyTyped
        char caracter = evt.getKeyChar();             
        if((int)caracter==com.sun.glass.events.KeyEvent.VK_ENTER)this.tbDireccion.requestFocus();
        if(!Character.isSpaceChar(caracter)) if(!Character.isLetterOrDigit(caracter))evt.consume();
        
        // TODO add your handling code here:// TODO add your handling code here:
    }//GEN-LAST:event_tbNombreKeyTyped

    private void tbDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDireccionKeyTyped
        char caracter = evt.getKeyChar();             
        if((int)caracter==com.sun.glass.events.KeyEvent.VK_ENTER)this.tbTelefono.requestFocus();// TODO add your handling code here:
    }//GEN-LAST:event_tbDireccionKeyTyped

    private void tbDeudaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDeudaKeyTyped
       char caracter = evt.getKeyChar();             
        if((int)caracter==com.sun.glass.events.KeyEvent.VK_ENTER)this.btnModificar.requestFocus();
        if(caracter!='.') if(!Character.isDigit(caracter))evt.consume();// TODO add your handling code here:
    }//GEN-LAST:event_tbDeudaKeyTyped

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    public void AddItemsAutocompleterCliente() {
        
        ArrayList <Cliente> array = clienteAux.GetListCliente();
        int i=0;
        while(!array.isEmpty()) {
            this.textautocompleter.addItem(array.remove(i).getC_nom());
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tbCliente;
    private javax.swing.JTextField tbDeuda;
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
