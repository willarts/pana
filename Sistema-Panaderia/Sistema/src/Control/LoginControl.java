/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class LoginControl {
    private String Unombre;
    private String upassword;
    private boolean recordar;
    
    public static ArrayList<String> GetRecordados(){
        ArrayList <String> recordados= new ArrayList();
        ResultSet r=Conexion.getInstance().GetRecordados();
        try{
            while(r.next()) recordados.add(r.getString(1));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return recordados;
    }
    
    public static boolean ValidarUsuarioYContraseña(String usuario,String password){
        return Conexion.getInstance().ValidarUsuarioYContraseña(usuario,password);
    }
    
    public static void Recordarme(String usuario){
        Conexion.getInstance().Recordarme(usuario);
    }
}