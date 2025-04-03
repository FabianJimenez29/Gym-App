package com.gym.app.gymapp.features;

import com.gym.app.gymapp.classes.Membresias;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MembresiaDAO {

    public void insertarMembresia(String nombre, String duracion, float precio) {
        String sql = "{CALL InsertMembership(?, ?, ?)}";

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, duracion);
            stmt.setFloat(3, precio);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "✅ Membresía agregada con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al insertar membresía: " + e.getMessage());
        }
    }

    public void actualizarMembresia(int id, String nombre, String duracion, float precio) {
        String sql = "{CALL UpdateMembership(?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, duracion);
            stmt.setFloat(4, precio);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "✅ Membresía actualizada con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al actualizar membresía: " + e.getMessage());
        }
    }

    public void eliminarMembresia(int id) {
        String sql = "{CALL DeleteMembership(?)}";

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "✅ Membresía eliminada con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al eliminar membresía: " + e.getMessage());
        }
    }

    public List<Membresias> obtenerMembresia() {
        List<Membresias> lista = new ArrayList<>();
        String sql = "SELECT Id_Membership, Name_Membership, Duration_Membership, Price_Membership FROM memberships";

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("Id_Membership");
                String nombre = rs.getString("Name_Membership");
                String duracion = rs.getString("Duration_Membership");
                float precio = rs.getFloat("Price_Membership");

                // Crear el objeto Membresias con los datos correctos
                lista.add(new Membresias(id, nombre, duracion, precio));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
