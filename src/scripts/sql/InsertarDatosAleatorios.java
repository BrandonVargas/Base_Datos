package scripts.sql;
import conexion.sql.ConnectionSQL;
import java.sql.SQLException;

/**
 * Clase para inserción de datos aleatorios ala BD.
 * @author ZtuX
 */
public class InsertarDatosAleatorios {
    public static void main(String[] args) {
        
        /*String NOMBRE,AP_PAT,AP_MAT,FECHA_NACIMIENTO,NUM_CUENTA,PLAN_ESTUDIO_ID,CARRERA_ID,TESIS_ID = null;
        NOMBRE = "JESUS";
        AP_PAT = "HERNANDEZ";
        AP_MAT = "ALARCON";
        FECHA_NACIMIENTO = "SYSDATE";
        NUM_CUENTA = "309140720";
        PLAN_ESTUDIO_ID = "1";
        CARRERA_ID = "11";
        TESIS_ID = null;
        */
        //Conexion a la Base de datos
        ConnectionSQL c = new ConnectionSQL("ADMIN1","ADMIN1","192.168.1.125",1521,"CURSOBD");
        /*try{
            c.consulta =  c.getConnection().prepareStatement(
                "INSERT INTO ESTUDIANTE "
                + "(ESTUDIANTE_ID,NOMBRE,AP_PAT,AP_MAT,FECHA_NACIMIENTO,NUM_CUENTA,PLAN_ESTUDIO_ID,CARRERA_ID,TESIS_ID)"
                + " VALUES("
                        +"10000"+","
                        +NOMBRE+","
                        +AP_PAT+","
                        +AP_PAT+","
                        +FECHA_NACIMIENTO+","
                        +NUM_CUENTA+","
                        +PLAN_ESTUDIO_ID+","
                        +CARRERA_ID+","
                        +TESIS_ID+")");
            c.consulta.execute();
            System.out.println("AGREGADO CORRECTAMENTE");  
        }catch(SQLException e){
            e.printStackTrace();
        }*/
        
        
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
