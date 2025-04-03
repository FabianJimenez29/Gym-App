/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp.features;

import com.gym.app.gymapp.classes.Pagos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabi
 */
public class PagosDAO {

    public boolean insertarPago(Pagos pago) {
        String sql = "{CALL InsertPayment(?, ?, ?, ?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, pago.getId_Administrador());
            stmt.setInt(2, pago.getId_Cliente());
            stmt.setString(3, pago.getTipo_Pago().name()); // Convertir ENUM a String
            stmt.setDate(4, pago.getFecha_Pago());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar pago: " + e.getMessage());
            return false;
        }
    }

    // Método para editar un pago
    public boolean editarPago(Pagos pago) {
        String sql = "{CALL UpdatePayment(?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, pago.getId_Pago());
            stmt.setInt(2, pago.getId_Administrador());
            stmt.setInt(3, pago.getId_Cliente());
            stmt.setString(4, pago.getTipo_Pago().name()); // Convertir ENUM a String
            stmt.setDate(5, pago.getFecha_Pago());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al editar pago: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un pago
    public boolean eliminarPago(int idPago) {
        String sql = "{CALL DeletePayment(?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = ConexionBD.conectar(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idPago);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar pago: " + e.getMessage());
            return false;
        }
    }
}
