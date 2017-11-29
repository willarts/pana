/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandra
 */
public class jTable extends javax.swing.JTable {
    int CantidadColumnas,CantidadFilas;
    Object [] fila;
    DefaultTableModel modelo;
    ResultSet r;
    ArrayList array;
    
    public jTable(javax.swing.table.TableModel Model,ResultSet r)
    {       
        setModel(Model);
        CantidadColumnas=getColumnCount();
        CantidadFilas=getRowCount();
        fila=new Object[CantidadColumnas];
        modelo=(DefaultTableModel)this.getModel();
        this.r=r;
        ArmarTabla();
    }
    
    public jTable(javax.swing.table.TableModel Model,ArrayList array) {
        setModel(Model);
        CantidadColumnas=getColumnCount();
        CantidadFilas=getRowCount();
        fila=new Object[CantidadColumnas];
        modelo=(DefaultTableModel)this.getModel();
        this.array=array;
        ArmarTablaArray();    
    }
    
    private void ArmarTabla() 
    {
        int i=1;
        Object [] fila= new Object[CantidadColumnas];
        try{
            while(r.next())
            {
                while(i<=CantidadColumnas)
                {
                    fila[i-1]=r.getObject(i);
                    i++;
                }
                modelo.addRow(fila); 
                i=1;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
    
    private void ArmarTablaArray() {
        int i=0,j=0;
        Object [] fila= new Object[CantidadColumnas];
            while(i<array.size())
            {
                while(j<CantidadColumnas)
                {
                    fila[j]=array.get(j).toString();
                    j++;
                }
                modelo.addRow(fila); 
                i++;
            }   
    }
    
    
    
    public javax.swing.table.DefaultTableModel getModeloTablaArmada()
    {
        return modelo;
    }
}
