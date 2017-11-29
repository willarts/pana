package Vista;

import Control.Cliente;
import Control.Pedido;
import Control.Producto;
import Control.Remito;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class CrearPlanillaYRemitos extends javax.swing.JInternalFrame implements Observador,SujetoObservable{
    //TextAutoCompleter 
    private final TextAutoCompleter TA_producto;
    private final TextAutoCompleter TA_cliente;
    private Remito remito; // Se inicializa al apretar el click en el evento de mouse click de jlist
    private Cliente cliente;
    private Producto producto;
    private Pedido pedido;
    private boolean remitocreado=false;
    
    public CrearPlanillaYRemitos() {
        // Metodos de la ventana
        initComponents();
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));         
        // Inicializacion
        TA_producto = new TextAutoCompleter(jTF_prodNombre);// inicializa TA_producto con referencia al jTF_prodNombre
        TA_cliente = new TextAutoCompleter(jTextField_AgregarCliente);
        jPanel_agregarcliente.setVisible(false);
        CargarListaClientesNoche(); 
        jList1.setSelectedIndex(0);
        jList1MouseClicked(null);
        jList1.requestFocus();
        //
        AddItemsAutocompleterP_nom(TA_producto); // Agrega el nombre de los productos al autocompleter
        AddItemsAutocompleterC_nom(TA_cliente);
        CargarPlanilla();
        observadores = new ArrayList<Observador>();
        icono_pNombreMAL.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelPlanilla = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanelClientes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel_agregarcliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_AgregarCliente = new javax.swing.JTextField();
        icono_cNombreOK = new javax.swing.JLabel();
        icono_cNombreMAL = new javax.swing.JLabel();
        jL_sel = new javax.swing.JLabel();
        jPanelPedido = new javax.swing.JPanel();
        jL_prodNombre = new javax.swing.JLabel();
        jL_prodCant = new javax.swing.JLabel();
        jL_prodUnidad = new javax.swing.JLabel();
        jTF_prodCant = new javax.swing.JTextField();
        jCB_prodUnidad = new javax.swing.JComboBox<>();
        jLabel_$1 = new javax.swing.JLabel();
        jL_PRECIO = new javax.swing.JLabel();
        jL_prodPrecio = new javax.swing.JLabel();
        icono_pNombreMAL = new javax.swing.JLabel();
        icono_pNombreOK = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton_agregarProd = new javax.swing.JButton();
        jButton_ModificarProd = new javax.swing.JButton();
        jTF_prodNombre = new javax.swing.JTextField();
        jCheckBox_PrecioEspecial = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jButton_eliminarPedido = new javax.swing.JButton();
        jButton_cancelarPedidos = new javax.swing.JButton();
        jPanelPedidosR = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jL_TOTAL = new javax.swing.JLabel();
        jLabel_$2 = new javax.swing.JLabel();
        jL_precioTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Turno = new javax.swing.JLabel();
        jComboBox_Turno = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(11, 128, 236));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1020));
        setMinimumSize(new java.awt.Dimension(1920, 1020));
        setPreferredSize(new java.awt.Dimension(1920, 1020));

        jPanelPrincipal.setBackground(new java.awt.Color(255, 204, 204));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPlanilla.setBackground(new java.awt.Color(255, 180, 86));
        jPanelPlanilla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Planilla", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelPlanilla.setOpaque(false);
        jPanelPlanilla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(null);

        jTable2.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLIENTE", "PEDIDO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setRowHeight(24);
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(150);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(150);
            jTable2.getColumnModel().getColumn(1).setMinWidth(500);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(500);
        }

        jPanelPlanilla.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 830, 670));

        jButton3.setFont(new java.awt.Font("Verdana", 3, 13)); // NOI18N
        jButton3.setText("IMPRIMIR REMITOS");
        jButton3.setBorder(null);
        jButton3.setFocusable(false);
        jPanelPlanilla.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 750, 160, 40));

        jButton1.setFont(new java.awt.Font("Verdana", 3, 13)); // NOI18N
        jButton1.setText("IMPRIMIR PLANILLA");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelPlanilla.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 750, 170, 40));

        jButton2.setFont(new java.awt.Font("Verdana", 3, 13)); // NOI18N
        jButton2.setText("MOSTRAR PANTALLA COMPLETA");
        jButton2.setBorder(null);
        jButton2.setFocusable(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanelPlanilla.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 750, 240, 40));

        jPanelPrincipal.add(jPanelPlanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 100, 910, 820));

        jPanelClientes.setBackground(new java.awt.Color(255, 180, 86));
        jPanelClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelClientes.setOpaque(false);
        jPanelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jList1.setBackground(new java.awt.Color(255, 255, 204));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jList1.setOpaque(false);
        jList1.setSelectionBackground(new java.awt.Color(204, 102, 0));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanelClientes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, 640));

        jPanel_agregarcliente.setOpaque(false);
        jPanel_agregarcliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel2.setText("Agregar cliente a lista:");
        jPanel_agregarcliente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 20));

        jTextField_AgregarCliente.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField_AgregarCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_AgregarCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_AgregarClienteFocusLost(evt);
            }
        });
        jTextField_AgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_AgregarClienteActionPerformed(evt);
            }
        });
        jTextField_AgregarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_AgregarClienteKeyTyped(evt);
            }
        });
        jPanel_agregarcliente.add(jTextField_AgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 30));

        icono_cNombreOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok3.png"))); // NOI18N
        jPanel_agregarcliente.add(icono_cNombreOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 30, 30));
        icono_cNombreOK.setVisible(false);

        icono_cNombreMAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mal.png"))); // NOI18N
        jPanel_agregarcliente.add(icono_cNombreMAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 30, 30));
        icono_cNombreMAL.setVisible(false);

        jPanelClientes.add(jPanel_agregarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 240, 80));

        jL_sel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jL_sel.setText("Seleccione cliente");
        jPanelClientes.add(jL_sel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanelPrincipal.add(jPanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 260, 820));

        jPanelPedido.setBackground(new java.awt.Color(255, 180, 86));
        jPanelPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelPedido.setOpaque(false);
        jPanelPedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_prodNombre.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jL_prodNombre.setText("Producto:");
        jPanelPedido.add(jL_prodNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jL_prodCant.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jL_prodCant.setText("Cantidad:");
        jPanelPedido.add(jL_prodCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jL_prodUnidad.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jL_prodUnidad.setText("Unidad:");
        jPanelPedido.add(jL_prodUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        jTF_prodCant.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTF_prodCant.setText("0");
        jTF_prodCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_prodCantKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_prodCantKeyTyped(evt);
            }
        });
        jPanelPedido.add(jTF_prodCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 150, 30));

        jCB_prodUnidad.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jCB_prodUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kilo", "docena", "unidad" }));
        jCB_prodUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_prodUnidadActionPerformed(evt);
            }
        });
        jCB_prodUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCB_prodUnidadKeyPressed(evt);
            }
        });
        jPanelPedido.add(jCB_prodUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 150, 30));
        jCB_prodUnidad.setOpaque(true);

        jLabel_$1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel_$1.setForeground(new java.awt.Color(8, 75, 1));
        jLabel_$1.setText("$");
        jPanelPedido.add(jLabel_$1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 20, -1));

        jL_PRECIO.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jL_PRECIO.setText("PRECIO:");
        jPanelPedido.add(jL_PRECIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, -1));

        jL_prodPrecio.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jL_prodPrecio.setForeground(new java.awt.Color(8, 75, 1));
        jL_prodPrecio.setText("0.0");
        jPanelPedido.add(jL_prodPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 100, -1));

        icono_pNombreMAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mal.png"))); // NOI18N
        jPanelPedido.add(icono_pNombreMAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 30, 30));
        icono_pNombreMAL.setVisible(false);

        icono_pNombreOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok3.png"))); // NOI18N
        jPanelPedido.add(icono_pNombreOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 30, 30));
        icono_pNombreOK.setVisible(false);

        jTextField1.setText("0");
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanelPedido.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 150, 30));
        jTextField1.setEnabled(false);

        jButton_agregarProd.setFont(new java.awt.Font("Verdana", 3, 13)); // NOI18N
        jButton_agregarProd.setText("AGREGAR");
        jButton_agregarProd.setBorder(null);
        jButton_agregarProd.setFocusable(false);
        jButton_agregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarProdActionPerformed(evt);
            }
        });
        jButton_agregarProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton_agregarProdKeyPressed(evt);
            }
        });
        jPanelPedido.add(jButton_agregarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 90, 40));

        jButton_ModificarProd.setFont(new java.awt.Font("Lucida Bright", 1, 13)); // NOI18N
        jButton_ModificarProd.setText("MODIFICAR");
        jButton_ModificarProd.setBorder(null);
        jButton_ModificarProd.setFocusable(false);
        jButton_ModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ModificarProdActionPerformed(evt);
            }
        });
        jPanelPedido.add(jButton_ModificarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 90, 40));
        jButton_ModificarProd.setVisible(false);

        jTF_prodNombre.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTF_prodNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_prodNombreFocusLost(evt);
            }
        });
        jTF_prodNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_prodNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_prodNombreKeyTyped(evt);
            }
        });
        jPanelPedido.add(jTF_prodNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, 30));
        jTF_prodNombre.setText("");

        jCheckBox_PrecioEspecial.setBackground(new java.awt.Color(255, 255, 153));
        jCheckBox_PrecioEspecial.setForeground(new java.awt.Color(102, 0, 0));
        jCheckBox_PrecioEspecial.setOpaque(false);
        jCheckBox_PrecioEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_PrecioEspecialActionPerformed(evt);
            }
        });
        jPanelPedido.add(jCheckBox_PrecioEspecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Precio Especial:");
        jPanelPedido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 30));
        jLabel1.setEnabled(false);

        jButton_eliminarPedido.setFont(new java.awt.Font("Verdana", 3, 13)); // NOI18N
        jButton_eliminarPedido.setText("ELIMINAR ");
        jButton_eliminarPedido.setBorder(null);
        jButton_eliminarPedido.setFocusable(false);
        jButton_eliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarPedidoActionPerformed(evt);
            }
        });
        jPanelPedido.add(jButton_eliminarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 90, 40));
        jButton_eliminarPedido.setVisible(false);

        jButton_cancelarPedidos.setFont(new java.awt.Font("Verdana", 3, 13)); // NOI18N
        jButton_cancelarPedidos.setText("CANCELAR");
        jButton_cancelarPedidos.setBorder(null);
        jButton_cancelarPedidos.setFocusable(false);
        jButton_cancelarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarPedidosActionPerformed(evt);
            }
        });
        jPanelPedido.add(jButton_cancelarPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 90, 40));

        jPanelPrincipal.add(jPanelPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 640, 310));

        jPanelPedidosR.setBackground(new java.awt.Color(255, 180, 86));
        jPanelPedidosR.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Realizado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 24))); // NOI18N
        jPanelPedidosR.setOpaque(false);
        jPanelPedidosR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(null);

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "PRODUCTO", "CANT.", "UNIDAD", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jTable1.setSelectionBackground(new java.awt.Color(204, 102, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(75);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(75);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(75);
        }

        jPanelPedidosR.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 590, 330));

        jL_TOTAL.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jL_TOTAL.setText("PRECIO TOTAL:");
        jPanelPedidosR.add(jL_TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 160, -1));

        jLabel_$2.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel_$2.setForeground(new java.awt.Color(8, 75, 1));
        jLabel_$2.setText("$");
        jPanelPedidosR.add(jLabel_$2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        jL_precioTotal.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jL_precioTotal.setForeground(new java.awt.Color(0, 102, 0));
        jL_precioTotal.setText("0.0");
        jPanelPedidosR.add(jL_precioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 210, -1));

        jPanelPrincipal.add(jPanelPedidosR, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 640, 480));

        jPanel1.setBackground(new java.awt.Color(255, 180, 86));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Turno.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel_Turno.setText("TURNO:");
        jPanel1.add(jLabel_Turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        jComboBox_Turno.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jComboBox_Turno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Noche", "Tarde" }));
        jComboBox_Turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TurnoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_Turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 150, -1));

        jPanelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1870, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondos/thumb-1920-434741.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void jComboBox_TurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TurnoActionPerformed
        if(jComboBox_Turno.getSelectedItem().toString()=="Noche") { // Si la lista es de la noche carga lista de clientes fijos)
            jPanel_agregarcliente.setVisible(false);
            CargarListaClientesNoche(); 
            jList1.setSelectedIndex(0);
            jList1MouseClicked(null);
            jList1.requestFocus();
        } else {
            remito=null; // Se inicializa al apretar el click en el evento de mouse click de jlist
            cliente = null;
            producto = null;
            pedido = null;
            remitocreado=false;
            jPanel_agregarcliente.setVisible(true);
            ((DefaultListModel)jList1.getModel()).removeAllElements();
            CargarListaClientesTarde();
            if(jList1.getModel().getSize()>0) {
                jList1.setSelectedIndex(0);
                jList1MouseClicked(null);
                jList1.requestFocus();
            }       
        }
        VaciarTabla(this.jTable2);  
        CargarPlanilla();
        jList1MouseClicked(null);
    }//GEN-LAST:event_jComboBox_TurnoActionPerformed
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        Limpiar();
        jButton_cancelarPedidosActionPerformed(null);
        if(((DefaultListModel)jList1.getModel()).getSize()>0) {  
            cliente=jList1.getSelectedValue();
            remito=new Remito();
            remito.setClient(cliente);
            remito.setFecha(getFecha());
            remito.setTurno(jComboBox_Turno.getModel().getSelectedItem().toString().charAt(0));
            remito.ObtenerRemito();
            CargarPedidos(remito,jTable1);
        } 
    }//GEN-LAST:event_jList1MouseClicked
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jTable2.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaseleccionada = jTable1.getSelectedRow();
        jTF_prodNombre.setEnabled(false);
        jTF_prodNombre.setText(jTable1.getValueAt(filaseleccionada, 1).toString());
        producto = (Producto)TA_producto.findItem(jTF_prodNombre.getText());
        jTF_prodCant.requestFocus();
        jTF_prodCant.selectAll();
        double precio=0;
        jTF_prodCant.setText(jTable1.getValueAt(filaseleccionada, 2).toString());
        char unid = jTable1.getValueAt(filaseleccionada,3).toString().charAt(0);
        String s="unidad";
        switch(unid) {
            case 'k': 
                jCB_prodUnidad.setSelectedIndex(0);
                precio=producto.getP_prec_k();
            break;
            case 'd':
                jCB_prodUnidad.setSelectedIndex(1);
                precio=producto.getP_prec_d();
            break;
            case 'u':
                jCB_prodUnidad.setSelectedIndex(2);
                precio=producto.getP_prec_u();
            break;        
        }
        jL_prodPrecio.setText(jTable1.getValueAt(filaseleccionada,4).toString());
        if((precio*Double.parseDouble(jTF_prodCant.getText())) != Double.parseDouble(jL_prodPrecio.getText())) {
            jCheckBox_PrecioEspecial.setSelected(true);
            jCheckBox_PrecioEspecial.setEnabled(true);
            jLabel1.setEnabled(true);
            jTextField1.setEnabled(true);
            jTextField1.setText(String.valueOf(Double.parseDouble(jL_prodPrecio.getText())/Double.parseDouble(jTF_prodCant.getText())));
        } else {
            jCheckBox_PrecioEspecial.setSelected(false);
            jCheckBox_PrecioEspecial.setEnabled(true);
            jLabel1.setEnabled(false);
            jTextField1.setEnabled(false);        
            jTextField1.setText("0");
        }
        jButton_agregarProd.setVisible(false);
        jButton_ModificarProd.setVisible(true);
        jButton_eliminarPedido.setVisible(true);
        
        pedido= new Pedido();
        pedido.setPrecio(Float.parseFloat(jL_prodPrecio.getText())); 
// Guardo el precio en el pedido global, para luego utilizarlo en el remito en caso de eliminar o modificar
    }//GEN-LAST:event_jTable1MouseClicked
    private void jTextField_AgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_AgregarClienteActionPerformed
        Cliente client=BuscarClienteAC(jTextField_AgregarCliente.getText());
        ArrayList<Integer> indice = new ArrayList<Integer>(); // Uso un arrayList para pasar por referencia
        if(client!=null) { 
            if( !contains(client, (DefaultListModel)jList1.getModel(), indice) ) { // Es decir si no lo contiene
                ((DefaultListModel)jList1.getModel()).add(indice.get(0), client); // Lo agrego a la lista
            } else { // Si lo contiene 
                JOptionPane.showMessageDialog(null, "El cliente ya se encuentra en la lista"); // MSJ
            }
            jTextField_AgregarCliente.setText("");
            icono_cNombreMAL.setVisible(false);
            icono_cNombreOK.setVisible(false);
            jList1.setSelectedIndex(indice.get(0));
            jList1MouseClicked(null);
            jTF_prodNombre.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Cliente incorrecto");
        }
    }//GEN-LAST:event_jTextField_AgregarClienteActionPerformed
    private void jTextField_AgregarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_AgregarClienteKeyTyped
        if ((int)evt.getKeyChar()==8) { // Si borra
            BuscarClienteAC(jTextField_AgregarCliente.getText()); // Le pasa el contenido de prodnombre sin borrar
        } else {
            BuscarClienteAC(jTextField_AgregarCliente.getText()+evt.getKeyChar()); // Si no borra y presiona otra tecla le pasa el contenido con el caracter, ya que no lo toma sino.
        } 
    }//GEN-LAST:event_jTextField_AgregarClienteKeyTyped
    private void jTextField_AgregarClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_AgregarClienteFocusLost
        BuscarClienteAC(jTextField_AgregarCliente.getText());
    }//GEN-LAST:event_jTextField_AgregarClienteFocusLost
    private void jButton_cancelarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarPedidosActionPerformed
        jTF_prodNombre.setText("");
        jTF_prodNombre.setEnabled(true);
        jTF_prodCant.setText("0");
        jCB_prodUnidad.setSelectedIndex(0);
        jLabel1.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField1.setText("0");
        jCheckBox_PrecioEspecial.setEnabled(true);
        jCheckBox_PrecioEspecial.setSelected(false);
        jButton_ModificarProd.setVisible(false);
        jButton_eliminarPedido.setVisible(false);
        jButton_agregarProd.setVisible(true);
        icono_pNombreOK.setVisible(false);
        icono_pNombreMAL.setVisible(false);
        producto=null;
        jTF_prodNombre.requestFocus();
    }//GEN-LAST:event_jButton_cancelarPedidosActionPerformed
    private void jButton_eliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarPedidoActionPerformed
        // Le resto el precio del pedido antes de modificar, ya que luego va a sumar el precio nuevo
        remito.setP_total(remito.getP_total()-pedido.getPrecio());
        remito.setP_abonado(remito.getP_abonado()-pedido.getPrecio());
        //////////////////////////////////////////////////////////////
        Pedido ped = new Pedido();
        ped.setProd(producto);
        ped.setCant(Float.parseFloat(jTF_prodCant.getText()));
        try {
            ped.Eliminar(remito);
            jButton_cancelarPedidosActionPerformed(null);
            Limpiar();
            CargarPedidos(remito, jTable1);
            if(jTable1.getRowCount()==0) {
                remito.EliminarRemito();
                if(cliente.getTipo()=='N') {
                    ((DefaultListModel)jList1.getModel()).removeElement(cliente);
                    jList1.setSelectedIndex(0);
                    jList1.requestFocus();
                }
            }
            VaciarTabla(jTable2);
            CargarPlanilla();
            JOptionPane.showMessageDialog(null, "El pedido se elimino correctamente");
            notificar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton_eliminarPedidoActionPerformed
    private void jCheckBox_PrecioEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_PrecioEspecialActionPerformed
        if(jCheckBox_PrecioEspecial.isSelected()) {
            jLabel1.setEnabled(true);
            jTextField1.setEnabled(true);
            CalcularPrecioIndividualCant(jTextField1.getText()); // Calcula precio individual con 0
        } else {
            jLabel1.setEnabled(false);
            jTextField1.setEnabled(false);
            CalcularPrecioIndividualCant(jTF_prodCant.getText()); // Calcula precio individual con 0
        }
    }//GEN-LAST:event_jCheckBox_PrecioEspecialActionPerformed
    private void jTF_prodNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_prodNombreKeyTyped
        if ((int)evt.getKeyChar()==8) { // Si borra
            producto=BuscarProductoAC(jTF_prodNombre.getText()); // Le pasa el contenido de prodnombre sin borrar
        } else {
            producto=BuscarProductoAC(jTF_prodNombre.getText()+evt.getKeyChar()); // Si no borra y presiona otra tecla le pasa el contenido con el caracter, ya que no lo toma sino.
        }
    }//GEN-LAST:event_jTF_prodNombreKeyTyped
    private void jTF_prodNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_prodNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            jButton_agregarProdActionPerformed(null);
        }
    }//GEN-LAST:event_jTF_prodNombreKeyPressed
    private void jTF_prodNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_prodNombreFocusLost
        producto=BuscarProductoAC(jTF_prodNombre.getText());
        if(jTF_prodNombre.isEnabled() && producto!=null) { // Pregunto si el jtf prod nombre est activo xq si no se forma un loop infinito del jtable mouse clicked, por lo tanto si se selecciona un producto ya cargado como pedido llama al evento del jtable y en este caso tl jt prodnombre si esta enabled. En el otro caso que se clickee en el jtable, se produce el evento y tambien el cambio de foco pero como esta en no enabled no entra en el if, por lo tanto no se forma un loop infinito
            BuscarPedidoEnTabla(producto.getP_cod(), jTable1);
        }
    }//GEN-LAST:event_jTF_prodNombreFocusLost
    private void jButton_ModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ModificarProdActionPerformed
        // Le resto el precio del pedido antes de modificar, ya que luego va a sumar el precio nuevo
        if(cliente.getDeuda()>0) {
            remito.setP_total(remito.getP_total()-pedido.getPrecio());
            remito.setP_abonado(remito.getP_abonado());
            //remito.setDeuda_actual();
        } else {
            remito.setP_total(remito.getP_total()-pedido.getPrecio());
            remito.setP_abonado(remito.getP_abonado()-pedido.getPrecio());
        }

        //////////////////////////////////////////////////////////////
        Pedido ped=new Pedido();
        ped.setProd(producto);
        ped.setCant(Float.parseFloat(jTF_prodCant.getText()));
        ped.setUnidad(jCB_prodUnidad.getSelectedItem().toString().charAt(0));
        ped.setPrecio(Float.parseFloat(jL_prodPrecio.getText()));
        try {
            ped.ModificarPedido(remito);
            jButton_cancelarPedidosActionPerformed(null);
            Limpiar();
            CargarPedidos(remito, jTable1);
            VaciarTabla(jTable2);
            CargarPlanilla();
            JOptionPane.showMessageDialog(null, "El pedido se modifico correctamente");
            notificar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton_ModificarProdActionPerformed
    private void jButton_agregarProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_agregarProdKeyPressed
        if (jButton_agregarProd.isVisible() && evt.getKeyCode() == KeyEvent.VK_F1) {
            jButton_agregarProdActionPerformed(null);
        }
    }//GEN-LAST:event_jButton_agregarProdKeyPressed
    private void jButton_agregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarProdActionPerformed
        if(jButton_agregarProd.isVisible()) {
            if((producto=BuscarProductoAC(jTF_prodNombre.getText()))==null){
                JOptionPane.showMessageDialog(null, "El producto ingresado es invalido");
            } else {
                AgregarPedido();
                jButton_cancelarPedidosActionPerformed(null);
                VaciarTabla(jTable2);
                CargarPlanilla(); // Por ahora asi por tiempo
            }
        }
    }//GEN-LAST:event_jButton_agregarProdActionPerformed
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char caracter = evt.getKeyChar();
        if((int)caracter!=46) {
            if(!Character.isDigit(caracter) && (int)caracter!=8) {
                evt.consume();
            } else {
                String pe = jTextField1.getText()+caracter; // ya que al capturar el evento no lo toma
                CalcularPrecioIndividualPE(pe);
            }
        } else {
            if(contadordepunto==0) { // si es el primero punto
                contadordepunto++; // suma el cont
            } else {
                evt.consume(); // Si ingresa mas de un punto se consume
            }
        }
    }//GEN-LAST:event_jTextField1KeyTyped
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            jButton_agregarProdActionPerformed(null);
        }
        if ((int)evt.getKeyChar()==8) {
            if(jTF_prodCant.getText().endsWith(".")) // Si lo que borra es un punto
            contadordepunto--; // resto el contador
        }
    }//GEN-LAST:event_jTextField1KeyPressed
    private void jCB_prodUnidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCB_prodUnidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            jButton_agregarProdActionPerformed(null);
        }
    }//GEN-LAST:event_jCB_prodUnidadKeyPressed
    private void jCB_prodUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_prodUnidadActionPerformed
        CalcularPrecioIndividualCant(jTF_prodCant.getText());
    }//GEN-LAST:event_jCB_prodUnidadActionPerformed
    private void jTF_prodCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_prodCantKeyTyped
        char caracter = evt.getKeyChar();
        if((int)caracter!=46) {
            if(!Character.isDigit(caracter) && (int)caracter!=8) {
                evt.consume();
            } else {
                String cantidad = jTF_prodCant.getText()+caracter; // ya que al capturar el evento no lo toma
                CalcularPrecioIndividualCant(cantidad);
            }
        } else {
            if(contadordepunto==0) { // si es el primero punto
                contadordepunto++; // suma el cont
            } else {
                evt.consume(); // Si ingresa mas de un punto se consume
            }
        }
    }//GEN-LAST:event_jTF_prodCantKeyTyped
    private void jTF_prodCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_prodCantKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            jButton_agregarProdActionPerformed(null);
        }
        if ((int)evt.getKeyChar()==8) {
            if(jTF_prodCant.getText().endsWith(".")) // Si lo que borra es un punto
            contadordepunto--; // resto el contador
        }
    }//GEN-LAST:event_jTF_prodCantKeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        new PlanillaGrande((DefaultTableModel)jTable2.getModel());
    }//GEN-LAST:event_jButton2MouseClicked
    /**************************************************************************************/
    private void CargarListaClientesNoche() {
        Cliente client = new Cliente();
        DefaultListModel modelo=new DefaultListModel();
        ArrayList<Cliente> clF= client.getArrayListClienteF("c_nom"); // Obtiene los clientes fijos
        //ArrayList<Cliente> clNF= client.getArrayListClientNFConRemito(getFecha(),'N'); // Obtiene los clientes no fijos con remitos del dia
        int i=0;
        /*while(!clNF.isEmpty()) {
            modelo.add(i,clNF.remove(i));
        }*/
        while(!clF.isEmpty()) {
            modelo.add(i,clF.remove(i));
        }
        jList1.setModel(modelo);// Recupero en la lista el nombre de los clientes fijos
    }
    private void CargarListaClientesTarde() {
        Cliente client = new Cliente();
        DefaultListModel modelo=new DefaultListModel();
        ArrayList<Cliente> clNF= client.getArrayListClienteNFyFConRemito(getFecha(),'T'); // Obtiene los clientes no fijos con remitos del dia
        int i=0;
        while(!clNF.isEmpty()) {
            modelo.add(i,clNF.remove(i));
        }
        jList1.setModel(modelo);    
    }
    public void AddItemsAutocompleterP_nom(TextAutoCompleter ta) {
        Producto prod = new Producto();
        ArrayList <Producto> array = prod.GetListProducto();
        int i=0;
        while(!array.isEmpty()) {
            ta.addItem(array.remove(i));
        }
    }
    public void AddItemsAutocompleterC_nom(TextAutoCompleter ta) {
        Cliente client = new Cliente();
        ArrayList <Cliente> array = client.GetListCliente();
        int i=0;
        while(!array.isEmpty()) {
            ta.addItem(array.remove(i));
        }
    }
    public void CalcularPrecioIndividualCant(String cant) {
        if(producto != null) {
            try {
                Float cantidad = Float.parseFloat(cant);
                if(!jCheckBox_PrecioEspecial.isSelected()) { // Si no se realiza un precio especial calcula de la forma comun
                    String opcion=jCB_prodUnidad.getSelectedItem().toString();
                    switch(opcion) {
                        case "kilo": 
                            jL_prodPrecio.setText(""+ cantidad * producto.getP_prec_k());
                        break;
                        case "docena":
                            jL_prodPrecio.setText(""+ cantidad * producto.getP_prec_d());
                        break;
                        case "unidad":
                            jL_prodPrecio.setText(""+ cantidad * producto.getP_prec_u());
                        break;
                    }
                } else { // Si se realiza un precio especial se debe calcular con el precio especial
                    jL_prodPrecio.setText(""+ cantidad * Float.parseFloat(jTextField1.getText()));
                }
            } catch(NumberFormatException e) {
                jL_prodPrecio.setText("0.0");
            } 
        } else {
            jL_prodPrecio.setText("0.0");
        }
    }
    public void CalcularPrecioIndividualPE(String PE) {
        if(producto != null) {
            try {
                Float pe = Float.parseFloat(PE);
                jL_prodPrecio.setText(""+ pe * Float.parseFloat(jTF_prodCant.getText()));
            } catch(NumberFormatException e) {
                jL_prodPrecio.setText("0.0");
            } 
        } else {
            jL_prodPrecio.setText("0.0");
        }
    }
    public String getFecha() {
        ZoneId zona = ZoneId.systemDefault();
        LocalDate ahora = LocalDate.now();
        ZonedDateTime inicioHoy = ahora.atStartOfDay(zona);
        Instant instante = inicioHoy.toInstant();
        Date fecha = Date.from(instante);       
        return fecha.toLocaleString().substring(0,10);
    }
    public void Limpiar() {
        jTF_prodNombre.setText("");
        icono_pNombreOK.setVisible(false);
        icono_pNombreMAL.setVisible(true);
        jTF_prodCant.setText("0");
        jCB_prodUnidad.setSelectedIndex(0);
        jL_prodPrecio.setText("0.0");
        while(jTable1.getRowCount()>0){
           ((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getRowCount()-1);
        }
        jTextField1.setEnabled(false);
        jLabel1.setEnabled(false);
        jL_precioTotal.setText("0.0");
    }
    private void CargarPedidos(Remito r, javax.swing.JTable tabla) {
        if(r.ObtenerRemito()) { // Si ya habia remito cargado 
            int i=0;
            while(i<r.getPed().size()) { //cargo los pedidos en la tabla pedido
                AgregarPedidoATabla(tabla, r.getPed().get(i++)); // Se carga el pedido i
            }
            jL_precioTotal.setText(String.valueOf(r.getP_total())); // Seteo el precio total
            remitocreado=true;
        } else {
            remitocreado=false;
        } 
    }
    private void AgregarPedido() {
        //Creo el pedido
        pedido=new Pedido();
        pedido.setProd(producto);
        if(jTF_prodCant.getText().isEmpty()) // Si es vacio le asigno 0
            jTF_prodCant.setText("0");
        pedido.setCant(Float.parseFloat(jTF_prodCant.getText()));
        pedido.setUnidad(jCB_prodUnidad.getSelectedItem().toString().charAt(0));
        pedido.setPrecio(Float.parseFloat(jL_prodPrecio.getText()));
        
        // El remito ya esta creado y tiene el cliente, la fecha y el turno. Falta el total, el abonado, la deuda y si es cancelado o no. El nro_r es asginado automaticamente en la BD
        if(cliente.getDeuda()>0) { // Si el cliente tiene deuda, cuando vuelve el remito, tiene que cargar lo que pago o si cancelo, cancelar la deuda, es decir, ingresar el pago en su totalidad.
            remito.setCancel(false); // Si tiene deuda, entonces lo pongo en falso, luego en administrar deuda se debe poner la cantidad abonada o si se cancelo la deuda
            remito.setP_total(remito.getP_total()+pedido.getPrecio());
            remito.setP_abonado(remito.getP_abonado()+0);
            remito.setDeuda_actual(cliente.getDeuda()+pedido.getPrecio()); 
            cliente.setDeuda(cliente.getDeuda()+pedido.getPrecio());
            cliente.ActualizarDeuda(); 
        } else {
            remito.setCancel(true); // Lo pongo en verdadero, pero si devuelven el remito es xq no se cancelo por lo tanto hay q administrar la deuda que incluye ponerlo en falso
            remito.setP_total(remito.getP_total()+pedido.getPrecio());
            remito.setP_abonado(remito.getP_abonado()+pedido.getPrecio());    
            remito.setDeuda_actual(cliente.getDeuda()+0);
            cliente.setDeuda(cliente.getDeuda()+0); // No hace falta actualizar la deuda en la BD
        }
        
        remito.agregarPedido(pedido); //Agrego el pedido al remito
        if(!remitocreado) {
            try {
                remito.AgregarRemito(); // Agrego el remito a la BD
                pedido.AgregarPedidoARemito(remito); //Agrego el pedido al remito en la BD
                AgregarPedidoATabla(jTable1,pedido); //Agregar pedido al JTable
                jL_precioTotal.setText(String.valueOf(remito.getP_total()));
                remitocreado=true; // El remito se creo
                notificar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            try {
                pedido.AgregarPedidoARemito(remito); //Agrego el pedido al ramito en la BD
                remito.Modificar(); // Actualizo el remito con los datos nuevos
                AgregarPedidoATabla(jTable1,pedido); //Agregar pedido al JTable
                jL_precioTotal.setText(String.valueOf(remito.getP_total()));
                notificar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }   
        }    
    }    
    private void AgregarPedidoATabla(javax.swing.JTable tabla,Pedido pedido) {
        String p_cod = pedido.getProd().getP_cod();
        String p_nom = pedido.getProd().getP_nom();
        String cant = String.valueOf(pedido.getCant());
        String unid= String.valueOf(pedido.getUnidad());
        String precio= String.valueOf(pedido.getPrecio());
        Object [] fila= new Object[5];
        fila[0]=p_cod;
        fila[1]=p_nom;
        fila[2]=cant;
        fila[3]=unid;
        fila[4]=precio;
        ((DefaultTableModel)tabla.getModel()).addRow(fila); 
    }
    private Producto BuscarProductoAC(String nombreproducto) {
         if(nombreproducto.isEmpty()) {
            icono_pNombreMAL.setVisible(false);
            icono_pNombreOK.setVisible(false);
            return null;
        } else {
            Producto producto=(Producto)TA_producto.findItem(nombreproducto);
            if(producto!=null) {
                icono_pNombreMAL.setVisible(false); // No visible el icono MAL
                icono_pNombreOK.setVisible(true); // Visible el icono OK
               
                char unid = producto.getPrecio_predeterminado();
                switch(unid) {
                    case 'k' : 
                        jCB_prodUnidad.setSelectedIndex(0);
                    break;
                    case 'd':
                        jCB_prodUnidad.setSelectedIndex(1);
                    break;
                    case 'u':
                        jCB_prodUnidad.setSelectedIndex(2);
                    break;
                }
            
            } else {
                icono_pNombreOK.setVisible(false); // No visible el icono OK
                icono_pNombreMAL.setVisible(true); // Visible el icono MAL  
            }
            return producto;
        }
    }
    private Cliente BuscarClienteAC(String nombrecliente) {
        if(nombrecliente.isEmpty()) {
            icono_cNombreMAL.setVisible(false);
            icono_cNombreOK.setVisible(false);
            return null;
        } else {
            Cliente client=(Cliente)TA_cliente.findItem(nombrecliente);
            if(client!=null) {
                icono_cNombreMAL.setVisible(false); // No visible el icono MAL
                icono_cNombreOK.setVisible(true); // Visible el icono OK
            } else {
                icono_cNombreOK.setVisible(false); // No visible el icono OK
                icono_cNombreMAL.setVisible(true); // Visible el icono MAL  
            }        
            return client;
        }
    }
    private void CargarPlanilla() {
        Remito r=new Remito();
        r.setFecha(getFecha());
        r.setTurno(jComboBox_Turno.getSelectedItem().toString().charAt(0));
        
        if(jComboBox_Turno.getSelectedItem().equals("Noche")) {
            ArrayList <Cliente> clientes = cliente.getArrayListClienteF("indice");
            int i=clientes.size()-1;
            while(i>=0) {
                if( i<clientes.size()-1 && clientes.get(i).getZona()!=clientes.get(i+1).getZona()) {
                    Object [] fila = {"","",""};
                    ((DefaultTableModel)jTable2.getModel()).addRow(fila);
                }
                Object [] fila = {clientes.get(i).getC_nom(),"",""};
                ((DefaultTableModel)jTable2.getModel()).addRow(fila);
                i--;
            }
            r.GetTablePlanillaNoche((DefaultTableModel)jTable2.getModel());
        } else {
            r.GetTablePlanillaTarde((DefaultTableModel)jTable2.getModel());
        }

    }
    private void VaciarTabla(javax.swing.JTable table){
        while(table.getRowCount()>0) {
           ((DefaultTableModel)table.getModel()).removeRow(table.getRowCount()-1);
        }
    
    }
    private void BuscarPedidoEnTabla(String p_cod,javax.swing.JTable tabla) {
        int filas = 0;
        while(filas < tabla.getRowCount()) {
            if(p_cod.equalsIgnoreCase(tabla.getValueAt(filas, 0).toString())) {
                jTable1.setRowSelectionInterval(filas, filas);
                jTable1MouseClicked(null);
                break;
            }
            filas++;
        }
    }
    private boolean contains(Cliente client, DefaultListModel m, ArrayList<Integer> pos) {
        String c_nom=client.getC_nom();
        Integer indice=0;
        pos.add(indice);
        while(pos.get(0)<m.getSize() && ((Cliente)m.get(pos.get(0))).getC_nom().compareToIgnoreCase(c_nom) < 0) {        
            pos.set(0, pos.get(0)+1);
        }
        if(pos.get(0)>=m.getSize() || !((Cliente)m.get(pos.get(0))).getC_nom().equalsIgnoreCase(c_nom)) {
            return false;
        } else {
            return true;
        }
    }

    private int contadordepunto=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icono_cNombreMAL;
    private javax.swing.JLabel icono_cNombreOK;
    private javax.swing.JLabel icono_pNombreMAL;
    private javax.swing.JLabel icono_pNombreOK;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_ModificarProd;
    private javax.swing.JButton jButton_agregarProd;
    private javax.swing.JButton jButton_cancelarPedidos;
    private javax.swing.JButton jButton_eliminarPedido;
    private javax.swing.JComboBox<String> jCB_prodUnidad;
    private javax.swing.JCheckBox jCheckBox_PrecioEspecial;
    private javax.swing.JComboBox<String> jComboBox_Turno;
    private javax.swing.JLabel jL_PRECIO;
    private javax.swing.JLabel jL_TOTAL;
    private javax.swing.JLabel jL_precioTotal;
    private javax.swing.JLabel jL_prodCant;
    private javax.swing.JLabel jL_prodNombre;
    private javax.swing.JLabel jL_prodPrecio;
    private javax.swing.JLabel jL_prodUnidad;
    private javax.swing.JLabel jL_sel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_$1;
    private javax.swing.JLabel jLabel_$2;
    private javax.swing.JLabel jLabel_Turno;
    private javax.swing.JList<Cliente> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JPanel jPanelPedidosR;
    private javax.swing.JPanel jPanelPlanilla;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanel_agregarcliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTF_prodCant;
    private javax.swing.JTextField jTF_prodNombre;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_AgregarCliente;
    // End of variables declaration//GEN-END:variables

    
    /******************************************** Observador *********************************************/
    @Override
    public void update() {
        TA_cliente.removeAllItems();
        AddItemsAutocompleterC_nom(TA_cliente);
        jComboBox_TurnoActionPerformed(null);
    }
    
    public void ObservarSujeto(SujetoObservable sujeto) {
            sujeto.añadir(this);
    }
    
    /********************************************Sujeto Observable*****************************************/

    private ArrayList<Observador> observadores;
    
    @Override
    public void añadir(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminar(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificar() {
        int i=0;
        while(i<observadores.size()) {
            observadores.get(0).update();
            i++;
        }   
    }
}