package Vista;

import Control.Cliente;
import Control.Remito;
import javax.swing.table.DefaultTableModel;

public class DeudaXCliente extends javax.swing.JFrame {
    
    public DeudaXCliente() {
        // Metodos de la ventana
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);      
        // Inicializacion
        CargarTablaClientesDeuda(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelPlanilla1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanelPlanilla = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Deudas");
        setBackground(new java.awt.Color(11, 128, 236));
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(225, 178, 86));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPlanilla1.setBackground(new java.awt.Color(225, 178, 86));
        jPanelPlanilla1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Remitos que adeuda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelPlanilla1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBorder(null);

        jTable3.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Fecha", "Total", "Abonado", "Deuda hasta la fecha", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable3);

        jPanelPlanilla1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 39, 800, 620));

        jPanelPrincipal.add(jPanelPlanilla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 850, 690));

        jPanelPlanilla.setBackground(new java.awt.Color(225, 178, 86));
        jPanelPlanilla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelPlanilla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(null);

        jTable2.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Deuda Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jPanelPlanilla.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 39, 420, 620));

        jPanelPrincipal.add(jPanelPlanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 470, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if(jTable2.getSelectedRow()>=0) {
            LimpiarTablaDeRemitos();
            CargarRemitosAdeudados(jTable2.getModel().getValueAt(jTable2.getSelectedRow(),0).toString());
        }
    }//GEN-LAST:event_jTable2MouseClicked
   
    /**************************************************************************************/
    
    private void CargarTablaClientesDeuda() {
        Cliente client = new Cliente();
        jTable2.setModel(client.getTableClienteDeuda(jTable2.getModel()).getModel());// Recupero en la lista el nombre de los clientes fijos
    }
    
    private void CargarRemitosAdeudados(String cl) {
        Remito remito = new Remito();
        jTable3.setModel(remito.GetTablaRemitosAdeudados(jTable3.getModel(),cl).getModel());
    }
    
    private void LimpiarTablaDeRemitos() {
        while(jTable3.getRowCount()>0){
           ((DefaultTableModel)jTable3.getModel()).removeRow(jTable3.getRowCount()-1);
        }
    }

    private int contadordepunto=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPlanilla;
    private javax.swing.JPanel jPanelPlanilla1;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}