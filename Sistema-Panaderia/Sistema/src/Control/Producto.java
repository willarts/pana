/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gonza
 */
public class Producto {
    private String p_cod;
    private String p_nom;
    private double p_prec_k;
    private double p_prec_d;
    private double p_prec_u;
    private char precio_predeterminado;

    /**
     * @return the p_cod
     */
    public String getP_cod() {
        return p_cod;
    }

    /**
     * @param p_cod the p_cod to set
     */
    public void setP_cod(String p_cod) {
        this.p_cod = p_cod;
    }

    /**
     * @return the p_nom
     */
    public String getP_nom() {
        return p_nom;
    }

    /**
     * @param p_nom the p_nom to set
     */
    public void setP_nom(String p_nom) {
        this.p_nom = p_nom;
    }

    /**
     * @return the p_prec_k
     */
    public double getP_prec_k() {
        return p_prec_k;
    }

    /**
     * @param p_prec_k the p_prec_k to set
     */
    public void setP_prec_k(double p_prec_k) {
        this.p_prec_k = p_prec_k;
    }

    /**
     * @return the p_prec_d
     */
    public double getP_prec_d() {
        return p_prec_d;
    }

    /**
     * @param p_prec_d the p_prec_d to set
     */
    public void setP_prec_d(double p_prec_d) {
        this.p_prec_d = p_prec_d;
    }

    /**
     * @return the p_prec_u
     */
    public double getP_prec_u() {
        return p_prec_u;
    }

    /**
     * @param p_prec_u the p_prec_u to set
     */
    public void setP_prec_u(double p_prec_u) {
        this.p_prec_u = p_prec_u;
    }
    
    /**
     * @return the precio_predeterminado
     */
    public char getPrecio_predeterminado() {
        return precio_predeterminado;
    }

    /**
     * @param precio_predeterminado the precio_predeterminado to set
     */
    public void setPrecio_predeterminado(char precio_predeterminado) {
        this.precio_predeterminado = precio_predeterminado;
    }
    
    @Override
    public String toString() {
        return this.getP_nom();
    }
    
    private ArrayList <Producto> GetArrayListProd(jTable table) {        
        ArrayList<Producto> array = new ArrayList();
        int i = 0;
        while(i < table.getModel().getRowCount())
        {
            Producto p=new Producto();
            p.setP_cod(table.getModel().getValueAt(i, 0).toString());
            p.setP_nom(table.getModel().getValueAt(i, 1).toString());
            p.setP_prec_k(Double.parseDouble(table.getModel().getValueAt(i, 2).toString()));
            p.setP_prec_d(Double.parseDouble(table.getModel().getValueAt(i, 3).toString()));
            p.setP_prec_u(Double.parseDouble(table.getModel().getValueAt(i, 4).toString()));
            p.setPrecio_predeterminado(table.getModel().getValueAt(i, 5).toString().charAt(0));
            array.add(p);
            i++;
        }
        return array;
    }
    
    public ArrayList<Producto> GetListProducto(){
        ResultSet r=Conexion.getInstance().ObtenerProductos();
        jTable table=new jTable(new javax.swing.JTable(0,6).getModel(),r);
        return GetArrayListProd(table);  
    }   
    
    public void GetProductoNombre(String p_nom) throws SQLException {
        ResultSet r=Conexion.getInstance().ObtenerProductoNombre(p_nom);
        if(r.next()) {
            setP_cod(r.getString(1));
            setP_nom(r.getString(2));
            setP_prec_k(Double.parseDouble(r.getString(3)));
            setP_prec_d(Double.parseDouble(r.getString(4)));
            setP_prec_u(Double.parseDouble(r.getString(5)));
            setPrecio_predeterminado(r.getString(6).charAt(0));
        } else {
            SQLException ex = new SQLException("No se encontro el producto");
            throw ex;
        }
    }
    
        public void GetProductoCod(String p_cod) throws SQLException {
        ResultSet r=Conexion.getInstance().ObtenerProductoCod(p_cod);
        if(r.next()) {
            setP_cod(r.getString(1));
            setP_nom(r.getString(2));
            setP_prec_k(Double.parseDouble(r.getString(3)));
            setP_prec_d(Double.parseDouble(r.getString(4)));
            setP_prec_u(Double.parseDouble(r.getString(5)));
            setPrecio_predeterminado(r.getString(6).charAt(0));
        } else {
            SQLException ex = new SQLException("No se encontro el producto");
            throw ex;
        }
    }


}
