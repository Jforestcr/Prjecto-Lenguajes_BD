/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conexionBD {
    
    Connection nuevaConexion;

    public conexionBD() {
    }
    //Inicia el controlador para conectar con la BD
    public void iniciarDriver(){
        String driver = "OracleThin";
            try {
                Class.forName(driver);
            } catch (java.lang.ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Se ha presentado un error al iniciar el driver. El error es: " + ex.getMessage());
            }
    }
    
        public Connection conectarBD() {
                final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String user = "hr";
        final String pass = "12345";

        try {
            nuevaConexion = DriverManager.getConnection(DATABASE_URL, user, pass);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error al conectar con la base de datos. El error es: " + ex.getMessage());
        }
        return nuevaConexion;
    }
        
            public void cerrarConexionBD() {
        try {
            nuevaConexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error al cerrar la conexión con la base de datos. El error es: " + ex.getMessage());
        }
    }
}
