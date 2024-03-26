package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mateo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Estos valores deben ajustarse según tu configuración
    private static final String URL = "jdbc:mysql://localhost:3306/bd_ds";
    private static final String USUARIO = "usuario";
    private static final String CONTRASENA = "contraseña";

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos");
                // Aquí puedes realizar operaciones en la base de datos
            } else {
                System.out.println("No se pudo establecer la conexión");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión en el bloque finally para garantizar su cierre
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
