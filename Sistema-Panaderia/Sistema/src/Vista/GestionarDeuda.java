package Vista;

import Control.Cliente;
import Control.Pedido;
import Control.Remito;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionarDeuda extends javax.swing.JFrame {

    public GestionarDeuda() {
        initComponents();
        CargarClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanelClientes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaClientes = new javax.swing.JList<>();
        jPanelPlanilla1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_remitos = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        fecha_desde = new com.toedter.calendar.JDateChooser();
        fecha_hasta = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_nro_remito = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtf_fecha_remito = new javax.swing.JLabel();
        jtf_cancel_remito = new javax.swing.JLabel();
        nro_remito = new javax.swing.JLabel();
        fecha_remito = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pedidos_remito = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        total_remito = new javax.swing.JLabel();
        jtf_total_remito = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        abonado_remito = new javax.swing.JLabel();
        deudaActual_remito = new javax.swing.JLabel();
        jtf_abonado_remito = new javax.swing.JLabel();
        jtf_deudaActual_remito = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        modificarAbonado_remito = new javax.swing.JLabel();
        jtf_modificarAbonado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Deuda");
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 180, 86));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelClientes.setBackground(new java.awt.Color(255, 180, 86));
        jPanelClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelClientes.setOpaque(false);
        jPanelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        ListaClientes.setBackground(new java.awt.Color(255, 255, 204));
        ListaClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ListaClientes.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        ListaClientes.setOpaque(false);
        ListaClientes.setSelectionBackground(new java.awt.Color(204, 102, 0));
        ListaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaClientes);

        jPanelClientes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 230, 780));

        jPanel2.add(jPanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 290, 950));

        jPanelPlanilla1.setBackground(new java.awt.Color(255, 180, 86));
        jPanelPlanilla1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Remitos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelPlanilla1.setOpaque(false);
        jPanelPlanilla1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBorder(null);

        tabla_remitos.setBackground(new java.awt.Color(255, 255, 204));
        tabla_remitos.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        tabla_remitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRO.", "FECHA", "TOTAL", "ABONADO", "DEUDA ACTUAL", "TURNO", "CANCELADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_remitos.setRowHeight(24);
        tabla_remitos.setSelectionBackground(new java.awt.Color(204, 102, 0));
        tabla_remitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_remitosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabla_remitos);
        if (tabla_remitos.getColumnModel().getColumnCount() > 0) {
            tabla_remitos.getColumnModel().getColumn(0).setMinWidth(100);
            tabla_remitos.getColumnModel().getColumn(0).setMaxWidth(100);
            tabla_remitos.getColumnModel().getColumn(1).setMinWidth(150);
            tabla_remitos.getColumnModel().getColumn(1).setMaxWidth(150);
            tabla_remitos.getColumnModel().getColumn(5).setMinWidth(60);
            tabla_remitos.getColumnModel().getColumn(5).setMaxWidth(60);
            tabla_remitos.getColumnModel().getColumn(6).setMinWidth(80);
            tabla_remitos.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        jPanelPlanilla1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 800, 780));

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("CANCELADO");
        jCheckBox1.setOpaque(false);
        jPanelPlanilla1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 890, -1, -1));

        jPanel2.add(jPanelPlanilla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 900, 950));
        jPanel2.add(fecha_desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 150, -1));
        fecha_desde.setDate(getFecha());
        jPanel2.add(fecha_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 150, -1));
        fecha_hasta.setDate(getFecha());

        jLabel2.setText("HASTA:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel3.setText("DESDE:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 180, 86));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Remito seleccionado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(255, 180, 86));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(0, 102, 0));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("REMITO");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 91, 39));

        jtf_nro_remito.setForeground(new java.awt.Color(0, 102, 0));
        jPanel3.add(jtf_nro_remito, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 60, 90, 16));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 11, 133));

        jtf_fecha_remito.setForeground(new java.awt.Color(0, 102, 0));
        jPanel3.add(jtf_fecha_remito, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 90, 90, 16));

        jtf_cancel_remito.setForeground(new java.awt.Color(0, 102, 0));
        jPanel3.add(jtf_cancel_remito, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 130, 16));

        nro_remito.setText("NÚMERO: ");
        jPanel3.add(nro_remito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        fecha_remito.setText("FECHA:");
        jPanel3.add(fecha_remito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        pedidos_remito.setBackground(new java.awt.Color(255, 255, 204));
        pedidos_remito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CANT.", "DESCRIPCIÓN", "P. UNITARIO", "IMPORTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pedidos_remito.setFocusable(false);
        pedidos_remito.setSelectionBackground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setViewportView(pedidos_remito);
        if (pedidos_remito.getColumnModel().getColumnCount() > 0) {
            pedidos_remito.getColumnModel().getColumn(0).setMinWidth(50);
            pedidos_remito.getColumnModel().getColumn(0).setMaxWidth(50);
            pedidos_remito.getColumnModel().getColumn(1).setMinWidth(250);
            pedidos_remito.getColumnModel().getColumn(1).setMaxWidth(250);
            pedidos_remito.getColumnModel().getColumn(2).setMinWidth(75);
            pedidos_remito.getColumnModel().getColumn(2).setMaxWidth(75);
        }

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        total_remito.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        total_remito.setText("Total:");

        jtf_total_remito.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jtf_total_remito.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(total_remito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_total_remito, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_remito)
                    .addComponent(jtf_total_remito, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));

        abonado_remito.setText("ABONADO:");

        deudaActual_remito.setText("DEUDA ACTUAL:");

        jtf_abonado_remito.setForeground(new java.awt.Color(0, 102, 0));

        jtf_deudaActual_remito.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abonado_remito)
                    .addComponent(deudaActual_remito))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_abonado_remito, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jtf_deudaActual_remito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abonado_remito)
                    .addComponent(jtf_abonado_remito, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deudaActual_remito)
                    .addComponent(jtf_deudaActual_remito, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 60, 580, 780));

        jPanel6.setBackground(new java.awt.Color(255, 180, 86));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "MODIFICAR ABONADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        modificarAbonado_remito.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        modificarAbonado_remito.setForeground(new java.awt.Color(255, 204, 102));
        modificarAbonado_remito.setText("ABONA:");
        jPanel6.add(modificarAbonado_remito, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));
        jPanel6.add(jtf_modificarAbonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 120, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 3, 16)); // NOI18N
        jButton1.setText("MODIFICAR (F1)");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 150, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 870, 580, 140));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondos/thumb-1920-434741.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaClientesMouseClicked
        VaciarTabla(tabla_remitos);
        CargarRemitosDesdeHasta(ListaClientes.getModel().getElementAt(ListaClientes.getSelectedIndex()).getC_nom(),GetFromDateChooser(fecha_desde), GetFromDateChooser(fecha_hasta));
    }//GEN-LAST:event_ListaClientesMouseClicked

    private void tabla_remitosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_remitosMouseClicked
        CargarRemito(ObtenerRemitoTabla(tabla_remitos.getSelectedRow()));
    }//GEN-LAST:event_tabla_remitosMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(tabla_remitos.getSelectedRow()>=0) { // Si hay algun remito seleccionado
            Remito remito_seleccionado = ObtenerRemitoTabla(tabla_remitos.getSelectedRow()); // Obtengo el remito
            if(remito_seleccionado.getR_num()==ObtenerRemitoTabla(tabla_remitos.getRowCount()-1).getR_num()) { // Si el remito sleccionado es el ultimo creado para ese cliente
                Float abonado = Float.parseFloat(jtf_modificarAbonado.getText()); // Obtengo el precio abonado ingresado
                if(remito_seleccionado.getDeuda_actual()>0) { // Si el cliente tiene deuda (Recordar que el precio actual del ultimo remito equivale a la deuda total del cliente)
                    if(abonado<remito_seleccionado.getDeuda_actual()) { // Si el precio abonado es la totalidad de la deuda
                        remito_seleccionado.setCancel(false);
                        remito_seleccionado.setP_abonado(remito_seleccionado.getP_abonado()+abonado);
                        remito_seleccionado.setDeuda_actual(remito_seleccionado.getDeuda_actual()-abonado);
                        ListaClientes.getSelectedValue().setDeuda(remito_seleccionado.getDeuda_actual());
                        try {
                            remito_seleccionado.Modificar();
                            ListaClientes.getSelectedValue().Modificar();

                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }                    
                    } else if(abonado>remito_seleccionado.getDeuda_actual()) {
                        JOptionPane.showMessageDialog(null, "El valor abonado no puede ser mayor al total del remito");
                    } else { // Si el precio abonado es la totalidad de la deuda
                        try {
                            ListaClientes.getSelectedValue().CancelarDeuda(remito_seleccionado);
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }              
                } else { // Si el cliente no tiene deuda
                    if(abonado<remito_seleccionado.getP_total()) { // Si no ingresa un valor mayor al del remito
                        remito_seleccionado.setCancel(false);
                        remito_seleccionado.setP_abonado(abonado);
                        remito_seleccionado.setDeuda_actual(remito_seleccionado.getP_total()-abonado);
                        ListaClientes.getSelectedValue().setDeuda(remito_seleccionado.getDeuda_actual());
                        try {
                            remito_seleccionado.Modificar();
                            ListaClientes.getSelectedValue().Modificar();
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if(abonado==remito_seleccionado.getP_total()) {
                        // No hace nada
                    } else {
                        JOptionPane.showMessageDialog(null, "El valor abonado no puede ser mayor al total del remito");
                    }
                }
        int select_remito = tabla_remitos.getSelectedRow();
        ListaClientesMouseClicked(null);
        tabla_remitos.setRowSelectionInterval(select_remito, select_remito);
        tabla_remitosMouseClicked(null);
            } else {
                JOptionPane.showMessageDialog(null, "Solo se pueden modificar el ultimo remito");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un remito");
        }
    }//GEN-LAST:event_jButton1MouseClicked
    
    private void CargarClientes() /* (1) Cargar clientes en la lista */ {
        Cliente cliente = new Cliente();
        ArrayList <Cliente> listCliente = cliente.GetListAllCliente();
        DefaultListModel modelo=new DefaultListModel();
        while(!listCliente.isEmpty()) {
            modelo.add(0, listCliente.remove(0));
        }
        ListaClientes.setModel(modelo);
    } 

    private void VaciarTabla(javax.swing.JTable table) {
        while(table.getRowCount()>0){
           ((DefaultTableModel)table.getModel()).removeRow(table.getRowCount()-1);
        }
    }
    
    private String GetFromDateChooser(com.toedter.calendar.JDateChooser fecha) {
        String formato = fecha.getDateFormatString();
        Date date = fecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato); 
        return String.valueOf(sdf.format(date));
    }
    
    private void CargarRemitosDesdeHasta(String c_nom, String desde, String hasta) {
        Remito remito = new Remito();
        javax.swing.JTable tablaRemitos = remito.GetAllRemitosClientDesdeHasta(c_nom, desde, hasta, (DefaultTableModel) tabla_remitos.getModel());
        tabla_remitos.setModel(tablaRemitos.getModel());
    }
    
    public Date getFecha() {
        ZoneId zona = ZoneId.systemDefault();
        LocalDate ahora = LocalDate.now();
        ZonedDateTime inicioHoy = ahora.atStartOfDay(zona);
        Instant instante = inicioHoy.toInstant();
        Date fecha = Date.from(instante);       
        return fecha;
    }
    
    private Remito ObtenerRemitoTabla(int filaseleccionada) {
        Remito remito = new Remito();
        remito.setR_num(Integer.valueOf(tabla_remitos.getValueAt(filaseleccionada, 0).toString()));
        remito.setClient(ListaClientes.getModel().getElementAt(ListaClientes.getSelectedIndex()));
        remito.setFecha(tabla_remitos.getValueAt(filaseleccionada, 1).toString());
        remito.setP_total(Float.valueOf(tabla_remitos.getValueAt(filaseleccionada, 2).toString()));
        remito.setP_abonado(Float.valueOf(tabla_remitos.getValueAt(filaseleccionada, 3).toString()));
        remito.setDeuda_actual(Float.valueOf(tabla_remitos.getValueAt(filaseleccionada, 4).toString()));
        remito.setTurno(tabla_remitos.getValueAt(filaseleccionada, 5).toString().charAt(0));
        remito.setCancel(Boolean.valueOf(tabla_remitos.getValueAt(filaseleccionada, 6).toString()));
        remito.ObtenerPedidos(); // Cargar pedidos del remito
        return remito;
    }
    
    private void CargarRemito(Remito remito) {
        jtf_nro_remito.setText(String.valueOf(remito.getR_num()));
        jtf_fecha_remito.setText(remito.getFecha());
        if(remito.isCancel()) {
            jtf_cancel_remito.setText("CANCELADO");
        } else {
            jtf_cancel_remito.setText("NO CANCELADO");
        }
        jtf_abonado_remito.setText("$ "+String.valueOf(remito.getP_abonado()));
        jtf_deudaActual_remito.setText("$ "+String.valueOf(remito.getDeuda_actual()));
        jtf_total_remito.setText("$ "+String.valueOf(remito.getP_total()));
        jtf_modificarAbonado.setText("0");
        
        int cant_pedidos=0;
        ArrayList<Pedido> pedidos = remito.getPed();
        VaciarTabla(pedidos_remito);
        while(cant_pedidos < pedidos.size()) {
            Object [] fila = new Object [4];
            fila[0] = String.valueOf(pedidos.get(cant_pedidos).getCant()) +" "+pedidos.get(cant_pedidos).getUnidad();
            fila[1] = pedidos.get(cant_pedidos).getProd().getP_nom();
            fila[2] = "$ "+String.valueOf(pedidos.get(cant_pedidos).getPrecio() / pedidos.get(cant_pedidos).getCant());
            fila[3] = "$ "+String.valueOf(pedidos.get(cant_pedidos).getPrecio());
            ((DefaultTableModel)pedidos_remito.getModel()).addRow(fila);
            cant_pedidos++;
        }
        while(cant_pedidos < 22) {
            ((DefaultTableModel)pedidos_remito.getModel()).addRow(new Object[4]);
            cant_pedidos++;
        }
    }
       
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarDeuda().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Cliente> ListaClientes;
    private javax.swing.JLabel abonado_remito;
    private javax.swing.JLabel deudaActual_remito;
    private com.toedter.calendar.JDateChooser fecha_desde;
    private com.toedter.calendar.JDateChooser fecha_hasta;
    private javax.swing.JLabel fecha_remito;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelPlanilla1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jtf_abonado_remito;
    private javax.swing.JLabel jtf_cancel_remito;
    private javax.swing.JLabel jtf_deudaActual_remito;
    private javax.swing.JLabel jtf_fecha_remito;
    private javax.swing.JTextField jtf_modificarAbonado;
    private javax.swing.JLabel jtf_nro_remito;
    private javax.swing.JLabel jtf_total_remito;
    private javax.swing.JLabel modificarAbonado_remito;
    private javax.swing.JLabel nro_remito;
    private javax.swing.JTable pedidos_remito;
    private javax.swing.JTable tabla_remitos;
    private javax.swing.JLabel total_remito;
    // End of variables declaration//GEN-END:variables
}
