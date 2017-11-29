package Vista;

import Control.Pedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class DatosEstadisticas extends javax.swing.JFrame{
    SujetoObservable so;
    
    public DatosEstadisticas() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadísticas");
        setMaximumSize(new java.awt.Dimension(820, 460));
        setMinimumSize(new java.awt.Dimension(820, 460));
        setPreferredSize(new java.awt.Dimension(820, 460));
        setResizable(false);
        setSize(new java.awt.Dimension(820, 460));

        jPanel1.setBackground(new java.awt.Color(225, 178, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(225, 178, 86));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("Fecha:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jDateChooser1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 159, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Unidad:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kg", "docena", "unidad" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 159, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        jButton1.setText("Abrir ventana estadística");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 180, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(124, 56, 14));
        jLabel5.setText("pedidos");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 220, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(124, 56, 14));
        jLabel6.setText("Estadisticas de productos");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 740, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 760, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String formato = this.jDateChooser1.getDateFormatString();
        Date date = this.jDateChooser1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato); 
        String fecha = String.valueOf(sdf.format(date));
        String unidad = jComboBox1.getSelectedItem().toString();
        DefaultCategoryDataset ds= new DefaultCategoryDataset();
        generarBarras(fecha,unidad);
    }//GEN-LAST:event_jButton1MouseClicked

    public void generarBarras(String fecha, String unidad) {
        try {
            Pedido pedido= new Pedido();
            ArrayList <Object[]> pedidos = pedido.ObtenerPedidos(fecha, unidad.charAt(0));
            int i=0;
            DefaultCategoryDataset ds= new DefaultCategoryDataset();
            while(i<pedidos.size()) {
                Object[] ob=pedidos.get(i);
                ds.addValue(Float.parseFloat(ob[1].toString()),ob[0].toString(),ob[0].toString());
                i++;
            }
            JFreeChart jc=ChartFactory.createBarChart3D("Cantidades Vendidas por "+unidad, "Producto", "Cantidad", ds, PlotOrientation.VERTICAL, true, true, true);
            
            ChartFramee cf= new ChartFramee("Fecha:"+fecha,jc);
            cf.setFecha(fecha);
            cf.setUnidad(unidad);
            cf.ObservarSujeto(so);
            
            cf.setSize(688, 384);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch(Exception e) {
            System.out.println("Error "+e);
        }
    }

    public void SetSujeto(SujetoObservable so) {
        this.so=so;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
