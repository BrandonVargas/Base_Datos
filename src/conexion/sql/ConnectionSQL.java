package conexion.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ConnectionSQL
 * Clase para conectar con la base de datos.
 * @author ZtuX
 * @version 1.0
 * 
 */
public class ConnectionSQL{
    /*
    * Variables para la configuración del la conexión.
    */
    public String user;
    protected String password;
    protected String host;
    protected int port;
    protected String dbName;
	
    /*
    * Variables para realizar la conexión.
    * */
    protected Connection c = null;
    protected PreparedStatement consulta;
    protected ResultSet datos;
    protected DatabaseMetaData metadata;
    public String urlConexion;
    
    /*Nombre del driver a usar*/
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    
    /**
     * Constructor de la Clase Conexion.
     * @param user Nombre de usuario de la BD
     * @param password Password del usuario de la BD
     * @param host Host a conectar
     * @param port Puerto
     * @param dbName Nombre de la base de datos
    */
    public ConnectionSQL(String user,String password, String host,int port,String dbName){
        this.user = user;
    	this.password = password;
    	this.host = host;
    	this.port = port;
    	this.dbName = dbName;
    	//PARA ORACLE: jdbc:oracle:thin:[user/password]@[host][:port]:SID
    	//Se crea la url para la conexión.
    	this.urlConexion = "jdbc:oracle:thin:"+this.user+"/"+this.password+
    			           "@"+this.host+":"+this.port+":"+this.dbName;
    }
    
    
    @SuppressWarnings("finally")
    public Connection getConnection(){
    /*Almacena la conexión con la BD*/
        Connection c = null;
    	
        try{
            //Cargamos el Driver
            Class.forName(DRIVER_NAME);
            //Obtenemos una conexión mediante la url
            c = DriverManager.getConnection(urlConexion);
            
            //Si la conexion se realiza con éxito... (Unicamete para Testing)
            if(c!=null){
                System.out.println("Conexion establecida con exito: "+c);
                System.out.println("Datos de la conexion: ");
                metadata = c.getMetaData();
                System.out.println("URL: "+metadata.getURL());
                System.out.println("Manejador: "+metadata.getDatabaseProductName());
                System.out.println("Version: "+metadata.getDatabaseProductVersion());
                System.out.println("Driver: "+metadata.getDriverName());
                System.out.println("Version: "+metadata.getDriverVersion());
            }
    	}catch(ClassNotFoundException e){
            System.out.println("No se encontro el driver");
    	}catch (SQLException e) {
            System.out.println("No se pudo conectar a la BD");
            //e.printStackTrace();
        }finally{
            return c;	
        }
    }
    
    
    /**
    * Desconecta de la base de datos.
    * @throws SQLException 
    */
    public void endConnection() throws SQLException{
    	this.c.close();
    	this.consulta.close();
    }
    
    public void endConnection(ResultSet rs) throws SQLException{
    	this.endConnection();
    	rs.close();
    }
 
}
