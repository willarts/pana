package Control;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class Conexion 
{
    private  Connection connection;
    private  Statement statement;
    private  String url="jdbc:postgresql://localhost:5432/sistema";;
    private  String password="postgres";
    private static Conexion instance=null;
         
    private Conexion(){}
    
    private static void createInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
    }
    
    public static Conexion getInstance() {
        if (instance == null) createInstance();
            return instance;
    }
    
    public  void Conectar(){
       try{
           Class.forName("org.postgresql.Driver");
           connection=DriverManager.getConnection(url,"postgres",password);
           statement=connection.createStatement();
       }catch(Exception e){
           System.out.println("Error: "+e.getMessage());
       }   
    }
    
    public  void Desconectar(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Desconexion error: "+ex.getMessage());
        }
    }
    
    public  void Insert(String esquema,String nupla) throws SQLException{
        Conectar();
        try{
            if(statement.executeUpdate("INSERT INTO "+esquema+" VALUES("+nupla+")")==1)
                Desconectar();
        }catch(PSQLException e){
            Desconectar();
            throw e;
        }
    }
    
    public  void Delete(String esquema,String condicion) throws SQLException
    {
        Conectar();
        try{
            if(statement.executeUpdate("DELETE FROM "+esquema+" WHERE "+condicion)==1)
                Desconectar();
        }catch(SQLException e){
            Desconectar();
            throw e;
        }
    }
    
    public  void Update(String esquema,String modificacion, String condicion) throws SQLException
    {
        Conectar();
        try{
            if(statement.executeUpdate("UPDATE "+esquema+" SET "+modificacion+" WHERE "+condicion)==1)
                Desconectar();
        }catch(SQLException e){
            Desconectar();
            throw e;
        }
    }    
    public  ResultSet Consulta(String consulta){
        Conectar();
        CachedRowSetImpl ResultSetCache=null;
        try{
            ResultSetCache=new CachedRowSetImpl();
            ResultSet rs=statement.executeQuery(consulta);
            if(rs.next()) ResultSetCache.populate(statement.executeQuery(consulta)); // copio lo de result set en esta variable ya que si desconecto no puedo usar resultset
        }catch(Exception e){
            if(ResultSetCache!=null)System.out.println(e.getMessage());
        }
        Desconectar();
        return ResultSetCache;
    }
    
    /************************************************************ CONEXION ************************************************************/    
    public  ResultSet GetRecordados(){     
        return Consulta("SELECT unombre FROM usuario WHERE recordar=true");
    }
    
    public  boolean ValidarUsuarioYContraseña(String usuario, String contraseña){
        try { 
            return Consulta("SELECT unombre FROM usuario WHERE unombre='"+usuario+"' and upassword='"+contraseña+"'").next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public  void Recordarme(String usuario){
        Consulta("UPDATE usuario SET recordar=true WHERE unombre='"+usuario+"'"); // problema la consulta no retorna resultado
    }
    
    /************************************************************ CLIENTE ************************************************************/ 
    
    public ResultSet ObetenerClientesFijos(String orderby) {
        return Consulta("SELECT * FROM cliente WHERE tipo='F' and baja='false' ORDER BY "+orderby+" desc");
    }
    
    public ResultSet ObtenerClientesNFConRemito(String fecha, char turno) {
        return Consulta("SELECT DISTINCT cliente.c_nom, dir, tel, tipo, zona, deuda, baja FROM cliente,remito WHERE cliente.c_nom=remito.c_nom and tipo='N' and fecha='"+fecha+"' and turno='"+turno+"' and baja='false' ORDER BY c_nom desc");
    }
    
    public ResultSet ObtenerClientesNFyFConRemito(String fecha, char turno) {
        return Consulta("SELECT DISTINCT cliente.c_nom, dir, tel, tipo, zona, deuda, baja FROM cliente,remito WHERE cliente.c_nom=remito.c_nom and fecha='"+fecha+"' and turno='"+turno+"' and baja='false' ORDER BY c_nom desc");
    }
    
    public  ResultSet ObtenerProductos() {
        return Consulta("SELECT * FROM producto");
    }
    
    public  ResultSet ObtenerProductoNombre(String p_nom) {
        return Consulta("SELECT * FROM producto WHERE p_nom='"+p_nom+"'");
    }
    
    public  ResultSet ObtenerProductoCod(String p_cod) {
        return Consulta("SELECT * FROM producto WHERE p_cod='"+p_cod+"'");
    }
   
    public ResultSet ObtenerRemitoCliente(String fecha, char turno, Cliente cliente) {
        return Consulta("SELECT * FROM remito WHERE c_nom='"+cliente.getC_nom()+"' and turno='"+turno+"' and fecha='"+fecha+"'");
    }
    
    public ResultSet ObtenerPedidosRemito(Remito remito) {
        return Consulta("SELECT * FROM pedido WHERE r_nro="+remito.getR_num());
    }
    
    public  ResultSet ObtenerPedidosRemito (int r_nro) { 
        return Consulta("SELECT Pr.p_nom,Pe.cant,Pe.unid FROM pedido as Pe, producto as Pr WHERE r_nro='"+r_nro+"' and Pe.p_cod=Pr.p_cod");
    }
    
    public ResultSet ObtenerProductoCodigo(String codigo) {
        return Consulta("SELECT * FROM producto WHERE p_cod='"+codigo+"'");
    }
    
    public int AltaRemito(Remito r) throws SQLException {
        Insert("remito (c_nom, fecha, p_total, p_abonado, deuda_actual, cancel, turno)","'"+r.getClient().getC_nom()+"','"+r.getFecha()+"',"+r.getP_total()+","+r.getP_abonado()+","+r.getDeuda_actual()+","+r.isCancel()+",'"+r.getTurno()+"'");
        ResultSet rs=Conexion.getInstance().ObtenerRemitoCliente(r.getFecha(), r.getTurno(), r.getClient());
        int r_nro=0;
        while(rs.next()) {
            r_nro=Integer.valueOf(rs.getObject(1).toString());
        }
        return r_nro;
    }
    
    public void AltaPedido(int r_nro,Pedido p) throws SQLException {
        Insert("pedido",r_nro+","+p.getProd().getP_cod()+","+p.getCant()+",'"+p.getUnidad()+"',"+p.getPrecio());
    }
    
    public void ModificarRemito(int r_nro,float p_total, float p_abonado, float deuda_actual) throws SQLException {
        Update("remito","p_total="+p_total+",p_abonado="+p_abonado+",deuda_actual="+deuda_actual, "r_nro="+r_nro);
    }
    
    public  ResultSet ObtenerRemitosFechaTurno (String fecha,char turno) {
        return Consulta("SELECT r_nro,C.c_nom,p_total,C.zona FROM remito as R,cliente as C WHERE R.c_nom = C.c_nom and fecha='"+fecha+"' and turno='"+turno+"' order by C.zona");
    }
    
    public ResultSet ObtenerRemitosAdeudados(String c_nom) {
        return Consulta("SELECT r_nro,fecha,p_total,p_abonado,deuda_actual,turno FROM remito WHERE c_nom='"+c_nom+"' and cancel='false'");
    }
    
    public void ModificarPedido(int r_nro, Pedido ped) throws SQLException {
        Update("pedido","cant="+ped.getCant()+", unid='"+ped.getUnidad()+"', precio="+ped.getPrecio(), "r_nro="+r_nro+" and p_cod='"+ped.getProd().getP_cod()+"'");
    }
    
    public void BajaPedido(int r_nro, String p_cod) throws SQLException {
         String condicion = "r_nro = '"+r_nro+"' and p_cod ='"+p_cod+"'";
         Delete("pedido",condicion);
    }
    
    public ResultSet ObtenerPedidosCant(String fecha, char unidad) {
        return Consulta("SELECT p_nom,sum(cant) FROM remito,pedido,producto WHERE remito.r_nro=pedido.r_nro and pedido.p_cod=producto.p_cod and fecha='"+fecha+"' and unid='"+unidad+"' GROUP BY p_nom");
    }
    
    public ResultSet ObtenerPedidoDeRemito(Remito r) {
        return Consulta("SELECT p_cod, cant, unid, precio FROM pedido WHERE r_nro='"+String.valueOf(r.getR_num())+"'");
    }
    
    public void BajaRemito(int r_nro) throws SQLException {
        Delete("remito","r_nro='"+r_nro+"'");
    }
    
    public  ResultSet ObetenerClientes()
    {
        return Consulta("SELECT * FROM cliente where baja=false");
    }
    
    
    public  ResultSet ObetenerClientesDeuda()
    {
        return Consulta("SELECT c_nom,deuda FROM cliente where baja=false and deuda>'0' ORDER BY c_nom asc");
    }
    
    public void AltaCliente(String c_nom,String dir, String tel, char tipo, char zona) throws SQLException {
        
        String nupla = "'"+c_nom+"','"+dir+"','"+tel+"','"+tipo+"','"+zona+"','"+0+"',false";
        this.Insert("cliente", nupla);
       
    }
    
    public void ModificarCliente(String c_nom,String dir, String tel, char tipo, char zona, float deuda) throws SQLException {
        Update("cliente","dir='"+dir+"', tel='"+tel+"', tipo='"+tipo+"', zona='"+zona+"', deuda='"+deuda+"'" , "c_nom='"+c_nom+"'");
    }
    
    public void BajaCliente(boolean B,String c_nom) throws SQLException {
        
        String modificacion = "baja ="+B+"";
        String condicion = "c_nom = '"+c_nom+"'";
        this.Update("cliente",modificacion,condicion);
       
    }
    
    public ResultSet BuscarCliente(String c_nom) throws SQLException {
        
         return this.Consulta("select * from cliente where c_nom ='"+c_nom+"'");
       
    }
    
    public ResultSet GetAllClient() { // Obtener todos los clientes activos y no activos, es decir, los que estan dados de baja logicamente tambien
        return Consulta("SELECT * FROM cliente ORDER BY c_nom DESC");
    }
    
    public ResultSet GetAllRemitosClientDesdeHasta(String c_nom, String desde, String hasta) {
        return Consulta("SELECT r_nro,fecha,p_total,p_abonado,deuda_actual,turno,cancel FROM remito where c_nom='"+c_nom +"' and fecha>='"+desde+"' and fecha<='"+hasta+"' ORDER BY r_nro");
    }
    
}