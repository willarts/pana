/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author gonza
 */
public class Factura {
    private Remito remito;
    private String f_fecha; // fecha en la que se realizo la factura
    
    /**
     * @return the remito
     */
    public Remito getRemito() {
        return remito;
    }

    /**
     * @param remito the remito to set
     */
    public void setRemito(Remito remito) {
        this.remito = remito;
    }
    

    /**
     * @return the f_fecha
     */
    public String getF_fecha() {
        return f_fecha;
    }

    /**
     * @param f_fecha the f_fecha to set
     */
    public void setF_fecha(String f_fecha) {
        this.f_fecha = f_fecha;
    }
    
}
