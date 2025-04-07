package com.gym.app.gymapp.features;

import com.gym.app.gymapp.classes.Administrador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.HTML;

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

    public List<Administrador> obtenerAdministradoresTotales() {
        List<Administrador> lista = new ArrayList<>();
        String sql = "SELECT Id_Admin, Name, LastName, Age, Phone, Mail, Password FROM admin";  // Asegúrate de que solo traiga estos 3 campos

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("Id_Admin");
                String nombre = rs.getString("Name");
                String apellido = rs.getString("LastName");
                int edad = rs.getInt("Age");
                int telefono = rs.getInt("Phone");
                String correo = rs.getString("Mail");
                String contrasena = rs.getString("Password");

                // Crear el objeto Usuario con solo los campos que necesitas
                lista.add(new Administrador(id, nombre, apellido, edad, telefono, correo, contrasena)); // Aquí solo pasamos lo necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
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
        String asunto = "🔒 Envío Automático De Contraseña - GymCabita";

        String cuerpoHTML = """
    <html>
    <body style="font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;">
        <div style="max-width: 600px; margin: auto; background-color: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
            <h2 style="color: #2E86C1; text-align: center;">💪 ¡Hola de nuevo! 💪</h2>
            <p style="font-size: 16px; color: #333;">
                Hemos generado una nueva contraseña para tu cuenta en <strong>GymCabita</strong>. Asegúrate de cambiarla al iniciar sesión por una que recuerdes mejor.
            </p>
            <div style="background-color: #F2F3F4; padding: 15px; border-radius: 5px; text-align: center; margin: 20px 0;">
                <p style="font-size: 18px; color: #000;">🔐 Tu nueva contraseña es:</p>
                <p style="font-size: 22px; font-weight: bold; color: #2C3E50;">{{contrasena}}</p>
            </div>
            <p style="font-size: 16px; color: #333;">
                Si no solicitaste este cambio, por favor contáctanos inmediatamente.
            </p>
            <p style="font-size: 14px; color: #888; margin-top: 30px;">
                Gracias por seguir entrenando con nosotros 💙<br>
                <strong>GymCabita</strong>
            </p>
        </div>
    </body>
    </html>
    """;

        cuerpoHTML = cuerpoHTML.replace("{{contrasena}}", contrasena);

        try {
            MailService.sendEmail(correo, asunto, cuerpoHTML); 
            return true;
        } catch (Exception e) {
            System.out.println("❌ Error al enviar el correo: " + e.getMessage());
            return false;
        }
    }

}
