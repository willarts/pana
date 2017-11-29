package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {
    
    private String c_nom;
    private String dir;
    private String tel;
    private char tipo;
    private char zona;
    private float deuda;
    private boolean baja;
    int indice;
    

    public String getC_nom() {
        return c_nom;
    }

    public void setC_nom(String c_nom) {
        this.c_nom = c_nom;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getZona() {
        return zona;
    }

    public void setZona(char zona) {
        this.zona = zona;
    }
    
    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }
    
    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
    
    public int getIndice() {
        return indice;
    }
    
    public void setIndice(int indice) {
        this.indice=indice;
    }

    public javax.swing.JTable getTableClienteDeuda(javax.swing.table.TableModel model) {
        ResultSet r=Conexion.getInstance().ObetenerClientesDeuda();
        jTable tabla=new jTable(model,r);
        return tabla;
    }
    
    private javax.swing.JTable getTableClientF(String orderby){
        
        ResultSet r=Conexion.getInstance().ObetenerClientesFijos(orderby); // Recupero tabla ResultSet de clientes
        //transformamos la tabla ResultSet a una JTable
        jTable tabla= new jTable(new javax.swing.JTable(0,8).getModel(),r); // Ya que la tabla contiene 7 columnas, las filas no importan xq necesitamos el modelo de una tabla de 6 columnas (conociendo la base de datos)
        return tabla;  
    }
    
    public ArrayList<Cliente> getArrayListClienteF(String orderby) {
        javax.swing.table.TableModel tablemodel=getTableClientF(orderby).getModel(); // Recupero Tabla Con los clientes fijos
        ArrayList<Cliente> array = new ArrayList();
        int filas=tablemodel.getRowCount(),i=0;
        while(i<filas) {
            Cliente cl = new Cliente();
            cl.setC_nom(tablemodel.getValueAt(i, 0).toString());
            cl.setDir(tablemodel.getValueAt(i, 1).toString());
            cl.setTel(tablemodel.getValueAt(i, 2).toString());
            cl.setTipo(tablemodel.getValueAt(i, 3).toString().charAt(0));
            cl.setZona(tablemodel.getValueAt(i, 4).toString().charAt(0));
            cl.setDeuda(Float.parseFloat(tablemodel.getValueAt(i, 5).toString()));
            cl.setBaja(Boolean.valueOf(tablemodel.getValueAt(i, 6).toString()));
            cl.setIndice(Integer.valueOf(tablemodel.getValueAt(i, 7).toString()));
            array.add(cl);
            i++;
        }
        return array;
    }
    
    public ArrayList<Cliente> getArrayListClientNFConRemito(String fecha, char turno) {
        ResultSet r=Conexion.getInstance().ObtenerClientesNFConRemito(fecha, turno);
        jTable table=new jTable(new javax.swing.JTable(0,6).getModel(),r);
        return GetArrayListCliente(table);
    }
    
    public ArrayList<Cliente> getArrayListClienteNFyFConRemito(String fecha, char turno) {
        ResultSet r=Conexion.getInstance().ObtenerClientesNFyFConRemito(fecha, turno);
        jTable table=new jTable(new javax.swing.JTable(0,6).getModel(),r);
        return GetArrayListCliente(table);
    }
    
    /////////////////////////////////////////////////////////
    
    private ArrayList <Cliente> GetArrayListCliente(jTable table) {        
        ArrayList<Cliente> array = new ArrayList();
        int i = 0;
        while(i < table.getModel().getRowCount())
        {
            Cliente c=new Cliente();
            c.setC_nom(table.getModel().getValueAt(i,0).toString());
            c.setDir(table.getModel().getValueAt(i,1).toString());
            c.setTel( table.getModel().getValueAt(i,2).toString());
            c.setTipo(table.getModel().getValueAt(i,3).toString().charAt(0));
            c.setZona(table.getModel().getValueAt(i,4).toString().charAt(0));
            c.setDeuda(Float.parseFloat( table.getModel().getValueAt(i,5).toString()));
            array.add(c);
            i++;
        }
        return array;
    }
    
    public ArrayList<Cliente> GetListCliente(){
        ResultSet r=Conexion.getInstance().ObetenerClientes();
        jTable table=new jTable(new javax.swing.JTable(0,6).getModel(),r);
        return GetArrayListCliente(table);  
    }
    
    public ArrayList<Cliente> GetListAllCliente(){
        ResultSet r=Conexion.getInstance().GetAllClient();
        jTable table=new jTable(new javax.swing.JTable(0,6).getModel(),r);
        return GetArrayListCliente(table);  
    }
    
    public int AgregarCliente() throws SQLException{
        Cliente clienteBaja = new Cliente();
        clienteBaja.setC_nom(c_nom);
        if(clienteBaja.BuscarCliente()){
            if(clienteBaja.isBaja())
            {
                this.Modificar();
                return 2;
            }
            else return 0;
        }
        else{
            
            Conexion.getInstance().AltaCliente(c_nom, dir, tel, tipo, zona);
            return 1;
        }
    }

    public boolean BuscarCliente() throws SQLException
    {
        ResultSet Rs = Conexion.getInstance().BuscarCliente(c_nom);
        jTable tCliente = new jTable(new javax.swing.JTable(0,7).getModel(),Rs);
        if (tCliente.getModel().getRowCount() ==1)
        {
            c_nom= tCliente.getModel().getValueAt(0,0).toString();
            dir = tCliente.getModel().getValueAt(0,1).toString();;
            tel= tCliente.getModel().getValueAt(0,2).toString();
            tipo= tCliente.getModel().getValueAt(0,3).toString().charAt(0);
            zona= tCliente.getModel().getValueAt(0,4).toString().charAt(0);
            deuda= Float.parseFloat( tCliente.getModel().getValueAt(0,5).toString());
            setBaja((boolean) Boolean.valueOf(tCliente.getModel().getValueAt(0,6).toString()));
            return true;
        }
        else return false;
    }
    
     public void Modificar() throws SQLException{
        Conexion.getInstance().ModificarCliente(getC_nom(), getDir(), getTel(), getTipo(), getZona(), getDeuda());
    }
     
     public void ActualizarDeuda() {
         Conexion.getInstance().Consulta("UPDATE cliente SET deuda='"+getDeuda()+"' WHERE c_nom='"+getC_nom()+"'");
     }
             
     public void Baja() throws SQLException{
        Conexion.getInstance().BajaCliente(true,c_nom);
    }
     
    public void CancelarDeuda(Remito r) throws SQLException {
        Conexion.getInstance().Update("remito", "cancel='true'", "c_nom='"+getC_nom()+"'");
        Conexion.getInstance().Update("cliente", "deuda='0'", "c_nom='"+getC_nom()+"'" );
        float p_abonado=r.getP_abonado()+r.getDeuda_actual();
        Conexion.getInstance().Update("remito", "deuda_actual='0', p_abonado='"+p_abonado+"'", "r_nro='"+r.getR_num()+"'");
    }
    
    @Override
    public String toString() {
        return getC_nom();
    }
}
