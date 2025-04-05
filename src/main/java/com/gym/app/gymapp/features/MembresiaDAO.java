package com.gym.app.gymapp.features;

import com.gym.app.gymapp.TipoMembresia;
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

    public void insertarMembresia(Membresias mem) {
        String sql = "{CALL InsertMembership(?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, mem.getNombre_Membresia());
            stmt.setString(2, mem.getDuracion_Membresia());
            stmt.setFloat(3, mem.getPrecio_Membresia());
            stmt.setString(4, mem.getTipo_Membresia().name());

            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al insertar membresía: " + e.getMessage());
        }
    }

    public boolean actualizarMembresia(Membresias mem) {
        String sql = "{CALL UpdateMembership(?, ?, ?, ?, ?)}";
        boolean resultado = false;  // Inicializamos con false por defecto

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, mem.getId_Membresia());
            stmt.setString(2, mem.getNombre_Membresia());
            stmt.setString(3, mem.getDuracion_Membresia());
            stmt.setFloat(4, mem.getPrecio_Membresia());
            stmt.setString(5, mem.getTipo_Membresia().name());

            int filasAfectadas = stmt.executeUpdate(); // Usamos executeUpdate, que retorna el número de filas afectadas

            if (filasAfectadas > 0) {
                resultado = true;  // Si la operación afecta al menos una fila, retornamos true
                JOptionPane.showMessageDialog(null, "✅ Membresía actualizada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al actualizar membresía: " + e.getMessage());
        }

        return resultado;  // Devolvemos el resultado de la operación
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
        String sql = "SELECT Id_Membership, Name_Membership, Duration_Membership, Price_Membership, Type_Membership FROM memberships";

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("Id_Membership");
                String nombre = rs.getString("Name_Membership");
                String duracion = rs.getString("Duration_Membership");
                float precio = rs.getFloat("Price_Membership");
                TipoMembresia tipo = TipoMembresia.valueOf(rs.getString("Type_Membership"));

                // Crear el objeto Membresias con los datos correctos
                lista.add(new Membresias(id, nombre, duracion, precio, tipo));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Membresias> obtenerTipoMembresia() {
        List<Membresias> lista = new ArrayList<>();
        String sql = "SELECT Type_Membership FROM memberships";

        try (Connection conn = ConexionBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                TipoMembresia tipo = TipoMembresia.valueOf(rs.getString("Type_Membership"));

                // Crear el objeto Membresias con los datos correctos
                lista.add(new Membresias(0, "", "", 0, tipo));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
