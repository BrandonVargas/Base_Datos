package scripts.sql;
import conexion.sql.ConnectionSQL;
import java.sql.SQLException;

/**
 * Clase para inserción de datos aleatorios ala BD.
 * @author ZtuX
 */
public class InsertarDatosAleatorios {
    public static void main(String[] args) {
        //Conexion a la Base de datos
        ConnectionSQL c = new ConnectionSQL("ADMIN1","ADMIN1","192.168.1.125",1521,"CURSOBD");
     
        String CARRERA_ID,NOMBRE,CLAVE,DESCRIPCION;
        CARRERA_ID = "1";
        NOMBRE = "'ING COMPUTACION'";
        CLAVE = "1";
        DESCRIPCION = "'CARRERA DE INGENIERIA EN COMPUTACION'";
        
        try{
            c.consulta =  c.getConnection().prepareStatement(
                "INSERT INTO CARRERA "
                + "(CARRERA_ID,NOMBRE,CLAVE,DESCRIPCION)"
                + " VALUES("
                +CARRERA_ID+","
                +NOMBRE+","
                +CLAVE+","
                +DESCRIPCION
                +")");
            c.consulta.execute();
            System.out.println("AGREGADO CORRECTAMENTE");  
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
}
