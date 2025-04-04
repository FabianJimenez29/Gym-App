/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp.features;

import com.gym.app.gymapp.classes.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabi
 */
public class UsuarioDAO {

    public boolean insertarUsuario(Usuario usuario) {
        String sql = "{CALL InsertClient(?, ?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); // Reutiliza la conexión
                 CallableStatement stmt = conn.prepareCall(sql)) {

            // Asignar parámetros al procedimiento almacenado
            stmt.setInt(1, usuario.getId_Cliente());
            stmt.setString(2, usuario.getNombre_Cliente());
            stmt.setString(3, usuario.getApellido_Cliente());
            stmt.setInt(4, usuario.getEdad_Cliente());
            stmt.setInt(5, usuario.getNumero_Cliente());
            stmt.setString(6, usuario.getCorreo_Cliente());

            // Ejecutar el procedimiento almacenado
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se insertó correctamente

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean editarUsuario(Usuario usuario) {
        String sql = "{CALL UpdateClient(?, ?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, usuario.getId_Cliente());
            stmt.setString(2, usuario.getNombre_Cliente());
            stmt.setString(3, usuario.getApellido_Cliente());
            stmt.setInt(4, usuario.getEdad_Cliente());
            stmt.setInt(5, usuario.getNumero_Cliente());
            stmt.setString(6, usuario.getCorreo_Cliente());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al editar usuario: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un usuario
    public boolean eliminarUsuario(int idCliente) {
        String sql = "{CALL DeleteClient(?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idCliente);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }

    public List<Usuario> obtenerClientes() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT Id_Client, Name, LastName FROM client";  // Asegúrate de que solo traiga estos 3 campos

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("Id_Client");
                String nombre = rs.getString("Name");
                String apellido = rs.getString("LastName");

                // Crear el objeto Usuario con solo los campos que necesitas
                lista.add(new Usuario(id, nombre, apellido, 0, 0, "")); // Aquí solo pasamos lo necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Usuario> obtenerClientesTotales() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT Id_Client, Name, LastName, Age, Phone, Mail FROM client";  // Asegúrate de que solo traiga estos 3 campos

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("Id_Client");
                String nombre = rs.getString("Name");
                String apellido = rs.getString("LastName");
                int edad = rs.getInt("Age");
                int telefono = rs.getInt("Phone");
                String correo = rs.getString("Mail");

                // Crear el objeto Usuario con solo los campos que necesitas
                lista.add(new Usuario(id, nombre, apellido, edad, telefono, correo)); // Aquí solo pasamos lo necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Usuario> buscarClientePorNombreApellido(String nombre, String apellido) {
        List<Usuario> listaClientes = new ArrayList<>();

        String query = "SELECT * FROM client WHERE Name LIKE ? AND LastName LIKE ?";

        try (Connection conn = ConexionBD.conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {

            // Usamos "%" para buscar cualquier coincidencia parcial
            stmt.setString(1, "%" + nombre + "%");
            stmt.setString(2, "%" + apellido + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear un objeto Usuario para cada registro
                    Usuario cliente = new Usuario(
                            rs.getInt("Id_Client"),
                            rs.getString("Name"),
                            rs.getString("LastName"),
                            rs.getInt("Age"),
                            rs.getInt("Phone"),
                            rs.getString("Mail")
                    );
                    listaClientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el cliente: " + e.getMessage());
        }

        return listaClientes;
    }

}
