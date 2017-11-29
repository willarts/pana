/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author gonza
 */
public interface SujetoObservable {
    public void añadir(Observador o);
    public void eliminar(Observador o);
    public void notificar();
}
