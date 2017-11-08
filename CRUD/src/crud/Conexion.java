
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection cx;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Tiendta1", "root", "");
            System.out.println("Se Conecto");
        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println("No se conecto");
        }
        return cx;
    }

    public void cerrar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cera conexion");
        }
    }
    public static void main(String[] args) {
        Conexion c=new Conexion();
        c.conectar();
    }

}
