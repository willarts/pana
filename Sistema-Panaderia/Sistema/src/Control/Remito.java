package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Remito {
    private int r_num;
    private Cliente client;
    private ArrayList <Pedido> ped=new ArrayList();
    private String fecha;
    private float p_total;
    private float p_abonado;
    private float deuda_actual; // deuda a la fecha
    private boolean cancel;
    private char turno;
    
    /**
     * @return the r_num
     */
    public int getR_num() {
        return r_num;
    }

    /**
     * @param r_num the r_num to set
     */
    public void setR_num(int r_num) {
        this.r_num = r_num;
    }

    /**
     * @return the client
     */
    public Cliente getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Cliente client) {
        this.client = client;
    }
    

    /**
     * @return the ped
     */
    public ArrayList <Pedido> getPed() {
        return ped;
    }

    /**
     * @param ped the ped to set
     */
    public void setPed(ArrayList <Pedido> ped) {
        this.ped = ped;
    }
    
    public void agregarPedido(Pedido ped) {
        this.ped.add(ped);
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the p_total
     */
    public float getP_total() {
        return p_total;
    }

    /**
     * @param p_total the p_total to set
     */
    public void setP_total(float p_total) {
        this.p_total = p_total;
    }

    /**
     * @return the p_abonado
     */
    public float getP_abonado() {
        return p_abonado;
    }

    /**
     * @param p_abonado the p_abonado to set
     */
    public void setP_abonado(float p_abonado) {
        this.p_abonado = p_abonado;
    }

    /**
     * @return the deuda_actual
     */
    public float getDeuda_actual() {
        return deuda_actual;
    }

    /**
     * @param deuda_actual the deuda_actual to set
     */
    public void setDeuda_actual(float deuda_actual) {
        this.deuda_actual = deuda_actual;
    }

    /**
     * @return the cancel
     */
    public boolean isCancel() {
        return cancel;
    }

    /**
     * @param cancel the cancel to set
     */
    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * @return the turno
     */
    public char getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(char turno) {
        this.turno = turno;
    }
    
    private void ArmarArregloPedido(javax.swing.JTable jtable) {
        int filas = jtable.getRowCount(),i=0;
        while(i<filas) {
            Pedido pedid=new Pedido();
            // Traigo el producto correspondiente a cada pedido de la tabla
            ResultSet rs = Conexion.getInstance().ObtenerProductoCodigo(jtable.getModel().getValueAt(i, 1).toString()); // Obtiene tabla con el producto correspondiente a dicho codigo
            jTable tablaprod = new jTable(new javax.swing.JTable(0,5).getModel(),rs); // Creo tabla de producto
            Producto prod = new Producto();
            // Seteo producto
            prod.setP_cod(tablaprod.getModel().getValueAt(0, 0).toString());
            prod.setP_nom(tablaprod.getModel().getValueAt(0, 1).toString());
            prod.setP_prec_k(Float.parseFloat(tablaprod.getModel().getValueAt(0, 2).toString()));
            prod.setP_prec_d(Float.parseFloat(tablaprod.getModel().getValueAt(0, 3).toString()));
            prod.setP_prec_u(Float.parseFloat(tablaprod.getModel().getValueAt(0, 4).toString()));
            // Seteo pedido
            pedid.setProd(prod);
            pedid.setCant(Float.parseFloat(jtable.getModel().getValueAt(i, 2).toString()));
            pedid.setUnidad(jtable.getModel().getValueAt(i, 3).toString().charAt(0));
            pedid.setPrecio(Float.parseFloat(jtable.getModel().getValueAt(i, 4).toString()));
            //Agrego el pedido al arraylist
            agregarPedido(pedid);
            //Incrementar variable
            i++;
        }
    }
    
    public boolean ObtenerRemito() { // retorna true si hay remito si no false
        ResultSet rs = Conexion.getInstance().ObtenerRemitoCliente(fecha, turno, client);
        jTable table = new jTable(new javax.swing.JTable(0,8).getModel(),rs);
        if(table.getModel().getRowCount()>0) { // un if ya que solo puede haber 1 solo remito en dicho turno
           setR_num(Integer.parseInt(table.getModel().getValueAt(0, 0).toString()));
           setP_total(Float.parseFloat(table.getModel().getValueAt(0, 3).toString()));
           setP_abonado(Float.parseFloat(table.getModel().getValueAt(0, 4).toString()));
           setDeuda_actual(Float.parseFloat(table.getModel().getValueAt(0, 5).toString()));
           setCancel(Boolean.parseBoolean(table.getModel().getValueAt(0, 6).toString()));
           ResultSet rs2 = Conexion.getInstance().ObtenerPedidosRemito(this);
           jTable tablepedido = new jTable(new javax.swing.JTable(0,5).getModel(),rs2);
           setPed(new ArrayList());
           ArmarArregloPedido(tablepedido);
           return true;
        } else {
            setP_total(0);
            setP_abonado(0);
            setDeuda_actual(0);
            setCancel(false);
            return false;
        }
    }
    
    public void AgregarRemito() throws SQLException {
        setR_num(Conexion.getInstance().AltaRemito(this));
    }
    
    private String FilaPedido(ResultSet R)   {
        jTable tPedidos = new jTable(new javax.swing.JTable(0,3).getModel(),R);
        int countrows=0;
        String Producto;
        String Cant;
        String Unidad;
        String Fila = "";
        while(countrows < tPedidos.getRowCount()) {
            Producto = tPedidos.getModel().getValueAt(countrows,0).toString();
            Cant = tPedidos.getModel().getValueAt(countrows,1).toString();
            Unidad = tPedidos.getModel().getValueAt(countrows,2).toString();
            Fila += Cant+" "+Unidad+" "+Producto+", ";
            countrows++;
        }
        return Fila;
    }
    
    public javax.swing.table.TableModel GetTablePlanillaTarde(DefaultTableModel model ) {
        ResultSet rs = Conexion.getInstance().ObtenerRemitosFechaTurno(fecha,turno);
        jTable tRemitos = new jTable(new javax.swing.JTable(0,4).getModel(),rs);
        javax.swing.JTable tPlanilla = new javax.swing.JTable(model);
        if(tRemitos.getModel().getRowCount()!=0){
                int countitems=0;
                String zona= tRemitos.getModel().getValueAt(countitems,3).toString();
                while(countitems < tRemitos.getModel().getRowCount()) {
                        ResultSet resut = Conexion.getInstance().ObtenerPedidosRemito(Integer.parseInt(tRemitos.getModel().getValueAt(countitems,0).toString()));
                        String Pedido = this.FilaPedido(resut);
                        String zonaAux= tRemitos.getModel().getValueAt(countitems,3).toString();
                        Object [] fila= new Object[3];
                        if(zona.equals(zonaAux) ){
                                fila[0]=tRemitos.getModel().getValueAt(countitems,1).toString();
                                fila[1]=Pedido;
                                fila[2]=tRemitos.getModel().getValueAt(countitems,2).toString();
                                ((DefaultTableModel)(tPlanilla.getModel())).addRow(fila);
                                countitems++;
                        } else {
                            fila[0]="";
                            fila[1]="";
                            fila[2]="";
                           ((DefaultTableModel)(tPlanilla.getModel())).addRow(fila);
                            zona = tRemitos.getModel().getValueAt(countitems,3).toString();
                        }        
                }//end While
            }//end if
       return tPlanilla.getModel();
    }
    
    public void GetTablePlanillaNoche(DefaultTableModel model ) {
        ResultSet rs = Conexion.getInstance().Consulta("SELECT r_nro,C.c_nom,p_total FROM remito as R,cliente as C WHERE R.c_nom = C.c_nom and fecha='"+fecha+"' and turno='"+turno+"' order by C.indice");
        jTable tRemitos = new jTable(new javax.swing.JTable(0,3).getModel(),rs);
        if(tRemitos.getModel().getRowCount()!=0){
                int countitems=0;
                int cont=0;
                while(countitems < tRemitos.getModel().getRowCount()) {
                        ResultSet resut = Conexion.getInstance().ObtenerPedidosRemito(Integer.parseInt(tRemitos.getModel().getValueAt(countitems,0).toString()));
                        String Pedido = FilaPedido(resut);
                        Object [] fila= new Object[3];

                        fila[0]=tRemitos.getModel().getValueAt(countitems,1).toString();
                        fila[1]=Pedido;
                        fila[2]=tRemitos.getModel().getValueAt(countitems,2).toString();

                        //Busqueda de cliente
                        while(cont < model.getRowCount() && !model.getValueAt(cont,0).toString().equalsIgnoreCase(fila[0].toString())) {
                            cont ++;
                        }
                        model.removeRow(cont);
                        model.insertRow(cont, fila);
                        countitems++;
                }//end While
            }//end if
    }
    
    public javax.swing.JTable GetTablaRemitosAdeudados(TableModel modelo,String nombre) {
        ResultSet rs = Conexion.getInstance().ObtenerRemitosAdeudados(nombre);
        jTable tRemitos = new jTable(modelo,rs);
        return tRemitos;
    }
    
    public void EliminarRemito() throws SQLException {
        Conexion.getInstance().BajaRemito(getR_num());
    }
    
    public javax.swing.JTable GetAllRemitosClientDesdeHasta(String c_nom, String desde, String hasta, DefaultTableModel model) {
        ResultSet rs= Conexion.getInstance().GetAllRemitosClientDesdeHasta(c_nom, desde, hasta);
        jTable table = new jTable(model,rs);
        return table;
    }
    
    public void Modificar() throws SQLException {
        Conexion.getInstance().Update("remito","p_total="+getP_total()+", p_abonado="+getP_abonado()+", deuda_actual="+getDeuda_actual()+", cancel="+isCancel(),"r_nro="+getR_num());
    }
    
    public void ObtenerPedidos() {
        ResultSet rs = Conexion.getInstance().ObtenerPedidoDeRemito(this);
        jTable tabla = new jTable(new javax.swing.JTable(0,4).getModel(),rs);
        ArrayList <Pedido> pedidos = new ArrayList <Pedido>();
        int fila = 0;
        while(fila<tabla.getRowCount()) {
            Producto producto = new Producto();
            try {
                producto.GetProductoCod(tabla.getModel().getValueAt(fila, 0).toString());
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
                producto=null;
            }
            Pedido pedido = new Pedido();
            pedido.setProd(producto);
            pedido.setCant(Float.valueOf(tabla.getModel().getValueAt(fila, 1).toString()));
            pedido.setUnidad(tabla.getModel().getValueAt(fila, 2).toString().charAt(0));
            pedido.setPrecio(Float.valueOf(tabla.getModel().getValueAt(fila, 3).toString()));
            pedidos.add(pedido);
            fila++;
        }
        this.setPed(pedidos);
    }
}