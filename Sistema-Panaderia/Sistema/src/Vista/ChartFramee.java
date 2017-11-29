package Vista;

import Control.Pedido;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartFramee extends ChartFrame implements Observador{
    private String fecha;
    private String unidad;
    SujetoObservable o;
    
    public ChartFramee(String title, JFreeChart chart) {
        super(title, chart);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                fWindowClosing(winEvt);
            }
        });
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fWindowClosing(java.awt.event.WindowEvent evt) {
        o.eliminar(this);
        dispose();
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

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
            cf.ObservarSujeto(o);
            
            cf.setSize(688, 384);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch(Exception e) {
            System.out.println("Error "+e);
        }
    }
    
    public void ObservarSujeto(SujetoObservable sujeto) {
        o=sujeto;
        sujeto.añadir(this);
    }
    
    @Override
    public void update() {
        dispose();
        o.eliminar(this);
        generarBarras(fecha,unidad);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
