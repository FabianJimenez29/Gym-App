package com.gym.app.gymapp.features;

import com.gym.app.gymapp.classes.Administrador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabi
 */
public class AdminDAO {

    public boolean insertarAdministrador(Administrador admin) {
        String sql = "{CALL InsertAdmin(?, ?, ?, ?, ?, ?, ?)}"; 

        // Primero, enviamos el correo antes de hacer cualquier cambio en la base de datos
        String contrasenaGenerada = generarContrasena(admin);
        
        // Si el correo no se envió correctamente, no realizamos la inserción
        if (!enviarCorreo(admin.getCorreo_Administrador(), contrasenaGenerada)) {
            System.out.println("❌ Error: El correo no se pudo enviar. Los datos no se guardarán.");
            return false;
        }

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, admin.getId_Administrador());
            stmt.setString(2, admin.getNombre_Administrador());
            stmt.setString(3, admin.getApellido_Administrador());
            stmt.setInt(4, admin.getEdad_Administrador());
            stmt.setInt(5, admin.getNumero_Administrador());
            stmt.setString(6, admin.getCorreo_Administrador());
            stmt.setString(7, contrasenaGenerada);  
            
            // Ahora que sabemos que el correo se envió correctamente, realizamos la inserción en la base de datos
            int filasAfectadas = stmt.executeUpdate();
            
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar administrador: " + e.getMessage());
            return false;
        }
    }

    public boolean editarAdministrador(Administrador admin) {
        String sql = "{CALL UpdateAdmin(?, ?, ?, ?, ?, ?, ?)}"; 

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, admin.getId_Administrador());
            stmt.setString(2, admin.getNombre_Administrador());
            stmt.setString(3, admin.getApellido_Administrador());
            stmt.setInt(4, admin.getEdad_Administrador());
            stmt.setInt(5, admin.getNumero_Administrador());
            stmt.setString(6, admin.getCorreo_Administrador());
            stmt.setString(7, admin.getContrasena_Administrador());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al editar administrador: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarAdministrador(int idAdministrador) {
        String sql = "{CALL DeleteAdmin(?)}"; 

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idAdministrador);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar administrador: " + e.getMessage());
            return false;
        }
    }

    private String generarContrasena(Administrador admin) {
        String nombre = admin.getNombre_Administrador();
        String apellido = admin.getApellido_Administrador();
        int edad = admin.getEdad_Administrador();

        String contrasena = nombre.substring(0, Math.min(3, nombre.length()))
                + apellido.substring(0, Math.min(4, apellido.length()))
                + edad
                + "_gym2025";
        return contrasena;
    }

    private boolean enviarCorreo(String correo, String contrasena) {
        String asunto = "Tu nueva contraseña";
        String cuerpo = "Hola,\n\nTu nueva contraseña es: " + contrasena + "\n\nGracias por ser parte de nuestro gimnasio.";

        try {
            // Si el correo se envía sin problemas, retornamos true
            MailService.sendEmail(correo, asunto, cuerpo);
            return true;
        } catch (Exception e) {
            // Si ocurre algún error al enviar el correo, capturamos la excepción
            System.out.println("❌ Error al enviar el correo: " + e.getMessage());
            return false;
        }
    }
}
