
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexion {
Connection conexion;
    public Connection Conexion(){
     try {
           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/DB_Zapateria?useSSL=false&allowPublicKeyRetrieval=true";
           String user = "root";
           String password = "admin";
           conexion = (Connection) DriverManager.getConnection(url, user, password);
       } catch (ClassNotFoundException | SQLException error) {
           StackTraceElement elemento = error.getStackTrace()[0];
           System.out.println("Error en: " + elemento.getClassName() + " linea " + elemento.getLineNumber());
           System.out.println("Mensaje: " + error.getMessage());
       }
        return conexion;
    }
}

