package Vista;

import Control.Cliente;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.glass.events.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteBaja extends javax.swing.JFrame implements SujetoObservable{
    private TextAutoCompleter textautocompleter;
    Cliente clienteAux;

    public ClienteBaja() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true); 
        textautocompleter=new TextAutoCompleter(tbCliente);
        clienteAux = new Cliente();
        AddItemsAutocompleterCliente();
        observadores = new ArrayList<Observador>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tbCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblZona = new javax.swing.JLabel();
        lblFijo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Cliente");
        setMaximumSize(new java.awt.Dimension(820, 460));
        setMinimumSize(new java.awt.Dimension(820, 460));
        setResizable(false);
        setSize(new java.awt.Dimension(820, 460));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(225, 178, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Dirección:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Telefono:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("Zona:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 150, 50));

        jButton2.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.setBorder(null);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 150, 50));

        tbCliente.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
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
        jPanel1.add(tbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 180, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setText("Cliente:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(124, 56, 14));
        jLabel5.setText("Eliminar Cliente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 500, -1));

        pnlDatos.setBackground(new java.awt.Color(255, 215, 215));

        lblNombre.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(102, 0, 0));
        lblNombre.setText("  ");

        lblDireccion.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(102, 0, 0));
        lblDireccion.setText("  ");

        lblTelefono.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(102, 0, 0));
        lblTelefono.setText("  ");

        lblZona.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        lblZona.setForeground(new java.awt.Color(102, 0, 0));
        lblZona.setText("  ");

        lblFijo.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        lblFijo.setForeground(new java.awt.Color(102, 0, 0));
        lblFijo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFijo.setText("  ");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(lblTelefono)
                            .addComponent(lblZona))
                        .addContainerGap(430, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                        .addComponent(lblFijo))))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblZona, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1.add(pnlDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 450, 160));
        this.pnlDatos.setVisible(false);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LimpiarFormulario(){
       lblNombre.setText("");
       lblDireccion.setText("");
       lblTelefono.setText("");
       lblFijo.setText("");
       lblZona.setText("");
       tbCliente.setText("");
       tbCliente.setEnabled(true);
       tbCliente.requestFocus();
       pnlDatos.setVisible(false);
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Cliente cliente= new Cliente();
        if(!this.tbCliente.getText().isEmpty() && !this.lblNombre.getText().isEmpty()){
                try {
                    cliente.setC_nom(this.lblNombre.getText());
                    cliente.Baja();
                    JOptionPane.showMessageDialog(this, this.tbCliente.getText()+" Fue eliminado correctamente");
                    AddItemsAutocompleterCliente();
                    LimpiarFormulario();
                    notificar();
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
        }
        else JOptionPane.showMessageDialog(this, "Ingrese un Cliente");
        tbCliente.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimpiarFormulario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbClienteKeyTyped
        char caracter = evt.getKeyChar();             
        if((int)caracter==KeyEvent.VK_ENTER){
            Cliente cliente= new Cliente();
            cliente.setC_nom(this.tbCliente.getText());
            try {
                if(cliente.BuscarCliente()) {
                    lblNombre.setText(cliente.getC_nom());
                    lblDireccion.setText(cliente.getDir());
                    lblTelefono.setText(cliente.getTel());
                    if(cliente.getTipo()=='F') {
                        lblFijo.setText("Cliente Fijo");
                    } else {
                        lblFijo.setText("Cliente Normal");
                    }
                    lblZona.setText(String.valueOf(cliente.getZona()));
                    btnEliminar.requestFocus();
                    tbCliente.setEnabled(false);
                    pnlDatos.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, this.tbCliente.getText()+" No se encontro registrado");
                    LimpiarFormulario();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_tbClienteKeyTyped

    private void tbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbClienteActionPerformed
    }//GEN-LAST:event_tbClienteActionPerformed
    
    public void AddItemsAutocompleterCliente() {
        this.textautocompleter.removeAllItems();
        ArrayList <Cliente> array = clienteAux.GetListCliente();
        int i=0;
        while(!array.isEmpty()) {
            textautocompleter.addItem(array.remove(i).getC_nom());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFijo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblZona;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTextField tbCliente;
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
