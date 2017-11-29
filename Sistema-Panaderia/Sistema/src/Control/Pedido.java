/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author gonza
 */
public class Pedido {
    private Producto prod;
    private float cant;
    private char unidad;
    private float precio;
    /**
     * @return the prod
     */
    public Producto getProd() {
        return prod;
    }

    /**
     * @param prod the prod to set
     */
    public void setProd(Producto prod) {
        this.prod = prod;
    }

    /**
     * @return the cant
     */
    public float getCant() {
        return cant;
    }

    /**
     * @param cant the cant to set
     */
    public void setCant(float cant) {
        this.cant = cant;
    }

    /**
     * @return the unidad
     */
    public char getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(char unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }   
    
    public void AgregarPedidoARemito(Remito r)  throws SQLException{
        Conexion.getInstance().AltaPedido(r.getR_num(),this); // Agrego el pedido
    }
    
    public void ModificarPedido(Remito r) throws SQLException {
        Conexion.getInstance().ModificarPedido(r.getR_num(), this);
        r.setP_total(r.getP_total()+getPrecio());
        r.setP_abonado(r.getP_abonado()+getPrecio());
        Conexion.getInstance().ModificarRemito(r.getR_num(), r.getP_total(), r.getP_abonado(), r.getDeuda_actual());
    }
    
    public void Eliminar(Remito r) throws SQLException {
        Conexion.getInstance().BajaPedido(r.getR_num(),getProd().getP_cod());
        Conexion.getInstance().ModificarRemito(r.getR_num(), r.getP_total(), r.getP_abonado(), r.getDeuda_actual());
    }
    
    public ArrayList ObtenerPedidos(String fecha, char unidad ) {
        ResultSet rs=Conexion.getInstance().ObtenerPedidosCant(fecha, unidad);
        jTable table = new jTable(new javax.swing.JTable(0,2).getModel(),rs);
        TableModel tablemodel=table.getModel();
        ArrayList <Object[]> array = new ArrayList();
        int filas=tablemodel.getRowCount(),i=0;
        System.out.println(filas);
        while(i<filas) {
            Object [] ped = new Object[2];
            ped[0]=tablemodel.getValueAt(i, 0).toString();
            ped[1]=tablemodel.getValueAt(i, 1).toString();
            array.add(ped);
            i++;
        }
        return array;    
    }
}