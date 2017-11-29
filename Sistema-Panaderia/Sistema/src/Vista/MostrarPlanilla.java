package Vista;

import Control.Remito;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarPlanilla extends javax.swing.JFrame {
    javax.swing.table.DefaultTableModel modelvacio;
    int flagFecha;
    
    public MostrarPlanilla() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true); 
        dFecha.setDateFormatString("dd/MM/yyyy");
        flagFecha=0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneralMostrar = new javax.swing.JPanel();
        dFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        pnlPlanilla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlanilla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        bTurno = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Planilla");
        setResizable(false);

        pnlGeneralMostrar.setBackground(new java.awt.Color(225, 178, 86));
        pnlGeneralMostrar.setMinimumSize(new java.awt.Dimension(1366, 768));
        pnlGeneralMostrar.setPreferredSize(new java.awt.Dimension(1366, 768));
        pnlGeneralMostrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dFecha.setDateFormatString("dd-MM-yyyy");
        dFecha.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        dFecha.setName("dateMostrar"); // NOI18N
        dFecha.setOpaque(false);
        dFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dFechaFocusGained(evt);
            }
        });
        dFecha.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                dFechaComponentHidden(evt);
            }
        });
        dFecha.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                dFechaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        dFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dFechaPropertyChange(evt);
            }
        });
        pnlGeneralMostrar.add(dFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 150, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(104, 0, 0));
        jLabel1.setText("Turno:");
        pnlGeneralMostrar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, -1, 50));

        tblPlanilla.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        tblPlanilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Pedido", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlanilla.setGridColor(new java.awt.Color(255, 255, 255));
        tblPlanilla.setRowHeight(24);
        jScrollPane2.setViewportView(tblPlanilla);
        if (tblPlanilla.getColumnModel().getColumnCount() > 0) {
            tblPlanilla.getColumnModel().getColumn(0).setResizable(false);
            tblPlanilla.getColumnModel().getColumn(0).setPreferredWidth(75);
            tblPlanilla.getColumnModel().getColumn(1).setResizable(false);
            tblPlanilla.getColumnModel().getColumn(1).setPreferredWidth(1000);
            tblPlanilla.getColumnModel().getColumn(2).setResizable(false);
            tblPlanilla.getColumnModel().getColumn(2).setPreferredWidth(75);
        }

        javax.swing.GroupLayout pnlPlanillaLayout = new javax.swing.GroupLayout(pnlPlanilla);
        pnlPlanilla.setLayout(pnlPlanillaLayout);
        pnlPlanillaLayout.setHorizontalGroup(
            pnlPlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        pnlPlanillaLayout.setVerticalGroup(
            pnlPlanillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        pnlGeneralMostrar.add(pnlPlanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 1280, 510));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(104, 0, 0));
        jLabel2.setText("Ingresar fecha de planilla que desea ver:");
        pnlGeneralMostrar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, 30));

        bTurno.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        bTurno.setSelected(true);
        bTurno.setText("Noche");
        bTurno.setBorder(null);
        bTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTurnoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bTurnoMousePressed(evt);
            }
        });
        pnlGeneralMostrar.add(bTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 100, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(124, 56, 14));
        jLabel4.setText("Mostrar Planilla");
        jLabel4.setToolTipText("");
        pnlGeneralMostrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 510, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jButton1.setText("IMPRIMIR");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        pnlGeneralMostrar.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 710, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneralMostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneralMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dFechaPropertyChange
        if(dFecha.getDate()!=null) {
                 if(flagFecha!=1){
                    Remito remito= new Remito();
                    String formato = this.dFecha.getDateFormatString();
                    Date date = this.dFecha.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat(formato);
                    remito.setFecha(String.valueOf(sdf.format(date)));
                    if(this.bTurno.getText().equals("Noche"))remito.setTurno('N');
                    else remito.setTurno('T');
                    this.VaciarTabla(tblPlanilla);
                    this.tblPlanilla.setModel(remito.GetTablePlanillaTarde((DefaultTableModel)this.tblPlanilla.getModel()));
                    flagFecha++;
                    if(this.tblPlanilla.getModel().getRowCount()==0)JOptionPane.showMessageDialog(this, "No se han realizados pedidos esa fecha");
                 }
                 else flagFecha=2;
            }
    }//GEN-LAST:event_dFechaPropertyChange

    private void bTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTurnoMouseClicked
    }//GEN-LAST:event_bTurnoMouseClicked

    private void bTurnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTurnoMousePressed
        if(dFecha.getDate()==null){
            JOptionPane.showMessageDialog(this, "Ingrese Fecha");
            bTurno.setSelected(true);
        } else {
            if(bTurno.isSelected()) {
                bTurno.setText("Tarde");
            } else {
                bTurno.setText("Noche");
            }
            Remito remito= new Remito();
            String formato = dFecha.getDateFormatString();
            Date date = dFecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            remito.setFecha(String.valueOf(sdf.format(date)));
            if(bTurno.getText().equals("Noche")) {
                remito.setTurno('N');
            } else {
                remito.setTurno('T');
            }
            VaciarTabla(tblPlanilla);
            tblPlanilla.setModel(remito.GetTablePlanillaTarde((DefaultTableModel)tblPlanilla.getModel()));
            if(tblPlanilla.getModel().getRowCount()==0) {
               JOptionPane.showMessageDialog(this, "No se han realizados pedidos esa fecha");
            }
        }
    }//GEN-LAST:event_bTurnoMousePressed

    private void dFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dFechaFocusGained
    }//GEN-LAST:event_dFechaFocusGained

    private void dFechaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dFechaCaretPositionChanged
    }//GEN-LAST:event_dFechaCaretPositionChanged

    private void dFechaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dFechaComponentHidden
    }//GEN-LAST:event_dFechaComponentHidden

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            tblPlanilla.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void VaciarTabla(javax.swing.JTable table) {
        while(table.getRowCount()>0) {
           ((DefaultTableModel)table.getModel()).removeRow(table.getRowCount()-1);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bTurno;
    private com.toedter.calendar.JDateChooser dFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlGeneralMostrar;
    private javax.swing.JPanel pnlPlanilla;
    private javax.swing.JTable tblPlanilla;
    // End of variables declaration//GEN-END:variables
}
