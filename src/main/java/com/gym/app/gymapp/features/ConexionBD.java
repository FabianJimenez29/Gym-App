package com.gym.app.gymapp.features;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fabi
 */
public class ConexionBD {  
    private static final String URL = "jdbc:mysql://localhost:3306/GymApp";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "fabian29";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("✅ Conexión exitosa a MySQL");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a MySQL: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {
        Connection conexion = conectar();  
        if (conexion != null) {
            System.out.println("🎉 Base de datos conectada correctamente.");
        } else {
            System.out.println("⚠️ No se pudo establecer conexión.");
        }
    }
    
    
    
    
}


